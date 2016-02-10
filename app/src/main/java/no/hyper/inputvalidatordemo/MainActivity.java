package no.hyper.inputvalidatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import no.hyper.input_validator.Validator;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private EditText email;
    private EditText phone;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.text);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
    }

    public void validate(View view) {
        Validator validator = new Validator();
        boolean checkText = validator.check(text);
        boolean checkEmail = validator.check(email);
        boolean checkPhone = validator.check(phone);
        boolean checkPassword = validator.check(password);

        Log.d("TEST", "checkText: " + checkText + ", checkEmail: " + checkEmail + ", checkPhone: " +
                checkPhone + ", checkPassword: " + checkPassword);
    }

}
