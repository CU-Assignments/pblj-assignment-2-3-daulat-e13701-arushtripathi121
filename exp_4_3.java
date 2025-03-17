import java.util.*;
import java.util.stream.Collectors;

public class exp_4_3 {

    static class Product {
        String name;
        String category;
        double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 800),
                new Product("Shirt", "Clothing", 30),
                new Product("Smartphone", "Electronics", 500),
                new Product("Shoes", "Clothing", 70)
        );

        // Calculate average price by category
        Map<String, Double> avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));
        avgPriceByCategory.forEach((category, avgPrice) -> System.out.println(category + ": " + avgPrice));

        // Find the most expensive product in each category
        Map<String, Product> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().get()));
        mostExpensiveByCategory.forEach((category, product) -> System.out.println(category + ": " + product));
    }
}
