package ru.timofeev.translator.utils.validator;

import ru.timofeev.translator.constants.exception.ExceptionMessageKeeper;
import ru.timofeev.translator.exception.InvalidRequestTextException;

public class InputTextValidator {

    public static void validateInputText(String text) {
        if (text.length() == 0) {
            throw new InvalidRequestTextException(ExceptionMessageKeeper.INPUT_TEXT_IS_EMPTY);
        }
    }

}
