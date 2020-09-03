package by.borisov.textcomposite.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements TextComponent {
    static Logger logger = LogManager.getLogger();

    private final ComponentType componentType;
    private final List<TextComponent> listComponent = new ArrayList<>();

    public CompositeText(ComponentType componentType) {
        this.componentType = componentType;
    }

    public List<TextComponent> getListComponent() {
        return listComponent;
    }

    @Override
    public void add(TextComponent component) {
        listComponent.add(component);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void getChild(TextComponent textComponent) {

    }
}
