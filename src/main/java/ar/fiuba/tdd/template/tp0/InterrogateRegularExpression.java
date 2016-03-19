package ar.fiuba.tdd.template.tp0;

/**
 * Created by Monica2015 on 19/3/16.
 */
public class InterrogateRegularExpression implements IRegularExpresion {

    private static final Character specialCharacter = '?';

    @Override
    public Boolean isRegularExpression(String aText) {
        if (aText.length() == 1 && aText.charAt(0) == specialCharacter) return true;
        return false;
    }

    @Override
    public String getRandomStringForWithLimit(Character aCharacter, Integer aLimit) {
        return null;
    }
}
