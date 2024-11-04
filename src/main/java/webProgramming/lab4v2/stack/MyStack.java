package webProgramming.lab4v2.stack;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Представление базового стека с типом данных String
 */
public class MyStack implements Iterable<String> {
    @Getter
    private final Stack<String> stack;

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
     * @param data некоторая строка
     */
    public void push(String data) {
        stack.push(data);
    }

    /**
     * Удаляет и возвращает элемент из вершины стека
     *
     * @return элемент из вершины стека
     */
    public String pop() {
        return stack.pop();
    }

    /**
     * Возвращает элемент на вершине стека
     *
     * @return элемент на вершине стека
     */
    public String top() {
        return stack.getLast();
    }

    /**
     * Возвращает все элементы из стека в виде списка String
     *
     * @return список со строками
     */
    public List<String> getAllData() {
        List<String> data = new ArrayList<>();
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
    public String getLargestValue() {
        String largest = null;
        for (String current : stack) {
            if (largest == null || largest.length() < current.length() ||
                    (largest.length() == current.length() && largest.compareTo(current) < 0)) {
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
    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            final Iterator<String> iterator = stack.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public String next() {
                return iterator.next();
            }
        };
    }

    /**
     * Возвращает стек, который создаётся на основе списка со строками
     *
     * @param data список со строками
     * @return стек из строк
     */
    public static MyStack getStringStack(List<String> data) {
        MyStack stack = new MyStack();
        for (String datum : data) {
            stack.push(datum);
        }
        return stack;
    }
}
