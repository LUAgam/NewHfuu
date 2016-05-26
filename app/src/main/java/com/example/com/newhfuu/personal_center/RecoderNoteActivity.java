package com.example.com.newhfuu.personal_center;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.com.newhfuu.R;

public class RecoderNoteActivity extends AppCompatActivity {


    private TextView note_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.content_recoder_note);

        init();
    }

    private void init() {
        note_text = (TextView) findViewById(R.id.note_text);
        note_text.setText("1、请在就诊日的预约时间段内提前30分钟前往医院现场区号。");
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

}
