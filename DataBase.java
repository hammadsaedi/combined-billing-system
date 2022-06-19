import java.io.*;
import java.util.*;

/**
 * @hammadsaedi
 */
public class DataBase {
    private Society society;
    private Record[][][][][] file;
    private String rootDirectory, namesFileName, recordsFileName; // System File Names
    private String startingMonth, startingYear; 
    private File root, nameFile, recordFiles, yearFile; // File Instances
    private String openedRecordFile = new String();


    DataBase(Society society, Record[][][][][] file, String rootDirectory, String namesFileName, String recordsFileName, String startingYear, String startingMonth){
        this.society = society;
        this.file = file;
        this.rootDirectory = rootDirectory;
        this.namesFileName = namesFileName;
        this.recordsFileName = recordsFileName;
        this.startingYear = startingYear;
        this.startingMonth = startingMonth;
        initialize();
    }

    public void initialize(){
        root = new File(rootDirectory);
        nameFile = new File(root.getName() + "/" + namesFileName);
        recordFiles = new File(root.getName() + "/" + recordsFileName);
        root.mkdir(); // Makes DataBase Folder
        nameFile.mkdirs(); // Make Names File
        recordFiles.mkdirs(); // Make Records Dir
    }

    private String getCurrentMonth(){
        if (getPreviousMonth().isEmpty()){
            return this.startingMonth;
        }
        if (getPreviousMonth().equals("December")){ // Previous Month is Dec
            return indexToMonthName(0); // Current Month is Jan
        }
        return indexToMonthName(monthNameToIndex(getPreviousMonth()) + 1);
    }

    private String getCurrentYear(){
        if (getPreviousYear().isEmpty()){
            mkNewYearDir(this.startingYear);
            return this.startingYear;
        }

        if (getPreviousMonth().equals("December")){ // Previous Month is Dec
            String newYear = Integer.toString(Integer.parseInt(getPreviousYear()) + 1);
            mkNewYearDir(newYear);
            return newYear; 
        }
        
        return getPreviousYear();
    }

    private String getPreviousMonth(){
        if (getYearsList().length == 0){
            return "";
        } 
        return indexToMonthName(getMonthsList(getPreviousYear()).length - 1);
    }

    private String getPreviousYear(){
        if (getYearsList().length == 0){
            return "";
        } 
        return getYearsList()[getYearsList().length - 1]; // Last Year
    }

    public String[] getYearsList(){
        return recordFiles.list();
    }

    public String[] getMonthsList(String year){
        yearFile = new File(recordFiles.getPath() + "/" + year);
        return yearFile.list();
    }

    public String getOpenedRecordFile() {
        return this.openedRecordFile;
    }

    private String indexToMonthName(int index){
        switch(index){
            case 0: return "January";
            case 1: return "February";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
        }
        return "Not Initialized";
    }
    
    private int monthNameToIndex(String monthName){
        switch(monthName){
            case "January": return 0;
            case "February": return 1;
            case "March": return 2;
            case "April": return 3;
            case "May": return 4;
            case "June": return 5;
            case "July": return 6;
            case "August": return 7;
            case "September": return 8;
            case "October": return 9;
            case "November": return 10;
            case "December": return 11;
        }
        return -1;
    }

    /**
     * 
     * @return List of Proceeding Files after opened File (Loaded File)
    */
    public ArrayList<String> proceedingFilesPaths(){
        ArrayList<String> recordPaths = new ArrayList<>();
        String year = openedRecordFile.split("/")[openedRecordFile.split("/").length - 2]; // Year
        String month = openedRecordFile.split("/")[openedRecordFile.split("/").length - 1]; // Month

        String[] totalYears = getYearsList();
        int startingYearIndex = 0;
        // Search for a Starting Year Index
        for (int i = 0; i < totalYears.length; i++){
            if (totalYears[i].equals(year)){
                startingYearIndex = i;
            }
        }

        int startingMonthIndex = monthNameToIndex(month.replace(".txt", "")) + 1; // From very next month


        // Starts from a Particular Year
        for (int i = startingYearIndex; i < totalYears.length; i++){
            String[] months = getMonthsList(totalYears[i]);
            int index;
            if (i == startingYearIndex) {
                index = startingMonthIndex;
            } else {
                index = 0;
            }
            for (int j = index; j < months.length; j++) {
                recordPaths.add(monthFilePath(totalYears[i], indexToMonthName(j)));
            }
        }
        return recordPaths;
    }

    private void mkNewYearDir(String year){
        yearFile = new File(recordFiles.getPath() + "/" + year);
        yearFile.mkdirs();
    }

    public void pushNames() throws IOException{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nameFile.getPath())));

        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            writer.println(file[block][subBlock][street][house][portion].name);
                        }
                    }
                }
            }
        }

        writer.flush();
        writer.close();
    }

    public void pushRecords(String file_name) throws IOException{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file_name)));

        String record = new String();

        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            record = file[block][subBlock][street][house][portion].status + " ";
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    record += file[block][subBlock][street][house][portion].reading[utility][category] + " "; 
                                    record += file[block][subBlock][street][house][portion].bill[utility][category] + " ";            
                                }  
                            }
                            writer.println(record);
                        }
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }
    
    public void pullNames() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(nameFile.getPath()));

        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            file[block][subBlock][street][house][portion].name = reader.readLine();
                        }
                    }
                }
            }
        }
        reader.close();
    }

    public void pullRecords(String recordsAddress) throws IOException{
        System.out.println("DataBase.pullRecords(): Reading File " + recordsAddress);

        BufferedReader reader = new BufferedReader(new FileReader(recordsAddress));
        this.openedRecordFile = recordsAddress;
        String[] record = new String[13];

        for (byte block = 0; block < society.BLOCKS(); block++){
            for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
                for (byte street = 0; street < society.STREETS(); street++){
                    for (byte house = 0; house < society.HOUSES(); house++){
                        for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
                            record = reader.readLine().split(" ");
                            file[block][subBlock][street][house][portion].status = record[0].equals("null")?null:Boolean.parseBoolean(record[0]);
                            int index = 1;
                            for (byte utility = 0; utility < society.UTILITIES(); utility++) {
                                for (byte category = 0; category < file[block][subBlock][street][house][portion].reading[utility].length; category++) {
                                    file[block][subBlock][street][house][portion].reading[utility][category] = Double.parseDouble(record[index]);
                                    file[block][subBlock][street][house][portion].bill[utility][category] = Double.parseDouble(record[index + 1]);
                                    index += 2;                                 
                                }  
                            }
                        }
                    }
                }
            }
        }
        reader.close();
    }

    public void pullPreviousRecord() throws IOException{
        if (getPreviousMonth().isEmpty()){
            return;
        }

        pullRecords(monthFilePath(getPreviousYear(), getPreviousMonth()));
    }

    // For Current Month
    public void pushCurrentRecord() throws IOException{
        pushRecords(monthFilePath(getCurrentYear(), getCurrentMonth()));
    }

    public void pushOpenedRecord() throws IOException{
        pushRecords(getOpenedRecordFile());
        System.out.println("DataBase.pushOpenedRecord() " + getOpenedRecordFile());
    } 

    public String monthFilePath(String year, String month){
        return "db/records" + "/" + year + "/" + month + ".txt";
    }
}