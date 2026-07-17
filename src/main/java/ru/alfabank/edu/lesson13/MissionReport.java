package ru.alfabank.edu.lesson13;

import java.util.List;

public class MissionReport {
    private String missionName;
    private List<Alien> capturedAliens;
    private int squadSize;

    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = capturedAliens;
        this.squadSize = squadSize;
    }

    // Геттеры и сеттеры
    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Alien> getCapturedAliens() {
        return capturedAliens;
    }

    public void setCapturedAliens(List<Alien> capturedAliens) {
        this.capturedAliens = capturedAliens;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }

    @Override
    public String toString() {
        return "Миссия: " + missionName + "\n" +
                "Поймано пришельцев: " + capturedAliens.size() + "\n" +
                "Размер отряда: " + squadSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionReport that = (MissionReport) o;
        return squadSize == that.squadSize &&
                java.util.Objects.equals(missionName, that.missionName) &&
                java.util.Objects.equals(capturedAliens, that.capturedAliens);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(missionName, capturedAliens, squadSize);
    }
}