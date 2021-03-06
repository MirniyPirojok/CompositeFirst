package by.borisov.compositechain.parser.impl;

import by.borisov.compositechain.entity.ComponentType;
import by.borisov.compositechain.entity.TextComponent;
import by.borisov.compositechain.entity.impl.CompositeText;
import by.borisov.compositechain.parser.BaseParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements BaseParser {
    static Logger logger = LogManager.getLogger();
    public static final String REGEX_LEXEME = "([\\d(][\\d-,+*/)ij(:\\s]+|[\\w-,.!:?')(]+)";
    private final BaseParser lexemeParser = new LexemeParser();

    public SentenceParser() {
    }

    @Override
    public TextComponent parse(String sentence) {
        TextComponent componentSentence = new CompositeText(ComponentType.SENTENCE);
        Matcher matcher = Pattern.compile(REGEX_LEXEME).matcher(sentence);
        while (matcher.find()) {
            String lexeme = matcher.group().trim();
            TextComponent componentLexeme = lexemeParser.parse(lexeme);
            componentSentence.add(componentLexeme);
        }

        logger.info("Sentence parsed to lexemes.");
        return componentSentence;
    }
}
