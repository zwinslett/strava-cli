package com.zwinslett.strava.formatter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonFormatter {
    public static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    
    public static String formatJson(String json){
        try {
            JsonNode tree = objectMapper.readTree(json);
            return objectMapper.writeValueAsString(tree);
        } catch (Exception e) {
            return "Error formatting JSON: " + e.getMessage();
        }
    }
}