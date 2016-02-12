package no.hyper.inputvalidatordemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import no.hyper.input_validator.Validator;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout text;
    private TextInputLayout email;
    private TextInputLayout phone;
    private TextInputLayout password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextInputLayout) findViewById(R.id.text);
        email = (TextInputLayout) findViewById(R.id.email);
        phone = (TextInputLayout) findViewById(R.id.phone);
        password = (TextInputLayout) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
    }

    public void validate(View view) {
        boolean checkText = Validator.check(text, "text is not good");
        boolean checkEmail = Validator.check(email, "email is not good");
        boolean checkPhone = Validator.check(phone, "phone is not good");
        boolean checkPassword = Validator.check(password, "password is not good");

        Log.d("TEST", "checkText: " + checkText + ", checkEmail: " + checkEmail + ", checkPhone: " +
                checkPhone + ", checkPassword: " + checkPassword);
    }

}
