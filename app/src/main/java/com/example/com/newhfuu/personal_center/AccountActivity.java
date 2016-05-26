package com.example.com.newhfuu.personal_center;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import java.io.File;

public class AccountActivity extends AppCompatActivity {
    LinearLayout account_photo, account_name, account_sex, account_IDtype, account_IDnum, account_mobile,
            account_bloodtype, account_marriage, account_occupation, account_birth, account_SIN,account_where;
    ImageView account_iv_photo;
    AccountClicker ac;
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    /* 头像文件 */
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";
    CliclkerDispose c = new CliclkerDispose("1",this,"1");
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头

        setContentView(R.layout.activity_personal_center_account);
        init();
        clicker();
//        getSupportActionBar().hide();

    }

    private void clicker() {
        account_name.setOnClickListener(ac);
        account_photo.setOnClickListener(ac);
       account_birth.setOnClickListener(ac);
        account_sex.setOnClickListener(ac);
        account_bloodtype.setOnClickListener(ac);
        account_IDnum.setOnClickListener(ac);
        account_mobile.setOnClickListener(ac);
        account_where.setOnClickListener(ac);
        account_SIN.setOnClickListener(ac);
        account_marriage.setOnClickListener(ac);
        account_occupation.setOnClickListener(ac);
    }

    private void init() {
        /*Context context = getBaseContext();*/
        // TODO: 2016/5/22    初始化控件
        ac = new AccountClicker(this);
        account_photo = (LinearLayout) findViewById(R.id.account_photo);
        account_name = (LinearLayout) findViewById(R.id.account_name);
        account_sex = (LinearLayout) findViewById(R.id.account_sex);
        account_IDtype = (LinearLayout) findViewById(R.id.account_IDtype);
        account_IDnum = (LinearLayout) findViewById(R.id.account_IDnum);
        account_mobile = (LinearLayout) findViewById(R.id.account_mobile);
        account_bloodtype = (LinearLayout) findViewById(R.id.account_bloodtype);
        account_marriage = (LinearLayout) findViewById(R.id.account_marriage);
        account_occupation = (LinearLayout) findViewById(R.id.account_occupation);
        account_birth = (LinearLayout) findViewById(R.id.account_birth);
        account_SIN = (LinearLayout) findViewById(R.id.account_SIN);
        account_where = (LinearLayout) findViewById(R.id.account_where);
        account_iv_photo = (ImageView) findViewById(R.id.account_iv_photo);
        // TODO: 2016/5/22  初始化控件数据获取
        boolean fe;
        fe =fileIsExists();
        if(fe==true){
            Bitmap bitmap = BitmapFactory.decodeFile(Environment
                    .getExternalStorageDirectory()+"/temp_head_image.jpg");
            account_iv_photo.setImageBitmap(bitmap);
            Log.i("f","cunzai");
        }
        Log.i("f","buzai");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_account, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //判断文件是否存在
    public boolean fileIsExists(){
        try{
            File f=new File(Environment
                    .getExternalStorageDirectory(),"temp_head_image.jpg");
            if(!f.exists()){
                return false;
            }

        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account_save:
                /*Intent intent = new Intent(AccountActivity.this,TestActivity.class);
                startActivity(intent);*/
                return true;
            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                c.cropRawPhoto(intent.getData(), this);
                break;

            case CODE_CAMERA_REQUEST:
                if (c.hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    c.cropRawPhoto(Uri.fromFile(tempFile),this);
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }

                break;

            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    c.setImageToHeadView(intent,this);
                }

                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                c.choseHeadImageFromCameraCapture(this);
            } else
            {
                // Permission Denied
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
