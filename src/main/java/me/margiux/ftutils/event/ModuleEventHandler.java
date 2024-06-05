package me.margiux.ftutils.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleEventHandler {
    EventPriority priority() default EventPriority.NORMAL;

    boolean ignoreCanceled() default true;

    boolean executeInDisabledMode() default false;
}
