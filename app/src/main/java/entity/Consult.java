package entity;

/**
 * Created by LLLLLLL on 5/14/2016.
 */
public class Consult {
    private String name;
    private int imageID;

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public Consult(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }
}
