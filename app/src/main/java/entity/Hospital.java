package entity;

/**
 * Created by LLLLLLL on 5/23/2016.
 */
public class Hospital {
    private String hospital_ID;
    private String hospital_name;
    private String hospital_address;
    private String hospital_info;
    private String hospital_phone;
    private String hospital_webSite;
    private int hospital_state;
    private int hospital_imageID;

    public int getHospital_regisNum() {
        return hospital_regisNum;
    }

    private int hospital_regisNum;

    public Hospital(String hospital_ID, String hospital_name, int hospital_imageID, int hospital_regisNum) {
        this.hospital_ID = hospital_ID;
        this.hospital_name = hospital_name;
        this.hospital_imageID = hospital_imageID;
        this.hospital_regisNum = hospital_regisNum;
    }

    public String getHospital_ID() {
        return hospital_ID;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public String getHospital_address() {
        return hospital_address;
    }

    public String getHospital_info() {
        return hospital_info;
    }

    public String getHospital_phone() {
        return hospital_phone;
    }

    public String getHospital_webSite() {
        return hospital_webSite;
    }

    public int getHospital_state() {
        return hospital_state;
    }

    public int getHospital_imageID() {
        return hospital_imageID;
    }
}
