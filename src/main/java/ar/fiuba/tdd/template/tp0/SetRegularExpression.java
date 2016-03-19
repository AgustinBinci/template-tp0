package ar.fiuba.tdd.template.tp0;

/**
 * Created by Monica2015 on 19/3/16.
 */
public class SetRegularExpression implements IRegularExpresion {

    private static final Character firstSpecialCharacter = '[';
    private static final Character lastSpecialCharacter = ']';

    @Override
    public Boolean isRegularExpression(String aText) {
        if (aText.length() > 1) {
            if (aText.charAt(0) == firstSpecialCharacter && aText.charAt(aText.length() - 1) == lastSpecialCharacter) return true;
        }
        return false;
    }

    @Override
    public String getRandomStringForWithLimit(Character aCharacter, Integer aLimit) {
        return null;
    }
}
