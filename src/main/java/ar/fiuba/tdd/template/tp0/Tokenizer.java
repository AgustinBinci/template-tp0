package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monica2015 on 19/3/16.
 */
public class Tokenizer {

    private List<IRegularExpresion> regularExpressions;

    public Tokenizer() {
        this.regularExpressions = new ArrayList<>();
    }

    public void addRegularExpression(IRegularExpresion aRegularExpression) {
        this.regularExpressions.add(aRegularExpression);
    }

    /*public List<String> getTokensOf(String aText) {
        List<String> tokens = new ArrayList<String>();
        String aToken = new String();

        //First tokenize
        for (int i = 0; i < aText.length(); i++) {
            aToken += aText.charAt(i);

            for (IRegularExpresion regularExpresion : this.regularExpressions) {
                if (regularExpresion.isRegularExpression(aToken)) {

                    tokens.add(new String(aToken.toString()));
                }
            }
        }
    }*/
}
