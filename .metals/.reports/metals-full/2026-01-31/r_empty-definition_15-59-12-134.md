error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/JsonFormatter.java:_empty_/ObjectMapper#writeValueAsString#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/JsonFormatter.java
empty definition using pc, found symbol in pc: _empty_/ObjectMapper#writeValueAsString#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 519
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/JsonFormatter.java
text:
```scala
package com.zwinslett.strava;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonFormatter {
    public static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);
    
    public static String formatJson(String json){
        try {
            JsonNode tree = objectMapper.readTree(json);
            return objectMapper.writeValueAsS@@tring(tree);
        } catch (Exception e) {
            return "Error formatting JSON: " + e.getMessage();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ObjectMapper#writeValueAsString#