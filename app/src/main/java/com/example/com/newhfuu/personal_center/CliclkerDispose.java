package com.example.com.newhfuu.personal_center;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by woshi on 2016/5/12.
 * 处理popupWindow点击按钮后的后台操作
 */
public class CliclkerDispose {
    /* 头像文件 */
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";

    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;

    // 裁剪后图片的宽(X)和高(Y),480 X 480的正方形。
    private static int output_X = 150;
    private static int output_Y = 150;

    private ImageView headImage = null;
    private Intent imageToHeadView;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    public CliclkerDispose(String title, Context context, String b) {

    switch (title){
        case "头像":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();

            switch (b){
                    case "本地相册":
                        choseHeadImageFromGallery(context);
                        break;
                    case  "拍照":
                        choseHeadImageFromCameraCapture(context);
                        break;
                    default:
                        break;
                }
            break;
        case "姓名":
            Toast.makeText(context,"输入了 "+b,Toast.LENGTH_SHORT).show();
            break;
        case "职业":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "性别":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "血型":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
        case "婚姻状况":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
        case "生日":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "证件号":
            Toast.makeText(context,"证件号 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "手机号码":
            Toast.makeText(context,"手机号码 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "社保卡":
            Toast.makeText(context,"社保卡 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "居住地":
            Toast.makeText(context,"居住地 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;

    }
    }


//从图库选取
    private void choseHeadImageFromGallery(Context context) {
        Activity activity = (Activity) context;
        //// FIXME: 2016/5/22 注释代码无法用于6.0
//        Intent intentFromGallery = new Intent();
//        // 设置文件类型
//        intentFromGallery.setType("image/*");
//
//        intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
//
//        intentFromGallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");    注释部分6.0报错  下面的不报错
        Intent intentFromGallery = new Intent(Intent.ACTION_PICK, null);
        // 如果朋友们要限制上传到服务器的图片类型时可以直接写如：image/jpeg 、 image/png等的类型
        intentFromGallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    //从相机获取图片
    public void choseHeadImageFromCameraCapture(Context context) {
        Activity activity = (Activity) context;
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else
        {
          activity = (Activity) context;

        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 判断存储卡是否可用，存储照片文件
        if (hasSdcard()) {
            Log.i("sdAfter","here");
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                    .fromFile(new File(Environment
                            .getExternalStorageDirectory(), IMAGE_FILE_NAME)));
        }

        activity.startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }}
//存储检查
    public boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            Log.i("sdT","you");
            return true;
        } else {
            Log.i("sdF","wu");
            return false;
        }
    }
// 剪裁从相册选取或拍照的相片
    public void cropRawPhoto(Uri uri,Activity activity) {
Log.i("after","进入剪裁");
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        Toast.makeText(activity,uri.toString(),Toast.LENGTH_SHORT).show();
        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        activity.startActivityForResult(intent, CODE_RESULT_REQUEST);

    }
//      设置crop后的头像
    public void setImageToHeadView(Intent intent,Context context) {
        Bundle extras = intent.getExtras();
        Activity activity = (Activity) context;
        headImage = (ImageView) activity.findViewById(R.id.account_iv_photo);
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            headImage.setImageBitmap(photo);
            saveBitmap(photo);
        }
    }
//     保存图片 便于本地加载
    public void saveBitmap(Bitmap bitmap) {
        Log.e("TAG", "保存图片");
        File f = new File(Environment
                .getExternalStorageDirectory(), IMAGE_FILE_NAME);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            Log.i("TAG", "已经保存");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
