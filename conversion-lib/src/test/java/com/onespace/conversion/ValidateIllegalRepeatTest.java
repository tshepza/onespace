package com.onespace.conversion;

import com.onespace.enums.ErrorMessages;
import com.onespace.rules.ValidateIllegalRepeat;
import org.junit.Assert;
import org.junit.Test;

public class ValidateIllegalRepeatTest {

    //"D", "L", and "V" can never be repeated.

    @Test
    public void testSymbolsMustNotAppearMoreThanOne() {
        ValidateIllegalRepeat rule1 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCMXDD").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.NO_REPEAT, rule1.getViolatedRomanNumeral()), rule1.hasRuleFailure());

        ValidateIllegalRepeat rule2 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("DDMCMXDD").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.NO_REPEAT, rule2.getViolatedRomanNumeral()), rule2.hasRuleFailure());

        ValidateIllegalRepeat rule3 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCLMXL").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.NO_REPEAT, rule3.getViolatedRomanNumeral()), rule3.hasRuleFailure());

        ValidateIllegalRepeat rule4 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCMVVXDD").executeRule();
        Assert.assertTrue(String.format(ErrorMessages.NO_REPEAT, rule4.getViolatedRomanNumeral()), rule4.hasRuleFailure());

        ValidateIllegalRepeat rule5 = new ValidateIllegalRepeat();
        rule5.executeRule("VMCMVDDV");
        Assert.assertTrue(String.format(ErrorMessages.NO_REPEAT, rule5.getViolatedRomanNumeral()), rule5.hasRuleFailure());

    }

    @Test
    public void testSymbolsMustNotAppearMoreThanOneNegativeTest() {

        ValidateIllegalRepeat rule1 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCMXD").executeRule();
        Assert.assertFalse(String.format(ErrorMessages.NO_REPEAT, rule1.getViolatedRomanNumeral()), rule1.hasRuleFailure());

        ValidateIllegalRepeat rule2 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCMXD").executeRule();
        Assert.assertFalse(String.format(ErrorMessages.NO_REPEAT, rule2.getViolatedRomanNumeral()), rule2.hasRuleFailure());

        ValidateIllegalRepeat rule3 = (ValidateIllegalRepeat) new ValidateIllegalRepeat("MCLMX").executeRule();
        Assert.assertFalse(String.format(ErrorMessages.NO_REPEAT, rule3.getViolatedRomanNumeral()), rule3.hasRuleFailure());

    }
}
