import java.util.Scanner;
import java.util.List;

public class Main {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nWelcome to the Electronics Inventory Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");

            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addDevice();
                    break;
                case 2:
                    removeDevice();
                    break;
                case 3:
                    updateDeviceDetails();
                    break;
                case 4:
                    listAllDevices();
                    break;
                case 5:
                    findCheapestDevice();
                    break;
                case 6:
                    sortDevicesByPrice();
                    break;
                case 7:
                    calculateTotalInventoryValue();
                    break;
                case 8:
                    restockDevice();
                    break;
                case 9:
                    exportInventoryReport();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
        scanner.close();
    }

    private static void addDevice() {
        System.out.println("Enter category (Laptop, Smart Phone, Smart Watch, Headphones, Tv): ");
        String category = scanner.nextLine();
        System.out.println("Enter device name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Device device = null;
        switch (category.toLowerCase()) {
            case "laptop":
                device = new Laptop(name, price, quantity);
                break;
            case "smart phone":
                device = new SmartPhone(name, price, quantity);
                break;
            case "smart watch":
                device = new SmartWatch(name, price, quantity);
                break;
            case "tv":
                device = new Tv(name, price, quantity);
                break;
            case "headphones":
                device = new Headphones(name, price, quantity);
                break;
            default:
                System.out.println("Invalid category! Device not added.");
                return;
        }

        inventory.addDevice(device);
        System.out.printf("%s, %s, %.2f$, %d amount added...%n",device.getCategory(), device.getName(), device.getPrice(), device.getQuantity());
    }

    private static void removeDevice() {
        System.out.println("Enter the name of the device to remove: ");
        String name = scanner.nextLine();
        if (inventory.removeDevice(name)) {
            System.out.println("Device removed: " + name);
        } else {
            System.out.println("Device not found.");
        }
    }

    private static void updateDeviceDetails() {
        System.out.println("Enter the name of the device to update: ");
        String name = scanner.nextLine();  // This is where 'name' should be declared and initialized

        System.out.println("Enter new price (leave blank to keep current): ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline left-over

        System.out.println("Enter new quantity (leave blank to keep current): ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume the newline left-over

        Device device = inventory.findDeviceByName(name); // 'name' is used here

        if (device != null) {
            if (price >= 0) device.setPrice(price);
            if (quantity >= 0) device.setQuantity(quantity);
            System.out.printf("%s details updated: Price - %.2f$, Quantity - %d%n",
                              device.getName(), device.getPrice(), device.getQuantity());
        } else {
            System.out.println("Device not found.");
        }
    }

      

    private static void listAllDevices() {
        List<Device> allDevices = inventory.getAllDevices();
        if (allDevices.isEmpty()) {
            System.out.println("No devices in the inventory.");
        } else {
            System.out.println("\nDevice List:");
            for (Device device : allDevices) {
                System.out.printf("Category: %s, Name: %s, Price: %.2f$, Quantity: %d%n",
                                  device.getCategory(), device.getName(), device.getPrice(), device.getQuantity());
            }
        }
    }

    private static void findCheapestDevice() {
        Device cheapestDevice = inventory.getCheapestDevice();
        if (cheapestDevice == null) {
            System.out.println("No devices available to determine the cheapest one.");
        } else {
            System.out.printf("The cheapest device is: Category: %s, Name: %s, Price: %.2f$, Quantity: %d%n",
                              cheapestDevice.getCategory(), cheapestDevice.getName(), cheapestDevice.getPrice(), cheapestDevice.getQuantity());
        }
    }

    private static void sortDevicesByPrice() {
        List<Device> sortedDevices = inventory.sortDevicesByPrice();
        System.out.println("Devices sorted by price:");
        for (Device device : sortedDevices) {
            System.out.printf("Category: %s, Name: %s, Price: %.2f$, Quantity: %d\n", 
                              device.getCategory(), device.getName(), 
                              device.getPrice(), device.getQuantity());
        }
    }

    private static void calculateTotalInventoryValue() {
        double totalValue = inventory.getTotalInventoryValue();
        System.out.printf("Total inventory value: $%.2f%n", totalValue);
    }

private static void restockDevice() {
    System.out.println("Enter the name of the device to restock: ");
    String name = scanner.nextLine();
    System.out.println("Do you want to add or remove stock? (Add/Remove): ");
    String action = scanner.nextLine().trim();
    int quantity;

    switch (action.toLowerCase()) {
        case "add":
            System.out.println("Enter the quantity to add: ");
            quantity = scanner.nextInt();
            scanner.nextLine();  // consume newline
            if (inventory.restockDevice(name, quantity, true)) {
                System.out.println(name + " restocked. New quantity: " + inventory.findDeviceByName(name).getQuantity());
            } else {
                System.out.println("Could not restock " + name + ".");
            }
            break;
        case "remove":
            System.out.println("Enter the quantity to remove: ");
            quantity = scanner.nextInt();
            scanner.nextLine();  // consume newline
            if (inventory.restockDevice(name, quantity, false)) {
                System.out.println(name + " stock reduced. New quantity: " + inventory.findDeviceByName(name).getQuantity());
            } else {
                System.out.println("Could not modify stock for " + name + ".");
            }
            break;
        default:
            System.out.println("Invalid action. Please specify 'Add' or 'Remove'.");
            break;
    }
}
    private static void exportInventoryReport() {
        System.out.println("Enter filename to export inventory report:");
        String filename = scanner.nextLine();
        inventory.exportInventoryReport(filename);
        System.out.println("Inventory report exported successfully.");
    }
}