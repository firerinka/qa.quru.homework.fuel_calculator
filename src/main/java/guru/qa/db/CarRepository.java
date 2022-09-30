package guru.qa.db;

import guru.qa.entity.CarEntity;

        import java.util.List;

public interface CarRepository {
    List<CarEntity>  getAll();
    Object[] getAllNames();
    CarEntity  getByName(String carName);
    void addCar(CarEntity car);
    void updateCar(CarEntity car);
}
