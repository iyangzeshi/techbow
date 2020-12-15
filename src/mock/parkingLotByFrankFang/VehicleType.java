package mock.parkingLotByFrankFang;

public enum VehicleType {
    CAR("CAR", 1),
    SUV("SUV",2),
    TRUCK("TRUCK", 3);
    String name;
    int size;

    VehicleType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
