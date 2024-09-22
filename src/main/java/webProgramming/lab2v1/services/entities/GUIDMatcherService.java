package webProgramming.lab2v1.services.entities;

import webProgramming.lab2v1.services.interfaces.MatcherService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс GUIDMatcher представляет собой сервис проверки строк
 * на соответствие GUID (является ли переданная строка GUID)
 */
public class GUIDMatcherService implements MatcherService {
    private List<Pattern> _patternList;

    /**
     * конструктор по умолчанию
     */
    public GUIDMatcherService() {
        _patternList = List.of(
                Pattern.compile("^[{][a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}[}]$"),
                Pattern.compile("^[(][a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}[)]$"),
                Pattern.compile("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")
        );
    }

    public boolean match(String stringToParse) {
        Matcher matcher;
        for (Pattern pattern : _patternList) {
            matcher = pattern.matcher(stringToParse);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    /**
     * метод добавляет регулярное выражение в список
     *
     * @param regEx - строка регулярного выражения
     */
    public void addGUIDPattern(String regEx) {
        _patternList.add(Pattern.compile(regEx));
    }

    /**
     * метод удаляет регулярное выражение из списка
     *
     * @param index - индекс регулярного выражения, который нужно удалить
     */
    public void deleteGUIDPatternByIndex(int index) {
        _patternList.remove(index);
    }
}
