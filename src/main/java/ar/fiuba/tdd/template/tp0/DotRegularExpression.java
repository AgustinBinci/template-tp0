package ar.fiuba.tdd.template.tp0;

import java.util.Random;
/**
 * Created by Monica2015 on 19/3/16.
 */
public class DotRegularExpression implements IRegularExpresion {

    private static final Character specialCharacter = '.';

    @Override
    public Boolean isRegularExpression(String aText) {
        if (aText.length() == 1 && aText.charAt(0) == specialCharacter) return true;
        return false;
    }

    @Override
    public String getRandomStringForWithLimit(Character aCharacter, Integer aLimit) {
        Integer random = (new Random()).nextInt();
        String aRandomString = "";

        if (random == 1) {
            for (Integer i = 0; i < aLimit; i++) {
                aRandomString += aCharacter;
            }
        }

        return aRandomString;
    }

}
