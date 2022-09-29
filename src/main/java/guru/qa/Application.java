package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.service.ConsoleInterface;
import guru.qa.service.GuiInterface;
import guru.qa.service.UserInterface;

public class Application {

    private final UserInterface userInterface;

    public Application(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    void run() {
        Car car = userInterface.chooseCar();
        Track track = userInterface.chooseTrack();
        userInterface.showResult(car, track);
    }
}
