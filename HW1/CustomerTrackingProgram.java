// Importing the required libraries
import java.io.File;
import java.util.Scanner;

// Defining the abstract class person
abstract class person {
    // Declaring the protected variables
    protected String name;
    protected String surname;
    protected String address;
    protected String phone;
    protected int ID;

    // Defining the constructor
    public person(String name, String surname, String address, String phone, int ID) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
    }

    // Defining the abstract methods
    public abstract void print_person();
}

// Defining the class operator that extends person
class operator extends person {
    // Declaring the private variables
    private int wage;
    private customer[] customers;

    // Defining the constructor
    public operator(String name, String surname, String address, String phone, int ID, int wage) {
        super(name, surname, address, phone, ID); // Calling the super class constructor
        this.wage = wage;
        this.customers = new customer[100]; // Initializing the customers array with size 100
    }

    // Defining the method to print the operator information
    public void print_operator() {
        System.out.println("*** Operator Screen ***");
        System.out.println("Name & Surname: " + name + " " + surname);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + ID);
        System.out.println("Wage: " + wage);
        System.out.println("-------------------------");
    }

    // Defining the method to print the customers of the operator
    public void print_customers() {
        int count = 0; // To keep track of the number of customers
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) { // If the customer is not null
                count++; // Increment the count
                System.out.println("Customer #" + count + " (a " + customers[i].getClass().getSimpleName() + ") :"); // Print the customer type
                customers[i].print_customer(); // Print the customer information
                customers[i].print_orders(); // Print the orders of the customer
            }
        }
        if (count == 0) { // If the operator has no customer
            System.out.println("This operator doesn't have any customer.");
        }
    }

    // Defining the method to define the customers of the operator
    public void define_customers(customer[] all_customers) {
        int index = 0; // To keep track of the index of the customers array
        for (int i = 0; i < all_customers.length; i++) {
            if (all_customers[i] != null) { // If the customer is not null
                if (all_customers[i].get_operator_ID() == this.ID) { // If the customer's operator ID matches the operator's ID
                    this.customers[index] = all_customers[i]; // Assign the customer to the customers array
                    index++; // Increment the index
                }
            }
        }
    }

    // Overriding the print_person method
    public void print_person() {
        print_operator(); // Call the print_operator method
    }
}

// Defining the abstract class customer that extends person
abstract class customer extends person {
    // Declaring the protected variables
    protected order[] orders;
    protected int operator_ID;

    // Defining the constructor
    public customer(String name, String surname, String address, String phone, int ID, int operator_ID) {
        super(name, surname, address, phone, ID); // Calling the super class constructor
        this.operator_ID = operator_ID;
        this.orders = new order[100]; // Initializing the orders array with size 100
    }

    // Defining the method to print the customer information
    public void print_customer() {
        System.out.println("Name & Surname: " + name + " " + surname);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("ID: " + ID);
        System.out.println("Operator ID: " + operator_ID);
    }

    // Defining the method to print the orders of the customer
    public void print_orders() {
        int count = 0; // To keep track of the number of orders
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) { // If the order is not null
                count++; // Increment the count
                System.out.println("Order #" + count + " =>");
                orders[i].print_order(); // Print the order information
                
            }
        }
        System.out.println("-----------------------");
    }

    // Defining the method to define the orders of the customer
    public void define_orders(order[] all_orders) {
        int index = 0; // To keep track of the index of the orders array
        for (int i = 0; i < all_orders.length; i++) {
            if (all_orders[i] != null) { // If the order is not null
                if (all_orders[i].get_customer_ID() == this.ID) { // If the order's customer ID matches the customer's ID
                    this.orders[index] = all_orders[i]; // Assign the order to the orders array
                    index++; // Increment the index
                }
            }
        }
    }

    // Defining the getter method for operator ID
    public int get_operator_ID() {
        return this.operator_ID;
    }

    // Overriding the print_person method
    public void print_person() {
        print_customer(); // Call the print_customer method
    }
}

