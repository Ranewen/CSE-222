/**
 * Represents a Laptop device. This class implements the {@link Device} interface,
 * encapsulating properties specific to laptops such as name, price, and quantity.
 * The category is predefined as "Laptop".
 * <p>
 * The time complexity for the operations of this class is O(1) for all methods,
 * as they merely set or return the value of member variables without performing
 * any computations that depend on the size of the input.
 */
public class Laptop implements Device {
    private final String category = "Laptop"; // The category of this device, fixed as "Laptop".
    private String name;            // The name of the Laptop.
    private double price;           // The price of the Laptop.
    private int quantity;           // The quantity of Laptops available.

    /**
     * Constructs a new Laptop object with the specified name, price, and quantity.
     * <p>
     * Time complexity: O(1), as assigning values to the fields does not depend on input size.
     *
     * @param name     The name of the Laptop.
     * @param price    The price of the Laptop.
     * @param quantity The available quantity of the Laptop.
     */
    public Laptop(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the category of the device, which is predefined as "Laptop".
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
     * Returns the name of the Laptop.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The name of the Laptop.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Laptop.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param name The new name of the Laptop.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the Laptop.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The price of the Laptop.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the Laptop.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param price The new price of the Laptop.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the Laptop available.
     * <p>
     * Time complexity: O(1), as it simply returns the value of a field.
     *
     * @return The available quantity of the Laptop.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the available quantity of the Laptop.
     * <p>
     * Time complexity: O(1), as it simply assigns a value to a field.
     *
     * @param quantity The new available quantity of the Laptop.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
