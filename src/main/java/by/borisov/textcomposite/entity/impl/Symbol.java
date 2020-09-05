package by.borisov.textcomposite.entity.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Symbol implements TextComponent {
    private final String symbol;    //TODO change symbol to char
    private ComponentType componentType;

    public Symbol(String symbol) {
        this.symbol = symbol;
        this.componentType = ComponentType.SYMBOL;
    }

    @Override
    public void add(TextComponent component) {
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void getChild(TextComponent textComponent) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

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
        return "" + symbol;
    }
}
