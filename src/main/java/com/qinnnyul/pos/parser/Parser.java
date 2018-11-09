package com.qinnnyul.pos.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Parser<T> {

    public List<T> parse(String fileName) {
        List<T> items = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
            items = lines.map(line -> convert(line)).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return items;
    }

    protected abstract T convert(String line);
}
