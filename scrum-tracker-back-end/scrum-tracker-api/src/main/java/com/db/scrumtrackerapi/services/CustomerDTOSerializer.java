package com.db.scrumtrackerapi.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.db.scrumtrackerapi.models.dtos.CustomerDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Service
public class CustomerDTOSerializer extends JsonSerializer<CustomerDTO> {

    @Override
    public void serialize(CustomerDTO value, JsonGenerator gen, SerializerProvider serializers) {
        try {
            gen.writeStartObject();
            gen.writeStringField("email", value.getEmail());
            gen.writeStringField("name", value.getName());
            gen.writeStringField("lastName", value.getLastName());
            gen.writeStringField("password", value.getPassword());
            gen.writeStringField("role", value.getRole().name());
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
