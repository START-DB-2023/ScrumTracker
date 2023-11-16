package com.db.scrumtrackerapi.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.db.scrumtrackerapi.model.ErrorMessage;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class ErrorMessageSerializer extends JsonSerializer<ErrorMessage> {

    @Override
    public void serialize(ErrorMessage value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        try {
            gen.writeStartObject();
            gen.writeStringField("description", value.getDescription());
            gen.writeStringField("status", String.valueOf(value.getStatus()));
            gen.writeStringField("exceptionMessage", value.getExceptionMessage());
            gen.writeStringField("timestamp", value.getTimestamp().toString());
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
