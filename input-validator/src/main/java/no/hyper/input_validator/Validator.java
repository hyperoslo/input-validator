package no.hyper.input_validator;

import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;

import no.hyper.input_validator.checkable.Checkable;
import no.hyper.input_validator.checkable.DateValidator;
import no.hyper.input_validator.checkable.EmailValidator;
import no.hyper.input_validator.checkable.PhoneValidator;
import no.hyper.input_validator.checkable.TextValidator;

public class Validator {

    private String LOG_TAG = this.getClass().getSimpleName();

    public boolean check(EditText editText, String error) {
        Checkable checkable = getTypeValidator(editText);
        if (checkable.check()) {
            editText.setError(null);
            return true;
        } else {
            editText.setError(error);
            return false;
        }
    }

    public boolean check(TextInputLayout inputLayout, String error) {
        EditText editText = inputLayout.getEditText();
        Checkable checkable = getTypeValidator(editText);
        if (checkable.check()) {
            inputLayout.setErrorEnabled(false);
            inputLayout.setError(null);
            return true;
        } else {
            inputLayout.setErrorEnabled(true);
            inputLayout.setError(error);
            return false;
        }
    }

    private Checkable getTypeValidator(EditText editText) {

        int type = editText.getInputType();
        String value = editText.getText().toString();

        switch(type) {
            case InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE :
                return new DateValidator(value);
            case InputType.TYPE_CLASS_PHONE : return new PhoneValidator(value);
            case InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                return new EmailValidator(value);
            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES):
                return new TextValidator(value);
            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD):
                return new TextValidator(value);
            default : return new TextValidator(value);
        }

    }

}
