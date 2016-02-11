package no.hyper.input_validator.checkable;

public class TextValidator extends BaseCheckable{

    public TextValidator(String value) {
        this.value = value;
    }

    @Override
    public boolean check() {
        return isNotBlank();
    }
}
