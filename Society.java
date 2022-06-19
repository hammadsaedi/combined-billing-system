/**
 * Immutable Data Container which holds information about Map of society.
 * <li>{@code BLOCKS} number of blocks in society.</li> 
 * <li>{@code SUB_BLOCKS} number of sub block in each block.</li> 
 * <li>{@code STREETS} number of street in each block.</li> 
 * <li>{@code HOUSES} number of houses in each street.</li> 
 * <li>{@code PORTIONS} number of portions in each house.</li>
 * <li>{@code UTILITIES} number of utility provided in each portion.</li>
 * Fields are {@code private} {@code final}. Use getter methods (same as name of field) to access fields.
 * @author @hammadsaedi
 * @version 1.0
*/
public record Society(int BLOCKS, int SUB_BLOCKS, int STREETS, int HOUSES, int PORTIONS, int UTILITIES){
}

