/**
 * DSA Group 12345 Panlilio, A., Relox, J., Militar, J.
 * Code by Panlilio A.
**/

import model.Inventory;
import java.util.*;
public class Main {
    
    // inventory list as per reference lectures/code using LinkedLists
    static LinkedList<Inventory> inv = new LinkedList<>();

    // scanner class import for user input on main menu
    static Scanner input = new Scanner(System.in);
    
    // initialize new ID counter -- assume fresh list always.
    static int id = 1000;
    
    // Main Class/Core Program
    public static void main(String[] args) 
    {
        int choice;
        //do-while loop for main menu, menu options, menu logic + exit logic
        do 
        {         
            System.out.print
            (
                "\n\n - MotorPH Inventory Management Console - \n"
                +  "----------------------------------------\n"
                + "1 > Print Full Inventory\n"
                + "2 > Search ID\n"
                + "3 > Search Brand\n"
                + "4 > Search Model\n"
                + "5 > Add Items\n"
                + "6 > Delete Items\n"
                + "7 > Sort Items\n"
                + "8 > Exit Application\n"
                + "Enter option: "
            );

            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nPrinting Inventory...\n");
                    inventoryReport();
                    break;
                case 2:
                    System.out.println("\nSearching by ID...");
                    idSearch();
                    break;
                case 3:
                    System.out.println("\nSearching by Brand...");
                    idSearch();
                    break;
                case 4:
                    System.out.println("\nSearching by Model...");
                    idSearch();
                    break;
                case 5:
                    System.out.println("\nAdding Items...");
                    addItem();
                    break;
                case 6:
                    System.out.println("\nDeleting Items...");
                    deleteItem();
                    break;
                case 7:
                    System.out.println("\nSorting Database...");
                    sortItems();
                    break;
                case 8:
                    System.out.println("\n--System Shutdown--\n");
                    break;
                default:
                    System.out.println("Invalid option. Please choose from 1 to 6 only.");
            }
        }
        while (choice != 8);
    }

/**
---Methods List    
**/  
    
    // Report Full Inventory
    static void inventoryReport() {
        if (!inv.isEmpty()) {
            System.out.println("-- MotorPH Inventory --");
            for (Inventory i : inv) {
            i.row_print();
            }
        }
        else System.out.println("Error: Databse is empty.");
    }
    
    // Add new Entry
    static void addItem() {
        
        // get parameters from user
        //System.out.print("\nEnter an ID for the item: ");
        //int id = input.nextInt(); //numbers only for IDs
        //input.nextLine();
        System.out.print("\nEnter the brand of the vehicle: ");
        String brnd = input.nextLine();
        System.out.print("Enter the model of the vehicle: ");
        String mdl = input.nextLine();
        System.out.print("Enter the cost of the vehicle: ");
        double cost = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the quantity: ");
        int qty = input.nextInt();
        input.nextLine();
        
        // only try to add if values are non-null and non-zero
        if (id != 0 && brnd != null && mdl != null && cost != 0 && qty != 0)
        {
            //do a quick search algo to verify if there are duplicate ids
            boolean exists = false;
            for (Inventory i : inv) {
                if (i.getId().equalsIgnoreCase(Integer.toString(id))) 
                {
                    exists = true;
                    System.out.println("ID already exists.");
                    id++;  // increment ID to try again later
                    break; // exit the loop because ID exists
                }
            }
            if (!exists)
            {
                
                System.out.println("All fields valid. Adding Item.\n\n");           
                inv.add(new Inventory(Integer.toString(id), brnd, mdl, cost, qty)); // add the items
                id++; // increment ID
            }
        }
        else System.out.println("Invalid entries. Cannot Add Item\n\n");
    }
    
    // id searching -- taken directly from sample code
    static void idSearch() {
        System.out.print("\nEnter the ID to lookup: ");
        String data = input.nextLine();
        boolean found = false;
        for (Inventory i : inv) {
            if (i.getId().equalsIgnoreCase(data)) {
                i.row_print();
                found = true;
                break; // ID is unique
            }
        }
        if (!found) {
            System.out.println("ID does not exist.");
        }
    }
    
    // brand searching  -- taken directly from sample code
    static void brandSearch() {
        System.out.print("\nEnter the vehicle brand to lookup: ");
        String data = input.nextLine();
        boolean found = false;
        for (Inventory i : inv) {
            if (i.getBrand().equalsIgnoreCase(data)) {
                i.row_print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching data.");
        }
    }

    // model searching  -- taken directly from sample code
    static void modelSearch() {
        System.out.print("\nEnter the model to lookup: ");
        String data = input.nextLine();
        boolean found = false;
        for (Inventory i : inv) {
            if (i.getModel().equalsIgnoreCase(data)) {
                i.row_print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching data.");
        }
    }
    
    // item delete function
    static void deleteItem() {
        System.out.print("\nEnter the itemID to delete: ");
        String data = input.nextLine();
        //int index;
        boolean found = false;
        for (Inventory i : inv) {
            if (i.getId().equalsIgnoreCase(data)) {
                found = true;
                inv.remove(i);
                break; // ID is unique
            }
        }
        if (!found) {
            System.out.println("ID does not exist.");
        }
    }
    
    // sort database
    static void sortItems() {
        System.out.print("\nSorting Items\n");
        Collections.sort(inv, null);
    }
    
}
