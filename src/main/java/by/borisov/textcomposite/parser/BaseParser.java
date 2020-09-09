package by.borisov.textcomposite.parser;

import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.exception.CustomException;

public interface BaseParser{
    TextComponent parse(String textComponent) throws CustomException;
}
