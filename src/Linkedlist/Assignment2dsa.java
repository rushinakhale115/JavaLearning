import java.util.Scanner;

class ProductInventoryApp {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Show Products");
            System.out.println("5. Modify Product");
            System.out.println("6. Show Total Inventory Value");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    String name = productList.getProductName();
                    int quantity = productList.getProductQuantity();
                    int price = productList.getProductPrice();
                    String category = productList.getProductCategory();
                    productList.addProduct(name, quantity, price, category);
                    break;
                case 2:
                    String searchName = productList.getProductName();
                    productList.searchProduct(searchName);
                    break;
                case 3:
                    String removeName = productList.getProductName();
                    productList.removeProduct(removeName);
                    break;
                case 4:
                    productList.showProducts();
                    break;
                case 5:
                    String modifyName = productList.getProductName();
                    productList.modifyProduct(modifyName);
                    break;
                case 6:
                    productList.showTotalInventoryValue();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }
}

class ProductList {
    ProductNode head;
    int productCounter = 100;
    int totalValue = 0;
    Scanner scanner = new Scanner(System.in);

    class ProductNode {
        String name;
        int quantity;
        int price;
        ProductNode next;
        ProductNode prev;
        int productId;
        String category;

        ProductNode(String name, int quantity, int price, String category) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.category = category;
        }
    }

    public void addProduct(String name, int quantity, int price, String category) {
        ProductNode newProduct = new ProductNode(name, quantity, price, category);
        if (head == null) {
            head = newProduct;
            productCounter++;
            newProduct.productId = productCounter;
            totalValue += newProduct.price * newProduct.quantity;
        } else {
            ProductNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newProduct;
            newProduct.prev = current;
            productCounter++;
            newProduct.productId = productCounter;
            totalValue += newProduct.price * newProduct.quantity;
        }
    }

    public void showProducts() {
        System.out.println("Enter the product category to display: ");
        String userCategory = scanner.next();
        showProductsByCategory(userCategory);
    }

    public void showProductsByCategory(String userCategory) {
        ProductNode current = head;
        boolean found = false;
        System.out.println("Category: " + userCategory);
        while (current != null) {
            if (current.category.equals(userCategory)) {
                System.out.println("ProductId: " + current.productId);
                System.out.println("[ Name: " + current.name + " Quantity: " + current.quantity + " Price: " + current.price + " ]");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No products found in the category.");
        }
    }

    public void searchProduct(String name) {
        ProductNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("ProductId: " + current.productId);
                System.out.print("[ Name: " + current.name + " Quantity: " + current.quantity + " Price: " + current.price + " ]");
                return;
            }
            current = current.next;
        }
        System.out.println("Product not found");
    }

    public void removeProduct(String name) {
        ProductNode current = head;

        if (current != null && current.name.equals(name)) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            totalValue -= current.quantity * current.price;
            System.out.println("Product " + current.name + " with ID: " + current.productId + " successfully removed.");
            return;
        }

        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Product " + name + " not found.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        totalValue -= current.quantity * current.price;
        System.out.println("Product " + current.name + " with ID: " + current.productId + " successfully removed.");
    }

    public void modifyProduct(String name) {
        ProductNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("ProductId: " + current.productId);
                System.out.print("[ Name: " + current.name + " Quantity: " + current.quantity + " Price: " + current.price + " ]");
                System.out.println(" ");
                int oldTotalValue = current.quantity * current.price;
                System.out.println("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                System.out.println("Enter new price: ");
                int newPrice = scanner.nextInt();
                current.quantity = newQuantity;
                current.price = newPrice;

                totalValue = totalValue - oldTotalValue + (newQuantity * newPrice);

                System.out.println("Product updated successfully");
                System.out.print("[ Name: " + current.name + " Quantity: " + current.quantity + " Price: " + current.price + " ]");
                return;
            }
            current = current.next;
        }
        System.out.println("No product found with the name " + name);
    }

    public void showTotalInventoryValue() {
        System.out.println("Total Value of Inventory is: " + totalValue);
    }

    public String getProductName() {
        System.out.println("Enter product name: ");
        return scanner.next();
    }

    public int getProductQuantity() {
        System.out.println("Enter quantity: ");
        return scanner.nextInt();
    }

    public int getProductPrice() {
        System.out.println("Enter price: ");
        return scanner.nextInt();
    }

    public String getProductCategory() {
        System.out.println("Enter product category: ");
        return scanner.next();
    }
}
