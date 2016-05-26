package com.example.com.newhfuu.Login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import Util.TimeButton;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import daoImpl.RegisterDispose;
import entity.PatientBaseInfo;

/**
 * 注册功能：
 */
public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView getCode_registered,textview_agreement;
    private Button registered_okBtn;
    private EditText reg_phoneNum,reg_code,reg_pwd;
    private CheckBox reg_checkBox;
    String phoneEditText,codeEditText,pwdEditText;
    boolean isCheckD;
    RegisterDispose registerDispose = new RegisterDispose(this);
    PatientBaseInfo patientBaseInfo;
    EventHandler eh;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1){
                case 111:
                    patientBaseInfo = (PatientBaseInfo) msg.obj;
                    System.out.println(patientBaseInfo.getPatient_phone());
                   // SMSSDK.unregisterEventHandler(eh);
                  //  registerAction(patientBaseInfo);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_registered);
        init();
    }

    private void init() {
        getCode_registered = (TimeButton) findViewById(R.id.getCode_registered);     /*获取验证码textview*/
        textview_agreement = (TextView) findViewById(R.id.textview_agreement);      /*协议的链接*/
        registered_okBtn = (Button) findViewById(R.id.registered_ok);           /*完成按钮*/
        reg_phoneNum = (EditText) findViewById(R.id.reg_phoneNum);             /*手机号码输入框*/
        reg_code = (EditText) findViewById(R.id.reg_code);                      /*验证码输入框*/
        reg_pwd = (EditText) findViewById(R.id.reg_pwd);                       /* 密码输入框*/
        reg_checkBox = (CheckBox) findViewById(R.id.reg_checkBox);          /*我同意checkbox*/

        getCode_registered.setOnClickListener(this);
        textview_agreement.setOnClickListener(this);
        registered_okBtn.setOnClickListener(this);
        reg_phoneNum.addTextChangedListener(new TextWatcherUser());        /*为输入框添加事件*/
        reg_code.addTextChangedListener(new TextWatcherUser());
        reg_pwd.addTextChangedListener(new TextWatcherUser());
        reg_checkBox.setOnCheckedChangeListener(new CheckChangeListener());
        registered_okBtn.setEnabled(false);                         /*完成按钮默认为不可点击*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:

                this.finish();
                //overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return true;
            default:
                return super.onOptionsItemSelected(item);}
    }

    @Override
    public void onClick(View v) {
        initGetCodeAndDispose();
        phoneEditText = reg_phoneNum.getText().toString().trim();
        codeEditText = reg_code.getText().toString().trim();
        String country ="86";
        switch (v.getId()){
            case R.id.getCode_registered:            /*获取验证码事件*/
                SMSSDK.getVerificationCode(country,phoneEditText);
                break;
            case R.id.textview_agreement:             /*协议链接事件*/
                break;
            case R.id.registered_ok:
                SMSSDK.submitVerificationCode(country, phoneEditText,codeEditText);/*完成事件*/
                break;
        }
    }

    private void initGetCodeAndDispose() {
        SMSSDK.initSDK(this,"132b58c1cad84","62203241070c26c1c316a20200e17807");
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        Log.i("提交验证码成功","提交验证码成功");
                        // TODO: 2016/5/25 连接服务器 服务器写入数据库
                        //提交验证码成功
                        registerDispose.login(handler);

                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        Log.i("获取验证码成功","获取验证码成功");
                        //Toast toast = Toast.makeText(getApplicationContext(),"验证码已发送，请注意查收！", Toast.LENGTH_SHORT);
                        if((boolean)data){
                          //  reg_code.setText("已通过验证");
                        }
                        //获取验证码成功
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                        String x = String.valueOf(data);
                        Log.e("c",x);
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调

    }

/*
    private void getCodeDispose() {

        //SMSSDK.initSDK(this, "132b58c1cad84", "62203241070c26c1c316a20200e17807");


    }
*/

    private class TextWatcherUser implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                validation();
        }
    }
    private void validation() {                                             /*输入框事件：若都不空时，按钮可操作*/
        phoneEditText = reg_phoneNum.getText().toString().trim();
        codeEditText = reg_code.getText().toString().trim();
        pwdEditText = reg_pwd.getText().toString().trim();
        if (!phoneEditText.equals("") && !pwdEditText.equals("") && !codeEditText.equals("") && isCheckD){
            registered_okBtn.setBackgroundColor(getResources().getColor(R.color.green));
            registered_okBtn.setEnabled(true);
        }else{
            registered_okBtn.setBackgroundColor(getResources().getColor(R.color.gray2));
            registered_okBtn.setEnabled(false);
        }
    }

    private class CheckChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            isCheckD = isChecked;
            validation();
        }
    }
}
