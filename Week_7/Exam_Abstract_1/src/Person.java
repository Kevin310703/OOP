import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Ham loai bo.
     * @param registrationNumber String
     */
    public void removeVehicle(String registrationNumber) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(vehicle);
            }
        }
    }

    /**
     * In thong tin.
     * @return ketqua
     */
    public String getVehiclesInfo() {
        StringBuilder sbd = new StringBuilder(this.name);
        if (this.vehicleList.isEmpty()) {
            return this.name + " has no vehicle!";
        } else {
            sbd.append(" has:\n\n");
            vehicleList.stream().forEach((vehicle) -> {
                sbd.append(vehicle.getInfo());
            });
        }
        return sbd.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}