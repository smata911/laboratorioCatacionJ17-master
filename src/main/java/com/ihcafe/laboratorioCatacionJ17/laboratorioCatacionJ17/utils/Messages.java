package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String messageKey){
        return messageSource.getMessage(messageKey, null, Locale.ENGLISH);
    }
}
