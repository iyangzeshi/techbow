package bq_resume.parking_lot_design.vehicle;

public enum VehicleType {
    MOTO(1),
    COMPACT(2),
    BUS(3);

    private final int size;

    VehicleType(final int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
