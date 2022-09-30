package guru.qa.db.impl;

import guru.qa.db.CarEntityRowMapper;
import guru.qa.db.CarRepository;
import guru.qa.db.DataSourceProvider;
import guru.qa.entity.CarEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresCarRepository implements CarRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<CarEntity> getAll() {
        return template.query("SELECT * FROM car", new CarEntityRowMapper());
    }

    @Override
    public Object[] getAllNames() {
        Object[] result = template.queryForList("SELECT name FROM car", String.class).toArray();
        return result;
    }

    @Override
    public @Nullable
    CarEntity getByName(String carName) {
        try {
            return template.queryForObject("SELECT * FROM car WHERE LOWER(car.name) LIKE ?", new CarEntityRowMapper(), carName.toLowerCase());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addCar(CarEntity car) {
        template.update("INSERT INTO car (name , fuel_economy ) values (? , ?)", car.getName(), car.getFuelEconomy());
    }

    @Override
    public void updateCar(CarEntity car) {
        template.update("UPDATE car SET name = ?, fuel_economy = ?", car.getName(), car.getFuelEconomy());
    }
}
