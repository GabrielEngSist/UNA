package com.example.meetchecker.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class CustomGson {
    private static CustomGson customGson;
    private static Gson gson;
    private CustomGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        gson = gsonBuilder.setPrettyPrinting().create();
    }

    public static Gson getInstance(){
        if(customGson == null){
            customGson = new CustomGson();
        }
        return gson;
    }
}
