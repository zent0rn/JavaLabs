package webProgramming.lab4v2.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<String> myStack;

    @Test
    @DisplayName("Конструктор по умолчанию работает корректно")
    void ensureDefaultConstructorWorks(){
        myStack = new MyStack<>();

        assertNotNull(myStack.getStack());
    }

    @Test
    @DisplayName("Конструктор с параметрами работает корректно")
    void ensureParameterizedConstructorWorks(){
        myStack = new MyStack<>(List.of("a", "b", "c"));

        assertNotNull(myStack.getStack());
    }

    @Test
    @DisplayName("Метод top работает корректно")
    void ensureTopMethodWorks(){
        String expected = "c";
        myStack = new MyStack<>(List.of("a", "b", "c"));

        String actual = myStack.top();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Метод push работает корректно")
    void ensurePushMethodWorks(){
        String expected = "a";
        myStack = new MyStack<>();

        myStack.push("a");
        String actual = myStack.top();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Метод pop работает корректно")
    void ensurePopMethodWorks(){
        String expected = "b";
        myStack = new MyStack<>(List.of("a", "b", "c"));

        myStack.pop();
        String actual = myStack.top();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Метод pop выбрасывает исколючение, если стек пуст")
    void ensurePopThrowsExceptionIfStackIsEmpty(){
        myStack = new MyStack<>();

        assertThrows(EmptyStackException.class, () -> myStack.pop());
    }

    @Test
    @DisplayName("Метод getAllData работает корректно")
    void ensureGetAllDataWorks(){
        myStack = new MyStack<>(List.of("a", "b", "c"));
        List<String> expected = List.of("c", "b", "a");

        List<String> actual = myStack.getAllData();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Значение largestValue устанавливается корректно")
    void ensureLargestValueIsSetCorrectly(){
        myStack = new MyStack<>(List.of("aaa", "b", "cc"));
        String expectedLargestValue = "aaa";

        String actualLargestValue = myStack.getLargestValue();

        assertEquals(expectedLargestValue, actualLargestValue);
    }

    @Test
    @DisplayName("Значение largestValue изменяется корректно")
    void ensureLargestValueIsChangedCorrectly(){
        myStack = new MyStack<>(List.of("aaa", "b", "cc"));

        myStack.push("dddd");
        String expectedLargestValue = "dddd";
        String actualLargestValue = myStack.getLargestValue();

        assertEquals(expectedLargestValue, actualLargestValue);
    }

    @Test
    @DisplayName("Метод getSize работает корректно")
    void ensureGetSizeWorks(){
        int expectedSize = 3;
        myStack = new MyStack<>(List.of("aaa", "b", "cc"));

        int actualSize = myStack.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("Итератор работает корректно")
    void ensureIteratorWorks(){
        myStack = new MyStack<>(List.of("a", "b", "c"));
        Iterator<String> iterator = myStack.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("c", iterator.next());

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("b", iterator.next());

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("a", iterator.next());

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    @DisplayName("Статический метод getStringStack работает")
    void ensureGetStringStackWorks(){
        List<String> data = List.of("a", "b", "c");

        myStack = MyStack.getStringStack(data);

        assertEquals("c", myStack.top());
        myStack.pop();

        assertEquals("b", myStack.top());
        myStack.pop();

        assertEquals("a", myStack.top());
    }
}