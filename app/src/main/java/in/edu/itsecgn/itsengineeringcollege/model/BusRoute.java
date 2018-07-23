package in.edu.itsecgn.itsengineeringcollege.model;

public class BusRoute {
    private String timings;
    private String stop;

    public BusRoute(String timings, String stop) {
        this.timings = timings;
        this.stop = stop;
    }

    public String getTimings() {
        return timings;
    }

    public String getStop() {
        return stop;
    }


}
