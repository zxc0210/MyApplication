package com.example.myapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        final Bundle bundle1 = this.getIntent().getExtras();
        TextView grade_data = findViewById(R.id.grade_data);
        TextView evaluation = findViewById(R.id.evaluation);
        TextView BMI_report = findViewById(R.id.BMI_report);
        TextView metabolism_report = findViewById(R.id.metabolism_report);
        TextView height_report = findViewById(R.id.height_report);

        String str1 = bundle1.getString("key1");
        String str2 = bundle1.getString("key2");
        String str3 = bundle1.getString("key3");
        String str4 = bundle1.getString("key4");

        int grade_score = Integer.parseInt(str1);
        float BMI_data = Float.parseFloat(str2);
        int metabolism_data = Integer.parseInt(str3);

        grade_data.setText(grade_score + "分");
        if (grade_score >= 85) evaluation.setText("恭喜你!");
        else if (grade_score < 70) evaluation.setText("继续加油");
        else evaluation.setText("再接再厉!");

        if ((10 <= BMI_data) && (BMI_data <= 18.5)) {
            BMI_report.setText("你太瘦了,不要为苗条而影响健康;");
        } else if ((18.5 < BMI_data) && (BMI_data <= 24)) {
            BMI_report.setText("体形不错,继续保持;");
        } else if ((24 < BMI_data) && (BMI_data <= 28)) {
            BMI_report.setText("平时要注意加强锻炼;");
        } else { BMI_report.setText("饮食注意油脂,多进行有氧运动;"); }

        switch (str4){
            case"男":{
                if (metabolism_data<1300) metabolism_report.setText("你的代谢太慢了,注意多走动,多补充睡眠。");
            else if (metabolism_data>1900) metabolism_report.setText("代谢较快,平时注意补充能量。");
            else metabolism_report.setText("代谢正常,说明你的生活有规律,继续保持。");
            }
            case"女":{
                if (metabolism_data<1100) metabolism_report.setText("你的代谢太慢了,注意多走动,多补充睡眠。");
            else if (metabolism_data>1500) metabolism_report.setText("代谢较快,平时注意补充能量。");
            else metabolism_report.setText("代谢正常,说明你的生活有规律,继续保持。");
            }
        }

        }
    }
