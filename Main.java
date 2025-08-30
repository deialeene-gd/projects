import java.util.*;

interface Discountable {
    double applyDiscount();
}

abstract class Product implements Discountable {
    protected String id;
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double applyDiscount() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: ₱" + price + ", Quantity: " + quantity;
    }
}

class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String id, String name, double price, int warrantyMonths, int quantity) {
        super(id, name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.9;
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months";
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String id, String name, double price, String size, int quantity) {
        super(id, name, price, quantity);
        this.size = size;
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.85;
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}

class Book extends Product {
    public Book(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.85;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Instrument extends Product {
    public Instrument(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.85;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Customer {
    private String id;
    private String name;
    private String password;

    public Customer(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

class Order {
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private List<Integer> quantities;
    public double totalAmount;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        products.add(product);
        quantities.add(quantity);
        totalAmount += product.applyDiscount() * quantity;
    }

    public void generateInvoice() {
        System.out.println("Invoice for Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int quantity = quantities.get(i);
            System.out.println(" - " + product.getName() + " (Quantity: " + quantity + "): ₱" + (product.applyDiscount() * quantity));
        }
        System.out.println("Total Amount: ₱" + totalAmount);
    }
}

class ECommerceSystem {
    private Map<String, Product> productCatalog = new HashMap<>();
    private Map<String, Order> orders = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public ECommerceSystem() {
        // Pre-adding some products
        addProduct(new Electronics("E001", "Smartphone", 699.99, 24, 10));
        addProduct(new Electronics("E002", "Laptop", 1299.99, 36, 5));
        addProduct(new Electronics("E003", "Smartwatch", 199.99, 12, 15));
        addProduct(new Electronics("E004", "TV", 899.99, 24, 10));
        addProduct(new Electronics("E005", "Electric Fan", 49.99, 12, 20));

        addProduct(new Clothing("C001", "T-Shirt", 19.99, "L", 10));
        addProduct(new Clothing("C002", "Polo", 29.99, "M", 15));
        addProduct(new Clothing("C003", "Dress", 49.99, "S", 5));

        addProduct(new Book("B001", "Mathematics", 29.99, 10));
        addProduct(new Book("B002", "Science", 39.99, 15));
        addProduct(new Book("B003", "Filipino", 59.99, 5));

        addProduct(new Instrument("I001", "Acoustic Guitar", 29.99, 10));
        addProduct(new Instrument("I002", "Piano", 39.99, 5));

        // Pre-adding some customers
        customers.put("user1", new Customer("user1", "Alice", "password123"));
        customers.put("user2", new Customer("user2", "Bob", "password456"));
    }

    public void addProduct(Product product) {
        productCatalog.put(product.getId(), product);
    }

    private void listProductsByCategory(String category) {
        System.out.println("\nAvailable Products in " + category + ":");
        for (Product product : productCatalog.values()) {
            if (category.equalsIgnoreCase("Electronics") && product instanceof Electronics) {
                System.out.println(product);
            } else if (category.equalsIgnoreCase("Clothing") && product instanceof Clothing) {
                System.out.println(product);
            } else if (category.equalsIgnoreCase("Book") && product instanceof Book) {
                System.out.println(product);
            } else if (category.equalsIgnoreCase("Instrument") && product instanceof Instrument) {
                System.out.println(product);
            }
        }
    }

    public void showMenu() {
        if (!authenticateUser()) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }
        while (true) {
            System.out.println("\nE-Commerce System Menu");
            System.out.println("1. List All Products");
            System.out.println("2. List Products by Category");
            System.out.println("3. Place an Order");
            System.out.println("4. Track an Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    System.out.print("Enter category (Electronics/Clothing/Book/Instrument): ");
                    String category = scanner.nextLine();
                    listProductsByCategory(category);
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    trackOrder();
                    break;
                case 5:
                    System.out.println("Thank you for using the E-Commerce System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private boolean authenticateUser() {
        while (true) {
            System.out.print("Enter your ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            Customer customer = customers.get(userId);
            if (customer != null && customer.getPassword().equals(password)) {
                return true; // Authentication successful
            } else {
                System.out.println("Invalid ID or password. Please try again.");
            }
        }
    }

    private void listProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productCatalog.values()) {
            System.out.println(product);
        }
    }

    private void placeOrder() {
        System.out.print("\nEnter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = customers.get(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();
        Order order = new Order(orderId, customer);
        System.out.println("Enter product IDs to add to the order (type 'done' to finish):");
        while (true) {
            String productId = scanner.nextLine();
            if (productId.equalsIgnoreCase("done")) break;
            Product product = productCatalog.get(productId);
            if (product != null) {
                System.out.print("Enter quantity for " + product.getName() + ": ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (quantity > 0 && quantity <= product.getQuantity()) {
                    product.setQuantity(product.getQuantity() - quantity);
                    order.addProduct(product, quantity);
                    System.out.println("Added: " + product.getName() + " (Quantity: " + quantity + ")");
                } else {
                    System.out.println("Invalid quantity or insufficient stock!");
                }
            } else {
                System.out.println("Product not found!");
            }
        }

        System.out.print("Do you have a discount code? (yes/no): ");
        String hasDiscount = scanner.nextLine();
        if (hasDiscount.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage (e.g., 10 for 10%): ");
            double discountPercentage = scanner.nextDouble();
            scanner.nextLine();
            double discountAmount = order.totalAmount * (discountPercentage / 100);
            order.totalAmount -= discountAmount;
            System.out.println("Discount applied: ₱" + discountAmount);
        }

        orders.put(orderId, order);
        System.out.println("Order placed successfully!");
        order.generateInvoice();
    }

    private void trackOrder() {
        System.out.print("\nEnter Order ID to track: ");
        String orderId = scanner.nextLine();
        Order order = orders.get(orderId);
        if (order != null) {
            order.generateInvoice();
        } else {
            System.out.println("Order not found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        system.showMenu();
    }
}