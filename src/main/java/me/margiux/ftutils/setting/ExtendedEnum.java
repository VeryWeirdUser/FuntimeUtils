package me.margiux.ftutils.setting;

public interface ExtendedEnum<T extends ExtendedEnum<T>> {
    boolean isDisplayOnly();
    T[] getValues();
    default T getNext() {
        int thisIndex = -1;
        for (int i = 0; i < getValues().length; i++) {
            if (getValues()[i] == this) {
                thisIndex = i;
                break;
            }
        }
        for (int i = thisIndex; i < getValues().length; i++) {
            if (i != thisIndex && !getValues()[i].isDisplayOnly()) return getValues()[i];
        }
        return getValues()[0];
    }
}
