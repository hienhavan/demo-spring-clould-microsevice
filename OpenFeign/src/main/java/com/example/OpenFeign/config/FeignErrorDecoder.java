package com.example.OpenFeign.config;

import com.google.common.io.CharStreams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        String result;
        try (Reader reader = response.body().asReader()) {
            result = CharStreams.toString(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Tạo ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // Tắt tính năng fail on unknown properties
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // Đọc JSON thành ObjectNode
        ObjectNode objectNode;
        try {
            objectNode = (ObjectNode) mapper.readTree(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Lấy thông điệp từ ObjectNode
        String message = objectNode.get("message").asText();
        System.out.println("Message from response: " + message);

        return errorDecoder.decode(methodKey, response);
    }
}
