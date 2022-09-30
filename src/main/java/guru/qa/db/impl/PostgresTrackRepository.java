package guru.qa.db.impl;

import guru.qa.db.DataSourceProvider;
import guru.qa.db.TrackEntityRowMapper;
import guru.qa.db.TrackRepository;
import guru.qa.entity.TrackEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

import java.util.List;

public class PostgresTrackRepository implements TrackRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public List<TrackEntity> getAll() {
        return template.query("SELECT * FROM track", new TrackEntityRowMapper());
    }

    @Override
    public Object[] getAllNames() {
        Object[] result = template.queryForList("SELECT name FROM track", String.class).toArray();
        return result;
    }

    @Override
    public @Nullable
    TrackEntity getByName(String trackName) {
        try {
            return template.queryForObject("SELECT * FROM track WHERE LOWER(track.name) LIKE ?", new TrackEntityRowMapper(), trackName.toLowerCase());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addTrack(TrackEntity track) {
        template.update("INSERT INTO track (name , laps, lap_distance ) values (? , ?, ?)", track.getName(), track.getLaps(), track.getLapDistance());
    }

    @Override
    public void updateTrack(TrackEntity track) {
        template.update("UPDATE track SET name = ?, laps = ?, lap_distance = ?", track.getName(), track.getLaps(), track.getLapDistance());
    }
}

