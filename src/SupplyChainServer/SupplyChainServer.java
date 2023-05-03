/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SupplyChainServer extends UnicastRemoteObject implements SupplyChain {

    private List<Product> products = new ArrayList<Product>();

    public SupplyChainServer() throws RemoteException {
        super();
    }

    public List<Product> getProducts() throws RemoteException {
        return products;
    }

    public void addProduct(Product p) throws RemoteException {
        products.add(p);
    }

    public void removeProduct(Product p) throws RemoteException {
        products.remove(p);
    }

    public void updateProduct(Product p) throws RemoteException {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(p.getName())) {
                products.set(i, p);
                break;
            }
        }
    }
}