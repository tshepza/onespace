package com.onespace.conversion;

import com.onespace.RomanNumeralToNumericConverter;
import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralToNumericConverterTest {
    @Test
   public void test(){
/*

        //glob glob Silver is 34 Credits
        Assert.assertEquals("XXXII",17, RomanNumeralToNumericConverter.convert("XVII") ); //32   II=2    === 32 * 1 + 2

        //glob prok Silver is 68 Credits
        Assert.assertEquals("42",42, RomanNumeralToNumericConverter.convert("XLII") ); // 32   IV=4    ====  32 * 2 + 4

        //glob prok Gold is 57800 Credits
        // IV

        //pish tegj glob glob is 42
        Assert.assertEquals("XLII",42, RomanNumeralToNumericConverter.convert("XLII") );


        ///





        /////
        Assert.assertEquals("M", RomanNumeralToNumericConverter.convert("M"), 1000);
        Assert.assertEquals("MMCDXXI", RomanNumeralToNumericConverter.convert("MCMIII"), 1903);
        Assert.assertEquals("XXXIX", RomanNumeralToNumericConverter.convert("XXXIX"), 39);
        Assert.assertEquals("CCXLVI", RomanNumeralToNumericConverter.convert("CCXLVI"), 246);
        Assert.assertEquals("DCCLXXXIX", RomanNumeralToNumericConverter.convert("DCCLXXXIX"), 789);
        Assert.assertEquals("MMCDXXI", RomanNumeralToNumericConverter.convert("MMCDXXI"), 2421);
        Assert.assertEquals("CLX", RomanNumeralToNumericConverter.convert("CLX"), 160);
        Assert.assertEquals("CCVII", RomanNumeralToNumericConverter.convert("CCVII"), 207);
        Assert.assertEquals("MIX", RomanNumeralToNumericConverter.convert("MIX"), 1009);
        Assert.assertEquals("MLXVI", RomanNumeralToNumericConverter.convert("MLXVI"), 1066);

        Assert.assertEquals("MMMCMXCIX", RomanNumeralToNumericConverter.convert("MMMCMXCIX"),3999);
        Assert.assertEquals("MDCCLXXVI", RomanNumeralToNumericConverter.convert("MDCCLXXVI"),1776  );
        Assert.assertEquals("MCMXVIII", RomanNumeralToNumericConverter.convert("MCMXVIII"),1918  );

        Assert.assertEquals("MCMXLIV", RomanNumeralToNumericConverter.convert("MCMXLIV"),1944 );
        Assert.assertEquals("MMXXIV", RomanNumeralToNumericConverter.convert("MMXXIV"),2024 );
        Assert.assertEquals("LXXXVIII", RomanNumeralToNumericConverter.convert("LXXXVIII"),88 );
*/



    }


   @Test
   public void ttt(){
        int thousand=0;
        String input = "XLII";
        int count = 0;

        thousand= findThousand(input);

       System.out.println("Thousands :" + thousand);
        for(int x =thousand;x < input.length();x++){

        }


   }

    private int findThousand(String input) {
        if(input.startsWith("MMM")){
            return 3;
        }else if(input.startsWith("MM")){
            return 2;
        }else if(input.startsWith("M")){
            return 1;
        }else{
            return 0;
        }
    }

}
