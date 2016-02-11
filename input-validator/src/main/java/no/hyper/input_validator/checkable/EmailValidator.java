package no.hyper.input_validator.checkable;

import android.util.Patterns;

public class EmailValidator extends BaseCheckable{

    public EmailValidator (String value) {
        this.value = value;
    }

    @Override
    public boolean check() {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }

}
