package me.margiux.ftutils.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public record SimpleEventExecutor(Method method, Listener listener, EventHandler handler) implements Executor {
    @Override
    public <T extends Event> void execute(T event) {
        try {
            if ((!event.isCanceled() || (event.isCanceled() && !handler.ignoreCanceled())))
                method.invoke(listener, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
