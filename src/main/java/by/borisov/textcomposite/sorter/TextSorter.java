package by.borisov.textcomposite.sorter;

import by.borisov.textcomposite.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class TextSorter {
    static Logger logger = LogManager.getLogger();

    public void sortParagraphsBySentenceCount(TextComponent text) {
        text.getComponents().sort(
                Comparator.comparingInt(o -> o.getComponents().size()));
        logger.info("Paragraphs were sorted by sentence count.");
    }
}