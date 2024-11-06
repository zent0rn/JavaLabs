package webProgramming.lab4v2.stack;

import lombok.Getter;
import webProgramming.lab4v2.data.MyString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Представление базового стека с типом данных String
 */
@Getter
public class MyStack {
    private final Stack<MyString> stack;
    /**
     * Конструктор по умолчанию
     */
    public MyStack() {
        stack = new Stack<>();
    }

    /**
     * Конструктор с параметрами
     *
     * @param data список данных типа String
     */
    public MyStack(List<String> data) {
        stack = new Stack<>();
        for (String t : data) {
            stack.push(t);
        }
    }

    /**
     * Добавляет элемент на вершину стека
     *
     * @param data элемент, добавляемый в стек
     */
    public void push(MyString data) {
        stack.push(data);
    }

    /**
     * Удаляет и возвращает элемент из вершины стека
     *
     * @return элемент из вершины стека
     */
    public MyString pop() {
        return stack.pop();
    }

    /**
     * Возвращает элемент на вершине стека
     *
     * @return элемент на вершине стека
     */
    public MyString top() {
        return stack.getLast();
    }

    /**
     * Возвращает все элементы из стека в виде списка String
     *
     * @return список со строками
     */
    public List<MyString> getAllData() {
        List<MyString> data = new ArrayList<>();
        while (!stack.empty()) {
            data.add(stack.pop());
        }
        return data;
    }

    /**
     * Возвращает самую длинную строку из стека
     *
     * @return самая длинная строка из стека
     */
    public MyString getLargestValue() {
        MyString largest = null;
        for (MyString current : stack) {
            if (largest == null || largest.getSize() < current.getSize() ||
                    (largest.getSize() == current.getSize() && largest.getValue().compareTo(current.getValue()) < 0)) {
                largest = current;
            }
        }
        return largest;
    }

    /**
     * Возвращает размер стека
     *
     * @return размер стека
     */
    public int getSize() {
        return stack.size();
    }

    /**
     * Итератор для стека
     *
     * @return итератор
     */
    public Iterator<MyString> iterator() {
        return new Iterator<>() {
            final Iterator<MyString> iterator = stack.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public MyString next() {
                return iterator.next();
            }
        };
    }

    /**
     * Создать стек на основе списка со строками
     *
     * @param data список со строками
     * @return стек из строк
     */
    public static MyStack getStringStack(List<MyString> data) {
        MyStack stack = new MyStack();
        for (MyString datum : data) {
            stack.push(datum);
        }
        return stack;
    }

}
