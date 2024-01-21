package com.onespace;

import com.onespace.enums.ErrorMessages;
import com.onespace.rules.ValidateIllegalRepeat;
import com.onespace.rules.ValidateRomanNumeralSymbolLimitedRepeat;

/**
 *
 */
public class Validator {



    public  static Error executeRules(String input){
        ValidateRomanNumeralSymbolLimitedRepeat rule = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat(input).executeRule();
        if(rule.hasRuleFailure()){
            return new Error(String.format(ErrorMessages.ILLEGAL_REPEAT, rule.getViolatedRomanNumeral(),rule.getLimit()),Boolean.TRUE);
        }

        ValidateIllegalRepeat rule2 = (ValidateIllegalRepeat) new ValidateIllegalRepeat(input).executeRule();
        if(rule.hasRuleFailure()){
            return new Error(String.format(ErrorMessages.NO_REPEAT,rule2.getViolatedRomanNumeral()),Boolean.TRUE);
        }

        return new Error(null,Boolean.FALSE);
    }
}
