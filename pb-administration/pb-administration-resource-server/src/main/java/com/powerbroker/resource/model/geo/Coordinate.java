package com.powerbroker.resource.model.geo;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wjwjtftf on 2016/12/28.
 */
@Getter
@Setter
public class Coordinate implements Serializable, Comparable<Coordinate> {

    private static final long serialVersionUID = 5484302928891640765L;

    protected Double latitude;
    protected Double longitude;

    private DecimalFormat format = new DecimalFormat("##0.000000");

    public static boolean valid(String longitudeLatitude) {
        String[] coordinateArray = StringUtils.split(longitudeLatitude, ",");
        String longitude = coordinateArray.length > 0 ? coordinateArray[0] : "";
        String latitude = coordinateArray.length > 1 ? coordinateArray[1] : "";
        return Coordinate.valid(longitude, latitude);
    }

    public static boolean valid(String longitudeString, String latitudeString) {

        boolean result = false;

        try {
            double longitude = Double.parseDouble(longitudeString);
            double latitude = Double.parseDouble(latitudeString);

            result = CoordinateManager.isValidLatitude(latitude) && CoordinateManager.isValidLongitude(longitude);

        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }

    public Coordinate(double longitude, double latitude) {
        this.generateCoordinate(longitude, latitude);
    }

    public Coordinate(String longitudeLatitude) {
        String[] coordinateArray = StringUtils.split(longitudeLatitude, ",");
        String longitudeString = coordinateArray.length > 0 ? coordinateArray[0] : "";
        String latitudeString = coordinateArray.length > 1 ? coordinateArray[1] : "";
        double longitude = Double.parseDouble(longitudeString);
        double latitude = Double.parseDouble(latitudeString);
        this.generateCoordinate(longitude, latitude);
    }

    public Coordinate(String longitudeString, String latitudeString) {
        double longitude = Double.parseDouble(longitudeString);
        double latitude = Double.parseDouble(latitudeString);
        this.generateCoordinate(longitude, latitude);
    }

    private void generateCoordinate(double longitude, double latitude) {

        if (CoordinateManager.isValidLatitude(latitude) && CoordinateManager.isValidLongitude(longitude)) {
            this.latitude = latitude;
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException(
                    "The parameters did not pass validation as defined by the CoordinateManager class");
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (CoordinateManager.isValidLongitude(longitude)) {
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException(
                    "The parameter did not pass validation as defined by the CoordinateManager class");
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (CoordinateManager.isValidLatitude(latitude)) {
            this.latitude = latitude;
        } else {
            throw new IllegalArgumentException(
                    "The parameter did not pass validation as defined by the CoordinateManager class");
        }
    }

    public String getLongitudeString() {
        return format.format(longitude);
    }

    public String getLatitudeString() {
        return format.format(latitude);
    }

    public String toString() {
        return format.format(latitude) + "," + format.format(longitude);
    }

    /**
     * A method to determine if one event is the same as another
     *
     * @param o the object to compare this one to
     * @return true if they are equal, false if they are not
     */
    public boolean equals(Object o) {
        // check to make sure the object is an event
        if ((o instanceof Coordinate) == false) {
            // o is not an event object
            return false;
        }

        // compare these two events
        Coordinate c = (Coordinate) o;

        // build items for comparison
        String me = this.getLatitudeString() + this.getLongitudeString();
        String you = c.getLatitudeString() + c.getLongitudeString();

        return me.equals(you);

    } // end equals method

    /**
     * Overide the default hashcode method
     *
     * @return a hashcode for this object
     */
    public int hashCode() {

        String me = this.getLatitudeString() + this.getLongitudeString();
        return 31 * me.hashCode();
    }

    /**
     * The compareTo method compares the receiving object with the specified
     * object and returns a negative integer, 0, or a positive integer depending
     * on whether the receiving object is less than, equal to, or greater than
     * the specified object.
     *
     * @param c the event to compare this one to
     * @return an integer indicating comparison result
     */
    @Override
    public int compareTo(Coordinate c) {
        String me = this.getLatitudeString() + this.getLongitudeString();
        String you = c.getLatitudeString() + c.getLongitudeString();

        Double meDbl = Double.valueOf(me);
        Double youDbl = Double.valueOf(you);

        if (meDbl == youDbl) {
            return 0;
        } else {
            Double tmp = Math.floor(meDbl - youDbl);
            return tmp.intValue();
        }
    }
}

class CoordinateManager {
    // declare public constants

    /**
     * The minimum allowed latitude
     */
    public static double MIN_LATITUDE = Double.valueOf("-90.000000");

    /**
     * The maximum allowed latitude
     */
    public static double MAX_LATITUDE = Double.valueOf("90.000000");

    /**
     * The minimum allowed longitude
     */
    public static double MIN_LONGITUDE = Double.valueOf("-180.000000");

    /**
     * The maximum allowed longitude
     */
    public static double MAX_LONGITUDE = Double.valueOf("180.000000");

    /**
     * The diameter of the Earth used in calculations
     */
    public static double EARTH_DIAMETER = Double.valueOf("12756.274000");

    /**
     * A method to validate a latitude value
     *
     * @param latitude the latitude to check is valid
     * @return true if, and only if, the latitude is within the MIN and MAX latitude
     */
    public static boolean isValidLatitude(double latitude) {
        if (latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method to validate a longitude value
     *
     * @param longitude the longitude to check is valid
     * @return true if, and only if, the longitude is between the MIN and MAX longitude
     */
    public static boolean isValidLongitude(double longitude) {
        if (longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A private method to calculate the latitude constant
     *
     * @return a double representing the latitude constant
     */
    public static double latitudeConstant() {
        return EARTH_DIAMETER * (Math.PI / Double.valueOf("360"));
        // return EARTH_DIAMETER * (Float.valueOf("3.14") /
        // Float.valueOf("360"));
    }

    /**
     * A private method to caluclate the longitude constant
     *
     * @param latitude a latitude coordinate in decimal notation
     * @return a double representing the longitude constant
     */
    public static double longitudeConstant(double latitude) {

        // return Math.abs( Math.cos(Math.abs(latitude)));
        return EARTH_DIAMETER * Math.PI * Math.abs(Math.cos(Math.abs(latitude))) / Double.valueOf("360");

    }

    /**
     * A method to add distance in a northerly direction to a coordinate
     *
     * @param latitude  a latitude coordinate in decimal notation
     * @param longitude a longitude coordinate in decimal notation
     * @param distance  the distance to add in metres
     * @return the new coordinate
     */
    public static Coordinate addDistanceNorth(double latitude, double longitude, int distance) {

        // check on the parameters
        if (isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
            throw new IllegalArgumentException("All parameters are required and must be valid");
        }

        // convert the distance from metres to kilometers
        double kilometers = distance / new Double(1000);

        // calculate the new latitude
        double newLat = latitude + (kilometers / latitudeConstant());

        return new Coordinate(newLat, longitude);

    }

    /**
     * A method to add distance in a southerly direction to a coordinate
     *
     * @param latitude  a latitude coordinate in decimal notation
     * @param longitude a longitude coordinate in decimal notation
     * @param distance  the distance to add in metres
     * @return the new coordinate
     */
    public static Coordinate addDistanceSouth(double latitude, double longitude, int distance) {

        // check on the parameters
        if (isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
            throw new IllegalArgumentException("All parameters are required and must be valid");
        }

        // convert the distance from metres to kilometers
        double kilometers = distance / new Double(1000);

        // calculate the new latitude
        double newLat = latitude - (kilometers / latitudeConstant());

        return new Coordinate(newLat, longitude);

    }

    /**
     * A method to add distance in an easterly direction to a coordinate
     *
     * @param latitude  a latitude coordinate in decimal notation
     * @param longitude a longitude coordinate in decimal notation
     * @param distance  the distance to add in metres
     * @return the new coordinate
     */
    public static Coordinate addDistanceEast(double latitude, double longitude, int distance) {

        // check on the parameters
        if (isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
            throw new IllegalArgumentException("All parameters are required and must be valid");
        }

        // convert the distance from metres to kilometers
        // double kilometers = distance / 1000;

        // calculate the new longitude
        double newLng = longitude + (distance / longitudeConstant(latitude));

        return new Coordinate(latitude, newLng);
    }

    /**
     * A method to add distance in an westerly direction to a coordinate
     *
     * @param latitude  a latitude coordinate in decimal notation
     * @param longitude a longitude coordinate in decimal notation
     * @param distance  the distance to add in metres
     * @return the new coordinate
     */
    public static Coordinate addDistanceWest(double latitude, double longitude, int distance) {

        // check on the parameters
        if (isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
            throw new IllegalArgumentException("All parameters are required and must be valid");
        }

        // convert the distance from metres to kilometers
        // double kilometers = distance / 1000;

        // calculate the new longitude
        double newLng = longitude - (distance / longitudeConstant(latitude));

        return new Coordinate(latitude, newLng);
    }

    /**
     * A method to build four coordinates representing a bounding box given a
     * start coordinate and a distance
     *
     * @param latitude  a latitude coordinate in decimal notation
     * @param longitude a longitude coordinate in decimal notation
     * @param distance  the distance to add in metres
     * @return a hashMap representing the bounding box (NE,SE,SW,NW)
     */
    public static java.util.HashMap<String, Coordinate> getBoundingBox(double latitude, double longitude, int distance) {

        // check on the parameters
        if (isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
            throw new IllegalArgumentException("All parameters are required and must be valid");
        }

        // convert the distance from metres to kilometers
        // float kilometers = distance / 1000;

        // declare helper variables
        java.util.HashMap<String, Coordinate> boundingBox = new java.util.HashMap<String, Coordinate>();

        // calculate the coordinates
        Coordinate north = addDistanceNorth(latitude, longitude, distance);
        Coordinate south = addDistanceSouth(latitude, longitude, distance);
        Coordinate east = addDistanceEast(latitude, longitude, distance);
        Coordinate west = addDistanceWest(latitude, longitude, distance);

        // build the bounding box object
        boundingBox.put("NE", new Coordinate(north.getLatitude(), east.getLongitude()));
        boundingBox.put("SE", new Coordinate(south.getLatitude(), east.getLongitude()));
        boundingBox.put("SW", new Coordinate(south.getLatitude(), west.getLongitude()));
        boundingBox.put("NW", new Coordinate(north.getLatitude(), west.getLongitude()));

        // return the bounding box object
        return boundingBox;
    }
}
