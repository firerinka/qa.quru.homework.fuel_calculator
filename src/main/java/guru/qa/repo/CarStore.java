package guru.qa.repo;

import guru.qa.db.CarRepository;
import guru.qa.db.impl.PostgresCarRepository;
import guru.qa.entity.CarEntity;

public class CarStore {

    private CarRepository carRepository = new PostgresCarRepository();

    public CarEntity lookup(String carName) {
        CarEntity car = carRepository.getByName(carName);

        if (car != null) {
            return car;
        }

        throw new IllegalArgumentException("Car not found for given name: " + carName);
    }

    public Object[] carModelNames() {
        return carRepository.getAllNames();
    }
}
