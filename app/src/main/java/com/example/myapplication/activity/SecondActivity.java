package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activity.util.RegexUtil;

public class SecondActivity extends AppCompatActivity {

    private EditText et_height;
    private EditText et_age;
    private EditText et_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText et_height = findViewById(R.id.et_height);
        final EditText et_age = findViewById(R.id.et_age);
        final EditText et_gender = findViewById(R.id.et_gender);
        final EditText et_weight = findViewById(R.id.et_weight);
        Button bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle bundle = new Bundle();
                String inputText1 = et_height.getText().toString().trim();
                String inputText2 = et_age.getText().toString().trim();
                String inputText3 = et_gender.getText().toString().trim();
                String inputText4 = et_weight.getText().toString().trim();

                if (TextUtils.isEmpty(inputText1)) {
                    Toast.makeText(SecondActivity.this, "请输入你的身高", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Integer.parseInt(inputText1)>250||Integer.parseInt(inputText1)<20){
                    Toast.makeText(SecondActivity.this, "请输入真实身高", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputText2)) {
                    Toast.makeText(SecondActivity.this, "请输入你的年龄", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Integer.parseInt(inputText2)>150||Integer.parseInt(inputText2)<1){
                    Toast.makeText(SecondActivity.this, "请输入真实年龄", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputText3)) {
                    Toast.makeText(SecondActivity.this, "请输入你的性别", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!inputText3.equals("男") && !inputText3.equals("女")) {
                    Toast.makeText(SecondActivity.this, "请输入真实性别", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputText4)) {
                    Toast.makeText(SecondActivity.this, "请输入你的体重", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!RegexUtil.isFloat(inputText4)) {
                    Toast.makeText(SecondActivity.this, "请按提示输入真实体重", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Integer.parseInt(inputText4)>150||Integer.parseInt(inputText4)<1){
                    Toast.makeText(SecondActivity.this, "请输入你的体重", Toast.LENGTH_SHORT).show();
                    return;
                }
                bundle.putString("inputText1", inputText1);
                bundle.putString("inputText2", inputText2);
                bundle.putString("inputText3", inputText3);
                bundle.putString("inputText4", inputText4);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
