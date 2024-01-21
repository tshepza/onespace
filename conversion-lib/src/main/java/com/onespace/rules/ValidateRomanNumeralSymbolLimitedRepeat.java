package com.onespace.rules;

import com.onespace.enums.RulesConstants;

/**
 * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no mor
 *  This will check that "I", "X", "C", and "M"  only appears three times in succession in a given string.
 *  Given  input as XXCVIIII will result in rule failure. "I" appears 3 times in succession
 *
 */
public class ValidateRomanNumeralSymbolLimitedRepeat implements Rule{
    private static final int REPEAT_LIMIT = 3;
    private Boolean ruleFailed =Boolean.FALSE;
    private String violatedRomanNumeral;
    private String input;

    public ValidateRomanNumeralSymbolLimitedRepeat(String input) {
        this.input = input;
    }

    public ValidateRomanNumeralSymbolLimitedRepeat() {
    }


    /**
     *  Valid if the input does not have numerals repeating more than three time
     * @param input
     */
    @Override
    public void executeRule(String input){
        this.input = input;
        execute();
    }

    private void execute() {
        for(String s: RulesConstants.NUMERALS_ALLOWED_TO_REPEAT){
            if(checkRepeat(s.charAt(0), this.input)){
                violatedRomanNumeral =s;
                ruleFailed= Boolean.TRUE;
                return;
            }
        }
    }

    /**
     *  Valid if the input does not have numerals repeating more than three time
     */
    @Override
    public Object executeRule() {
        execute();
        return this;
    }

    @Override
    public boolean hasRuleFailure() {
        return ruleFailed;
    }


    private boolean checkRepeat(char limitRepeatSymbol,String valueToValidate){
        int count =0;
        for(int i = 0; i < valueToValidate.length(); i++){
            char c = valueToValidate.charAt(i);
            if(limitRepeatSymbol==c){
                count++;
                if(count > REPEAT_LIMIT){
                    return Boolean.TRUE;
                }
            }


        }
        return Boolean.FALSE;
    }



    public int getLimit() {
        return REPEAT_LIMIT;
    }


    public String getViolatedRomanNumeral() {
        return violatedRomanNumeral;
    }
}
