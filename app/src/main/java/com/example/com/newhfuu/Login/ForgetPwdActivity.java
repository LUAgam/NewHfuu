package com.example.com.newhfuu.Login;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;
/**
 * 忘记密码功能：获取短信验证码并设置新的密码
 */
public class ForgetPwdActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView getCodeTextView;
    private Button forget_okBtn;
    private EditText forget_phoneNum,forget_code,forget_pwd;
    String phoneEditText,codeEditText,pwdEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);         //显示actionbar上的返回箭头
        setContentView(R.layout.content_forget_pwd);
        init();
    }

    private void init() {
        getCodeTextView = (TextView) findViewById(R.id.getCode);           /*获取验证码textview*/
        forget_okBtn = (Button) findViewById(R.id.forget_ok);               /*完成按钮*/
        forget_phoneNum = (EditText) findViewById(R.id.forget_phoneNum);    /*手机号码输入框*/
        forget_code = (EditText) findViewById(R.id.forget_code);            /*验证码输入框*/
        forget_pwd = (EditText) findViewById(R.id.forget_pwd);             /* 重置密码输入框*/
        getCodeTextView.setOnClickListener(this);
        forget_okBtn.setOnClickListener(this);
        forget_phoneNum.addTextChangedListener(new TextWatcherUser());         /*为手机号码、验证码、密码输入框添加内部类事件*/
        forget_code.addTextChangedListener(new TextWatcherUser());
        forget_pwd.addTextChangedListener(new TextWatcherUser());
        forget_okBtn.setEnabled(false);                     /*初始化按钮为不可点击状态*/
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

    private void validation() {                                             /*输入框事件：若都不空时，按钮可操作*/
        phoneEditText = forget_phoneNum.getText().toString().trim();
        codeEditText = forget_code.getText().toString().trim();
        pwdEditText = forget_pwd.getText().toString().trim();
        if (!phoneEditText.equals("") && !pwdEditText.equals("") && !codeEditText.equals("")){
            forget_okBtn.setBackgroundColor(getResources().getColor(R.color.green));
            forget_okBtn.setEnabled(true);
        }else{
            forget_okBtn.setBackgroundColor(getResources().getColor(R.color.gray2));
            forget_okBtn.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getCode:         /*获取验证码事件*/
                break;
            case R.id.forget_ok:         /*完成事件*/
                Toast.makeText(this,"忘记密码完成",Toast.LENGTH_SHORT).show();
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
}
