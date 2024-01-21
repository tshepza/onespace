package com.onespace.conversion;

import com.onespace.enums.ErrorMessages;
import com.onespace.rules.ValidateRomanNumeralSymbolLimitedRepeat;
import org.junit.Assert;
import org.junit.Test;

public class ValidateRomanNumeralSymbolLimitedRepeatTest {


    @Test
    public void testInValidMessageInput(){
        String message = "This is invalid message";
        ValidateRomanNumeralSymbolLimitedRepeat val1 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("XXCVIIII").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_REPEAT, val1.getViolatedRomanNumeral(),val1.getLimit()),val1.hasRuleFailure());

        ValidateRomanNumeralSymbolLimitedRepeat val2 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("XXCCCCIII").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_REPEAT, val2.getViolatedRomanNumeral(),val2.getLimit()),val2.hasRuleFailure());

        ValidateRomanNumeralSymbolLimitedRepeat val3 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("MMMMXCII").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_REPEAT, val3.getViolatedRomanNumeral(),val3.getLimit()),val3.hasRuleFailure());

        ValidateRomanNumeralSymbolLimitedRepeat val4 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("XXXXCV").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_REPEAT, val4.getViolatedRomanNumeral(),val4.getLimit()),val4.hasRuleFailure());
    }


    @Test
    public void testAValidMessageInput(){
        String message = "This is a valid string, please check your validator";

        ValidateRomanNumeralSymbolLimitedRepeat val1 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("XXCVIII").executeRule();
        Assert.assertFalse(message, val1.hasRuleFailure());

        ValidateRomanNumeralSymbolLimitedRepeat val2 = new ValidateRomanNumeralSymbolLimitedRepeat();
        val2.executeRule("XXCCCIII");
        Assert.assertFalse(message, val2.hasRuleFailure());

        ValidateRomanNumeralSymbolLimitedRepeat val3 = (ValidateRomanNumeralSymbolLimitedRepeat) new ValidateRomanNumeralSymbolLimitedRepeat("MMMXCII").executeRule();
        Assert.assertFalse(message, val3.hasRuleFailure());

    }


}

