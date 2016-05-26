package entity;

/**
 * Created by LLLLLLL on 5/20/2016.
 */
public class Menu {
    private String name;
    private int imageId;

    public Menu(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
