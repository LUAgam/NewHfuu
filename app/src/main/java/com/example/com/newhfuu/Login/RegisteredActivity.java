package com.example.com.newhfuu.Login;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.com.newhfuu.R;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_registered);
        init();
    }

    private void init() {
        getCode_registered = (TextView) findViewById(R.id.getCode_registered);     /*获取验证码textview*/
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
        switch (v.getId()){
            case R.id.getCode_registered:            /*获取验证码事件*/
                break;
            case R.id.textview_agreement:             /*协议链接事件*/
                break;
            case R.id.registered_ok:                    /*完成事件*/
                break;
        }
    }

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
