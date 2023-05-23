package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponent extends AbstractTextComponent{
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType type) {
        super(type);
    }

    @Override
    public String operation() {
        return
        componentList.stream()
                .map(cmp -> cmp.operation())
                .collect(Collectors.joining());

    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        this.size = componentList.size();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
        this.size = componentList.size();
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
