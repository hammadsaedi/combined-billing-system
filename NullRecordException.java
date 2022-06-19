public class NullRecordException extends Exception {
    NullRecordException(int block, int subBlock, int street, int house, int portion) {
        super("Status of Record is null." + " Block: " + block +  " Sub Block: " + subBlock + " Street: " + street + " House : " + house  + " Portion: " + portion);
    }

    NullRecordException(int id) {
        super("Status of Record is null." + "ID: " + id);
    }

    NullRecordException() {
        super("Status of Record is null.");
    }
}
