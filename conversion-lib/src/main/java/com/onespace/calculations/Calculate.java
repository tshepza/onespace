package com.onespace.calculations;

import com.onespace.enums.ErrorMessages;
import com.onespace.enums.RomanNumeralSymbol;

public class Calculate {
    private int total = 0;

    public int getTotal() {
        return total;
    }

    public Calculate compute(RomanNumeralSymbol x, RomanNumeralSymbol y) {
        if (x.getValue() < y.getValue()) {
            return subtract(x, y);
        } else {
            return add(x, y);
        }
    }

    public Calculate compute(RomanNumeralSymbol x) {
        Calculate a = this;
        a.total = a.total + x.getValue();
        return a;
    }

    public Calculate add(RomanNumeralSymbol x, RomanNumeralSymbol y) {
        Calculate a = this;
        a.total = a.total + (x.getValue() + y.getValue());
        return a;
    }


    public Calculate subtract(RomanNumeralSymbol x, RomanNumeralSymbol y) {
        validateForSubtraction(x, y);

        Calculate a = this;
        a.total = a.total + (y.getValue() - x.getValue());
        return a;
    }

    private void validateForSubtraction(RomanNumeralSymbol x, RomanNumeralSymbol y) {

        if (RomanNumeralSymbol.V.equals(x) || RomanNumeralSymbol.L.equals(x) || RomanNumeralSymbol.D.equals(x)) {
            throw new ArithmeticException(ErrorMessages.NOT_ALLOWED_SUBTRACTION);
        }

        if (RomanNumeralSymbol.I.equals(x)) {
            if (!RomanNumeralSymbol.V.equals(y) && !RomanNumeralSymbol.X.equals(y)) {
                throw new ArithmeticException(String.format(ErrorMessages.INVALID_SUBTRACTION, RomanNumeralSymbol.I.getSymbol(), RomanNumeralSymbol.V.getSymbol(), RomanNumeralSymbol.X.getSymbol()));
            }
        }

        if (RomanNumeralSymbol.X.equals(x)) {
            if (!RomanNumeralSymbol.L.equals(y) && !RomanNumeralSymbol.C.equals(y)) {
                throw new ArithmeticException(String.format(ErrorMessages.INVALID_SUBTRACTION, RomanNumeralSymbol.X.getSymbol(), RomanNumeralSymbol.L.getSymbol(), RomanNumeralSymbol.C.getSymbol()));
            }
        }
        if (RomanNumeralSymbol.C.equals(x)) {
            if (!RomanNumeralSymbol.D.equals(y) && !RomanNumeralSymbol.M.equals(y)) {
                throw new ArithmeticException(String.format(ErrorMessages.INVALID_SUBTRACTION, RomanNumeralSymbol.C.getSymbol(), RomanNumeralSymbol.D.getSymbol(), RomanNumeralSymbol.M.getSymbol()));
            }
        }
    }
}
