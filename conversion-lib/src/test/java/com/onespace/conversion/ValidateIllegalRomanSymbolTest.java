package com.onespace.conversion;

import com.onespace.enums.ErrorMessages;
import com.onespace.rules.ValidateIllegalRomanSymbol;
import org.junit.Assert;
import org.junit.Test;

public class ValidateIllegalRomanSymbolTest {


    @Test
    public void validateIllegalRomanNumeral(){
        ValidateIllegalRomanSymbol rule1 = new ValidateIllegalRomanSymbol();
        rule1.executeRule("TTTTTT");
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_ROMAN_SYMBOL, rule1.getIllegalRomanSymbol()), rule1.hasRuleFailure());

        ValidateIllegalRomanSymbol rule2 = (ValidateIllegalRomanSymbol) new ValidateIllegalRomanSymbol("AZAZ").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.ILLEGAL_ROMAN_SYMBOL, rule2.getIllegalRomanSymbol()), rule2.hasRuleFailure());
    }
}
