package entity;

/**
 * Created by LLLLLLL on 5/25/2016.
 */
public class AdapterDocVisit {
    private String text_time;
    private String text_timeOfday;
    private String text_preNum;
    private String text_totalNum;

    public AdapterDocVisit(String text_time, String text_timeOfday, String text_preNum, String text_totalNum) {
        this.text_time = text_time;
        this.text_timeOfday = text_timeOfday;
        this.text_preNum = text_preNum;
        this.text_totalNum = text_totalNum;
    }

    public String getText_time() {
        return text_time;
    }

    public String getText_timeOfday() {
        return text_timeOfday;
    }

    public String getText_preNum() {
        return text_preNum;
    }

    public String getText_totalNum() {
        return text_totalNum;
    }
}
