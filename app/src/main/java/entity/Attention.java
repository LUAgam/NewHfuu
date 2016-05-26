package entity;

/**
 * Created by LLLLLLL on 5/21/2016.
 */
public class Attention {
    private String userMes_id,userMes_name,userMes_position,userMes_hospital,userMes_department;
    private int userMes_imageId;

    public Attention(String userMes_id,String userMes_name, String userMes_position, String userMes_hospital, String userMes_department, int userMes_imageId) {
        this.userMes_id = userMes_id;
        this.userMes_name = userMes_name;
        this.userMes_position = userMes_position;
        this.userMes_hospital = userMes_hospital;
        this.userMes_department = userMes_department;
        this.userMes_imageId = userMes_imageId;
    }

    public String getUserMes_id() {
        return userMes_id;
    }

    public String getUserMes_name() {
        return userMes_name;
    }

    public String getUserMes_position() {
        return userMes_position;
    }

    public String getUserMes_hospital() {
        return userMes_hospital;
    }

    public String getUserMes_department() {
        return userMes_department;
    }

    public int getUserMes_imageId() {
        return userMes_imageId;
    }
}
