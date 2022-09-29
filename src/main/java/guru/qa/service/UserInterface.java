package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

public abstract class UserInterface {
    protected final CarStore carStore;
    protected final TrackStore trackStore;

    public UserInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public abstract Car chooseCar();

    public abstract Track chooseTrack();

    public abstract void showResult(Car car, Track track);
}
