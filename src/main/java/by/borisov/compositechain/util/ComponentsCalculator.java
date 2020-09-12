package by.borisov.compositechain.util;

import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.SymbolComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComponentsCalculator {
    public static final String REGEX_WORD = "[\\w]+";

    public static int calculateLexemesLengths(TextComponent sentence) {
        return sentence.getComponents()
                .stream().mapToInt(lexeme -> lexeme.getComponents().size()).sum();
    }

    public static int calculateWordsLength(TextComponent sentence) {
        int length = 0;
        String currentSentence = sentence.toString();
        Matcher matcher = Pattern.compile(REGEX_WORD).matcher(currentSentence);
        while (matcher.find()){
            length += matcher.group().length();
        }
        return length;
    }

    public static int sumSymbolOccurrence(TextComponent lexeme, char symbol) {
        TextComponent givenSymbol = new SymbolComponent(symbol);
        return (int) lexeme.getComponents().stream()
                .filter(s -> s.equals(givenSymbol)).count();
    }
}
