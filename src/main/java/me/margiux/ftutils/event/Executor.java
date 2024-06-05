package me.margiux.ftutils.event;

public interface Executor {
    <T extends Event> void execute(T event);
}
