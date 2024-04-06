/**
 * Represents a SmartPhone device. This class implements the {@link Device} interface,
 * encapsulating properties specific to smartphones such as name, price, and quantity.
 * The category is predefined as "Smart Phone".
 * <p>
 * The time complexity for the operations of this class is O(1) for all methods,
 * as they merely set or return the value of member variables without performing
 * any computations that depend on the size of the input.
 */
public class SmartPhone implements Device {
    private final String category = "Smart Phone"; // The category of this device, fixed as "Smart Phone".
    private String name;            // The name of the SmartPhone.
    private double price;           // The price of the SmartPhone.
    private int quantity;           // The quantity of SmartPhones available.

    /**
     * Constructs a new SmartPhone object with the specified name, price, and quantity.
     * <p>
     * Time complexity: O(1), as assigning values to the fields does not depend on input size.
     *
     * @param name     The name of the SmartPhone.
     * @param price    The price of the SmartPhone.
     * @param quantity The available quantity of the SmartPhone.
     */
    public SmartPhone(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the category of the device, which is predefined as "Smart Phone".
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
     * Returns the name of the SmartPhone.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The name of the SmartPhone.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the SmartPhone.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param name The new name of the SmartPhone.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the SmartPhone.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The price of the SmartPhone.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the SmartPhone.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param price The new price of the SmartPhone.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the SmartPhone available.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The available quantity of the SmartPhone.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the available quantity of the SmartPhone.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param quantity The new available quantity of the SmartPhone.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
