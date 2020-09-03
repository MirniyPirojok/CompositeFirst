package by.borisov.textcomposite.entity;

public interface TextComponent {

    void add(TextComponent component);

    ComponentType getComponentType();

    void getChild(TextComponent textComponent);
}
