package com.onespace;

import com.onespace.calculations.Calculate;
import com.onespace.enums.RomanNumeralSymbol;

public class RomanNumeralToNumericConverter {

    public static int convert(String input) {

        Error error = Validator.executeRules(input);

        if (error.isHasError()) {
            throw new IllegalArgumentException ("Input contains invalid Roman Numeral "  + error.getErrorMessage() );
        }

        int sumOfSymbols = 0;
        int thousand = 0;
        int hundreds = 0;

        int startIndex = 0;

        ///MM D XX II

        thousand = findThousandsAndHundredsFromInput(RomanNumeralSymbol.M.getSymbol(), input);
        hundreds = findThousandsAndHundredsFromInput(RomanNumeralSymbol.C.getSymbol(), input);

        startIndex = startIndex + thousand;

        startIndex = startIndex + hundreds;

        //This calculates the sum of M and C
        sumOfSymbols = (thousand * RomanNumeralSymbol.M.getValue() )+ (hundreds * RomanNumeralSymbol.C.getValue());

        boolean checkIfInputHasOddInputLength;
        if (sumOfSymbols == 0) {
            checkIfInputHasOddInputLength = ((input.length() % 2) != 0);
            if (checkIfInputHasOddInputLength) {
                sumOfSymbols = new Calculate().compute(RomanNumeralSymbol.getFromCharacter(String.valueOf(input.charAt(0)))).getTotal();
                startIndex = 1;
            }
        }

        for (int i = startIndex; i < input.length(); i++) {
            char xVal = input.charAt(i);
            char yVal = '\0';
            if ((i + 1) < input.length()) {
                yVal = input.charAt(i + 1);
                i++;
            }
            String xx = xVal == 0 ? null : String.valueOf(xVal);
            String yy = yVal == 0 ? null : String.valueOf(yVal);


            if (yy == null || yy.isEmpty()) {
                sumOfSymbols = sumOfSymbols + new Calculate().compute(RomanNumeralSymbol.getFromCharacter(xx)).getTotal();
            } else {
                sumOfSymbols = sumOfSymbols + new Calculate().compute(RomanNumeralSymbol.getFromCharacter(xx), RomanNumeralSymbol.getFromCharacter(yy)).getTotal();
            }

        }

        return sumOfSymbols;

    }


    /**
     * This checks if the given input starts with M | MM | MMM or C | CC | CCC
     * @param symbol e.g C | M
     * @param input
     * @return
     */
    private static int findThousandsAndHundredsFromInput(String symbol, String input) {
        if (input.startsWith(buildRomanNumeral(symbol, 3))) {
            return 3;
        } else if (input.startsWith(buildRomanNumeral(symbol, 2))) {
            return 2;
        } else if (input.startsWith(buildRomanNumeral(symbol, 1))) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     *
     * @param symbol
     * @param count
     * @return this return M | MM | MMM or C | C | C based on symbol
     */
    private static String buildRomanNumeral(String symbol, int count) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < count; i++) {
            temp.append(symbol);
        }
        return temp.toString();
    }
}
