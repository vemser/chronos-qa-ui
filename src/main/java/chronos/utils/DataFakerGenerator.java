package chronos.utils;

import com.github.javafaker.Faker;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();

    public String emailFaker() {
        return faker.internet().emailAddress();
    }
    public String senhaFaker() {
        return faker.internet().password();
    }

    public String firstNameFaker() { return faker.name().firstName(); }
    public String lastNameFaker() { return faker.name().lastName(); }
    public String titleFaker() { return String.valueOf(faker.random().nextInt(2) + 1);}

    public int dayOfBirthFaker() {
        return faker.random().nextInt(1, 31 + 1);
    }

    public String number(){
        return  faker.number().digits(5);
    }
    public String number51(){
        return  faker.number().digits(51);
    }

    public String number1(){
        return  faker.number().digits(1);
    }
    public String number256(){
        return  faker.number().digits(256);
    }


    public int monthOfBirthFaker() {
        return faker.random().nextInt(1, 12 + 1);
    }
    public int yearOfBirthFaker() {
        return faker.random().nextInt(1, 126 + 1);
    }

    public String ProdutoFaker(){
        return faker.commerce().productName();
    }

    public String mensagemFaker() {
        return faker.lorem().sentence();
    }
}