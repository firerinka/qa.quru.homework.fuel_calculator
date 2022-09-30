package guru.qa.entity;

public class TrackEntity {
    private int id;
    private String name;
    private int laps;
    private int lapDistance;

    public int getId() {
        return id;
    }

    public TrackEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getLaps() {
        return laps;
    }

    public TrackEntity setLaps(int laps) {
        this.laps = laps;
        return this;
    }

    public int getLapDistance() {
        return lapDistance;
    }

    public TrackEntity setLapDistance(int lapDistance) {
        this.lapDistance = lapDistance;
        return this;
    }
}
