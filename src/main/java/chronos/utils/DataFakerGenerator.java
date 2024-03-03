package chronos.utils;

import com.github.javafaker.Faker;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();

    public static String emailFaker() {
        return faker.internet().emailAddress();
    }
    public static String senhaFaker() {
        return faker.internet().password();
    }

    public static String firstNameFaker() { return faker.name().firstName(); }
    public static String lastNameFaker() { return faker.name().lastName(); }
    public static String titleFaker() { return String.valueOf(faker.random().nextInt(2) + 1);}

    public static int dayOfBirthFaker() {
        return faker.random().nextInt(1, 31 + 1);
    }

    public static int monthOfBirthFaker() {
        return faker.random().nextInt(1, 12 + 1);
    }
    public static int yearOfBirthFaker() {
        return faker.random().nextInt(1, 126 + 1);
    }

    public static String ProdutoFaker(){
        return faker.commerce().productName();
    }

    public static String mensagemFaker() {
        return faker.lorem().sentence();
    }
    public static String evento() { return faker.company().name() + faker.letterify("??"); }
    public static String description() { return faker.lorem().sentence(); }

    public static String descricao256() { return faker.lorem().sentence(258);}
    public static String nome50() { return faker.lorem().sentence(51);}
}