public class Record {
    public int id;
    public String name;
    public Boolean status = false; // True for Updated // False for Not Updated // Null for Deleted
    public double[][] reading = {{0}, {0}, {0}, {0, 0, 0}};
    public double[][] bill = {{0}, {0}, {0}, {0, 0, 0}};
}
   