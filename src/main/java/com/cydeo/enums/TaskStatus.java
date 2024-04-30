package com.cydeo.enums;

import org.springframework.beans.factory.annotation.Value;

public enum TaskStatus {
    OPEN("Open"), IN_PROGRESS("In Progress"), UAT_TEST("UAT Testing"), COMPLETE("Complete");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
