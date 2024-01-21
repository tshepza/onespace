package com.onespace.enums;

public class ErrorMessages {
    public static final String ILLEGAL_REPEAT = "%s can't be repeated more than %s times";
    public static final String ILLEGAL_ROMAN_SYMBOL = "%s is invalid roman symbol";
    public static final String NO_REPEAT = "%s can't be repeated";
    public static final String INVALID_SUBTRACTION ="Invalid subtraction,%s can be subtracted from %s and %s only";
    public static final String NOT_ALLOWED_SUBTRACTION ="V, L, and D can never be subtracted";
    public static final String WRONG_SENTENCE_INPUT= "I have no idea what you are talking about";

    private ErrorMessages() {
        throw new IllegalStateException("Utility class");
    }
}
