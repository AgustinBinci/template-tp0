package ar.fiuba.tdd.template.tp0.regularExpressions;

import java.util.ArrayList;
import java.util.List;

public class SetRegularExpression extends RegularExpression {

    private static final Character firstSpecialCharacter = '[';
    private static final Character lastSpecialCharacter = ']';
    private List<Character> setCharacters;

    public SetRegularExpression(){
        this.setCharacters = new ArrayList<>();
    }

    public List<Character> getCharacters() {
        return this.setCharacters;
    }

    public void setCharacter(Character aCharacter) {
        this.setCharacters.add(aCharacter);
    }

    @Override
    public Character getRandomCharacter(){
        Integer aRandomNumber = (int)(Math.random() * this.setCharacters.size());
        return (this.setCharacters.get(aRandomNumber));
    }

}
