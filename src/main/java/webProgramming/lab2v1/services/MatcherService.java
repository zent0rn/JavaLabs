package webProgramming.lab2v1.services;

/**
 * Интерфейс MatcherService предоставляет метод match,
 * с помощью которого можно обработать строку на соответствие некоторому паттерну
 */
public interface MatcherService {
    /**
     * Метод проверяет строку, переданную в качестве аргумента, на соответствие регулярному выражению
     *
     * @param stringToParse - проверяемая строка
     * @return true, если соответствует, false в обратном случае
     */
    static boolean match(String stringToParse) {
        return false;
    }
}
