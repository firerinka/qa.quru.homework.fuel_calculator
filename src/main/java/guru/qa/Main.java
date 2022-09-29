package guru.qa;

import guru.qa.service.ArgumentReader;
import guru.qa.service.UserInterface;

public class Main {
    public static void main(String[] args) {
        ArgumentReader argumentReader = new ArgumentReader(args);
        UserInterface userInterface = argumentReader.selectInterfaceTypeFromArgs();

        new Application(userInterface).run();
    }
}
