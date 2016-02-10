package no.hyper.input_validator;

import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;

public class Validator {

    private String LOG_TAG = this.getClass().getSimpleName();

    public boolean check(EditText editText) {
        int type = editText.getInputType();
        String value = editText.getText().toString();

        switch(type) {
            case InputType.TYPE_CLASS_PHONE : return checkPhoneType(value);
            case InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                return checkEmailType(value);
            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES):
                return checkTextCapSentencesType(value);
            case (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD):
                return checkVisiblePasswordType(value);
            default : Log.d(LOG_TAG, "type: " + type);
        }

        return false;
    }

    private boolean checkPhoneType(String value) {
        Log.d(LOG_TAG, "checkPhoneType");
        return Patterns.PHONE.matcher(value).matches();
    }

    private boolean checkEmailType(String value) {
        Log.d(LOG_TAG, "checkEmailType");
        return Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }

    private boolean checkTextCapSentencesType(String value) {
        Log.d(LOG_TAG, "checkTextCapSentencesType");
        return isNotBlanck(value);
    }

    private boolean checkVisiblePasswordType(String value) {
        Log.d(LOG_TAG, "checkVisiblePasswordType");
        return isNotBlanck(value);
    }

    private boolean isNotBlanck(String value) {
        return value != null && !value.contains(" ");
    }

}
