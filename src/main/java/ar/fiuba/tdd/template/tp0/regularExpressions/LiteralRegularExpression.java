package ar.fiuba.tdd.template.tp0.regularExpressions;

public class LiteralRegularExpression extends RegularExpression {

    private Character literal;

    public LiteralRegularExpression(Character aLiteral) {
        this.literal = aLiteral;
    }

    @Override
    public Character getRandomCharacter(){
        return this.literal;
    }

}
