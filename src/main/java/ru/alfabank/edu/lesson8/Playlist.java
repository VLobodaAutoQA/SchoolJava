package ru.alfabank.edu.lesson8;

import java.util.ArrayList;

public class Playlist {

    private String namePlaylist;
    private ArrayList<String> listSongs= new ArrayList<>();

    public Playlist() {

    }

    public Playlist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
        this.listSongs = new ArrayList<>();
    }

    // добавление песни в плейлист
    public void addSong(String nameSong) {
        listSongs.add(nameSong);
        System.out.println("В плейлист добавлена песня: " + nameSong);
    }

    // удаление песни по индексу
    public void deleteSong(int index) {
        if (index >= 0 && index < listSongs.size()) {
            String removedSong = listSongs.remove(index);
            System.out.println("Из плейлиста удалена песня № " + index + ": " + removedSong);
        } else {
            System.out.println("Неправильно указан индекс песни!");
        }
    }

    // обновление песни по индексу
    public void updateSong(int index, String newSong) {
        String oldSong = listSongs.set(index, newSong);
        System.out.println("В плейлисте обновлена песня №" + index + ": " + oldSong + " на " + newSong);
    }

    // получение песни по индексу
    public String getSong(int index) {
        String song = listSongs.get(index);
        System.out.println("Получена песня по индексу №" + index + ": " + song);
        return song;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "Название плэйлиста='" + namePlaylist + '\'' +
                ", Список песен=" + listSongs +
                '}';
    }
}
