public class BikeService {
    private BikeDatabase bikeDatabase;

    public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }

    public boolean checkLocationValid(String location) {
        return bikeDatabase.isValidLocation(location);
    }

    public Bike findAvailableBike(String location) {
        return bikeDatabase.getAvailableBike(location);
    }

    public void markBikeAsRented(Bike bike) {
        bike.setRented(true);
    }

    public void returnBike(Bike bike) {
        bike.setRented(false);
    }
}
