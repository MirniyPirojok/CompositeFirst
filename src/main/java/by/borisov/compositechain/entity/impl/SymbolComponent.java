package by.borisov.compositechain.entity.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class SymbolComponent implements TextComponent {
    private char symbol;
    private ComponentType componentType;

    public SymbolComponent() {
    }

    public SymbolComponent(char symbolLetter) {
        this.symbol = symbolLetter;
        this.componentType = ComponentType.LETTER;
    }

    public SymbolComponent(char symbol, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Method add is not supported in Class Symbol");
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SymbolComponent symbol1 = (SymbolComponent) o;

        return new EqualsBuilder()
                .append(symbol, symbol1.symbol)
                .append(componentType, symbol1.componentType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(symbol)
                .append(componentType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
