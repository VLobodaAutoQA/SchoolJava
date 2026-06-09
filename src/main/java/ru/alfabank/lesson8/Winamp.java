package ru.alfabank.lesson8;

public class Winamp {
    static void main() {

        Playlist playlist = new Playlist("Мой новый плэйлист");

        System.out.println("=== Добавляем песни в плэйлист ===");
        playlist.addSong("Песня1");
        playlist.addSong("Песня2");
        playlist.addSong("Песня3");
        playlist.addSong("Песня4");
        playlist.addSong("Песня5");
        System.out.println(playlist);
        System.out.println();

        System.out.println("=== Удаляем песни из плэйлиста по индексу ===");
        playlist.deleteSong(1);
        System.out.println(playlist);
        System.out.println();

        System.out.println("=== Обновляем песню по индексу ===");
        playlist.updateSong(0, "Новая песня");
        System.out.println();

        System.out.println("=== Получаем песню по индексу ===");
        playlist.getSong(1);
        System.out.println();

        System.out.println("Финальный вывод плейлиста:");
        System.out.println(playlist);
    }
}
