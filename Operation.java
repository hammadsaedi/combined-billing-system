import java.io.*;
import java.util.*;

public class Operation {
    private Society society;
    Record[][][][][] file;
    DataBase db;
    
    Status status = new Status();
    UpdateRecord updateRecord = new UpdateRecord();
    MeterReading meterReading = new MeterReading();
    CombinedBill bill = new CombinedBill();
    
    private double[][] combinedBill; 
    private static Scanner input = new Scanner(System.in);
    

    
    Operation(Society society, Record[][][][][] file, DataBase db) throws IOException{
        this.society = society;
        this.file = file;
        this.db = db;
        initialize();
    }

    private void initialize() throws IOException{
        // creating class instance (objects) of individual record of file
        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            file[block][subBlock][street][house][portion] = new Record();
                        }
                    }
                }
            }
        }

        db.pullPreviousRecord();

        // db.pullNames();
        // System.out.println(db.getPreviousMonth());
        // System.out.println(db.getCurrentMonth());
        // System.out.println((db.getPreviousYear()));
        // System.out.println(db.getCurrentYear());
        // System.out.println(Arrays.toString(db.getYearsList()));
        // System.out.println(Arrays.toString(db.getMonthsList(db.getPreviousYear())));
        // // System.out.println(db.getYearsList()[1]);
        // // System.out.println(db.getMonthsList(db.getPreviousMonth()).toString());
        // db.pullPreviousRecord();
    }

    private void newBill(){
        this.combinedBill = new double[2][6]; // 1- Reading      2- Charges
    }


    // ------------------------------------------------------------- Bills -------------------------------------
    /**
     * Combined Bills
     * By: 
     *      - ID
     *      - Whole Society
     *      - Block
     *      - Sub Block
     *      - Street
     *      - House
     *      - Portion
     * Loads Combined Bill in combinedBill array
     * toString methods Beautify's bill
    */
    public class CombinedBill {
        public double[][] bill(int ID){ // by ID
            newBill();
            int[] indices = addressIndices(ID);
            int index = 0;
    
            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                for (byte category = 0; category < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading[utility].length; category++) {
                    combinedBill[0][index] = file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading[utility][category];
                    combinedBill[1][index] = file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].bill[utility][category];
                    index++;
                }
            }
    
            return combinedBill;
        }
    
        public double[][] bill(){ // Whole Society
            newBill();
            int index;
            for (byte block = 0; block < society.BLOCKS(); block++){
                for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                    for (byte street = 0; street < society.STREETS(); street++){
                        for (byte house = 0; house < society.HOUSES(); house++){
                            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                                index = 0;
                                for (byte utility = 0; utility < society.UTILITIES(); utility++) {                            
                                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                        combinedBill[0][index] += file[block][subBlock][street][house][portion].reading[utility][category];
                                        combinedBill[0][index] += file[block][subBlock][street][house][portion].bill[utility][category];
                                        index++;
                                    }  
                                }
                            }
                        }
                    }
                }
            }
            return combinedBill;
        }
    
        public double[][] bill(byte block){ // Whole Block
            newBill();
            int index;
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            index = 0;
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    combinedBill[0][index] += file[block][subBlock][street][house][portion].reading[utility][category];
                                    combinedBill[1][index] += file[block][subBlock][street][house][portion].bill[utility][category];
                                    index++;
                                }  
                            }
                        }
                    }
                }
            }
            return combinedBill;
        }
    
        public double[][] bill(int block, int subBlock){ // A Particular Sub Block
            newBill();
            int index;
            for (byte street = 0; street < society.STREETS(); street++){
                for (byte house = 0; house < society.HOUSES(); house++){
                    for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                        index = 0;
                        for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                            for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                combinedBill[0][index] += file[block][subBlock][street][house][portion].reading[utility][category];
                                combinedBill[1][index] += file[block][subBlock][street][house][portion].bill[utility][category];
                                index++;
                            } 
                        }
                    }
                }
            }
    
            return combinedBill;
        }
        
        public double[][] bill(int block, int subBlock, int street){ // A Particular Street
            newBill();
            int index;
            
            for (byte house = 0; house < society.HOUSES(); house++){
                for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                    index = 0;
                    for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                        for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                            combinedBill[0][index] += file[block][subBlock][street][house][portion].reading[utility][category];
                            combinedBill[1][index] += file[block][subBlock][street][house][portion].bill[utility][category];
                            index++;
                        }  
                    }
                }
            }
    
            return combinedBill;
        }
    
        public double[][] bill(int block, int subBlock, int street, int house){ // A Particular House
            newBill();
            int index;
            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                index = 0;
                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                        combinedBill[0][index] += file[block][subBlock][street][house][portion].reading[utility][category];
                        combinedBill[1][index] += file[block][subBlock][street][house][portion].bill[utility][category];
                        index++;
                    }  
                }
            }
    
            return combinedBill;
        }
    
        public double[][] bill(int block, int subBlock, int streetNumber, int houseNumber, int portion){ // A Particular Portion
            newBill();
            
            int index = 0;
            for (byte service = 0; service < file[block][subBlock][streetNumber][houseNumber][portion].reading.length; service++) {
                for (byte category = 0; category < file[block][subBlock][streetNumber][houseNumber][portion].reading[service].length; category++) {
                    combinedBill[0][index] += file[block][subBlock][streetNumber][houseNumber][portion].reading[service][category];
                    combinedBill[1][index] += file[block][subBlock][streetNumber][houseNumber][portion].bill[service][category];
                    index++;
                }  
            }
    
            return combinedBill;
        }

        public double totalBill(){
            double totalBill = 0;
            for(int i = 0; i < combinedBill[1].length; i++){
                totalBill += combinedBill[1][i];
            }
            return totalBill;
        }
    
        public String formattedBill(){
            String bill = "Utility\tReading\tCharges"; 
            // double totalBill = 0;
            // for(int i = 0; i < combinedBill[0].length; i++ ){
            //     if(i == 3){
            //         bill.concat("\n" + "\t\tPhone");
            //     }
            //     bill += ("\n" + utilities[i] + "\t"+ combinedBill[0][i] + "\t "+ combinedBill[1][i]);
            //     totalBill += combinedBill[1][i];
    
            // }  
            // bill += ("\n" + "Total Bill\t\t" + totalBill);
    
            return bill;
        }    
    }

    





    // ------------------------------------------------------------- Readings -------------------------------------
    // Over Loaded Methods    
    // Take Readings of All Utilities
    // Connect to Cookies

    /**
     * MeterReading
     * Takes Reading By: 
     *      - ID
     *      - Whole Society
     *      - Block
     *      - Sub Block
     *      - Street
     *      - House
     *      - Portion
     * Take Reading from FakeReading Class
     * Calculates Bills by CalculateBill Class
     * Load in 7D Array
    */
    public class MeterReading {
        public void takeReading(int ID) throws NullRecordException{ // by ID
            int[] indices = addressIndices(ID);
    
            for (byte service = 0; service < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading.length; service++) {
                for (byte category = 0; category < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading[service].length; category++) {
                    takeReading(indices[0], indices[1], indices[2], indices[3], indices[4]);
                }
            }
    
        }
    
        public void takeReading() throws NullRecordException{ // Whole Society
            for (byte block = 0; block < society.BLOCKS(); block++){
                for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                    for (byte street = 0; street < society.STREETS(); street++){
                        for (byte house = 0; house < society.HOUSES(); house++){
                            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                        takeReading(block, subBlock, street, house, portion);
                                    }  
                                }
                            }
                        }
                    }
                }
            }
        }
    
        public void takeReading(byte block) throws NullRecordException{ // Whole Block
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    takeReading(block, subBlock, street, house, portion);
                                }    
                            }
                        }
                    }
                }
            }
        }
    
        public void takeReading(int block, int subBlock) throws NullRecordException{ // A Particular Sub Block
            for (byte street = 0; street < society.STREETS(); street++){
                for (byte house = 0; house < society.HOUSES(); house++){
                    for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                        for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                            for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                takeReading(block, subBlock, street, house, portion);
                            }  
                        }
                    }
                }
            }
        }
        
        public void takeReading(int block, int subBlock, int street) throws NullRecordException{ // A Particular Street       
            for (byte house = 0; house < society.HOUSES(); house++){
                for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                    for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                        for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                            takeReading(block, subBlock, street, house, portion);
                        }  
                    }
                }
            }
        }
    
        public void takeReading(int block, int subBlock, int street, int house) throws NullRecordException{ // A Particular House
            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                        takeReading(block, subBlock, street, house, portion);
                    }  
                }
            }
        }
    
        public void takeReading(int block, int subBlock, int street, int house, int portion) throws NullRecordException{ // A Particular Portion
            if(Objects.isNull(file[block][subBlock][street][house][portion].status)){
                throw new NullRecordException(block, subBlock, street, house, portion);
            }

            double previousReading = 0, newReading = 0, monthlyBill = 0;
    
            for (byte utility = 0; utility < society.UTILITIES();utility++) {
                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                    // Previous Readings
                    previousReading = file[block][subBlock][street][house][portion].reading[utility][category];                                
                    // New Readings and Bill Calculations
                    switch(utility){
                        case 0:
                            newReading = Math.round(FakeReading.electricity(previousReading)*100)/100d; 
                            monthlyBill = Math.round(CalculateBill.electricity(newReading - previousReading)*100)/100d;
                            break;
                        case 1:
                            newReading = Math.round(FakeReading.gas(previousReading)*100)/100d; 
                            monthlyBill = Math.round(CalculateBill.gas(newReading - previousReading)*100)/100d;
                            break;
                        case 2:
                            newReading = Math.round(FakeReading.water(previousReading)*100)/100; 
                            monthlyBill = Math.round(CalculateBill.water(newReading - previousReading)*100)/100d;
                            break;
                        case 4:
                            switch(category){
                                case 0:
                                    newReading = Math.round(FakeReading.Media.localCalls(previousReading)*100)/100d; 
                                    monthlyBill = Math.round(CalculateBill.Media.localCalls(newReading - previousReading)*100)/100d;
                                    break;
                                case 1:
                                    newReading = Math.round(FakeReading.Media.internationalCalls(previousReading)*100)/100d; 
                                    monthlyBill = Math.round(CalculateBill.Media.internationalCalls(newReading - previousReading)*100)/100d;
                                    break;
                                case 2:
                                    newReading = Math.round(FakeReading.Media.internet(previousReading)*100)/100d; 
                                    monthlyBill = Math.round(CalculateBill.Media.internet(newReading - previousReading)*100)/100d;
                                    break;
                            }
                            break;
                    }
                    // Saving in Record File (Array)
                    file[block][subBlock][street][house][portion].reading[utility][category] = newReading;
                    file[block][subBlock][street][house][portion].bill[utility][category] = monthlyBill;
                }  
            }

            file[block][subBlock][street][house][portion].status = true; // Portion is Updated
        }

        public void configureNewFile(){
            status.setStatus(false);
        }
    }


    /**
     * // -- Set Status
     * Set Status of Portion null, true, false
    */
    public class Status {
        public void setStatus(Boolean status, int ID){ // by ID
            int[] indices = addressIndices(ID);
    
            for (byte service = 0; service < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading.length; service++) {
                for (byte category = 0; category < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading[service].length; category++) {
                    setStatus(status, indices[0], indices[1], indices[2], indices[3], indices[4]);
                }
            }
    
        }
    
        public void setStatus(Boolean status){ // Whole Society
            for (byte block = 0; block < society.BLOCKS(); block++){
                for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                    for (byte street = 0; street < society.STREETS(); street++){
                        for (byte house = 0; house < society.HOUSES(); house++){
                            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                        setStatus(status, block, subBlock, street, house, portion);
                                    }  
                                }
                            }
                        }
                    }
                }
            }
        }
    
        public void setStatus(Boolean status, byte block){ // Whole Block
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    setStatus(status, block, subBlock, street, house, portion);
                                }    
                            }
                        }
                    }
                }
            }
        }
    
        public void setStatus(Boolean status, int block, int subBlock){ // A Particular Sub Block
            for (byte street = 0; street < society.STREETS(); street++){
                for (byte house = 0; house < society.HOUSES(); house++){
                    for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                        for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                            for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                setStatus(status, block, subBlock, street, house, portion);
                            }  
                        }
                    }
                }
            }
        }
        
        public void setStatus(Boolean status, int block, int subBlock, int street){ // A Particular Street       
            for (byte house = 0; house < society.HOUSES(); house++){
                for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                    for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                        for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                            setStatus(status, block, subBlock, street, house, portion);
                        }  
                    }
                }
            }
        }
    
        public void setStatus(Boolean status, int block, int subBlock, int street, int house){ // A Particular House
            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                        setStatus(status, block, subBlock, street, house, portion);
                    }  
                }
            }
        }
    
        public void setStatus(Boolean status, int block, int subBlock, int street, int house, int portion){ // A Particular Portion
            file[block][subBlock][street][house][portion].status = status;    
        }
    }
    
    /**
     * Modification of Record
     * Set Status of Portion null 
    */
    public class UpdateRecord {
        public void modify(int ID) throws NullRecordException, IOException{ // by ID
            int[] indices = addressIndices(ID);
    
            for (byte service = 0; service < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading.length; service++) {
                for (byte category = 0; category < file[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]].reading[service].length; category++) {
                    modify(indices[0], indices[1], indices[2], indices[3], indices[4]);
                }
            }
    
        }
    
        public void modify() throws NullRecordException, IOException{ // Whole Society
            for (byte block = 0; block < society.BLOCKS(); block++){
                for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                    for (byte street = 0; street < society.STREETS(); street++){
                        for (byte house = 0; house < society.HOUSES(); house++){
                            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                        modify(block, subBlock, street, house, portion);
                                    }  
                                }
                            }
                        }
                    }
                }
            }
        }
    
        public void modify(byte block) throws NullRecordException, IOException{ // Whole Block
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    modify(block, subBlock, street, house, portion);
                                }    
                            }
                        }
                    }
                }
            }
        }
    
        public void modify(int block, int subBlock) throws NullRecordException, IOException{ // A Particular Sub Block
            for (byte street = 0; street < society.STREETS(); street++){
                for (byte house = 0; house < society.HOUSES(); house++){
                    for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                        for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                            for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                modify(block, subBlock, street, house, portion);
                            }  
                        }
                    }
                }
            }
        }
        
        public void modify(int block, int subBlock, int street) throws NullRecordException, IOException{ // A Particular Street       
            for (byte house = 0; house < society.HOUSES(); house++){
                for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                    for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                        for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                            modify(block, subBlock, street, house, portion);
                        }  
                    }
                }
            }
        }
    
        public void modify(int block, int subBlock, int street, int house) throws NullRecordException, IOException{ // A Particular House
            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                    for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                        modify(block, subBlock, street, house, portion);
                    }  
                }
            }
        }
    
        public void modify(int block, int subBlock, int street, int house, int portion) throws NullRecordException, IOException{ // A Particular Portion
            if(Objects.isNull(file[block][subBlock][street][house][portion].status)){
                throw new NullRecordException(block, subBlock, street, house, portion);
            }

            String currentFile = db.getOpenedRecordFile();

            double previousReading = 0, modifiedReading = 0, billingDifference = 0;
            double[][] difference = {{0}, {0}, {0}, {0, 0, 0}};
    
            for (byte utility = 0; utility < society.UTILITIES();utility++) {
                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                    // Previous Readings
                    previousReading = file[block][subBlock][street][house][portion].reading[utility][category];                                
                    // New Readings and Bill Calculations
                    switch(utility){
                        case 0:
                            modifiedReading = Math.round(FakeReading.electricity(previousReading)*100)/100d; 
                            billingDifference = Math.round(CalculateBill.electricity(modifiedReading - previousReading)*100)/100d;
                            break;
                        case 1:
                            modifiedReading = Math.round(FakeReading.gas(previousReading)*100)/100d; 
                            billingDifference = Math.round(CalculateBill.gas(modifiedReading - previousReading)*100)/100d;
                            break;
                        case 2:
                            modifiedReading = Math.round(FakeReading.water(previousReading)*100)/100d; 
                            billingDifference = Math.round(CalculateBill.water(modifiedReading - previousReading)*100)/100d;
                            break;
                        case 4:
                            switch(category){
                                case 0:
                                    modifiedReading = Math.round(FakeReading.Media.localCalls(previousReading)*100)/100d; 
                                    billingDifference = Math.round(CalculateBill.Media.localCalls(modifiedReading - previousReading)*100)/100d;
                                    break;
                                case 1:
                                    modifiedReading = Math.round(FakeReading.Media.internationalCalls(previousReading)*100)/100d; 
                                    billingDifference = Math.round(CalculateBill.Media.internationalCalls(modifiedReading - previousReading)*100)/100d;
                                    break;
                                case 2:
                                    modifiedReading = Math.round(FakeReading.Media.internet(previousReading)*100)/100d; 
                                    billingDifference = Math.round(CalculateBill.Media.internet(modifiedReading - previousReading)*100)/100d;
                                    break;
                            }
                            break;
                    }
                    // Saving in Record File (Array)
                    file[block][subBlock][street][house][portion].reading[utility][category] += modifiedReading;
                    file[block][subBlock][street][house][portion].bill[utility][category] += billingDifference; // Applying difference 
                    difference[utility][category] =  Math.round((modifiedReading - previousReading)*100)/100d;
                }
            }


            file[block][subBlock][street][house][portion].status = true;
            db.pushOpenedRecord(); // pushing opened file

            ArrayList<String> proceedingFileList = db.proceedingFilesPaths();
            System.out.println(proceedingFileList.toString());
            
            // Iterating through all procedding files
            for(int i = 0; i < proceedingFileList.size() - 1; i++){
                db.pullRecords(proceedingFileList.get(i)); // opening ith file
                    for (int utility = 0; utility < difference.length; utility++){
                        for(int category = 0; category < difference[utility].length; category++){
                            file[block][subBlock][street][house][portion].reading[utility][category] += difference[utility][category];
                        }
                    }
                db.pushOpenedRecord(); // pushing opened file
            }


            db.pullRecords(currentFile); // Reopening Current File (pulling)
        }    
    }


    /**
     * DataBase
     * Push and Pull Names File
     * Pull Previous File and Push Current File
     * Push and Pull any Record File
     * Gives Years list and Months List
     * 
    */


    // --------------------------------- Reports ----------------------------------------
    // For a Particular Month -- combined bill of a customer
    // Return Indices ?

    // .... Maximum Combined Bills ... //

    // Return ID of MaxBilled Customer ===> Fetch Bill from ID Later On
    public int maxCombinedBill(){ // Whole Society
        double maximumBill = 0;
        int id = 0, maxBilledID = 0;
         
        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            id++;
                            bill.bill(block, subBlock, street, house, portion);
                            if(bill.totalBill() > maximumBill){
                                maximumBill = bill.totalBill();
                                maximumBill = id;
                            }
                        }
                    }
                }
            }
        }
        return maxBilledID;
    }
    
    public int maxCombinedBill(char block){ // In a block
        double maximumBill = 0;
        int id = 0, maxBilledID = 0;
         
        for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
            for (byte street = 0; street < society.STREETS(); street++){
                for (byte house = 0; house < society.HOUSES(); house++){
                    for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                        id++;
                        bill.bill(block, subBlock, street, house, portion);
                        if(bill.totalBill() > maximumBill){
                            maximumBill = bill.totalBill();
                            maximumBill = id;
                        }
                    }
                }
            }
        }

        return maxBilledID;
    }

    public int maxCombinedBill(int block, int subBlock){ // In a sub block
        double maximumBill = 0;
        int id = 0, maxBilledID = 0;
         
        for (byte street = 0; street < society.STREETS(); street++){
            for (byte house = 0; house < society.HOUSES(); house++){
                for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                    id++;
                    bill.bill(block, subBlock, street, house, portion);
                    if(bill.totalBill() > maximumBill){
                        maximumBill = bill.totalBill();
                        maximumBill = id;
                    }
                }
            }
        }

        return maxBilledID;
    }

    public int maxCombinedBill(int block, int subBlock, int street){ // In a Street
        double maximumBill = 0;
        int id = 0, maxBilledID = 0;
         
        for (byte house = 0; house < society.HOUSES(); house++){
            for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                id++;
                bill.bill(block, subBlock, street, house, portion);
                if(bill.totalBill() > maximumBill){
                    maximumBill = bill.totalBill();
                    maximumBill = id;
                }
            }
        }

        return maxBilledID;
    }

    public void maxCombinedBill(int block, int subBlock, int street, int houseNumber ){ // In a house

    }
    
    // ... MAximum Bill of a Utility ....
    public void maxBill(){

    }
    public void maxBill(char block){ 

    }
    public void maxBill(char block, int subBlock){

    }
    public void maxBill(char block, int subBlock, int street){ 

    }
    public void maxBill(char block, int subBlock, int street, int houseNumber, int portion){ 

    }

    //
    
