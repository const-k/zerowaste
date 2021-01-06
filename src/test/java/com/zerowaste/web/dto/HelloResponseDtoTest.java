package com.zerowaste.web.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloResponseDtoTest {
    @Test
    public void lombokTest() throws Exception{
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertEquals(dto.getName(), name);
        assertEquals(dto.getAmount(), amount);
    }
}