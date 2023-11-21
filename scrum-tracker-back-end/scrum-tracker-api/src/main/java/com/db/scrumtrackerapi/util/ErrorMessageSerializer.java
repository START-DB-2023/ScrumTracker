package com.db.scrumtrackerapi.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.db.scrumtrackerapi.model.view.ErrorMessageView;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer for converting ErrorMessageView objects to JSON format.
 *
 * This component is responsible for serializing ErrorMessageView objects into a JSON representation.
 */
@Component
public class ErrorMessageSerializer extends JsonSerializer<ErrorMessageView> {

    /**
     * Serializes an ErrorMessageView object to JSON format.
     *
     * @param value      The ErrorMessageView object to be serialized.
     * @param gen        The JsonGenerator to write JSON content.
     * @param serializers The SerializerProvider to access serializers for nested objects.
     * @throws IOException If an I/O error occurs during serialization.
     */
    @Override
    public void serialize(ErrorMessageView value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
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

