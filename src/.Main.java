public class Main {
    public static void main(String[] args) {
        ERyder defaultBike = new ERyder();
        System.out.println("--- Default Constructor Bike ---");
        defaultBike.printBikeDetails();

        ERyder parameterBike = new ERyder("EB001", 75, true, 12.5);
        System.out.println("--- Parameter Constructor Bike ---");
        parameterBike.ride();
        parameterBike.printBikeDetails();
    }
}
