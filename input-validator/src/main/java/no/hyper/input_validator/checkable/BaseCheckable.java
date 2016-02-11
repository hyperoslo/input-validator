package no.hyper.input_validator.checkable;

import java.util.regex.Pattern;

abstract class BaseCheckable implements Checkable {

    protected String value;

    @Override
    public boolean isNotBlank() {
        return value != null && !value.isEmpty() && !value.contains(" ");
    }

    abstract public boolean check();

    @Override
    public boolean checkWithPattern(String pattern) {
        return Pattern.matches(pattern, value);
    }

}
