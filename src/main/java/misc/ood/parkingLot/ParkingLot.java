package misc.ood.parkingLot;

import java.util.*;

/**
 * Created by psagar on 1/28/2018.
 */
public class ParkingLot {
    private String parkingLotName;
    private int parkingLotCapacity;
    private List<ParkingSpot> smallVehicleParking = new ArrayList<>();
    private List<ParkingSpot> mediumVehicleParking = new ArrayList<>();
    private List<ParkingSpot> largeVehicleParking = new ArrayList<>();
    private int eachParkingLotCapacity;
    private Map<String, ParkingSpot> parkedVehicles = new HashMap<>();

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    private void initParkingSpots() {
        this.eachParkingLotCapacity = this.parkingLotCapacity / 3;
        initParkingSpots( "S", smallVehicleParking);
        initParkingSpots( "M", mediumVehicleParking);
        initParkingSpots( "L", largeVehicleParking);
    }

    private void initParkingSpots(String name ,List<ParkingSpot> spots) {
        for (int i=1;i<=this.eachParkingLotCapacity;i++) {
            spots.add(new ParkingSpot(name + i));
        }
    }

    public String parkVehicle(Vehicle v) {

        List<ParkingSpot> vehicleParking = Collections.EMPTY_LIST;
        if (v.getSize().equals(VehicleSize.SMALL)) {
            vehicleParking = smallVehicleParking;
        } else if (v.getSize().equals(VehicleSize.MEDIUM)) {
            vehicleParking = mediumVehicleParking;
        } else if (v.getSize().equals(VehicleSize.LARGE)) {
            vehicleParking = largeVehicleParking;
        }

        if (vehicleParking.size() == 0) {
            return "PARKING_FULL";
        }

        ParkingSpot parkingSpot = vehicleParking.get(0);
        parkingSpot.setVehicle(v);
        parkingSpot.setParked(true);
        vehicleParking.remove(parkingSpot);
        parkedVehicles.put(parkingSpot.getParkingSpotNumber(), parkingSpot);
        return parkingSpot.getParkingSpotNumber();
    }

    public boolean unPark(String parkingSlotNumber) {
        ParkingSpot parkingSpot = parkedVehicles.get(parkingSlotNumber);

        if (parkingSpot == null) {
            return false;
        }

        Vehicle v = parkingSpot.getVehicle();

        List<ParkingSpot> vehicleParking = Collections.EMPTY_LIST;
        if (v.getSize().equals(VehicleSize.SMALL)) {
            vehicleParking = smallVehicleParking;
        } else if (v.getSize().equals(VehicleSize.MEDIUM)) {
            vehicleParking = mediumVehicleParking;
        } else if (v.getSize().equals(VehicleSize.LARGE)) {
            vehicleParking = largeVehicleParking;
        }

        parkedVehicles.remove(parkingSlotNumber);
        parkingSpot.setParked(false);
        parkingSpot.setVehicle(null);
        vehicleParking.add(parkingSpot);
        return true;
    }

    public int availableParkingSpots() {
        return smallVehicleParking.size() + mediumVehicleParking.size() + largeVehicleParking.size();
    }
}
