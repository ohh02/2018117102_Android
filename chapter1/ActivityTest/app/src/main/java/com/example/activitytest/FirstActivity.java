package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);//第二步
        setContentView(R.layout.first_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"You clicked Button 1",
//                        Toast.LENGTH_SHORT).show();
//                finish();
//                //提示已经按下button 1
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //显式意图
//                Intent intent = new Intent("com.example.activitytest.ACTION START");
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.hstc.edu.cn/"));
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

    }

    /**
     *
     给当前活动创建菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    /**
     *
     定义菜单响应事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
//              Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"You clicked Add and you" +
                        " will enter the second activity.",Toast.LENGTH_LONG).show();
                //提示
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                //测试通过点击Add菜单项进入SecondActivity
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove.",Toast.LENGTH_SHORT).show();
                break;
            default:}
        return true;
    }
}
