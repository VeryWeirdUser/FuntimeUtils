package me.margiux.ftutils.module;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public final String name;
    public final boolean builtin;
    public final static List<Category> categories = new ArrayList<>();

    public final static Category VISUAL = new Category("Visual", true);
    public final static Category MISC = new Category("Miscellaneous", true);

    public Category(String name) {
        this(name, false);
    }

    private Category(String name, boolean builtin) {
        this.name = name;
        this.builtin = builtin;
        categories.add(this);
    }
}
