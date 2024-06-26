package me.margiux.ftutils.event;

public enum EventPriority {
    LOWEST(0),
    LOW(1),
    NORMAL(2),
    HIGH(3),
    HIGHEST(4),
    MONITOR(5);

    private final int slot;

    EventPriority(int slot) {
        this.slot = slot;
    }

    @SuppressWarnings("unused")
    public int getSlot() {
        return slot;
    }
}