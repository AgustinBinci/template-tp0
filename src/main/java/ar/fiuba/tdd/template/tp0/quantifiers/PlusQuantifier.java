package ar.fiuba.tdd.template.tp0.quantifiers;

public class PlusQuantifier extends Quantifier {

    public PlusQuantifier(int aMaximumRange) {
        super('+');
        this.minimumRange = 1;
        this.maximumRange = aMaximumRange;
    }

}
