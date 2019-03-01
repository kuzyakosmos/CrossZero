package com.crosszero;

import java.util.Arrays;

class Field {

    Field() {
        Arrays.fill(field, "*");
    }

    private String field[] = new String[9];

    public String[] getField() {
        return field;
    }

    public void setField(String[] field) {
        this.field = field;
    }
}
