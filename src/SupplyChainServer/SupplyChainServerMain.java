/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class SupplyChainServerMain {

    /**
     * @param args the command line arguments
     */
    private static boolean isExported = false;

    public static void main(String[] args) {
        try {
            //SupplyChainServer supplyChainServer = new SupplyChainServer();

            Registry reg = LocateRegistry.createRegistry(1888);
            reg.rebind("SupplyChainServer", new SupplyChainServer());

            System.out.println("SupplyChainServer is running...");
            
        } catch (Exception e) {
            System.err.println("SupplyChainServer exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
