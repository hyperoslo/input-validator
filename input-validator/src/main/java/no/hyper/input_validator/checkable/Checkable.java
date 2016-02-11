package no.hyper.input_validator.checkable;

public interface Checkable {

    boolean isNotBlank();

    boolean check();

    boolean checkWithPattern(String pattern);

}
