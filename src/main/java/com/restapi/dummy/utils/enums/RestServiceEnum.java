package com.restapi.dummy.utils.enums;

public enum RestServiceEnum {
    BASE_URL("https://dummy.restapiexample.com/api/v1"),
    URI_CREATE_EMPLOYEE("/create"),
    URI_CONSULT_USERS("/employee");

    private String uri;

    RestServiceEnum(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return uri;
    }
}
