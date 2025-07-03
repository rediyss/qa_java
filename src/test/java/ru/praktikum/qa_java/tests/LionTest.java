package ru.praktikum.qa_java.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void testDoesHaveManeMale() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittensUsesFeline() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFoodUsesFeline() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Мясо", "Курица", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        Feline felineMock = mock(Feline.class);
        new Lion("Другой", felineMock);
    }
}
