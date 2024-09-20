package webProgramming.lab2v1.services.entities;

import webProgramming.lab2v1.services.interfaces.MatcherService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUIDMatcherService implements MatcherService {
    private static final String regExWithFigureBrackets =
            "^[{][a-fA-F0-9]{8}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{12}[}]$";
    private static final String regExWithRoundedBrackets =
            "^[(][a-fA-F0-9]{8}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{12}[)]$";
    private static final String regExWithoutBrackets =
            "^[a-fA-F0-9]{8}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{4}[-][a-fA-F0-9]{12}$";
    private List<Pattern> _patternList;

    /**
     * конструктор по умолчанию, метод compile вызывает закрытый
     * конструктор класса Pattern для создания
     * скомпилированного представления регулярного выражения
     */
    public GUIDMatcherService(){
        _patternList = List.of(
                Pattern.compile(regExWithFigureBrackets),
                Pattern.compile(regExWithRoundedBrackets),
                Pattern.compile(regExWithoutBrackets)
        );
    }

    /**
     *
     * @param stringToParse - строчка, которая будет проверяться на соответствие регулярному выражению
     * @return - true, если соответствует, false в обратном случае
     */
    public boolean match(String stringToParse){
        Matcher matcher;
        for(Pattern pattern: _patternList){
            matcher = pattern.matcher(stringToParse);
            if(matcher.matches()){
                return true;
            }
        }
        return false;
    }

    /**
     * метод добавляет скомпилированное регулярное выражение в список
     * @param regEx - регулярное выражение
     */
    public void addGUIDPattern(String regEx){
        _patternList.add(Pattern.compile(regEx));
    }

    /**
     * метод удаляет регулярное выражение из списка
     * @param index - индекс регулярного выражения, который нужно удалить
     */
    public void deleteGUIDPatternByIndex(int index){
        _patternList.remove(index);
    }
}
