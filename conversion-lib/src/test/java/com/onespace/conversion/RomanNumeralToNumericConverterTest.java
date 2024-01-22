package com.onespace.conversion;

import com.onespace.RomanNumeralToNumericConverter;
import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralToNumericConverterTest {
    @Test
   public void tetsRomanNumeralConverstion(){


        Assert.assertEquals("XXXII",17, RomanNumeralToNumericConverter.convert("XVII") );

        Assert.assertEquals("M", RomanNumeralToNumericConverter.convert("M"), 1000);

        Assert.assertEquals("MMCDXXI", RomanNumeralToNumericConverter.convert("MCMIII"), 1903);

        Assert.assertEquals("CLX", RomanNumeralToNumericConverter.convert("CLX"), 160);

        Assert.assertEquals("MCMXLIV", RomanNumeralToNumericConverter.convert("MCMXLIV"),1944 );
        Assert.assertEquals("MMXXIV", RomanNumeralToNumericConverter.convert("MMXXIV"),2024 );
        Assert.assertEquals("LXXXVIII", RomanNumeralToNumericConverter.convert("LXXXVIII"),88 );

    }

}
