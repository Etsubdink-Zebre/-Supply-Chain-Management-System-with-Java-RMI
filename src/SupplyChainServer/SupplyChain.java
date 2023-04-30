/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author admin
 */
public interface SupplyChain extends Remote {
    public List<Product> getProducts() throws RemoteException;
    public void addProduct(Product p) throws RemoteException;
    public void removeProduct(Product p) throws RemoteException;
    public void updateProduct(Product p) throws RemoteException;
}

