package com.ccqstark.ioc;

public class MacShowCmd implements ShowCmd{
    @Override
    public String showCmd() {
        return "ls";
    }
}
