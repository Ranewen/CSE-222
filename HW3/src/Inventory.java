import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Manages a collection of devices in an inventory. Provides functionalities to add, remove, update,
 * and query devices, as well as to calculate inventory statistics and export inventory reports.
 */
public class Inventory {
    private List<Device> devices; // Holds the collection of devices.

    /**
     * Constructs an Inventory instance and initializes the list of devices.
     */
    public Inventory() {
        devices = new ArrayList<>();
    }

    /**
     * Adds a device to the inventory.
     * <p>
     * Time complexity: O(1) on average, but can be O(n) in the worst case when resizing is required.
     *
     * @param device The device to add.
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Removes a device from the inventory by name.
     * <p>
     * Time complexity: O(n), where n is the number of devices, since it may need to scan the entire list.
     *
     * @param name The name of the device to remove.
     * @return true if a device was removed; false otherwise.
     */
    public boolean removeDevice(String name) {
        return devices.removeIf(device -> device.getName().equalsIgnoreCase(name));
    }

    /**
     * Finds a device by name.
     * <p>
     * Time complexity: O(n), where n is the number of devices, since it may need to scan the entire list.
     *
     * @param name The name of the device to find.
     * @return The device if found; null otherwise.
     */
    public Device findDeviceByName(String name) {
        return devices.stream()
                      .filter(device -> device.getName().equalsIgnoreCase(name))
                      .findFirst()
                      .orElse(null);
    }

    /**
     * Updates the price and quantity of a device by name. If the device does not exist, no action is taken.
     * <p>
     * Time complexity: O(n), because it uses {@link #findDeviceByName(String)} internally.
     *
     * @param name     The name of the device to update.
     * @param price    The new price of the device.
     * @param quantity The new quantity of the device.
     */
    public void updateDevice(String name, double price, int quantity) {
        Device device = findDeviceByName(name);
        if (device != null) {
            if (price >= 0) device.setPrice(price);
            if (quantity >= 0) device.setQuantity(quantity);
        }
    }

    /**
     * Returns a new list containing all devices in the inventory.
     * <p>
     * Time complexity: O(n), where n is the number of devices.
     *
     * @return A list of all devices.
     */
    public List<Device> getAllDevices() {
        return new ArrayList<>(devices);
    }

    /**
     * Finds and returns the cheapest device in the inventory.
     * <p>
     * Time complexity: O(n), as it scans through all devices.
     *
     * @return The cheapest device, or null if the inventory is empty.
     */
    public Device getCheapestDevice() {
        return devices.stream()
                      .min((d1, d2) -> Double.compare(d1.getPrice(), d2.getPrice()))
                      .orElse(null);
    }

    /**
     * Calculates the total value of the inventory.
     * <p>
     * Time complexity: O(n), as it needs to aggregate values from all devices.
     *
     * @return The total value of all devices in the inventory.
     */
    public double getTotalInventoryValue() {
        return devices.stream()
                      .mapToDouble(device -> device.getPrice() * device.getQuantity())
                      .sum();
    }

    /**
     * Restocks or deducts stock for a device by name. If the device is not found, or if the operation
     * results in a negative quantity, the operation fails.
     * <p>
     * Time complexity: O(n), due to the search operation.
     *
     * @param name     The name of the device to restock.
     * @param quantity The quantity to add or remove.
     * @param addStock If true, adds stock; otherwise, removes stock.
     * @return true if the operation was successful; false otherwise.
     */
    public boolean restockDevice(String name, int quantity, boolean addStock) {
        Device device = findDeviceByName(name);
        if (device != null) {
            int newQuantity;
             if (addStock) {
                // Add stock
                newQuantity = device.getQuantity() + quantity;
            } else {
                // Remove stock
                newQuantity = device.getQuantity() - quantity;
            }

            if (newQuantity >= 0) {
                device.setQuantity(newQuantity);
                return true; // Successfully restocked
            } else {
                // The new quantity is less than 0, which is not allowed
                return false; // Restock failed due to invalid quantity
            }
        }
        return false; // Restock failed because the device was not found
    }


    /**
     * Sorts the devices in the inventory by price.
     * <p>
     * Time complexity: O(n log n), where n is the number of devices, due to sorting.
     *
     * @return The list of devices sorted by price.
     */
    public List<Device> sortDevicesByPrice() {
        devices.sort(Comparator.comparingDouble(Device::getPrice));
        return devices;
    }

    /**
     * Exports the inventory report to a specified file. The report includes a list of all devices,
     * their details, and a summary of the total number of devices and the total inventory value.
     * Each device is listed with its category, name, price, and quantity. The report also includes
     * the date it was generated.
     * <p>
     * Time complexity: O(n), where n is the number of devices. Writing to a file is generally considered
     * O(1) for each write operation, but since the method iterates over all devices to generate the report,
     * the overall complexity is O(n).
     *
     * @param filename The name of the file to which the report will be exported.
     */
    public void exportInventoryReport(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            LocalDate currentDate = LocalDate.now(); // Get the current date

            writer.write("Electronics Shop Inventory Report\n");
            writer.write("Generated on: " + currentDate + "\n"); // Include the current date in the report
            writer.write("---------------------------------------\n");
            writer.write("| No. | Category | Name | Price | Quantity |\n");
            writer.write("---------------------------------------\n");

            List<Device> devices = getAllDevices(); // Assuming this method returns the list of all devices
            int counter = 1;
            for (Device device : devices) {
                writer.write(String.format("| %d | %s | %s | $%.2f | %d |\n",
                        counter++, device.getCategory(), device.getName(), 
                        device.getPrice(), device.getQuantity()));
            }

            writer.write("---------------------------------------\n");
            writer.write(String.format("Summary:\n- Total Number of Devices: %d\n- Total Inventory Value: $%.2f\n",
                    devices.size(), getTotalInventoryValue())); // getTotalInventoryValue() should calculate the total value
            writer.write("End of Report\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
