package ar.fiuba.tdd.template.tp0;

import ar.fiuba.tdd.template.tp0.quantifiers.AsteriscQuantifier;
import ar.fiuba.tdd.template.tp0.quantifiers.InterrogateQuantifier;
import ar.fiuba.tdd.template.tp0.quantifiers.PlusQuantifier;
import ar.fiuba.tdd.template.tp0.regularExpressions.RegularExpression;
import ar.fiuba.tdd.template.tp0.tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private Tokenizer tokenizer;

    public RegExGenerator(int maxLength) {
        //Tokenizador
        this.tokenizer = new Tokenizer();
        this.tokenizer.addQuantifier(new AsteriscQuantifier(maxLength));
        this.tokenizer.addQuantifier(new InterrogateQuantifier());
        this.tokenizer.addQuantifier(new PlusQuantifier(maxLength));
    }

    // TODO: Uncomment parameters
    public List<String> generate(String regEx, int numberOfResults) {
        List<String> strings = new ArrayList<String>();
        String aString = "";

        List<RegularExpression> tokens = this.tokenizer.getTokensOf(regEx);

        for (int j = 0; j < numberOfResults; j++) {
            aString = "";
            for (RegularExpression aRegularExpresion : tokens) {
                aString += aRegularExpresion.getRandomString();
            }
            strings.add(aString);
        }

        return strings;
    }
}