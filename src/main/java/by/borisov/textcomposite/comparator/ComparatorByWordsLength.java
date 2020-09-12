package by.borisov.textcomposite.comparator;

import by.borisov.textcomposite.entity.TextComponent;

import java.util.Comparator;

import static by.borisov.textcomposite.util.ComponentsCalculator.calculateWordsLength;

public class ComparatorByWordsLength implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent sentence1, TextComponent sentence2) {
        return Integer.compare(calculateWordsLength(sentence1),
                calculateWordsLength(sentence2));
    }
}
