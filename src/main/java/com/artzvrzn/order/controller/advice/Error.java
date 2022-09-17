package com.artzvrzn.order.controller.advice;

public class Error {
    private String name;
    private String field;

    public Error(String name, String field) {
        this.name = name;
        this.field = field;
    }
}
