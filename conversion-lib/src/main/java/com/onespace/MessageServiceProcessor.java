package com.onespace;

import com.onespace.enums.ErrorMessages;
import com.onespace.enums.Material;
import com.onespace.enums.QueryEnum;
import com.onespace.enums.RomanNumeralSymbol;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageServiceProcessor {

    private Map<String, RomanNumeralSymbol> intergalacticRomanMap = new HashMap();
    public Map<Material, Double> mapMetalToNumericValue = new HashMap();
    private List<String> sentenceAnswers = new ArrayList();

    public String process(String messages) {

        if (messages == null  || messages.isEmpty()) {
            throw new NullPointerException("Input can't be null");
        }

        QueryProcessorFactory queryProcessorFactory;

        String[] sentenceArray = messages.split("\n");

        int lastPositionFound = intergalacticToRomanNumeralMap(sentenceArray);

        for (int i = lastPositionFound; i < sentenceArray.length; i++) {
            String sentence = sentenceArray[i];

            if (sentence.endsWith(QueryEnum.CREDIT.getDescription())) {
                queryProcessorFactory = QueryFactory.getInstance(sentence,QueryEnum.CREDIT,intergalacticRomanMap,mapMetalToNumericValue);
                queryProcessorFactory.processIt();
            } else if (sentence.startsWith(QueryEnum.HOW_MUCH.getDescription())) {
                queryProcessorFactory = QueryFactory.getInstance(sentence,QueryEnum.HOW_MUCH,intergalacticRomanMap,null);
                String response = queryProcessorFactory.processIt();
                if (response != null) {
                    sentenceAnswers.add(response);
                }
            } else if (sentence.startsWith(QueryEnum.HOW_MANY_CREDIT.getDescription())) {
                queryProcessorFactory = QueryFactory.getInstance(sentence,QueryEnum.HOW_MANY_CREDIT,intergalacticRomanMap,mapMetalToNumericValue);
                String response = queryProcessorFactory.processIt();
                if (response != null) {
                    sentenceAnswers.add(response);
                }
            } else {
                sentenceAnswers.add(ErrorMessages.WRONG_SENTENCE_INPUT);
            }

        }

        if(sentenceAnswers.size() > 0){
            return buildOutPut();
        }else{
            return "No -Content";
        }

    }

    private String buildOutPut() {
        StringBuilder outPut = new StringBuilder();
        for(int i = 0; i < sentenceAnswers.size();i++){
            outPut.append(sentenceAnswers.get(i));
            outPut.append("\n");
        }
        return outPut.toString();
    }


    /**
     *
     * @param inputSentences
     * @return
     */
    private int intergalacticToRomanNumeralMap(String[] inputSentences) {
        int positionOfIntergalacticSymbol = 0;
        int positionOfRomanSymbol = 2;
        for (int i = 0; i < inputSentences.length; i++) {
            String[] values = inputSentences[i].split(" ");
            //Array should have only 3 words
            if (values.length == 3) {
                RomanNumeralSymbol symbol = RomanNumeralSymbol.getFromCharacter(values[positionOfRomanSymbol]);
                intergalacticRomanMap.put(values[positionOfIntergalacticSymbol],symbol );
            } else {
                return i;
            }
        }
        return -1;
    }





}
