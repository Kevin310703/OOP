public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructor.
     * @param brand String
     * @param model String
     * @param registrationNumber String
     * @param owner Person
     * @param numberOfDoors int
     */
    public Car(String brand, String model,
               String registrationNumber, Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors  = numberOfDoors;
    }

    @Override
    public String getInfo() {
        return "Car:\n\t"
                + "Brand: " + brand + "\n\t"
                + "Model: " + model + "\n\t"
                + "Registration Number: " + registrationNumber + "\n\t"
                + "Number of Doors: " + numberOfDoors  + "\n\t"
                + "Belongs to " + this.getOwner().getName()
                + " - " + this.getOwner().getAddress() + "\n";
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}