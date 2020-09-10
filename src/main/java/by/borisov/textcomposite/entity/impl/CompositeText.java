package by.borisov.textcomposite.entity.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements TextComponent {
    static Logger logger = LogManager.getLogger();

    private final ComponentType componentType;
    private final List<TextComponent> components;

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

            if (type == ComponentType.LEXEME) {
                stringBuilder.append(" ");
            }

            stringBuilder.append(component);
            if (type == ComponentType.SENTENCE) {
                stringBuilder.append(".");
            } else if (type == ComponentType.PARAGRAPH) {
                stringBuilder.append("\n");
            }
        }
//        logger.info("Text collected back.");
        return stringBuilder.toString();
    }
}
