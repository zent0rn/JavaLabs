package webProgramming.lab2v1.entity;

import webProgramming.lab2v1.services.impl.GUIDMatcherService;

/**
 * Класс GUID используется для представления GUID объектов
 * имеет поле String _value - некоторая строка
 * имеет поле boolean _isGUID - является ли данная строка (_value) GUID'ом
 */
public class GUID {
    private final String _value;
    private final boolean _isGUID;

    /**
     * конструктор по умолчанию
     */
    public GUID() {
        _value = "";
        _isGUID = false;
    }

    /**
     * конструктор с параметром
     * @param value - некоторая строка, значение
     * которой будет присвоено полю _value
     */
    public GUID(String value) {
        _value = value;
        _isGUID = GUIDMatcherService.match(_value);
    }

    /**
     * метод используется для вывода данных о поле
     * _isGUID конкретного объекта класса GUID
     * @return - строка объекта класса GUID + пояснение:
     * является ли данная строка GUID'ом
     */
    public String isGUID() {
        if (_isGUID) {
            return (_value + " Удовлетворяет шаблону (является GUID)\n");
        }
        else {
            return (_value + " НЕ удовлетворяет шаблону (не является GUID)\n");
        }
    }

    /**
     * метод используется для разбиения строки на подстроки и добавления их в массив
     * @param input - строка, которая будет разбита на подстроки для добавления в массив
     * @return guids - массив объектов класса GUID
     */
    public static GUID[] stringToArrayGUIDs(String input) {
        String[] guidsAsStrings = input.split(" ");
        GUID[] guids = new GUID[guidsAsStrings.length];
        for (int i = 0; i < guidsAsStrings.length; i++) {
            guids[i] = new GUID(guidsAsStrings[i]);
        }
        return guids;
    }
}
