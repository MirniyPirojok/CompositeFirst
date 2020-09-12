package by.borisov.textcomposite.util;

import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.SymbolComponent;

public class ComponentsCalculator {
    public static int calculateLexemesLengths(TextComponent sentence) {
        return sentence.getComponents()
                .stream().mapToInt(lexeme -> lexeme.getComponents().size()).sum();
    }

    public static int sumSymbolOccurrence(TextComponent lexeme, char symbol) {
        int sum = 0;
        TextComponent givenSymbol = new SymbolComponent(symbol);
        for (TextComponent symbolComponent : lexeme.getComponents()) {
            if (givenSymbol.equals(symbolComponent)) {
                sum++;
            }
        }
        return sum;
    }
}
