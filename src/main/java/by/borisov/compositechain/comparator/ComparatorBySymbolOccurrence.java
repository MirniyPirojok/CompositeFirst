package by.borisov.compositechain.comparator;

import by.borisov.compositechain.entity.TextComponent;

import java.util.Comparator;

import static by.borisov.compositechain.util.ComponentsCalculator.sumSymbolOccurrence;

public class ComparatorBySymbolOccurrence implements Comparator<TextComponent> {
    private final char symbol;

    public ComparatorBySymbolOccurrence(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int result = Integer.compare(sumSymbolOccurrence(o2, symbol), sumSymbolOccurrence(o1, symbol));
        if (result == 0) {
            result = o1.toString().compareToIgnoreCase(o2.toString());
        }
        return result;
    }
}