// Defining the class retail_customer that extends customer
class retail_customer extends customer {
    // Defining the constructor
    public retail_customer(String name, String surname, String address, String phone, int ID, int operator_ID) {
        super(name, surname, address, phone, ID, operator_ID); // Calling the super class constructor
    }

    // Overriding the print_customer method
    public void print_customer() {
        super.print_customer(); // Call the super class method
    }
}

// Defining the class corporate_customer that extends customer
class corporate_customer extends customer {
    // Declaring the private variable
    private String company_name;

    // Defining the constructor
    public corporate_customer(String name, String surname, String address, String phone, int ID, int operator_ID, String company_name) {
        super(name, surname, address, phone, ID, operator_ID); // Calling the super class constructor
        this.company_name = company_name;
    }

    // Overriding the print_customer method
    public void print_customer() {
        super.print_customer(); // Call the super class method
        System.out.println("Company name: " + company_name); // Print the company name
    }
}

// Defining the class order
class order {
    // Declaring the private variables
    private String product_name;
    private int count;
    private int total_price;
    private int status;
    private int customer_ID;

    // Defining the constructor
    public order(String product_name, int count, int total_price, int status, int customer_ID) {
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.customer_ID = customer_ID;
    }

    // Defining the method to print the order information
    public void print_order() {
        System.out.println("Product name: " + product_name + " - Count: " + count + " - Total price: " + total_price + " - Status: " + get_status_string());
    }

    // Defining the method to get the status string
    public String get_status_string() {
        // Using a switch statement to match the status integer with the corresponding string
        switch (status) {
            case 0:
                return "Initialized";
            case 1:
                return "Processing";
            case 2:
                return "Completed";
            case 3:
                return "Cancelled";
            default:
            	return null;
        }
    }

    // Defining the getter method for customer ID
    public int get_customer_ID() {
        return this.customer_ID;
    }
}

