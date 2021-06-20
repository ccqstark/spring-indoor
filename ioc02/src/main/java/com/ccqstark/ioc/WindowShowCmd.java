package com.ccqstark.ioc;

public class WindowShowCmd implements ShowCmd{
    @Override
    public String showCmd() {
        return "dir";
    }
}
