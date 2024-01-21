package com.onespace.enums;

public enum QueryEnum {

    CREDIT ("Credits"),
    HOW_MUCH("how much is "),
    HOW_MANY_CREDIT("how many Credits is");

    private String description;
    QueryEnum(String s) {
        this.description =s;
    }

    public String getDescription() {
        return description;
    }
}
