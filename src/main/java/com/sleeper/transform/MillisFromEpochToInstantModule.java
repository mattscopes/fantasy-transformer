package com.sleeper.transform;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;

public class MillisFromEpochToInstantModule extends SimpleModule {
    
    public MillisFromEpochToInstantModule() {
        
        addDeserializer(Instant.class, new JsonDeserializer<Instant>() {
            @Override
            public Instant deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
                return Instant.ofEpochMilli(jp.getLongValue());
            }
        });
        
        addSerializer(new StdSerializer<Instant>(Instant.class) {
            @Override
            public void serialize(Instant instant, JsonGenerator jg, SerializerProvider sp) throws IOException {
                jg.writeNumber(instant.toEpochMilli());
            }
        });
        
    }
    
}
