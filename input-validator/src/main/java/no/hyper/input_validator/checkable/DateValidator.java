package no.hyper.input_validator.checkable;

import java.util.regex.Pattern;

public class DateValidator extends BaseCheckable {

    private static String EUROPEAN_DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";

    public DateValidator (String value) {
        this.value = value;
    }

    @Override
    public boolean check() {
        return Pattern.matches(EUROPEAN_DATE_PATTERN, value);
    }

}
