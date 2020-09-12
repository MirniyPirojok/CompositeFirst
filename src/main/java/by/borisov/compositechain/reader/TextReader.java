package by.borisov.compositechain.reader;

import by.borisov.compositechain.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public class TextReader {
    static Logger logger = LogManager.getLogger();

    public String readData(String filePath) throws CustomException {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(filePath)).getPath());

        String text;
        try (Stream<String> stream = new BufferedReader(new FileReader(file)).lines()) {
            StringBuilder builder = new StringBuilder();
            stream.forEachOrdered(line -> builder.append(line).append("\n"));
            text = builder.toString();
        } catch (IOException e) {
            logger.error("Cannot read file.", e);
            throw new CustomException("Cannot read file.", e);
        }

        return text;
    }
}
