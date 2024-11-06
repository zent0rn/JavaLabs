package webProgramming.lab4v2.stack;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webProgramming.lab4v2.data.MyString;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack myStack;

    @Test
    @Disabled
    @DisplayName("Конструктор по умолчанию работает корректно")
    void ensureDefaultConstructorWorks(){
        myStack = new MyStack();

        assertNotNull(myStack.getStack());
    }

    @Test
    @Disabled
    @DisplayName("Конструктор с параметрами работает корректно")
    void ensureParameterizedConstructorWorks(){
        myStack = new MyStack(List.of(new MyString("a"), new MyString("b"), new MyString("c")));

        assertNotNull(myStack.getStack());
    }

    @Test
    @Disabled
    @DisplayName("Метод top работает корректно")
    void ensureTopMethodWorks(){
        String expected = "c";
        myStack = new MyStack(List.of(new MyString("a"), new MyString("b"), new MyString("c")));

        MyString actual = myStack.top();

        assertEquals(expected, actual.getValue());
    }

    @Test
    @Disabled
    @DisplayName("Метод push работает корректно")
    void ensurePushMethodWorks(){
        String expected = "a";
        myStack = new MyStack();

        myStack.push(new MyString("a"));
        MyString actual = myStack.top();

        assertEquals(expected, actual.getValue());
    }

    @Test
    @Disabled
    @DisplayName("Метод pop работает корректно")
    void ensurePopMethodWorks(){
        String expected = "b";
        myStack = new MyStack(List.of(new MyString("a"), new MyString("b"), new MyString("c")));

        myStack.pop();
        MyString actual = myStack.top();

        assertEquals(expected, actual.getValue());
    }

    @Test
    @Disabled
    @DisplayName("Метод pop выбрасывает исколючение, если стек пуст")
    void ensurePopThrowsExceptionIfStackIsEmpty(){
        myStack = new MyStack();

        assertThrows(EmptyStackException.class, () -> myStack.pop());
    }

    @Test
    @Disabled
    @DisplayName("Метод getAllData работает корректно")
    void ensureGetAllDataWorks(){
        myStack = new MyStack(List.of(new MyString("a"), new MyString("b"), new MyString("c")));
        List<MyString> expected = List.of(new MyString("c"), new MyString("b"), new MyString("a"));

        List<MyString> actual = myStack.getAllData();

        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Значение largestValue устанавливается корректно")
    void ensureLargestValueIsSetCorrectly(){
        myStack = new MyStack(List.of(new MyString("aaa"), new MyString("b"), new MyString("cc")));
        String expectedLargestValue = "aaa";

        MyString actualLargestValue = myStack.getLargestValue();

        assertEquals(expectedLargestValue, actualLargestValue.getValue());
    }

    @Test
    @Disabled
    @DisplayName("Значение largestValue изменяется корректно")
    void ensureLargestValueIsChangedCorrectly(){
        myStack = new MyStack(List.of(new MyString("aaa"), new MyString("b"), new MyString("cc")));

        myStack.push(new MyString("dddd"));
        String expectedLargestValue = "dddd";
        MyString actualLargestValue = myStack.getLargestValue();

        assertEquals(expectedLargestValue, actualLargestValue.getValue());
    }

    @Test
    @Disabled
    @DisplayName("Метод getSize работает корректно")
    void ensureGetSizeWorks(){
        int expectedSize = 3;
        myStack = new MyStack(List.of(new MyString("aaa"), new MyString("b"), new MyString("cc")));

        int actualSize = myStack.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    @Disabled
    @DisplayName("Итератор работает корректно")
    void ensureIteratorWorks(){
        myStack = new MyStack(List.of(new MyString("a"), new MyString("b"), new MyString("c")));
        Iterator<MyString> iterator = myStack.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("a", iterator.next().getValue());

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("b", iterator.next().getValue());

        assertThat(iterator.hasNext()).isTrue();
        assertEquals("c", iterator.next().getValue());

        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    @Disabled
    @DisplayName("Статический метод getStringStack работает")
    void ensureGetStringStackWorks(){
        List<MyString> data = List.of(new MyString("a"), new MyString("b"), new MyString("c"));

        myStack = MyStack.getStringStack(data);

        assertEquals("c", myStack.top().getValue());
        myStack.pop();

        assertEquals("b", myStack.top().getValue());
        myStack.pop();

        assertEquals("a", myStack.top().getValue());
    }
}