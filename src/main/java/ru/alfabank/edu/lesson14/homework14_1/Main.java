package ru.alfabank.edu.lesson14.homework14_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        System.out.println("\nДо сортировки:");
        movies.forEach(System.out::println);

        movies.sort(new MovieRatingComparator());

        System.out.println("\nПосле сортировки:");
        movies.forEach(System.out::println);
    }
}
