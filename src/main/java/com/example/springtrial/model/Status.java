package com.example.springtrial.model;

public enum Status {
    SELLABLE("SELLABLE"),
    UNFULFILLABLE("UNFULFILLABLE"),
    INBOUND("INBOUND"),;
    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

