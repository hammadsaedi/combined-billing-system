import java.io.*;
import java.util.ArrayList;

public class test {
    private static String[] years;
    static int startingYear = 2010;
    static FileReplace fr = new FileReplace();

    public static void main(String[] args) throws IOException {
        fr.replace("mango.txt", "Java", " ");

        // File db = new File("db");
        // db.mkdir();
        // File nameFile = new File(db.getName() + "/names.txt");
        // nameFile.mkdirs();
        // File yearsFile = new File(db.getName() + "/years");
        // yearsFile.mkdirs();
        // years = yearsFile.list();
        
        // mkNewYearDir();

        // // File startingYeaFile = new File(yearsFile.getPath() + "/" + startingYear);
        // // startingYeaFile.mkdirs();

        // // System.out.println(years[0]);
        // System.out.println(db.list()[0]);

        // // for(int i = 0; i < 24; i++){
        // //     setNewMonth();
        // //     System.out.println(getCurrentYear() + "/" +indexToMonthName(getLastMonth()));
        // // }
    }

    // static void mkNewYearDir(){
    //     // String year;

    //     // if(years.length != 0){
    //     //     year = Integer.toString(Integer.parseInt(years[years.length - 1]) + 1);
    //     // } else {
    //     //     year = Integer.toString(startingYear);
    //     // }
    //     // File yearFile = new File("db/years" + "/" + year);
    //     // yearFile.mkdirs();
    // }

    // public static void setNewMonth(){
    //     // At start of project
    //     if(years.length == 0){
    //         years.add(new boolean[12]);
    //         // System.out.println("Adding New Year");
    //     }

    //     // Last Year
    //     boolean[] lastYear = years.get((years.size() - 1)); 
    //     // System.out.println(years.get(0)[0]);


    //     // Last Month
    //     for(int i = 0; i < lastYear.length; i++){
    //         if(lastYear[i] != true){
    //             lastYear[i] = true;
    //             // System.out.println("Month " + i + " added");
    //             return;
    //         }
    //     }

    //     // Adding New Year
    //     years.add(new boolean[12]);
    //     years.get((years.size() - 1))[0] = true; // setting first month true
    // }

    // public static int getLastMonth(){
    //     // Last Year
    //     boolean[] lastYear = years.get((years.size() - 1)); 

    //     // Last Month
    //     for(int i = 0; i < lastYear.length; i++){
    //         if(lastYear[i] != true){
    //             return i - 1;
    //         }
    //     }

    //     return 11;
    // }

    // static int getCurrentYear(){   
    //     return startingYear + years.size() - 1;
    // }

    // private static String indexToMonthName(int index){
    //     switch(index){
    //         case 0: return "January";
    //         case 1: return "February";
    //         case 2: return "March";
    //         case 3: return "April";
    //         case 4: return "May";
    //         case 5: return "June";
    //         case 6: return "July";
    //         case 7: return "August";
    //         case 8: return "September";
    //         case 9: return "October";
    //         case 10: return "November";
    //         case 11: return "December";
    //     }
    //     return "Not Initialized";
    // }


    // public void delete(String fileName, int ID) throws IOException{
    //     PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    //     BufferedReader reader = new BufferedReader(new FileReader(()));

    //     String record = new String();
    //     int counter = 0;
    //     for (byte block = 0; block < society.BLOCKS(); block++){
    //         for (byte subBlock = 0; subBlock < society.SUB_BLOCKS(); subBlock++){
    //             for (byte street = 0; street < society.STREETS(); street++){
    //                 for (byte house = 0; house < society.HOUSES(); house++){
    //                     for (byte portion = 0; portion < society.PORTIONS(); portion++ ) {
    //                         counter++;
    //                         if (counter == ID){
    //                             writer.println("x " + reader.readLine());
    //                         } else {
    //                             writer.println(reader.readLine());
    //                         }
                            
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     reader.close();
    //     writer.flush();
    //     writer.close();
    // }

}
