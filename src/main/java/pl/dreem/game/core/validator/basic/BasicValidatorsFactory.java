package pl.dreem.game.core.validator.basic;

        import java.util.*;

public final class BasicValidatorsFactory {

    private static List<BasicValidator> validators;

    public static List<BasicValidator> getBasicValidators() {
        if (validators == null) {
            final List<BasicValidator> validatorsToCache = new ArrayList<>();
            validatorsToCache.add(new BasicColumnValidator());
            validatorsToCache.add(new BasicRowValidator());
            validatorsToCache.add(new BasicDiagValidator());
            validatorsToCache.add(new BasicAntiDiagValidator());
            validatorsToCache.add(new BasicDrawValidator());
            validators = Collections.unmodifiableList(validatorsToCache);
        }
        return validators;
    }
}