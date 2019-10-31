package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.DecimalFormat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final Bundle bundle = this.getIntent().getExtras();
        double a1, a2, a3, a4, a5, a6, a7, b1, b2, b3, b4, b5, b6, b7, BMI, water_rate = 0, muscle = 0, bone, metabolism = 0;
        int BMI_score = 0, fat_score = 0, muscle_score = 0, water_score = 0, bone_score = 0, metabolism_score = 0, c = 0, grade, body_fat_rate;

        TextView tv_gender = findViewById(R.id.tv_gender);
        TextView tv_height_show = findViewById(R.id.tv_height_show);
        TextView tv_height_grade = findViewById(R.id.tv_height_grade);
        TextView tv_weight_show = findViewById(R.id.tv_weight_show);
        TextView tv_weight_grade = findViewById(R.id.tv_weight_grade);
        TextView tv_BMI_show = findViewById(R.id.tv_BMI_show);
        TextView tv_BMI_grade = findViewById(R.id.tv_BMI_grade);
        TextView tv_fat_rate = findViewById(R.id.tv_fat_rate);
        TextView tv_fat_grade = findViewById(R.id.tv_fat_grade);
        TextView tv_water_rate = findViewById(R.id.tv_water_rate);
        TextView tv_water_grade = findViewById(R.id.tv_water_grade);
        TextView tv_muscle_show = findViewById(R.id.tv_muscle_show);
        TextView tv_muscle_grade = findViewById(R.id.tv_muscle_grade);
        TextView tv_bone_show = findViewById(R.id.tv_bone_show);
        TextView tv_bone_grade = findViewById(R.id.tv_bone_grade);
        TextView tv_metabolism_show = findViewById(R.id.tv_metabolism_show);
        TextView tv_metabolism_grade = findViewById(R.id.tv_metabolism_grade);
        TextView Grade = findViewById(R.id.Grade);
        TextView rank = findViewById(R.id.rank);
        Button bt_health_report = findViewById(R.id.bt_health_report);

        String St_height = bundle.getString("inputText1");
        String St_age = bundle.getString("inputText2");
        final String gender = bundle.getString("inputText3");
        String St_weight = bundle.getString("inputText4");
        int height = Integer.parseInt(St_height);
        int age = Integer.parseInt(St_age);
        float weight = Integer.parseInt(St_weight);

        a1 = (height - 80) * 0.7 * 0.9;
        a2 = (height - 80) * 0.7 * 1.1;
        a3 = (height - 80) * 0.7 * 1.1;
        a4 = (height - 80) * 0.7 * 1.2;
        a5 = (height - 80) * 0.7 * 0.8;
        a6 = (height - 80) * 0.7 * 0.9;
        a7 = (height - 80) * 0.7 * 0.8;
        b1 = (height - 70) * 0.6 * 0.9;
        b2 = (height - 70) * 0.6 * 1.1;
        b3 = (height - 70) * 0.6 * 1.1;
        b4 = (height - 70) * 0.6 * 1.2;
        b5 = (height - 70) * 0.6 * 0.8;
        b6 = (height - 70) * 0.6 * 0.9;
        b7 = (height - 70) * 0.6 * 0.8;
        BMI = (weight / (height * 0.01 * height * 0.01));
        bone = (weight - age) * 0.2;
        switch (gender) {
            case "男": {
                c = 1;
                muscle = 100 * 39 / weight;
                water_rate = muscle * 1.2;
                metabolism = (13.7 * weight) + (5.0 * height) - (6.8 * age) + 66;
                new DecimalFormat("#.#").format(water_rate);
                new DecimalFormat("#.#").format(muscle);
                tv_muscle_show.setText(muscle +"%");
                tv_water_rate.setText(water_rate +"%");
                tv_metabolism_show.setText(metabolism + "");
            }
            break;
            case "女": {
                c = 0;
                muscle = 100 * 28 / weight;
                water_rate = muscle * 1.3;
                metabolism = (9.6 * weight) + (1.8 * height) - (4.7 * age) + 655;
                new DecimalFormat("#.#").format(water_rate);
                new DecimalFormat("#.#").format(muscle);
                tv_muscle_show.setText(muscle + "%");
                tv_water_rate.setText(water_rate +"%");
                tv_metabolism_show.setText(metabolism + "");
            }
        }
        body_fat_rate = (int) (1.2 * BMI + 0.23 * age - 5.4 - 10.8 * c);
        new DecimalFormat("#.#").format(weight);
        new DecimalFormat("#.#").format(body_fat_rate);
        new DecimalFormat("#.#").format(bone);
        new DecimalFormat("#.#").format(BMI);
        tv_gender.setText(gender);
        tv_height_show.setText(height + "cm");
        tv_weight_show.setText(weight + "kg");
        tv_BMI_show.setText(BMI + "");
        tv_fat_rate.setText(body_fat_rate + "%");
        tv_bone_show.setText(bone + "");
        if ((10 <= BMI) && (BMI <= 18.5)) {
            BMI_score = 75;
            tv_BMI_grade.setText("过轻");
        } else if ((18.5 < BMI) && (BMI <= 24)) {
            BMI_score = 100;
            tv_BMI_grade.setText("正常");
        } else if ((24 < BMI) && (BMI <= 28)) {
            BMI_score = 80;
            tv_BMI_grade.setText("超重");
        } else {
            BMI_score = 60;
            tv_BMI_grade.setText("肥胖");
        }

        if (water_rate < 70) {
            water_score = 70;
            tv_water_grade.setText("偏低");
        } else if ((70 < water_rate) && (water_rate <= 80)) {
            water_score = 100;
            tv_water_grade.setText("正常");
        } else {
            water_score = 70;
            tv_water_grade.setText("偏高");
        }

        if (bone < -4) {
            bone_score = 50;
            tv_bone_grade.setText("风险高");
        } else if ((-4 <= bone) && (bone <= -1)) {
            bone_score = 70;
            tv_bone_grade.setText("中度风险");
        } else {
            bone_score = 100;
            tv_bone_grade.setText("风险低");
        }

        switch (gender) {
            case "男":
                if (height >= 160) tv_height_grade.setText("标准");
                else tv_height_grade.setText("偏低");
                if ((weight >= a1) && (weight < a2)) tv_weight_grade.setText("正常");
                else if ((weight >= a3) && (weight < a4)) tv_weight_grade.setText("偏重");
                else if ((weight >= a5) && (weight < a6)) tv_weight_grade.setText("偏轻");
                else if (weight < a7) tv_weight_grade.setText("营养不良");
                else tv_weight_grade.setText("肥胖");
                if ((8 < body_fat_rate) && (body_fat_rate <= 15)) {
                    fat_score = 70;
                    tv_fat_grade.setText("过瘦");
                } else if ((15 < body_fat_rate) && (body_fat_rate <= 25)) {
                    fat_score = 100;
                    tv_fat_grade.setText("正常");
                } else {
                    fat_score = 70;
                    tv_fat_grade.setText("超重");
                }

                if (60 >= muscle) {
                    muscle_score = 60;
                    tv_muscle_grade.setText("偏低");
                } else if ((60 < muscle) && (muscle <= 65)) {
                    muscle_score = 80;
                    tv_muscle_grade.setText("正常");
                } else {
                    muscle_score = 100;
                    tv_muscle_grade.setText("优秀");
                }

                if (metabolism < 1300) {
                    metabolism_score = 70;
                    tv_metabolism_grade.setText("偏低");
                } else if ((1300 <= metabolism) && (metabolism <= 1900)) {
                    metabolism_score = 100;
                    tv_metabolism_grade.setText("正常");
                } else {
                    metabolism_score = 70;
                    tv_metabolism_grade.setText("偏高");
                }
                break;

            case "女":
                if (height >= 150) tv_height_grade.setText("标准");
                else tv_height_grade.setText("偏低");
                if (weight > b1 && weight < b2) tv_weight_grade.setText("正常");
                else if (weight >= b3 && weight < b4) tv_weight_grade.setText("偏重");
                else if (weight >= b5 && weight < b6) tv_weight_grade.setText("偏轻");
                else if (weight < b7) tv_weight_grade.setText("营养不良");
                else tv_weight_grade.setText("肥胖");
                if ((10 < body_fat_rate) && (body_fat_rate <= 20)) {
                    fat_score = 70;
                    tv_fat_grade.setText("过瘦");
                } else if ((20 < body_fat_rate) && (body_fat_rate <= 30)) {
                    fat_score = 100;
                    tv_fat_grade.setText("正常");
                } else {
                    fat_score = 70;
                    tv_fat_grade.setText("超重");
                }

                if (55 < muscle) {
                    muscle_score = 60;
                    tv_muscle_grade.setText("偏低");
                } else if ((55 < muscle) && (muscle <= 60)) {
                    muscle_score = 80;
                    tv_muscle_grade.setText("正常");
                } else {
                    muscle_score = 100;
                    tv_muscle_grade.setText("优秀");
                }

                if (metabolism < 1100) {
                    metabolism_score = 70;
                    tv_metabolism_grade.setText("偏低");
                } else if ((1100 <= metabolism) && (metabolism <= 1500)) {
                    metabolism_score = 100;
                    tv_metabolism_grade.setText("正常");
                } else {
                    metabolism_score = 70;
                    tv_metabolism_grade.setText("偏高");
                }

        }

        grade = (int) ((BMI_score * 0.5) + (fat_score * 0.1) + (water_score * 0.1) + (muscle_score * 0.1) + (bone_score * 0.1) + (metabolism_score * 0.1));
        Grade.setText(grade + "");
        if (grade >= 85) rank.setText("优秀");
        else if (grade < 85 && grade >= 70) rank.setText("良好");
        else rank.setText("较差");

        final TextView data1 = findViewById(R.id.Grade);
        final TextView data2=findViewById(R.id.tv_BMI_show);
        final TextView data3=findViewById(R.id.tv_metabolism_show);
        final TextView data4=findViewById(R.id.tv_gender);
        bt_health_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, ReportActivity.class);
                Bundle bundle1 = new Bundle();
                String key1 = data1.getText().toString();
                String key2 = data2.getText().toString();
                String key3 = data3.getText().toString();
                String key4 = data4.getText().toString();
                bundle1.putString("key1",key1);
                bundle1.putString("key2",key2);
                bundle1.putString("key3",key3);
                bundle1.putString("key4",key4);
                intent.putExtras(bundle1);
                startActivity(intent);

            }
        });
    }
}
