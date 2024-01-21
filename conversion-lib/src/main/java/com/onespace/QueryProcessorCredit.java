package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.RomanNumeralSymbol;

import java.util.Map;

public class QueryProcessorCredit extends QueryProcessorAbstraction implements QueryProcessorFactory{
    private String sentence;

    protected QueryProcessorCredit(String sentence,Map<String, RomanNumeralSymbol> intergalacticRomanMap, Map<Material, Double> mapMetalToNumericValue) {
        super(intergalacticRomanMap, mapMetalToNumericValue);
        this.sentence=sentence;
    }

    @Override
    public String processIt() {
        String[] sentenceArray = sentence.split(" ");
        String romanNumeral = findRomanNumeralByInteSymbols(sentenceArray);
        Material material = findMetal(sentenceArray);
        int value = findNumericValue(sentenceArray);
        int numericValueForRomanSymbol = RomanNumeralToNumericConverter.convert(romanNumeral);
        Double metalValue = Double.valueOf((double) value / numericValueForRomanSymbol);
        mapMetalToNumericValue.put(material, metalValue);
        return "Credit : " + material.getName() + " Value : " + metalValue;
    }
}
