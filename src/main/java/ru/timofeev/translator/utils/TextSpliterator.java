package ru.timofeev.translator.utils;

public class TextSpliterator {

    private TextSpliterator() {

    }

    public static String[] getSplittedText(String text) {
        return text.split(" ");
    }

}
