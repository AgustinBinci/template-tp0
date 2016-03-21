package ar.fiuba.tdd.template.tp0.quantifiers;

import ar.fiuba.tdd.template.tp0.regularExpressions.RegularExpression;

public abstract class Quantifier {

    private Character specialCharacter;
    protected int minimumRange;
    protected int maximumRange;

    protected Quantifier(Character aSpecialCharacter) {
        specialCharacter = aSpecialCharacter;
    }

    public Boolean isQuantifier(Character aCharacter) { return (aCharacter == this.specialCharacter); }

    public String generateStrings(RegularExpression aRegularExpression) {
        Integer aRandomNumber = (int)(Math.random() * ((this.maximumRange + 1) - this.minimumRange) + this.minimumRange);
        String aStrings = "";
        for (int i = 0; i < aRandomNumber; i++) {
            aStrings += aRegularExpression.getRandomCharacter();
        }

        return aStrings;
    }

}
