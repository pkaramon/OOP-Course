package agh.ics.oop;

import agh.ics.oop.model.genes.Genotype;

public class SimulationStatistics {
    private int animalsAlive = 0;
    private int animalsDeadOverall = 0;
    private int animalsDeadOnLastDay = 0;
    private int animalsBornOnLastDay = 0;
    private double averageLifetimeForDeadAnimals = 0;
    private Genotype dominantGenotype = null;
    private int grassOnMap = 0;
    private int freeFields = 0;
    private int currentDay = 0;



    public int getAnimalsAlive() {
        return animalsAlive;
    }

    public void setAnimalsAlive(int animalsAlive) {
        this.animalsAlive = animalsAlive;
    }

    public int getAnimalsDeadOverall() {
        return animalsDeadOverall;
    }

    public void setAnimalsDeadOverall(int animalsDeadOverall) {
        this.animalsDeadOverall = animalsDeadOverall;
    }

    public int getAnimalsDeadOnLastDay() {
        return animalsDeadOnLastDay;
    }

    public void setAnimalsDeadOnLastDay(int animalsDeadOnLastDay) {
        this.animalsDeadOnLastDay = animalsDeadOnLastDay;
    }

    public int getAnimalsBornOnLastDay() {
        return animalsBornOnLastDay;
    }

    public void setAnimalsBornOnLastDay(int animalsBornOnLastDay) {
        this.animalsBornOnLastDay = animalsBornOnLastDay;
    }

    public double getAverageLifetimeForDeadAnimals() {
        return averageLifetimeForDeadAnimals;
    }

    public void setAverageLifetimeForDeadAnimals(double averageLifetimeForDeadAnimals) {
        this.averageLifetimeForDeadAnimals = averageLifetimeForDeadAnimals;
    }

    public Genotype getDominantGenotype() {
        return dominantGenotype;
    }

    public void setDominantGenotype(Genotype dominantGenotype) {
        this.dominantGenotype = dominantGenotype;
    }

    public int getGrassOnMap() {
        return grassOnMap;
    }

    public void setGrassOnMap(int plantsGrows) {
        this.grassOnMap = plantsGrows;
    }

    public SimulationStatistics copy() {
        SimulationStatistics copy =  new SimulationStatistics();

        copy.setAnimalsAlive(this.getAnimalsAlive());
        copy.setAnimalsBornOnLastDay(this.getAnimalsBornOnLastDay());
        copy.setAnimalsDeadOnLastDay(this.getAnimalsDeadOnLastDay());
        copy.setAnimalsDeadOverall(this.getAnimalsDeadOverall());
        copy.setAverageLifetimeForDeadAnimals(this.getAverageLifetimeForDeadAnimals());
        copy.setDominantGenotype(this.getDominantGenotype());
        copy.setGrassOnMap(this.getGrassOnMap());
        copy.setFreeFields(this.getFreeFields());
        copy.setCurrentDay(this.getCurrentDay());

        return copy;
    }

    public int getFreeFields() {
        return freeFields;
    }

    public void setFreeFields(int freeFields) {
        this.freeFields = freeFields;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }
}
