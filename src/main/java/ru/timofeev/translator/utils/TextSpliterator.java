package ru.timofeev.translator.utils;

import java.util.List;

public class TextSpliterator {

    private TextSpliterator() {

    }

    public static List<String> getSplitTextBySpaces(String text) {
        return List.of(text.split(" "));
    }

}
