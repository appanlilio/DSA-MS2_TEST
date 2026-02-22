package model;

// Our Inventory Container Class
public class Inventory {
    // Product Parameters
    private String itemID;
    private String brand;
    private String model;
    private double price;
    private int quantity;
    
    // Initializer for Inventory
    public Inventory(String id, String brnd, String mdl, double cost, int qty)
    {
        this.itemID = id;
        this.brand = brnd;
        this.model = mdl;
        this.price = cost;
        this.quantity = qty;
    }

    // Print out Row
    public void row_print()
    {
        System.out.print("\nVehicle: " + itemID + " | " + brand + " " + model + " | Price: " + price + "php | Stock on Hand: " + quantity);
    }
    
    public String getId()
    {
        return itemID;
    }
    
    public String getBrand()
    {
        return brand;
    }
    
    public String getModel()
    {
        return model;
    }     
}