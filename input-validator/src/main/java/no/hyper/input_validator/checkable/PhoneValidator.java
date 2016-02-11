package no.hyper.input_validator.checkable;

import android.util.Patterns;

public class PhoneValidator extends BaseCheckable {

    public PhoneValidator (String value) {
        this.value = value;
    }

    @Override
    public boolean check() {
        return Patterns.PHONE.matcher(value).matches();
    }

}
