package com.onespace.rules;

import com.onespace.enums.RulesConstants;

import java.util.MissingResourceException;

/**
 *     //"D", "L", and "V" can never be repeated.
 */
public class ValidateIllegalRepeat implements Rule {

    private Boolean ruleFailed =Boolean.FALSE;
    private String violatedRomanNumeral;
    private String input;


    public ValidateIllegalRepeat(String input) {
        this.input = input;
    }

    public ValidateIllegalRepeat() {
    }

    /**
     *  This will check that D,L and V only appears once in a given string.
     *  Given  input as MCMXDD will result in rule failure. D appears twice in this instance
     *
     * @param input
     */
    @Override
    public void executeRule(String input) {
        this.input = input;
        ruleFailed = duplicateSymbol();
    }

    @Override
    public Object executeRule() {
        ruleFailed = duplicateSymbol();
        return this;
    }

    @Override
    public boolean hasRuleFailure() {
        return ruleFailed;
    }

    public String getViolatedRomanNumeral() {
        return violatedRomanNumeral;
    }

    /**
     * This will
     *
     * @param
     * @return
     */
    private boolean duplicateSymbol(){
        if(this.input == null){
            throw new MissingResourceException("Input string not provided","ValidateIllegalRepeat","");
        }

        for(String c: RulesConstants.NUMERALS_NOT_ALLOWED_TO_REPEAT){
           if( symbolAppearsMoreThanOnceInInputString(c.charAt(0),this.input)){
               violatedRomanNumeral = c;
               return true;
           }
        }
        return false;
    }

    private boolean symbolAppearsMoreThanOnceInInputString(char c,String value) {
        int count = 0;
        for(int i =0;i< value.length();i++){
            if(value.charAt(i) == c ){
                count++;
            }
            if(count > 1 ){
                return true;
            }
        }
        return false;
    }


}
