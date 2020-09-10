package by.borisov.textcomposite.interpreter;

import by.borisov.textcomposite.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.NumberFormat;

public class ExpressionInterpreter {
    static Logger logger = LogManager.getLogger();
    public static final String J = "7";
    public static final String I = "7";
    public static final String ENGINE_NAME = "JavaScript";

    public String interpretExpression(String expression) throws CustomException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName(ENGINE_NAME);
        engine.put("j", J);
        engine.put("i", I);

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);

        String countedExpression;
        try {
            Object countedExpressionObj = engine.eval(expression);
            countedExpression = numberFormat.format(countedExpressionObj);
        } catch (ScriptException e) {
            logger.error("JavaScript engine error.", e);
            throw new CustomException("JavaScript engine error.", e);
        }
        logger.info("Expression was counted.");

        return countedExpression;
    }

}
