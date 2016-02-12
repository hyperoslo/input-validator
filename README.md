# input-validator

This library use the `inputType` xml parameter from EditText object to validate their content.

##Gradle

```
compile 'no.hyper:input-validator:0.4'
```

##Usage

``` Java
public class MainActivity extends AppCompatActivity {

    private TextInputLayout email;

    ...

    public void onButtonValidation(View view) {
        boolean checkText = Validator.check(text, "text is not correct");
        Log.d("TEST", "checkText: " + checkText + ");
    }

}
```

You can also use `Validator.check(code, "\\d{4}" "email is not good")` for verification with custom pattern.

##Default pattern/behavior
* `date` : `"\\d{2}/\\d{2}/\\d{4}"`
* `textEmailAddress` : `Patterns.EMAIL_ADDRESS`
* `phone` : `Patterns.PHONE`
* every sub-types of text : `check` verifies if the field is not blanck
