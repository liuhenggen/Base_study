package com.laotou.Test;

import com.laotou.base.Father;

public class Son extends Father{
    private String name;
    private int height;

    public Son(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void run() {
        super.run();
    }

    public Son() {
        super();
    }
}
