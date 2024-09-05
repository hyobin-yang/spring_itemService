package practice.itemService.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.itemService.item.DeliveryCodes;
import practice.itemService.item.Item;
import practice.itemService.item.ItemRepository;
import practice.itemService.item.ItemTypes;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/form/items")
@RequiredArgsConstructor
public class ItemServiceController {

    private final ItemRepository itemRepository;


    @ModelAttribute("itemTypes")
    public ItemTypes[] itemTypes() {
        return ItemTypes.values();
    }


    @ModelAttribute("regions")
    public Map<String, String> regions(){
        Map<String, String> regions = new HashMap<>();
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        return regions;
    }

//    @ModelAttribute("deliveryCodes")
//    public Map<String, String> deliveryCodes(){
//        new DeliveryCodes("FAST", "빠른 배송");
//    }


    @GetMapping
    public String items(Model model){
        model.addAttribute(itemRepository.findAll());
        return "form/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        model.addAttribute(itemRepository.findById(itemId));
        return "form/item";
    }

    @GetMapping("/addItem")
    public String addItem(Model model){
        model.addAttribute(new Item());
        return "form/addForm";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Item item, Model model){
        model.addAttribute(itemRepository.save(item));
        return "form/addFrom";
    }

    @GetMapping("/editItem/{itemId}")
    public String editItem(@PathVariable long itemId, Model model){
        model.addAttribute(new Item());
        return "form/editForm";
    }

    @PostMapping("/editItem/{itemId}")
    public String editItem(@ModelAttribute Item item, @PathVariable long itemId, Model model){
        Item changedItem = itemRepository.update(itemId, item);
        model.addAttribute(changedItem);
        return "form/editForm";
    }


}











