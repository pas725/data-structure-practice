package misc.ood.parkingLot;

/**
 * Created by psagar on 1/28/2018.
 */
public class Parking {
    private ParkingLot parkingLot;

    public Parking() {
        this.parkingLot = new ParkingLot(100);
    }

    public String park(Vehicle v) {
        return parkingLot.parkVehicle(v);
    }

    public boolean unPark(String token) {
        return parkingLot.unPark(token);
    }
}
