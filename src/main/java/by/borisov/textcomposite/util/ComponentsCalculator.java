package by.borisov.textcomposite.util;

import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.SymbolComponent;

import static by.borisov.textcomposite.entity.ComponentType.LETTER;

public class ComponentsCalculator {
    public static int calculateLexemesLengths(TextComponent sentence) {
        return sentence.getComponents()
                .stream().mapToInt(lexeme -> lexeme.getComponents().size()).sum();
    }

    public static int calculateWordsLength(TextComponent sentence) {
        return (int) sentence.getComponents()
                .stream()
                .map(lexeme -> lexeme.getComponents()
                        .stream().filter(symbol -> symbol.getComponentType() == LETTER)).count();
    }

    public static int sumSymbolOccurrence(TextComponent lexeme, char symbol) {
        TextComponent givenSymbol = new SymbolComponent(symbol);
        return (int) lexeme.getComponents().stream()
                .filter(s -> s.equals(givenSymbol)).count();
    }
}
