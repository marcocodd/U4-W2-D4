package marco;

import marco.entities.Customer;
import marco.entities.Order;
import marco.entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {


    public static void main(String[] args) {

        Random random = new Random();
        // dichiarazione customers e Lista Customers
        Customer aldo = new Customer(random.nextLong(), "Aldo", 2);
        Customer giovanni = new Customer(random.nextLong(), "Giovanni", 1);
        Customer giacomo = new Customer(random.nextLong(), "Giacomo", 2);
        Customer alfredo = new Customer(random.nextLong(), "Alfredo", 1);
        List<Customer> customersList = new ArrayList<>();

        customersList.add(aldo);
        customersList.add(giovanni);
        customersList.add(giacomo);
        customersList.add(alfredo);

//        System.out.println(customersList);

        // dichiarazione prodotti e lista prodotti


        Product iPhone = new Product(random.nextLong(), "IPhone", "Smartphones", 2000.0);
        Product lotrBook = new Product(random.nextLong(), "LOTR", "Books", 101);
        Product itBook = new Product(random.nextLong(), "IT", "Books", 2);
        Product davinciBook = new Product(random.nextLong(), "Da Vinci's Code", "Books", 2);
        Product diapers = new Product(random.nextLong(), "Pampers", "Baby", 3);
        Product toyCar = new Product(random.nextLong(), "Car", "Boys", 15);
        Product toyPlane = new Product(random.nextLong(), "Plane", "Boys", 25);
        Product lego = new Product(random.nextLong(), "Lego Star Wars", "Boys", 500);
        List<Product> productsList = new ArrayList<>(Arrays.asList(iPhone, lotrBook, itBook, davinciBook, diapers, toyCar, toyPlane, lego));
//        System.out.println(productsList);

        // dichiarazione ordini
        LocalDate orderDate = LocalDate.parse("2024-03-01");
        LocalDate deliveryDate = orderDate.plusDays(5);

        Order aldoOrder = new Order(random.nextLong(), "waiting", orderDate, deliveryDate, Arrays.asList(productsList.get(0), productsList.get(1)), customersList.get(0));
        Order giovanniOrder = new Order(random.nextLong(), "dispatched", orderDate, deliveryDate, Arrays.asList(productsList.get(4), productsList.get(3)), customersList.get(1));
        Order giacomoOrder = new Order(random.nextLong(), "waiting", orderDate, deliveryDate, Arrays.asList(productsList.get(6), productsList.get(2)), customersList.get(2));
        Order alfredoOrder = new Order(random.nextLong(), "dispatched", orderDate, deliveryDate, Arrays.asList(productsList.get(7), productsList.get(5)), customersList.get(3));
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(aldoOrder);
        ordersList.add(giovanniOrder);
        ordersList.add(giacomoOrder);
        ordersList.add(alfredoOrder);
//        System.out.println(ordersList);
        System.out.println("Esercizio 1");

        Map<Customer, List<Order>> aldoOrders = ordersList.stream()
                .filter(order -> order.getCustomer().equals(aldo))
                .collect(Collectors.groupingBy(Order::getCustomer));
        aldoOrders.forEach(((customer, orders) -> System.out.println("Cliente: " + customer.getName() + " ," + "Ordini " + orders)));

        System.out.println(" ");
        System.out.println("Esercizio 2");


        System.out.println(" ");
        System.out.println("Esercizio 3");

        List<Product> productsMostExp = productsList.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
        productsMostExp.forEach(System.out::println);

    }


}
