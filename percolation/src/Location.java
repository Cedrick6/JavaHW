import stdlib.StdOut;

public class Location {
    private String name; // location name
    private double lat;  // latitude
    private double lon;  // longitude

    // Constructs a new location given its name, latitude, and longitude.
    public Location(String name, double lat, double lon) {
        // TODO
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    // Returns the great-circle distance between this location and other.
    public double distanceTo(Location other) {
        // TODO
        double R = 6371.0; // Earth’s radius in kilometers

        double lat1 = Math.toRadians(this.lat);
        double lon1 = Math.toRadians(this.lon);
        double lat2 = Math.toRadians(other.lat);
        double lon2 = Math.toRadians(other.lon);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.sin(dlon / 2) * Math.sin(dlon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;    }

    // Returns true if this location is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // TODO
        Location that = (Location) other;
        return this.lat == that.lat && this.lon == that.lon;
    }

    // Returns a string representation of this location.
    public String toString() {
        // TODO
        return name + " (" + lat + ", " + lon + ")";

    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Location x = new Location("Paris", 48.51, -2.17);
        Location y = new Location("Boston", 42.36, -71.05);
        StdOut.println("x               = " + x);
        StdOut.println("y               = " + y);
        StdOut.println("x.distanceTo(y) = " + x.distanceTo(y));
        StdOut.println("x.equals(y)     = " + x.equals(y));
    }
}

//javac -d out src/Location.java
//java Location