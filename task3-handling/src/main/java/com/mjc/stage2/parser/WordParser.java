package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.Arrays;

public class WordParser extends AbstractTextParser{

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        for (char c : string.toCharArray()) {
            abstractTextComponent.add(new SymbolLeaf(TextComponentType.SYMBOL, c));
        }
    }
}
