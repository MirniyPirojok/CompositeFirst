package by.borisov.compositechain.entity;

import java.util.List;

public interface TextComponent {

    void add(TextComponent component);

    ComponentType getComponentType();

    List<TextComponent> getComponents();

}
