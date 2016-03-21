package ar.fiuba.tdd.template.tp0.quantifiers;

public class AsteriscQuantifier extends Quantifier {

    public AsteriscQuantifier(int aMaximumRange) {
        super('*');
        this.minimumRange = 0;
        this.maximumRange = aMaximumRange;
    }

}
