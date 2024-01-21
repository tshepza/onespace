package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.QueryEnum;
import com.onespace.enums.RomanNumeralSymbol;

import java.util.Map;

/**
 *
 */
public class QueryFactory {


    public static QueryProcessorFactory getInstance(String sentence, QueryEnum query, Map<String, RomanNumeralSymbol> intergalacticRomanMap, Map<Material, Double> mapMetalToNumericValue){
        switch (query){
            case CREDIT:
                return new QueryProcessorCredit(sentence,intergalacticRomanMap,mapMetalToNumericValue);
            case HOW_MUCH:
                return new  QueryProcessorHowMuch(sentence,intergalacticRomanMap,mapMetalToNumericValue);
            case HOW_MANY_CREDIT:
                return new  QueryProcessorHowMany(sentence,intergalacticRomanMap,mapMetalToNumericValue);
            default:
                return null;
        }

    }
}
