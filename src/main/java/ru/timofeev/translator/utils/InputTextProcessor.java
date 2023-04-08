package ru.timofeev.translator.utils;

public class InputTextProcessor {

    private InputTextProcessor() {

    }

    public static String getProcessedText(String text) {
        String processedText = text.replace(",", " ");
        processedText = processedText.replaceAll("\\s+", " ");
        return processedText;
    }

}
