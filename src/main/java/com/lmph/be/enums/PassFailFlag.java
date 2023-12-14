package com.lmph.be.enums;

import lombok.Getter;

@Getter
public enum PassFailFlag {

    Unset ('U'),
    Failed ('F'),
    Passed ('P');

    private final char rating;

    PassFailFlag(char rating) {
        this.rating = rating;
    }

    public static PassFailFlag getReverse(char i){
        return switch (i) {
            case 'F' -> PassFailFlag.Failed;
            case 'P' -> PassFailFlag.Passed;
            default -> PassFailFlag.Unset;
        };
    }

    public static char getLabelOfFlag(String color) {
        for (PassFailFlag pff : values()) {
            if (pff.name().equals(color)) {
                return pff.rating;
            }
        }
        return 0;
    }
}
