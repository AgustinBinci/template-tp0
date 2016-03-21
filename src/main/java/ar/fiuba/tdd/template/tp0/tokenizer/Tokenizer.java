package ar.fiuba.tdd.template.tp0.tokenizer;

import ar.fiuba.tdd.template.tp0.quantifiers.Quantifier;
import ar.fiuba.tdd.template.tp0.regularExpressions.DotRegularExpression;
import ar.fiuba.tdd.template.tp0.regularExpressions.LiteralRegularExpression;
import ar.fiuba.tdd.template.tp0.regularExpressions.RegularExpression;
import ar.fiuba.tdd.template.tp0.regularExpressions.SetRegularExpression;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private List<Quantifier> quantifiers;

    public Tokenizer() {
        this.quantifiers = new ArrayList<>();
    }

    public void addQuantifier(Quantifier aQuantifier) {
        this.quantifiers.add(aQuantifier);
    }

    public List<RegularExpression> getTokensOf(String aText) {

        //Declaro objetos a utilizar
        List<RegularExpression> tokens = new ArrayList<>();
        String aToken = "";
        String aStringSet = "";
        Character aChar = ' ';
        Boolean isSetRegularExpression = false;
        Boolean isScapedLiteralRegularExpression = false;
        Boolean isQuantifier = false;

        //Tokenizo
        for (int i = 0; i < aText.length(); i++) {

            //Capturo el caracter
            aChar = aText.charAt(i);

            //Si no es el comienzo de una expresion regular de conjunto
            if (aChar != '[') {

                //Si no es el fin de una expresion regular de conjunto
                if (aChar != ']') {

                    //Si no es un literal escapado
                    if (aChar != '\\') {

                        //Si venia de un literal escapado
                        if (isScapedLiteralRegularExpression) {
                            tokens.add(new LiteralRegularExpression(aChar));
                            isScapedLiteralRegularExpression = false;
                        }
                        else {

                            //Si es un conjunto
                            if (isSetRegularExpression) aStringSet += aChar;
                            else {

                                //Si es una expresion regular de punto
                                if (aChar == '.') tokens.add(new DotRegularExpression());
                                else {

                                    //Si es un cuantificador
                                    for (Quantifier aQuantifier : this.quantifiers) {
                                        if (aQuantifier.isQuantifier(aChar)) {
                                            if (!tokens.isEmpty()) {
                                                if (isQuantifier)
                                                    throw new RuntimeException("Invalid regular expression");
                                                isQuantifier = true;
                                                tokens.get(tokens.size() - 1).setQuantifier(aQuantifier);
                                                break;
                                            }
                                            else throw new RuntimeException("Invalid regular expression");
                                        }
                                    }
                                    if (isQuantifier) continue;

                                    //Literal
                                    tokens.add(new LiteralRegularExpression(aChar));
                                }
                            }
                        }

                    }
                    else isScapedLiteralRegularExpression = true;
                }
                else {
                    SetRegularExpression aSetRegularExpression = new SetRegularExpression();
                    for (int j = 0; j < aStringSet.length(); j++) {
                        aSetRegularExpression.setCharacter(aStringSet.charAt(j));
                    }
                    tokens.add(aSetRegularExpression);
                    isSetRegularExpression = false;
                    aStringSet = "";
                }
            }
            else isSetRegularExpression = true;

            isQuantifier = false;

        }

        return tokens;
    }
}
