package ru.alfabank.lesson14_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.alfabank.edu.lesson14.homework14_2.XMLUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {
    @Test
    @DisplayName("Создание элемента с валидным значение: user")
    public void testCreateEmptyElementWithValidTagName() {
        //Arrange
         String tagName = "user";
        String expectedTagName = "<user></user>";

        //Act
        String actualTagName = XMLUtils.createEmptyElement(tagName);

        //Assert
        assertEquals(expectedTagName, actualTagName, "Метод должен возвращать корректный XML-элемент для валидного тега");
    }

    @Test
    @DisplayName("Создание элемента с валидным значение: user")
    public void testCreateEmptyElementWithNULLTagName() {
        //Arrange
        String tagName = null;
        String expectedTagName = "<invalid/>";

        //Act
        String actualTagName = XMLUtils.createEmptyElement(tagName);

        //Assert
        assertEquals(expectedTagName, actualTagName, "При отправке значения null метод должен возвращать <invalid/>");
    }

    @Test
    @DisplayName("Создание элемента с валидным значение: user")
    public void testCreateEmptyElementWithEmptyTagName() {
        //Arrange
        String tagName = "";
        String expectedTagName = "<invalid/>";

        //Act
        String actualTagName = XMLUtils.createEmptyElement(tagName);

        //Assert
        assertEquals(expectedTagName, actualTagName, "При отправке пустого значения метод должен возвращать <invalid/>");
    }
}
