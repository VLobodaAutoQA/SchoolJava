package ru.alfabank.edu.lesson14.homework14_1;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator <Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getRatingMovie(), o2.getRatingMovie());
    }
}
