package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.RomanNumeralSymbol;
import com.onespace.enums.SentenceTypeConstants;

import java.util.Map;

public class QueryProcessorHowMany extends QueryProcessorAbstraction implements QueryProcessorFactory{
    private String sentence;
    public QueryProcessorHowMany(String sentence, Map<String, RomanNumeralSymbol> intergalacticRomanMap, Map<Material, Double> mapMetalToNumericValue) {
        super(intergalacticRomanMap, mapMetalToNumericValue);
        this.sentence = sentence;
    }

    @Override
    public String processIt() {
        String temp = sentence.substring((SentenceTypeConstants.HOW_MANY_CREDIT).length());
        temp= temp.trim();
        String[] sentenceArray = temp.split(" ");
        String romanNumeral = findRomanNumeralByInteSymbols(sentenceArray);

        Integer romanNumeralNumericValue = RomanNumeralToNumericConverter.convert(romanNumeral);

        Material metalName = findMetal(sentenceArray);
        if (metalName != null) {
            Double val = getMetalValue(metalName);
            Double creditsDbl = romanNumeralNumericValue * val;
            int credits = creditsDbl.intValue();
            String answer = temp.replace("?", String.format("is %s Credits", credits));
            System.out.println(answer);
            return answer;
        }
        return null;
    }
}
