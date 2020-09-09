package by.borisov.textcomposite.parser.impl;

import by.borisov.textcomposite.entity.ComponentType;
import by.borisov.textcomposite.entity.TextComponent;
import by.borisov.textcomposite.entity.impl.CompositeText;
import by.borisov.textcomposite.entity.impl.SymbolComponent;
import by.borisov.textcomposite.exception.CustomException;
import by.borisov.textcomposite.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.NumberFormat;

public class LexemeParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    public static final Integer J = 7;
    public static final Integer I = 7;
    public static final String REGEX_EXPRESSION = "[\\d(][\\d-+*/)ij\\s(]+";

    public LexemeParser() {
    }

    @Override
    public TextComponent parse(String lexeme) throws CustomException {
        TextComponent componentLexeme = new CompositeText(ComponentType.LEXEME);

        if (lexeme.matches(REGEX_EXPRESSION)) {
            System.out.println(lexeme);
            lexeme = lexeme.replaceAll(REGEX_EXPRESSION, interpretExpression(lexeme));
        }

        char[] symbols = lexeme.toCharArray();
        for (char symbol : symbols) {
            TextComponent componentSymbol = new SymbolComponent(symbol);
            componentLexeme.add(componentSymbol);
        }
        logger.info("Lexeme parsed to symbols.");

        return componentLexeme;
    }

    private String interpretExpression(String expression) throws CustomException {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");
        engine.put("j", J);
        engine.put("i", I);

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);

        String countedExpression;
        try {
            Object countedExpressionObj = engine.eval(expression);
            countedExpression = numberFormat.format(countedExpressionObj);
        } catch (ScriptException e) {
            throw new CustomException("JavaScript engine error.", e);
        }
        logger.info("Expression was counted.");

        return countedExpression;
    }
}
