package ru.timofeev.translator.utils;

import java.util.List;

public class TextSpliterator {

    private TextSpliterator() {

    }

    public static List<String> getSplitTextBySpacesAndCommas(String text) {
        text = InputTextProcessor.getProcessedText(text);
        return List.of(text.split(" "));
    }

}
