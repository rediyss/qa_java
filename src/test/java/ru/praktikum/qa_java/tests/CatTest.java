package ru.praktikum.qa_java.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
