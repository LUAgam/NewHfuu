package entity;

/**
 * Created by LLLLLLL on 5/20/2016.
 */
public class Recorder {
    private String userMes_num;
    private String userMes_state;
    private int userMes_image;
    private String userMes_name;
    private String userMes_position;
    private String userMes_hospital;
    private String userMes_department;
    private String userMes_Uname;
    private String userMes_cost;
    private String userMes_time;

    public Recorder(String userMes_num, String userMes_state, int userMes_image, String userMes_name, String userMes_position, String userMes_hospital, String userMes_department, String userMes_Uname, String userMes_cost, String userMes_time) {
        this.userMes_num = userMes_num;
        this.userMes_state = userMes_state;
        this.userMes_image = userMes_image;
        this.userMes_name = userMes_name;
        this.userMes_position = userMes_position;
        this.userMes_hospital = userMes_hospital;
        this.userMes_department = userMes_department;
        this.userMes_Uname = userMes_Uname;
        this.userMes_cost = userMes_cost;
        this.userMes_time = userMes_time;
    }

    public String getUserMes_num() {
        return userMes_num;
    }

    public String getUserMes_state() {
        return userMes_state;
    }

    public int getUserMes_image() {
        return userMes_image;
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

    public String getUserMes_Uname() {
        return userMes_Uname;
    }

    public String getUserMes_cost() {
        return userMes_cost;
    }

    public String getUserMes_time() {
        return userMes_time;
    }
}
