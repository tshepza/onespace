package com.onespace.rules;

import com.onespace.enums.RomanNumeralSymbol;


/**
 *  This rules checks any illegal Symbol that is not part of legal Roman Symbols
 */
public class ValidateIllegalRomanSymbol implements Rule{
    private Boolean ruleFailed =Boolean.FALSE;
    private String illegalRomanSymbol;
    private String input;


    public ValidateIllegalRomanSymbol(String input) {
        this.input = input;
    }

    public ValidateIllegalRomanSymbol() {
    }

    @Override
    public void executeRule(String input) {
       this.input =input;
       ruleFailed = stringInputIsValid();
    }

    @Override
    public Object executeRule() {
        ruleFailed =stringInputIsValid();
        return this;
    }

    @Override
    public boolean hasRuleFailure() {
        return ruleFailed;
    }

    public String getIllegalRomanSymbol() {
        return illegalRomanSymbol;
    }

    private boolean stringInputIsValid(){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String s = String.valueOf(c);
            if(invalidRomanSymbol(s)){
                illegalRomanSymbol =s;
                return Boolean.TRUE ;
            }
        }
        return Boolean.FALSE;
    }

    private  boolean invalidRomanSymbol(String value){
        RomanNumeralSymbol symbolE = RomanNumeralSymbol.getFromCharacter(value);
        return symbolE == null ;
    }


}
