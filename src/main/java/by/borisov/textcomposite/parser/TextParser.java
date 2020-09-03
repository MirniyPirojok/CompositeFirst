package by.borisov.textcomposite.parser;

import by.borisov.textcomposite.entity.TextComponent;

public abstract class TextParser {
    private TextParser next;

    public TextParser linkWith(TextParser next){
        this.next = next;
        return next;
    }

    public abstract TextComponent parse(String str);
}
