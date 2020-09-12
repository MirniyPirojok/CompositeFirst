package by.borisov.compositechain.reader;

import by.borisov.compositechain.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextReaderTest {
    TextReader textReader;

    @BeforeClass
    public void setUp() {
        textReader = new TextReader();
    }

    @AfterClass
    public void tierDown() {
        textReader = null;
    }

    @Test
    public void readDataPositiveTest() throws CustomException {
        String expected = "Hello world!\n";
        String actual = textReader.readData("data/testText.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readDataNegativeTest() throws CustomException {
        String expected = "Hello world!";
        String actual = textReader.readData("data/testText.txt");
        Assert.assertNotEquals(expected, actual);
    }

    @Test(expectedExceptions = {CustomException.class, NullPointerException.class})
    public void readDataExceptionTest() throws CustomException {
        textReader.readData("data/nonExistedFile.txt");
    }
}
