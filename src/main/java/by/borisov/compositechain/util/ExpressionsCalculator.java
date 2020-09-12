package by.borisov.compositechain.util;

import by.borisov.compositechain.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionsCalculator {
    static Logger logger = LogManager.getLogger();
    public static final String SCRIPT_ENGINE_NAME = "JavaScript";
    public static final String REGEX_EXPRESSION = "[\\d(][\\d-+*/)ij\\s(]+";

    public String calculateExpressions(String text, long i, long j) throws CustomException {
        List<String> expressionList = findExpressions(text);

        for (String expression : expressionList) {
            String calculatedExpression = calculateExpression(expression, i, j);
            calculatedExpression = calculatedExpression.replace(".0", "");
            text = text.replace(expression, calculatedExpression);
        }
        return text;
    }

    private List<String> findExpressions(String text) {
        List<String> expressionList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_EXPRESSION);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String expression = matcher.group().trim();
            expressionList.add(expression);
        }
        return expressionList;
    }

    private String calculateExpression(String expression, long i, long j) throws CustomException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName(SCRIPT_ENGINE_NAME);
        engine.put("i", i);
        engine.put("j", j);

        Object calculatedExpression;
        try {
            calculatedExpression = engine.eval(expression);
        } catch (ScriptException e) {
            logger.error("JavaScript engine error.", e);
            throw new CustomException("JavaScript engine error.", e);
        }
        logger.info("Expression was counted.");

        return calculatedExpression.toString();
    }
}
