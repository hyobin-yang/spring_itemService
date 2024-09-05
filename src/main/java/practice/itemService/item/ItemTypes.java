package practice.itemService.item;

public enum ItemTypes {

    BOOK("책"), GLASS("유리"), ETC("기타");

    public final String label;

    ItemTypes(String label) {
        this.label = label;
    }

    public String label(){
        return label;
    }
}
