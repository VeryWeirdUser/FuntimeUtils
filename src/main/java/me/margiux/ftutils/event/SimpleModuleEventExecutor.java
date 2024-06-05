package me.margiux.ftutils.event;

import me.margiux.ftutils.module.Module;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public record SimpleModuleEventExecutor(Module module, Method method, Listener listener,
                                        ModuleEventHandler handler) implements Executor {
    public SimpleModuleEventExecutor(@NotNull Module module, Method method, Listener listener, ModuleEventHandler handler) {
        this.method = method;
        this.listener = listener;
        this.handler = handler;
        this.module = module;
    }

    @Override
    public <T extends Event> void execute(T event) {
        if (module.isEnabled()) {
            try {
                if ((!event.isCanceled() || (event.isCanceled() && !handler.ignoreCanceled())))
                    method.invoke(listener, event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
