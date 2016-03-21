package ar.fiuba.tdd.template.tp0.regularExpressions;

public class DotRegularExpression extends RegularExpression {

    @Override
    public Character getRandomCharacter(){
        Integer aRandomNumber = (int)(Math.random() * 256);
        return (aRandomNumber.toString().charAt(0));
    }

}
