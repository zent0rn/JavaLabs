package webProgramming.lab2v1.services.impl;

import webProgramming.lab2v1.services.MatcherService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс GUIDMatcher представляет собой сервис проверки строк
 * на соответствие GUID (является ли переданная строка GUID)
 */
public class GUIDMatcherService implements MatcherService {
    private static final List<Pattern> _patternList = List.of(
            Pattern.compile("^[{][a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}[}]$"),
            Pattern.compile("^[(][a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}[)]$"),
            Pattern.compile("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")
    );


    public static boolean match(String stringToParse) {
        Matcher matcher;
        for (Pattern pattern : _patternList) {
            matcher = pattern.matcher(stringToParse);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
