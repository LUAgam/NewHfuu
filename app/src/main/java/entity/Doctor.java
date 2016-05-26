package entity;

/**
 * Created by LLLLLLL on 5/24/2016.
 */
public class Doctor {
    private int doctorInfo_photoID;
    private String doctorInfo_name;
    private String doctorInfo_position;
    private String doctorInfo_disease;
    private int doctorInfo_num;

    public Doctor(int doctorInfo_photoID, String doctorInfo_name, String doctorInfo_position, String doctorInfo_disease, int doctorInfo_num) {
        this.doctorInfo_photoID = doctorInfo_photoID;
        this.doctorInfo_name = doctorInfo_name;
        this.doctorInfo_position = doctorInfo_position;
        this.doctorInfo_disease = doctorInfo_disease;
        this.doctorInfo_num = doctorInfo_num;
    }

    public int getDoctorInfo_photoID() {
        return doctorInfo_photoID;
    }

    public String getDoctorInfo_name() {
        return doctorInfo_name;
    }

    public String getDoctorInfo_position() {
        return doctorInfo_position;
    }

    public String getDoctorInfo_disease() {
        return doctorInfo_disease;
    }

    public int getDoctorInfo_num() {
        return doctorInfo_num;
    }
}
