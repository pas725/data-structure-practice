package misc.ood.parkingLot;

/**
 * Created by psagar on 1/28/2018.
 */
public class Vehicle {
    private String numberPlate;
    private String name;
    private VehicleSize size;

    public Vehicle(String numberPlate, String name, VehicleSize size) {
        this.numberPlate = numberPlate;
        this.name = name;
        this.size = size;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }
}