// -------------------------------------------- Ends --- Cookies Manager -----------------------
    // Society society = new Society(10, 4, 10, 20, 3, 4);
    // Cookies cookies = new Cookies(society,"db", "names.txt");
    public static void main(String[] args) {
        // Operation op = new Operation(new Record[1][1][1][1][1]);
        // op.cookies.setCurrentMonth(10);
        // op.cookies.setCurrentYear(2019);
        // op.updateCookies();
        // System.out.println(op.getCurrentMonth() + " " + op.getCurrentYear());      
    }






    //--------------------------------------- Society MAPs  Setting -----------------------
    String address(int ID){ 
        // Portions
        String[] portions = {"Ground", "First", "Second"};
        // Indices
        int[] indices = addressIndices(ID);
        // Generating Address
        return portions[indices[4]] + " Floor, House # " + (indices[3] + 1) + " Street # " + (indices[2] + 1) + " " + (char)(indices[0] + 65) + "-" + (indices[1] + 1);
    }
    
   /**
    * Fetch Indices by Customer ID
    * @param particular_id
    * @return Address Indices of Consumer
    * @author @hammadsaedi
    */
    int[] addressIndices(int particular_id){  // In case of negative ID? 
        // starting ID
        int id = 1;

        // Iterating through-out society file
        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte sub_block = 0; sub_block < society.SUB_BLOCKS(); sub_block++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            // in case, desired ID's address reached
                            if (id == particular_id){ 
                                // Generating Indices
                                int[] addressIndices = {block, sub_block, street, house, portion};
                                return addressIndices;
                            } else {
                                id++;
                            }                     
                        }
                    }
                }
            }
        }

        int[] lastIndices = {society.BLOCKS() - 1, society.SUB_BLOCKS() - 1, society.STREETS() - 1, society.HOUSES() - 1, society.PORTIONS() - 1}; // Last Indices
        return lastIndices;
    }
}
