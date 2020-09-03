package by.borisov.textcomposite.entity;

public class Symbol implements TextComponent {
    private char symbol;
    private ComponentType componentType;

    public Symbol(char symbol) {
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

}
