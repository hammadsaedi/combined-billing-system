import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    UserInterface(){

    }


    // Can we implement back functionality ?
    // By Call the invoker method?
    class ChoiceManager {
        static Scanner input = new Scanner(System.in);
        static int customer_ID_input(){
            
            int ID = 0;
            do {
                System.out.println("Enter Customer ID: ");
                try {
                    ID = input.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Customer ID must be Integer.");
                }
            } while(ID < 0 || ID > 24000);
    
            if (ID == 0){
                System.exit(0);
            }
    
            return ID;
        }
    
        static char block_choice(){
            char block = 'A';
    
            do {
                System.out.println("Enter Block Name: ");
                try {
                    block = input.next().toUpperCase().charAt(0);
                    if (block == 0){
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Block Must be character.");
                }
            } while(block < 'A' || block > 'J');
            
            return block;
        }

        static ArrayList<Integer> sub_block_choice() {
            int sub_block = 0;
            ArrayList<Integer> choice = new ArrayList<Integer>();
            
            choice.add((int) block_choice()); // Block
            
            do {
                System.out.println("Enter Sub Block Number: ");
                try {
                    sub_block = input.next().toUpperCase().charAt(0);
                    if (sub_block == 0){
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Sub Block Must be integer.");
                }
            } while(sub_block < 1 || sub_block > 4);

            choice.add(sub_block);
            
            return choice;
        }

        static ArrayList<Integer> street_choice() {
            int street = 0;
            ArrayList<Integer> choice = new ArrayList<Integer>();
            choice = sub_block_choice(); // Sub Block
            
            do {
                System.out.println("Enter Street Number: ");
                try {
                    street = input.next().toUpperCase().charAt(0);
                    if (street == 0){
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Street Must be integer.");
                }
            } while(street < 1 || street > 4);

            choice.add(street);
            
            return choice;
        }

        static ArrayList<Integer> house_choice() {
            int house = 0;
            ArrayList<Integer> choice = new ArrayList<Integer>();
            choice = street_choice(); // Street
            
            do {
                System.out.println("Enter House Number: ");
                try {
                    house = input.next().toUpperCase().charAt(0);
                    if (house == 0){
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("House Must be integer.");
                }
            } while(house < 1 || house > 20);

            choice.add(house);
            
            return choice;
        }

        static ArrayList<Integer> portion_choice() {
            int house = 0;
            ArrayList<Integer> choice = new ArrayList<Integer>();
            choice = street_choice(); // Street
            
            do {
                System.out.println("Choose Portion:\n1. Ground\2. First\3. Third");
                try {
                    house = input.next().toUpperCase().charAt(0);
                    if (house == 0){
                        System.exit(0);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Choice must be integer.");
                }
            } while(house < 1 || house > 3);

            choice.add(house);
            
            return choice;
        }

    }
}
