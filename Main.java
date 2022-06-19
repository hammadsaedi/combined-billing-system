import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * - Modification Logic (Threading)                    (Working) Without Threading              
 * - Deletion Logic (NullRecordException)              // Throws exception to main thread
 * - Cookies (Enums)                                   (Test Pending) -- > Done within DataBase Class
 * - Menu (UserInterface Class)                         
 * - Hash Map for IDs
 * - Reports
 * - Git Log
 */

/**
 * Switch Case Statements With No breaks
 * Can Stack overflow?
 * Kind of recursion
*/

/**
 * 0 Press any time Cause System Exit ? 
*/



/**
 * @author @hammadsaedi - everywhere
 * @category Algorithm
 * @
 * Methods 
 * - Read Names -->
 *          - Loads in 7D Array
 * - Read Record --> (From Previous File) ? which one is previous file? (Store in separate file about previous file detail)
 *          Record == meter reading, bill 
 *          - Loads in 7D Array
 * - Write Record -->
 *          Works in 7D array:
 *              for each record in file:
 *                  - Store previous reading in separate var
 *                  - Take new meter reading
 *                          -> By Random method, Fake_reading class
 *                                  - pass previous reading as argument to increment meter
 *                          -> By Keyboard Input
 *                                  - if new reading is greater than or equal to previous one
 *                                               - Subtract from previous reading, to have consumed unit in this month (If consumed unit is in negative, assume meter has been changed. So, take new input reading as current consumed units)
 *                                  - if new reading is less than previous one
 *                                               - assume meter is changed; So, new entry will be consumed unit
 *                  - Calculate Bill for consumed units
 *                  - replace old readings (Total - Actual Meter Reading) and bill amount (This month) with new ones
 *           Write 7D Array on file (Specified month) e.g. Jan2022, Feb2020 {OR Make Dir for Years; And Files for months}
 * - Prints Bills
 *         // continue(); 
 */ 
public class Main {
    private static Society society = new Society(10, 4, 10, 20, 3, 4);
    private static Record[][][][][] file = new Record[society.BLOCKS()][society.SUB_BLOCKS()][society.STREETS()][society.HOUSES()][society.PORTIONS()];
    private static Scanner input = new Scanner(System.in);
    private static Operation operations;
    private static DataBase db = new DataBase(society, file, "db", "names.txt", "records", "2010" , "January");


    public static void main(String[] args) throws IOException, NullRecordException {
        operations = new Operation(society, file, db);
        // for (int i = 0; i < 15; i++){
        //     operations.meterReading.configureNewFile();
        //     if(i > 3){
        //         operations.meterReading.takeReading(1);
        //     } else {
        //         operations.meterReading.takeReading();
        //     }
        //     operations.db.pushCurrentRecord();  
        // }
        // operations.db.pullRecords("db/records/2011/March.txt");
        // operations.status.setStatus(null, 1);
        
        // operations.db.pullRecords("db/records/2011/March.txt");
        System.out.println(operations.file[0][0][0][0][0].bill[0][0]);

        try{
            operations.db.pullRecords("db/records/2010/January.txt");            
            // operations.status.setStatus(null);
            // operations.db.pushOpenedRecord();

            // System.out.println(operations.file[0][0][0][0][0].status);
            
            System.out.println(operations.address(operations.maxCombinedBill()));

            operations.updateRecord.modify(1);

            // operations.updateRecord.modify(1, 1, 1 , 1, 1);
        } catch(NullRecordException nre){
            System.out.println(nre);
        }
        

        // System.out.println(operations.db.getOpenedRecordFile());
        // System.out.println(operations.db.proceedingFilesPaths().toString());
        // menu();

        // // read names from file (Secondary Storage) and load it into Array (Main Memory)
        // load_names("names.txt");
         
        // load_record(previous_month());

        // System.out.println(Society.address(100));

        // file[sector][sub_sector][street][house][portion]

        // System.out.println();

        // System.out.println(file[0][0][0][0][0].reading[0][0]);

        // take_reading();

        // push_data("Jan.txt");

        // input();

        // output();

    }

    // static void header() {
    //     System.out.println("-----Combined Billing System-----");

    //     // Show Previous Month
    //     // Show Next Month
    //     // Show Loaded (Opened) Month
    // }

    // static void menu() throws IOException{    
    //     header();

    //     int choice = 0;
        
    //     do {
    //         System.out.println("Choose any Option:\n1. Upload New Readings\n2. Print Bill\n3. Open File\n4. Reports\n0. Exit Program");
    //         try {
    //             choice = input.nextInt();
    //         } catch (NumberFormatException e) {
    //             System.out.println("Choice must be Integer.");
    //         }
    //     } while(choice < 0 && choice > 4);

