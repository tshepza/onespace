package com.onespace;

import com.onespace.enums.Material;
import com.onespace.enums.RomanNumeralSymbol;
import com.onespace.exceptions.MetalValueNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class QueryProcessorAbstraction {
    private int processPosition=0;
    private Map<String, RomanNumeralSymbol> intergalacticRomanMap ;
    public Map<Material, Double> mapMetalToNumericValue ;
    private List<String> sentenceAnswers = new ArrayList();


    protected QueryProcessorAbstraction(Map<String,RomanNumeralSymbol> intergalacticRomanMap, Map<Material, Double> mapMetalToNumericValue) {
        this.intergalacticRomanMap = intergalacticRomanMap;
        this.mapMetalToNumericValue =mapMetalToNumericValue ;
    }

    //public abstract  void process();

    protected void addSentenceAnswers(String sentenceAnswers) {
        this.sentenceAnswers.add(sentenceAnswers);
    }

    public List<String> getSentenceAnswers() {
        return sentenceAnswers;
    }

    protected Material findMetal(String[] sentenceArray) {
        Material material = null;
        int i = processPosition;
        while (i < sentenceArray.length && material == null) {
            material = Material.getFromName(sentenceArray[i]);
            i++;
        }
        processPosition = i;
        return material;
    }

    protected Double getMetalValue(Material metal) {
        Double metalValue = mapMetalToNumericValue.get(metal);
        if (metalValue == null) {
            throw new MetalValueNotFound(String.format("Undefined value of %s", metal));
        }
        return metalValue;
    }

    protected String findRomanNumeralByInteSymbols(String[] sentenceArray) {
        StringBuilder romanNumeralStringBuilder = new StringBuilder();
        for (int i = processPosition; i < sentenceArray.length; i++) {
            RomanNumeralSymbol val = intergalacticRomanMap.get(sentenceArray[i]);
            if (val != null) {
                romanNumeralStringBuilder.append(val.getSymbol());
                processPosition = i+1;
            } else {
                break;
            }
        }
        return romanNumeralStringBuilder.length() > 0 ? romanNumeralStringBuilder.toString() : null;

    }
    protected int findNumericValue(String[] sentence) {
        for (int i =processPosition ; i < sentence.length; i++) {
            try {
                return Integer.parseInt(sentence[i]);
            } catch (NumberFormatException e) {
                processPosition = i+1;
            }
        }
        return -1;
    }


}
