package by.borisov.compositechain.entity.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

import static by.borisov.compositechain.entity.ComponentType.LEXEME;
import static by.borisov.compositechain.entity.ComponentType.PARAGRAPH;

public class CompositeText implements TextComponent {

    private ComponentType componentType;
    private final List<TextComponent> components;

    public CompositeText() {
        this.components = new ArrayList<>();
    }

    public CompositeText(ComponentType componentType) {
        this.componentType = componentType;
        this.components = new ArrayList<>();
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CompositeText that = (CompositeText) o;

        return new EqualsBuilder()
                .append(componentType, that.componentType)
                .append(components, that.components)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(componentType)
                .append(components)
                .toHashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (TextComponent component : components) {
            ComponentType type = component.getComponentType();

            if (type == LEXEME) {
                stringBuilder.append(" ");
            } else if (type == PARAGRAPH) {
                stringBuilder.append("\n");
            }

            stringBuilder.append(component);
        }
        return stringBuilder.toString();
    }
}
