package entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LLLLLLL on 5/25/2016.
 */
public class BundleRegistertion implements Parcelable {
    private String hospital;
    private String department;
    private String doctorName;
    private String doctorType;
    private String time;
    private String timeOfDay;
    private String cost;

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public BundleRegistertion(String hospital, String department, String doctorName, String doctorType, String time, String timeOfDay, String cost) {
        this.hospital = hospital;
        this.department = department;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.time = time;
        this.timeOfDay = timeOfDay;
        this.cost = cost;
    }

    public BundleRegistertion(Parcel in) {
        hospital = in.readString();
        department = in.readString();
        doctorName = in.readString();
        doctorType = in.readString();
        time = in.readString();
        timeOfDay = in.readString();
        cost = in.readString();
    }

    public static final Creator<BundleRegistertion> CREATOR = new Creator<BundleRegistertion>() {
        @Override
        public BundleRegistertion createFromParcel(Parcel in) {
            return new BundleRegistertion(in);
        }

        @Override
        public BundleRegistertion[] newArray(int size) {
            return new BundleRegistertion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hospital);
        dest.writeString(department);
        dest.writeString(doctorName);
        dest.writeString(doctorType);
        dest.writeString(time);
        dest.writeString(timeOfDay);
        dest.writeString(cost);
    }
}
