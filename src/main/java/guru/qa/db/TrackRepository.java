package guru.qa.db;

import guru.qa.entity.TrackEntity;

import java.util.List;

public interface TrackRepository {
    List<TrackEntity> getAll();
    Object[] getAllNames();

    TrackEntity getByName(String trackName);

    void addTrack(TrackEntity track);

    void updateTrack(TrackEntity track);
}
