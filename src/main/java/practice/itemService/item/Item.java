package practice.itemService.item;

import lombok.Data;

import java.util.Map;

@Data
public class Item {

    private long id;
    private String itemName;
    private int price;
    private int quantity;

    private String itemType;
    private Map<String, String> regions;
    //private Map<String, String> deliveryCode;

    public Item(){
    }

    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }



}
