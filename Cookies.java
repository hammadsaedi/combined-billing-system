// Next Month .....> After Previous Month
// Previous Month .....> Last True Valued Month (At least one True)
// Loaded Month?
// Is Incomplete Month ....> As one can take readings of a particular sector
public class Cookies {
    // private String baseDir, namesFile;
    // private int previousMonth = -1,  currentMonth = 0, previousYear = -1, currentYear = 0;
    // private Society society;
    // private ArrayList<boolean[]> years = new ArrayList<boolean[]>();

    // // constructor
    // Cookies(Society society, String baseDir, String namesFile){
    //     this.society = society;
    //     this.baseDir = baseDir;
    //     this.namesFile = namesFile;
    // }

    // public void setNewMonth(){
    //     // At start of project
    //     if(years.size() == 0){
    //         years.add(new boolean[12]);
    //     }

    //     // Last Year
    //     boolean[] lastYear = years.get((years.size() - 1)); 


    //     // Last Month
    //     for(int i = 0; i < lastYear.length; i++){
    //         if(lastYear[i] = false){
    //             lastYear[i] = true;
    //             return;
    //         }
    //     }

    //     // Adding New Year
    //     years.add(new boolean[12]);
    //     years.get((years.size() - 1))[0] = true; // setting first month true
    // }

    // // getters and Setter for Class Attributes
    // public void setCurrentMonth(int currentMonth) {   
    //     this.currentMonth = currentMonth;
    // }

    // public void setCurrentYear(int currentYear) {
    //     this.currentYear = currentYear;
    // }

    // public void setPreviousMonth(int previousMonth) {
    //     this.previousMonth = previousMonth;
    // }

    // public void setPreviousYear(int previousYear) {
    //     this.previousYear = previousYear;
    // }

    // public int getCurrentMonth() {
    //     return currentMonth;
    // }

    // public int getCurrentYear() {
    //     return currentYear;
    // }

    // public int getPreviousMonth() {
    //     return previousMonth;
    // }

    // public int getPreviousYear() {
    //     return previousYear;
    // }

    // public String getBaseDir() {
    //     return baseDir;
    // }

    // public String getNamesFile() {
    //     return namesFile;
    // }
    // // ------------------------------------------- end ---- Getter and Setters -----------


    // public void addYear(){
    //     years.add(months);
    // }

    // public static void main(String[] args) {
    //     Cookies cookies = new Cookies(new Society(1, 1, 1, 1, 1,1), "db", "names.txt");
    //     // cookies.addYear();
    //     // boolean[][][][][] updatedRecords = cookies.years.get(0)[1].getUpdatedRecords();
    //     // updatedRecords[1][1][1][1][1] = true;
        
    //     // cookies.years.get(0)[1].setUpdatedRecords(updatedRecords);

    //     // System.out.println(cookies.getNextMonth() + " ");
    //     // cookies.years.get(0)[0].setEffectedRecords(cookies.years.get(0)[0].getEffectedRecords() + 1);
    //     // this.years[0][0].getEffectedRecords();


    //     cookies.setPreviousMonth(0);
    //     cookies.setPreviousYear(2016);

    //     System.out.println(cookies.currentMonth);
    // }

    // // // returns next month; if it was last month of year, will return null
    // // public String NextMonth() {

    // //     boolean[][][][][] updatedRecords;
    // //     int totalYears = this.years.size(), totalMonths = this.years.get(0).length;

    // //     for (int i = 0; i < totalMonths; i++ ){
    // //         updatedRecords = this.years.get(totalYears - 1)[i].getUpdatedRecords(); 
    // //         if(isAnyTrueValue(updatedRecords)){
    // //             System.out.println("Here");
    // //             continue;
    // //         } else {
    // //             System.out.println("There");
    // //             return this.years.get(totalYears - 1)[i].toString();
    // //         }
    // //     }

    // //     return null;
    // // }

    // // private static boolean isAnyTrueValue(boolean[][][][][] array){
    // //     // Iterates throw records
    // //     for (int j = 0; j < array.length; j++) {
    // //         for (int k = 0; k < array[j].length; k++) {
    // //             for (int l = 0; l < array[j][k].length; l++) {
    // //                 for (int m = 0; m < array[j][k][l].length; m++) {
    // //                     for (int n = 0; n < array[j][k][l][m].length; n++) {
    // //                         if(array[j][k][l][m][n] ==  true){
    // //                             System.out.println(array[j][k][l][m][n]);
    // //                             return true;
    // //                         }
    // //                     }
    // //                 }
    // //             }
    // //         }
    // //     }
    // //     return false;
    // // }

    // // public void isIncomplete(){

    // // }


}