package by.borisov.textcomposite.comparator;

import by.borisov.textcomposite.entity.TextComponent;

import java.util.Comparator;

public class ComparatorByLexemesLength implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent sentence1, TextComponent sentence2) {
        return Integer.compare(calculateLexemesLengths(sentence1),
                calculateLexemesLengths(sentence2));
    }

    private int calculateLexemesLengths(TextComponent sentence) {
        return sentence.getComponents()
                .stream().mapToInt(lexeme -> lexeme.getComponents().size()).sum();
    }
}
