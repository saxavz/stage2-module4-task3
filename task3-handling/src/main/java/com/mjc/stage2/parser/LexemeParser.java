package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.Arrays;

public class LexemeParser extends AbstractTextParser{
    private static final String SENTENCE_REGEX = "[!\\.?](?=\\s|$)";
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";


    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {

        Arrays.stream(string.split(SENTENCE_REGEX))
                .flatMap( s -> Arrays.stream(s.split(LEXEME_REGEX)))
                .map(String::trim) //remove left/right spaces
                .map(s -> s.replaceAll(",$","")) //remove trailing commas
                //.filter(s -> s.length() > 0)
                .filter(s -> s.matches(WORD_REGEX)) //push-down only expected word patterns
                .forEach( word -> abstractTextComponent.add(delegateToNext(word)));
    }

    private AbstractTextComponent delegateToNext(String word){
        AbstractTextComponent innerComposite = new TextComponent(TextComponentType.WORD);
        this.nextParser.parse(innerComposite,word);
        return innerComposite;
    }

}
