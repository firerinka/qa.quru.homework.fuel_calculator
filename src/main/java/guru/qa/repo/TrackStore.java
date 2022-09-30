package guru.qa.repo;

import guru.qa.db.TrackRepository;
import guru.qa.db.impl.PostgresTrackRepository;
import guru.qa.entity.TrackEntity;

public class TrackStore {

    private TrackRepository trackRepository = new PostgresTrackRepository();

    public TrackEntity lookup(String trackName) {
        TrackEntity track = trackRepository.getByName(trackName);

        if (track != null) {
            return track;
        }

        throw new IllegalArgumentException("Track not found for given name: " + trackName);
    }

    public Object[] trackNames() {
        return trackRepository.getAllNames();
    }
}
