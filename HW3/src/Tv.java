/**
 * Represents a TV device. This class implements the {@link Device} interface,
 * encapsulating properties specific to televisions such as name, price, and quantity.
 * The category is predefined as "Tv".
 * <p>
 * The time complexity for the operations of this class is O(1) for all methods,
 * as they merely set or return the value of member variables without performing
 * any computations that depend on the size of the input.
 */
public class Tv implements Device {
    private String category = "Tv"; // The category of this device.
    private String name;            // The name of the TV.
    private double price;           // The price of the TV.
    private int quantity;           // The quantity of TVs available.

    /**
     * Constructs a new TV object with the specified name, price, and quantity.
     * <p>
     * Time complexity: O(1), as assigning values to the fields does not depend on input size.
     *
     * @param name     The name of the TV.
     * @param price    The price of the TV.
     * @param quantity The available quantity of the TV.
     */
    public Tv(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the category of the device, which is predefined as "Tv".
     * <p>
     * Time complexity: O(1), as it returns a static, predefined string.
     *
     * @return A string representing the category of the device.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of the TV.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The name of the TV.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the TV.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param name The new name of the TV.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the TV.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The price of the TV.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the TV.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param price The new price of the TV.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the TV available.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The available quantity of the TV.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the available quantity of the TV.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param quantity The new available quantity of the TV.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
