package com.restapi.dummy.utils;

import com.google.gson.Gson;

public class ConverterJson {

     public static <T> String converter(T model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }
}
