package daoImpl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

import com.example.com.newhfuu.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;

import Util.HttpUtil;
import dao.HttpCallbackListener;
import entity.PatientBaseInfo;

/**
 * Created by woshi on 2016/5/25.
 */
public class RegisterDispose {
    Context context;

    private String baseUrl = "http://192.168.1.111:8080/MedicalRecordsAPP_Backstage/dep/ment/mobileRegister.action";
    private String patient_phone = null;
    private String patient_pwd  =null;
    private String uri  = null;
    private EditText reg_phoneNum,reg_pwd;
    private PatientBaseInfo patientBaseInfo;

    public RegisterDispose(Context context){this.context=context;}

    public void login(final Handler handler) {
        init(context);
        uri= baseUrl+"?patientBaseInfo.patient_phone="+patient_phone+"&patientBaseInfo.patient_pwd="+patient_pwd;
        HttpUtil.sendHttpRequest(uri, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                patientBaseInfo=jsonDispose(response);
                Message msg = new Message();
                msg.arg1 = 111;
                msg.obj = patientBaseInfo;
                handler.sendMessage(msg);
                Log.i("onFinishReturn",patientBaseInfo.getPatient_name());

            }

            @Override
            public void onError(Exception e) {
                Log.i("ss","failed");
            }
        });

    }

    private PatientBaseInfo jsonDispose(String response) {
        JSONObject jsonObject = null;
        try{

            JSONArray ja = new JSONArray("["+response+"]");//[]作用是变成数组，不然无法转换！！！！

            jsonObject =ja.getJSONObject(0);
            Log.i("jo1",jsonObject.toString());
            String dataMap = jsonObject.getString("dataMap");
            Log.i("dataMap",dataMap);
            JSONArray dataMapArray = new JSONArray("["+dataMap+"]");

            JSONObject jo2 = dataMapArray.getJSONObject(0);
            String success = jo2.getString("success");
            String patientBaseInfoStr = jo2.getString("patientBaseInfo");
            JSONArray patientBaseInfoArray = new JSONArray("[" + patientBaseInfoStr + "]");
            JSONObject jo3 = patientBaseInfoArray.getJSONObject(0);
            patientBaseInfo = new PatientBaseInfo();

            patientBaseInfo.setID(jo3.getInt("ID"));
            patientBaseInfo.setPatient_ID(jo3.getString("patient_ID"));
            patientBaseInfo.setPatient_ID_card(jo3.getString("patient_ID_card"));
            patientBaseInfo.setPatient_address(jo3.getString("patient_address"));


            patientBaseInfo.setPatient_name(jo3.getString("patient_name"));
            patientBaseInfo.setPatient_phone(jo3.getString("patient_phone"));
            patientBaseInfo.setPatient_photo(jo3.getString("patient_photo"));
            patientBaseInfo.setPatient_pwd(jo3.getString("patient_pwd"));
            patientBaseInfo.setPatient_sex(jo3.getInt("patient_sex"));
            switch (success) {
                case "true":
                    //string to java.sql.date 类型转换
                    String str = jo3.getString("patient_birthday");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date d = null;
                    d = format.parse(str);
                    patientBaseInfo.setPatient_birthday(new Date(d.getTime()));
                    patientBaseInfo.setPatient_login_state(true);

                    break;
                case "false":
                    patientBaseInfo.setPatient_birthday(null);
                    patientBaseInfo.setPatient_login_state(false);
                    break;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return patientBaseInfo;
    }

    private void init(Context context) {
        Activity activity = (Activity) context;
        reg_phoneNum = (EditText) activity.findViewById(R.id.reg_phoneNum);
        reg_pwd = (EditText) activity.findViewById(R.id.reg_pwd);
        patient_phone = reg_phoneNum.getText().toString();
        patient_pwd   = reg_pwd.getText().toString();
    }
}
