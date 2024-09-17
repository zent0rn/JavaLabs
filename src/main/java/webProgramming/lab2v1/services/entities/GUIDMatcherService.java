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

    public GUIDMatcherService(){
        _patternList = List.of(
                Pattern.compile(regExWithFigureBrackets),
                Pattern.compile(regExWithRoundedBrackets),
                Pattern.compile(regExWithoutBrackets)
        );
    }


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

    public void addGUIDPattern(String regEx){
        _patternList.add(Pattern.compile(regEx));
    }

    public void deleteGUIDPatternByIndex(int index){
        _patternList.remove(index);
    }
}
