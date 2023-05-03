/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainClient;

import SupplyChainServer.Product;
import SupplyChainServer.SupplyChain;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class SupplyChainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Registry reg = LocateRegistry.getRegistry("localhost", 1888);
            SupplyChain stub = (SupplyChain) reg.lookup("SupplyChainServer");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            System.out.println("Enter product quantity:");
            int quantity = scanner.nextInt();
            System.out.println("Enter product price:");
            double price = scanner.nextDouble();

            List<Product> products = stub.getProducts();
            System.out.println("Initial product list: " + products);

            Product p1 = new Product(name, quantity, price);
            stub.addProduct(p1);

            products = stub.getProducts();
            System.out.println("Product list after adding a new product: " + products);
            scanner.nextLine();
            System.out.println("Enter the name of the product to update:");
            String nameToUpdate = scanner.nextLine();

            Product productToUpdate = null;
            for (Product product : products) {
                if (product.getName().equals(nameToUpdate)) {
                    productToUpdate = product;
                    break;
                }
            }

            if (productToUpdate == null) {
                System.out.println("Product not found.");
            } else {
                System.out.println("Enter the new price:");
                double newPrice = Double.parseDouble(scanner.nextLine());
                productToUpdate.setPrice(newPrice);

                System.out.println("Enter the new quantity:");
                int newQuantity = Integer.parseInt(scanner.nextLine());
                productToUpdate.setQuantity(newQuantity);

               
                System.out.print("Enter the name of the product to remove: ");
                String productName = scanner.nextLine();
                Product productToRemove = null;
                for (Product product : products) {
                    if (product.getName().equals(productName)) {
                        productToRemove = product;
                        break;
                    }
                }
                if (productToRemove != null) {
                    stub.removeProduct(productToRemove);
                    products = stub.getProducts();
                    System.out.println("Product list after removing " + productName + ": " + products);
                } else {
                    System.out.println("Product not found");
                }

            }
        } catch (Exception e) {
            System.err.println("SupplyChainClient exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
