package com.db.scrumtrackerapi.util;

import java.io.IOException;

import org.springframework.stereotype.Component;
import com.db.scrumtrackerapi.model.dto.CustomerDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * JsonSerializer for converting a CustomerDTO object to JSON format.
 */
@Component
public class CustomerDTOSerializer extends JsonSerializer<CustomerDTO> {

    /**
     * Serializes the given CustomerDTO object to JSON format.
     *
     * @param value      the CustomerDTO object to be serialized.
     * @param gen        the JsonGenerator to write JSON content.
     * @param serializers the SerializerProvider.
     */
    @Override
    public void serialize(CustomerDTO value, JsonGenerator gen, SerializerProvider serializers) {
        try {
            gen.writeStartObject();
            gen.writeStringField("name", value.getName());
            gen.writeStringField("lastName", value.getLastName());
            gen.writeStringField("email", value.getEmail());
            gen.writeStringField("password", value.getPassword());
            gen.writeStringField("role", value.getRole().name());
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
