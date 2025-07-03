package ru.praktikum.qa_java.tests;

import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFoodShouldReturnHerbivoreFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void getFoodShouldThrowExceptionForUnknownKind() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Непонятный вид");
    }

    @Test
    public void getFamilyShouldReturnFamilyString() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}
