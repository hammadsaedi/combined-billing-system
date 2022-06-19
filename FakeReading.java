import java.security.SecureRandom;

public class FakeReading {
    private static SecureRandom random = new SecureRandom();

    public static double electricity(double previousReading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(4);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previousReading + random.nextDouble(100)); // Less than 100
        } else if (option == 1){
            return (previousReading + (100 + random.nextDouble(100)));  // Between 100-199
        } else if (option == 2){
            return (previousReading + (200 + random.nextDouble(100))); // Between 200-300
        } else {
            return (previousReading + (300 + random.nextDouble(700)));  // Above 300 Flat (But Less than 1000)
        }
    }
    
    public static double gas(double previousReading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(6);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previousReading + random.nextDouble(50)); // Less than 50
        } else if (option == 1){
            return (previousReading + (50 + random.nextDouble(50)));  // From 50 to 99
        } else if (option == 2){
            return (previousReading + (100 + random.nextDouble(100))); // From 100 to 199
        } else if (option == 3){
            return (previousReading + (200 + random.nextDouble(100)));  // From 200 to 299
        } else if (option == 4){
            return (previousReading + (300 + random.nextDouble(100)));  // From 300 to 399
        } else {
            return (previousReading + (400 + random.nextDouble(600)));  // Above 400 Flat (But Less than 1000)
        }

    }

    public static double water(double previousReading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(3);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previousReading + random.nextDouble(1001)); // Up to 1000.xx liters 
        } else if (option == 1){
            return (previousReading + (1001 + random.nextDouble(1001)));  // 1001-2000.xx liters
        } else {
            return (previousReading + (2001 + random.nextDouble(8000)));  // Above 2000 liters (But Less than 10000)
        }
    }
    

    public static class Media {
        public static double localCalls(double previousReading){
            // Returning random readings incremented to previous reading 
            return (previousReading + random.nextDouble((1001))); // Up to 1000 minutes 
        }

        public static double internationalCalls(double previousReading){
            // Returning random readings incremented to previous reading 
            return (previousReading + random.nextDouble((251))); // Up to 250 minutes
        }

        public static double internet(double previousReading){
            // Returning random readings incremented to previous reading 
            return (previousReading + random.nextDouble((101))); // Up to 100 GB
        }
    }
}
