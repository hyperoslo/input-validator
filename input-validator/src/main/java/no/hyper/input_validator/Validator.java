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

    public static boolean check(EditText editText, String error) {
        Checkable checkable = getTypeValidator(editText);
        boolean valid = isValid(checkable);
        setError(editText, valid, error);
        return valid;
    }

    public static boolean check(EditText editText, String pattern, String error) {
        Checkable checkable = getTypeValidator(editText);
        boolean valid = isValid(checkable, pattern);
        setError(editText, valid, error);
        return valid;
    }

    public static boolean check(TextInputLayout inputLayout, String error) {
        Checkable checkable = getTypeValidator(inputLayout.getEditText());
        boolean valid = isValid(checkable);
        setError(inputLayout, valid, error);
        return valid;
    }

    public static boolean check(TextInputLayout inputLayout, String pattern, String error) {
        Checkable checkable = getTypeValidator(inputLayout.getEditText());
        boolean valid = isValid(checkable, pattern);
        setError(inputLayout, valid, error);
        return valid;
    }

    private static boolean isValid(Checkable checkable) {
        return checkable.check();
    }

    private static boolean isValid(Checkable checkable, String pattern) {
        return checkable.checkWithPattern(pattern);
    }

    private static void setError(EditText editText, boolean isValid, String error) {
        if (isValid) {
            editText.setError(null);
        } else {
            editText.setError(error);
        }
    }

    private static void setError(TextInputLayout inputLayout, boolean isValid, String error) {
        if (isValid) {
            inputLayout.setErrorEnabled(false);
            inputLayout.setError(null);
        } else {
            inputLayout.setErrorEnabled(true);
            inputLayout.setError(error);
        }
    }

    private static Checkable getTypeValidator(EditText editText) {

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
