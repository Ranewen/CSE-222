/**
 * Represents a SmartWatch device. This class implements the {@link Device} interface,
 * encapsulating properties specific to smartwatches such as name, price, and quantity.
 * The category is predefined as "Smart Watch".
 * <p>
 * The time complexity for the operations of this class is O(1) for all methods,
 * as they merely set or return the value of member variables without performing
 * any computations that depend on the size of the input.
 */
public class SmartWatch implements Device {
    private final String category = "Smart Watch"; // The category of this device, fixed as "Smart Watch".
    private String name;            // The name of the SmartWatch.
    private double price;           // The price of the SmartWatch.
    private int quantity;           // The quantity of SmartWatches available.

    /**
     * Constructs a new SmartWatch object with the specified name, price, and quantity.
     * <p>
     * Time complexity: O(1), as assigning values to the fields does not depend on input size.
     *
     * @param name     The name of the SmartWatch.
     * @param price    The price of the SmartWatch.
     * @param quantity The available quantity of the SmartWatch.
     */
    public SmartWatch(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the category of the device, which is predefined as "Smart Watch".
     * <p>
     * Time complexity: O(1), as it returns a constant field value.
     *
     * @return A string representing the category of the device.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of the SmartWatch.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The name of the SmartWatch.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the SmartWatch.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param name The new name of the SmartWatch.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the SmartWatch.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The price of the SmartWatch.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the SmartWatch.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param price The new price of the SmartWatch.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the SmartWatch available.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The available quantity of the SmartWatch.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the available quantity of the SmartWatch.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param quantity The new available quantity of the SmartWatch.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
