package com.onespace.rules;

public interface Rule {
    void executeRule(String value);
    Object executeRule();
    boolean hasRuleFailure();
}
