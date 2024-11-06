package webProgramming.lab4v2.data;

import java.util.ArrayList;
import java.util.List;

public class MyString {
    private final String _value;

    /**
     * Конструктор по умолчанию
     */
    public MyString() {
        _value = "";
    }

    /**
     * Конструктор с параметрами
     * @param value некоторая строка
     */
    public MyString(String value) {
        _value = value;
    }

    /**
     * Получить строку
     * @return строка
     */
    public String getValue() {
        return _value;
    }

    /**
     * Получить размер строки
     * @return размер строки
     */
    public int getSize() {
        return _value.length();
    }

    /**
     * Конвертировать список строк в список объектов класса MyString
     * @param strings список строк
     * @return список объектов класса MyString
     */
    public static List<MyString> getMyStrings(List<String> strings) {
        List<MyString> myStrings = new ArrayList<>();
        for (String string : strings) {
            myStrings.add(new MyString(string));
        }
        return myStrings;
    }

    /**
     * Конвертировать список объектов класса MyString в список строк
     * @param myStrings список объектов класса MyString
     * @return список строк
     */
    public static List<String> getValues(List<MyString> myStrings) {
        List<String> strings = new ArrayList<>();
        for (MyString myString : myStrings) {
            strings.add(myString._value);
        }
        return strings;
    }
}
