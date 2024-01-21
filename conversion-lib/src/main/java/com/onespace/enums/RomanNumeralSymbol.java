package com.onespace.enums;

/**
 * The set of Roman Symbols and their fixed integer value
 */
public enum RomanNumeralSymbol {
    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L", 50),
    C("C", 100),
    D("D", 500),
    M("M", 1000);

    private String symbol;
    private int value;

    RomanNumeralSymbol(String name, int value) {
        this.symbol = name;
        this.value = value;
    }

    /**
     *  Given the character return the respective RomanNumeralSymbol enum
     * @param characterSymbol
     * @return return the
     */
    public static RomanNumeralSymbol getFromCharacter(String characterSymbol) {
        if (characterSymbol == null) {
            return null;
        }
        for (RomanNumeralSymbol romanNumeralSymbol : RomanNumeralSymbol.values()) {
            if (romanNumeralSymbol.getSymbol().equals(characterSymbol)) {
                return romanNumeralSymbol;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }
}
