package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.RomanNumeralSymbol;
import com.onespace.enums.SentenceTypeConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
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
            log.info(answer);
            return answer;
        }
        return null;
    }
}
