package by.borisov.textcomposite.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements TextComponent{
    private List<TextComponent> listComponent = new ArrayList<>();
    private ComponentType componentType;

    @Override
    public void add(TextComponent component) {

    }
}
