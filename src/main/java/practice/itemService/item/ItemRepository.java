package practice.itemService.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static long sequence = 0L;
    private static Map<Long, Item> store = new HashMap<>();


    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public Item findById(long id){
        return store.get(id);
    }

    public Item update(long id, Item updatedItem){
        Item item = findById(id);

        item.setItemName(updatedItem.getItemName());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());

        item.setItemType(updatedItem.getItemType());
        item.setRegions(updatedItem.getRegions());
        //item.setDeliveryCode(updatedItem.getDeliveryCode());

        return item;
    }



}
