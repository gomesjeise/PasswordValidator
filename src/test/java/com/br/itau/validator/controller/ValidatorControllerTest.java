package com.br.itau.validator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ValidatorControllerTest {

    @LocalServerPort
    private int port;

    HttpHeaders httpHeaders;

    String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        url = "http://localhost:" + port + "/password";
    }

    @Test
    public void shouldReturnBooleanWithValidatorResultWhenIsAValidPassword() {

        String validPasswordExample = "AbTp9!fok";

        HttpEntity<String> httpEntity = new HttpEntity<>(validPasswordExample, httpHeaders);
        ResponseEntity<Boolean> result = this.restTemplate.postForEntity(url, httpEntity, Boolean.class);
        assertTrue(result.getBody());
        assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
    }

    @Test
    public void shouldReturnBooleanWithValidatorResultWhenIsAInvalidPassword() {

        String invalidPasswordExample = "AbTp9! fok";

        HttpEntity<String> httpEntity = new HttpEntity<>(invalidPasswordExample, httpHeaders);
        ResponseEntity<Boolean> result = this.restTemplate.postForEntity(url, httpEntity, Boolean.class);
        assertFalse(result.getBody());
        assertEquals(HttpStatusCode.valueOf(200), result.getStatusCode());
    }
}