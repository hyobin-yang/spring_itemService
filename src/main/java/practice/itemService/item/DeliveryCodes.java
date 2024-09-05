package practice.itemService.item;

import java.util.HashMap;
import java.util.Map;

public class DeliveryCodes {

    private String deliveryCode;
    private String displayName;

    private static Map<String, String> deliveryCodeMap = new HashMap<>();

    public Map<String, String> getDeliveryCode() {
        return deliveryCodeMap;
    }

    DeliveryCodes(String deliveryCode, String displayName) {
        deliveryCodeMap.put(deliveryCode, displayName);
    }


}
