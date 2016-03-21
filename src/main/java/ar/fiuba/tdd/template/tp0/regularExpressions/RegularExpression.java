package ar.fiuba.tdd.template.tp0.regularExpressions;

import ar.fiuba.tdd.template.tp0.quantifiers.Quantifier;

public abstract class RegularExpression {

    protected Quantifier quantifier;

    public void setQuantifier(Quantifier aQuantifier) {
        this.quantifier = aQuantifier;
    }

    public String getRandomString() {
        if (this.quantifier != null) return this.quantifier.generateStrings(this);
        else return (this.getRandomCharacter().toString());
    }

    public abstract Character getRandomCharacter();

}