    //     switch(choice){
    //         case 0:
    //             System.exit(0);
    //         case 1: // Take Reading and Calculate Bills; At the end its automatically saves to new file ?
    //             input_menu();
    //             break;
    //         case 2: // // Current Opened File
    //             print_bills_menu();
    //             break;
    //         case 3:
    //             file_opening_menu();
    //             break;
    //         case 4:
    //             reports_menu();
    //             break;
    //     }
    // }

    // Taking input 
    // Take Reading and Calculate Bills; At the end its automatically saves to new file ?
    // Shows up % of how much reading has been uploaded.
    // Which file has to be interacted ? In case of opening other file?
    // On Menu Every time, next month file should be opened
    // Shows up Un Uploaded Data in Menu
    // static void input_menu() throws IOException{ 
    //     int choice = 0;
    //     do {
    //         System.out.println("Choose any Option to upload Meter Readings:\n1. By Customer ID.\n2. For the whole society.\n3. For a Block.\n4. For a Sub Block.\n5. For a Street.\n6. For a House.\n7. For a House's Portion\n8. Back\n0. Exit Program");
    //         try {
    //             choice = input.nextInt();
    //         } catch (NumberFormatException e) {
    //             System.out.println("Choice must be Integer.");
    //         }
    //     } while(choice < 0 || choice > 8);


    //     switch(choice){
    //         case 0: // Exit System
    //             System.exit(0);
    //         case 1: // By Customer ID.
    //             System.out.println(Operation.ChoiceManager.customer_ID_input() + "ID Input.");
    //             break;        
    //         case 2: // For whole society.
    //             System.out.println("Whole Society");
    //             break;
    //         case 3: // For a block of society
    //             System.out.println(Operation.ChoiceManager.block_choice() + "Block Input.");
    //             break;
    //         case 4: // For a Sub Block 
    //             System.out.println(Operation.ChoiceManager.sub_block_choice().toString() + "Sub Block Input.");
    //             break;
    //         case 5: // For Street
    //             System.out.println(Operation.ChoiceManager.street_choice().toString() + "Street Input.");
    //             break;
    //         case 6: // For a House
    //             System.out.println(Operation.ChoiceManager.house_choice().toString() + "House Input.");
    //             break;
    //         case 7: // For a Portion 
    //             System.out.println(Operation.ChoiceManager.portion_choice().toString() + "Portion Input.");
    //             break;
    //         case 8:
    //             // Back to Main Menu
    //             menu();
    //     }
    // }

    // static void print_bills_menu() throws IOException {
    //     int choice = 0;

    //     do {
    //         System.out.println("Choose any Option:\n1. Customer's Bill.\n2. Society Combined Bill.\n3. Block Combined Bill.\n4. Sub Block Combined Bill.\n5. Street Combined Bill.\n6. House Combined Bill.\n7. Portion Combined Bill.\n8. Back\n0. Exit Program");
    //         try {
    //             choice = input.nextInt();
    //         } catch (NumberFormatException e) {
    //             System.out.println("Choice must be Integer.");
    //         }
    //     } while(choice < 0 || choice > 8);


    //     switch(choice){
    //         case 0: // Exit System
    //             System.exit(0);
    //         case 1: // Print Bills by ID
    //             // get bill by ID (customer_ID_input());
    //             // Print
    //             System.out.println(Operation.ChoiceManager.customer_ID_input());
    //             break;        
    //         case 2: // Print Combined Bill for whole society.
    //             // get society's combined bill
    //             // Print
    //             System.out.println("Whole Society Bill");
    //             break;
    //         case 3: // choose particular block of society
    //             // get block's bill
    //             // print
    //             System.out.println(Operation.ChoiceManager.block_choice());
    //             break;
    //         case 4: // Sub Block Combined Bill.
    //             // get Sub Block Combined Bill.
    //             // print
    //             System.out.println(Operation.ChoiceManager.sub_block_choice().toString());
    //             break;
    //         case 5: // Street Combined Bill.
    //             // get Street Combined Bill.
    //             // print
    //             System.out.println(Operation.ChoiceManager.street_choice().toString());
    //             break;
    //         case 6: // House Combined Bill.
    //             // get House Combined Bill.
    //             // print
    //             System.out.println(Operation.ChoiceManager.house_choice().toString());
    //             break;
    //         case 7:
    //             // get Portion Combined Bill.
    //             // print
    //             System.out.println(Operation.ChoiceManager.portion_choice().toString());
    //             break;
    //         case 8:
    //             // Back to Main Menu
    //             menu();
    //     }

    //     // Again show menu
    //     // menu();  Menu should be do while based
    // }

    static void file_opening_menu() throws IOException {
        int choice = 0;

        // Fetched from cookies
        String[] years = {"2017", "2018", "2019", "2020", "2021", "2022"};

        while(choice < 0 || choice > 5) {
            for(int i = 1; i < years.length; i++){
                System.out.println("c");
            }

            try {
                choice = input.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Choice must be Integer.");
            }
        }

    }

    static void reports_menu(){
        System.out.println("Module Under Maintenance.");
    }
}