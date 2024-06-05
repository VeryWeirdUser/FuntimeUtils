package me.margiux.ftutils.setting;

import org.apache.commons.lang3.mutable.MutableObject;

public abstract class Setting<T> {
    protected final String name;
    protected final String description;
    protected final MutableObject<T> data;

    public Setting(String name, String description, T data) {
        this.name = name;
        this.description = description;
        this.data = new MutableObject<>(data);
    }

    public Setting(String name, String description) {
        this(name, description, null);
    }

    public T getData() {
        return data.getValue();
    }

    public void setData(T data) {
        this.data.setValue(data);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
