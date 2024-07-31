package com.example.test;

import com.example.test.service.LessonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LessonTest {
    @InjectMocks
    LessonService lessonService;
    @Test
    public void checkNameTest(){
        String name="Sebuhi";
        String surname="Qeribzade";
        String response = lessonService.checkName(name, surname);
        Assertions.assertEquals("SebuhiQeribzade",response);
    }
}
