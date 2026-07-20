package ru.alfabank.edu.lesson14.homework14_1;

public class Movie {
    private String nameMovie;
    private double ratingMovie;

    public Movie(String nameMovie, double ratingMovie) {
        this.nameMovie = nameMovie;
        this.ratingMovie = ratingMovie;
    }

    public Movie() {}

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public double getRatingMovie() {
        return ratingMovie;
    }

    public void setRatingMovie(float ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    @Override
    public String toString() {
        return "Фильм = '" + nameMovie + '\'' +
                ", Рейтинг = " + ratingMovie;
    }
}
