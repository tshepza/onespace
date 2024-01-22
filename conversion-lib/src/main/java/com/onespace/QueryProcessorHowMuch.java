package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.RomanNumeralSymbol;
import com.onespace.enums.SentenceTypeConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class QueryProcessorHowMuch extends QueryProcessorAbstraction implements QueryProcessorFactory {
    private String sentence;
    public QueryProcessorHowMuch(String sentence, Map<String, RomanNumeralSymbol> intergalacticRomanMap, Map<Material, Double> mapMetalToNumericValue) {
        super(intergalacticRomanMap, mapMetalToNumericValue);
        this.sentence=sentence;
    }


    @Override
    public String processIt() {
        String temp = sentence.substring(SentenceTypeConstants.HOW_MUCH.length());
        String[] sentenceArray = temp.split(" ");
        String romanNumeral = findRomanNumeralByInteSymbols( sentenceArray);
        int credits = RomanNumeralToNumericConverter.convert(romanNumeral);
        log.info(temp.replace("?", " is ") + credits);
        return  temp.replace("?", " is ") + credits;
    }
}
