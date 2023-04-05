package ru.timofeev.translator.utils;

public class TextSpliterator {

    private TextSpliterator() {

    }

    public static String[] getSplitTextBySpaces(String text) {
        return text.split(" ");
    }

}