// Defining the main class
public class CustomerTrackingProgram {
    // Defining the main method
    public static void main(String[] args) {
        // Declaring the arrays to store the data
        order[] orders = new order[100];
        customer[] customers = new customer[100];
        operator[] operators = new operator[100];

        // Declaring the variables to keep track of the indices of the arrays
        int order_index = 0;
        int customer_index = 0;
        int operator_index = 0;

        // Declaring the scanner object to read the input
        Scanner scanner = new Scanner(System.in);

        // Declaring the file object to read the text file
        File file = new File("content.txt");

        // Using a try-catch block to handle the exceptions
        try {
            // Creating another scanner object to read the file
            Scanner file_scanner = new Scanner(file);

            // Reading the file line by line
            while (file_scanner.hasNextLine()) {
                // Getting the next line
                String line = file_scanner.nextLine();
		
		// Rule: Line doesn't have a semicolon
    		if (!line.contains(";")) {
        		continue;
   		 }
                // Splitting the line
                String[] items = line.split(";");
		
		// Rule: Unknown identifier or Extra/Missing column
    		String type = items[0];
    		if (!type.equals("order") && !type.equals("retail_customer") && !type.equals("corporate_customer") && !type.equals("operator") ||
        		(type.equals("order") && items.length != 6) ||
        		(type.equals("retail_customer") && items.length != 7) ||
        		(type.equals("corporate_customer") && items.length != 8) ||
        		(type.equals("operator") && items.length != 7)) {
        		continue;
    		}
    
                // Using a switch statement to handle different types of data
                switch (type) {
                    case "order":
                        // Checking if the line has the correct number of items
                        if (items.length == 6) 
                        {
                            // Getting the values of the items
                            String product_name = items[1];
                            int count = Integer.parseInt(items[2]);
                            int total_price = Integer.parseInt(items[3]);
                            int status = Integer.parseInt(items[4]);
                            int customer_ID = Integer.parseInt(items[5]);

                            // Only create and add the order if count is greater than 0
            		    if (count > 0) 
            		    {
                           	// Creating a new order object with the values
                           	order new_order = new order(product_name, count, total_price, status, customer_ID);
 
                               // Adding the order object to the orders array
                               orders[order_index] = new_order;

                              // Incrementing the order index
                              order_index++;
            		    }
                       }
                        break;
                    case "retail_customer":
                        // Checking if the line has the correct number of items
                        if (items.length == 7) {
                            // Getting the values of the items
                            String name = items[1];
                            String surname = items[2];
                            String address = items[3];
                            String phone = items[4];
                            int ID = Integer.parseInt(items[5]);
                            int operator_ID = Integer.parseInt(items[6]);

                            // Creating a new retail customer object with the values
                            retail_customer new_retail_customer = new retail_customer(name, surname, address, phone, ID, operator_ID);

                            // Adding the retail customer object to the customers array
                            customers[customer_index] = new_retail_customer;

                            // Incrementing the customer index
                            customer_index++;
                        }
                        break;
                    case "corporate_customer":
                        // Checking if the line has the correct number of items
                        if (items.length == 8) {
                            // Getting the values of the items
                            String name = items[1];
                            String surname = items[2];
                            String address = items[3];
                            String phone = items[4];
                            int ID = Integer.parseInt(items[5]);
                            int operator_ID = Integer.parseInt(items[6]);
                            String company_name = items[7];

                            // Creating a new corporate customer object with the values
                            corporate_customer new_corporate_customer = new corporate_customer(name, surname, address, phone, ID, operator_ID, company_name);

                            // Adding the corporate customer object to the customers array
                            customers[customer_index] = new_corporate_customer;

                            // Incrementing the customer index
                            customer_index++;
                        }
                        break;
                    case "operator":
                        // Checking if the line has the correct number of items
                        if (items.length == 7) {
                            // Getting the values of the items
                            String name = items[1];
                            String surname = items[2];
                            String address = items[3];
                            String phone = items[4];
                            int ID = Integer.parseInt(items[5]);
                            int wage = Integer.parseInt(items[6]);

                            // Creating a new operator object with the values
                            operator new_operator = new operator(name, surname, address, phone, ID, wage);

                            // Adding the operator object to the operators array
                            operators[operator_index] = new_operator;

                            // Incrementing the operator index
                            operator_index++;
                        }
                        break;
                    default:
                        // Ignoring the line if the type is not valid
                        break;
                }
            }

            // Closing the file scanner
            file_scanner.close();

            // Defining the orders and customers of each operator
            for (int i = 0; i < operators.length; i++) {
                if (operators[i] != null) { // If the operator is not null
                    operators[i].define_customers(customers); // Call the define_customers method
                }
            }

            // Defining the orders of each customer
            for (int i = 0; i < customers.length; i++) {
                if (customers[i] != null) { // If the customer is not null
                    customers[i].define_orders(orders); // Call the define_orders method
                }
            }

            // Asking the user to enter an ID
            System.out.println("Please enter your ID...");

            // Getting the user input
            int user_ID = scanner.nextInt();

            // check if the ID is valid
            int foundIndex = -1;

            // Searching for the ID in the operators array
            for (int i = 0; i < operators.length; i++) {
                if (operators[i] != null && operators[i].ID == user_ID)  { // If the operator is not null
                  foundIndex = i;
                  break;
            }
            }

             // Check if an operator was found
            if (foundIndex != -1) {
                operators[foundIndex].print_operator();
                operators[foundIndex].print_customers();
            } else {
                // Reset foundIndex for searching in customers
                foundIndex = -1;
                // Attempt to find the user as a customer
                for (int i = 0; i < customers.length; i++) {
                    if (customers[i] != null && customers[i].ID == user_ID) {
                        foundIndex = i; // Store the index of the matching customer
                        break; // Stop searching once a match is found
                    }
                }

                // Check if a customer was found
                if (foundIndex != -1) {
                    customers[foundIndex].print_customer();
                    customers[foundIndex].print_orders();
                } else {
                    // If no matching ID was found
                    System.out.println("No operator/customer was found with ID " + user_ID + ". Please try again.");
                }
            }

            // Closing the scanner
            scanner.close();

        } catch (Exception e) {
            
        }
    }
}
