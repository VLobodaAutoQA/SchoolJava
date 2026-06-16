package ru.alfabank.edu.lesson9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Logo {
    static void main() throws IOException {
        // Часть 1. Название-Логотип
        Random random = new Random();
        Faker faker = new Faker();
        ArrayList<String> surnames = new ArrayList<>();

        surnames.add("surname2");
        surnames.add("surname3");
        surnames.add("surname1");
        surnames.add("surname4");
        surnames.add("surname5");
        surnames.add("surname6");
        System.out.println(surnames);

        // Генерируем первую фамилию из списка
        String surname1 = randomSurname(surnames, random);

        // Используем знак &
        String ampersand = "&";

        // Генерируем вторую фамилию через Faker
        String surname2 = faker.name().lastName();

        System.out.println(FigletFont.convertOneLine(surname1));
        System.out.println(FigletFont.convertOneLine(ampersand));
        System.out.println(FigletFont.convertOneLine(surname2));

        // Часть 2. Генерилка юр данных для регистрации
        System.out.println(faker.name().fullName());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.address().fullAddress());

    }

    public static String randomSurname(ArrayList<String> surnames, Random random) {
        int index = random.nextInt(surnames.size());
        return surnames.get(index);
    }

}
