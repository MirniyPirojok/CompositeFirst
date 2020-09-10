package by.borisov.textcomposite.comparator;

import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.SymbolComponent;

import java.util.Comparator;

public class ComparatorBySymbolOccurrence implements Comparator<TextComponent> {
    private final char symbol;

    public ComparatorBySymbolOccurrence(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int result = Integer.compare(sumSymbolOccurrence(o2), sumSymbolOccurrence(o1));
        if (result == 0) {
            return o1.toString().compareToIgnoreCase(o2.toString());
        }
        return result;
    }

    private int sumSymbolOccurrence(TextComponent lexeme) {
        int sum = 0;
        TextComponent givenSymbol = new SymbolComponent(this.symbol);
        for (TextComponent symbolComponent : lexeme.getComponents()) {
            if (givenSymbol.equals(symbolComponent)) {
                sum++;
            }
        }
        return sum;
    }
}
