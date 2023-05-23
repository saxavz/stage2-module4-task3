package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ChainParserBuilder {
    private final List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        IntStream.range(1,parsers.size())
                .forEach( i -> parsers.get(i-1).setNextParser(parsers.get(i)));
        return parsers.get(0);
    }
}
