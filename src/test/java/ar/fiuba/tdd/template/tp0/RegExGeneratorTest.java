package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RegExGeneratorTest {

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator(5);
        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }

    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", 1));
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", 1));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", 1));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", 1));
    }

    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", 1));
    }

    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 1));
    }

    @Test
    public void testCharacterSetWithPlusQuantifier() {
        assertTrue(validate("[abc]+", 1));
    }

    @Test
    public void testCharacterSetWithInterrogateQuantifier() {
        assertTrue(validate("[abc]?", 1));
    }

    @Test
    public void testExceptionWithInvalidRegularExpression() {
        try {
            validate("**[abc]+", 1);
            fail();
        }

        catch(RuntimeException anException) { assertTrue(true); }

    }

    @Test
    public void testZeroOrManyCharacter() {
        assertTrue(validate("\\@.h*", 1));
    }

    @Test
    public void testManyQuantifiers() { assertTrue(validate("\\@?.h*", 1)); }

}
