package com.onespace.enums;


/**
 *
 */
public class RulesConstants {
    //The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
    public static final String[] NUMERALS_ALLOWED_TO_REPEAT = {"I","C","M","X"};

    //"D", "L", and "V" can never be repeated.
    public static final String[] NUMERALS_NOT_ALLOWED_TO_REPEAT = {"D","L","V"};


    private RulesConstants() {
        throw new IllegalStateException("Utility class");
    }
}
