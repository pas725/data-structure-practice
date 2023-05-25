package misc.ood.parkingLot;

/**
 * Created by psagar on 1/28/2018.
 */
public class ParkingSpot {
    private Vehicle vehicle;
    private boolean isParked;
    private String parkingSpotNumber;

    public ParkingSpot(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }
}
