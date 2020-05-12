package com.example.buttontap20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class LevelStructurRight extends AppCompatActivity {
    Intent i;
Button LvL1,LvL2,LvL3,LvL4,LvL5,LvL6,LvL7,LvL8,LvL9,LvL10,LvL11,LvL12,LvL13;
public int ModLvL,Length,Life,TimeOver,Length2,Length3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level_structur_right);

        LvL1 = (Button)findViewById(R.id.LvL1);
        LvL2 = (Button)findViewById(R.id.LvL2);
        LvL3 = (Button)findViewById(R.id.LvL3);
        LvL4 = (Button)findViewById(R.id.LvL4);
        LvL5 = (Button)findViewById(R.id.LvL5);
        LvL6 = (Button)findViewById(R.id.LvL6);
        LvL7 = (Button)findViewById(R.id.LvL7);
        LvL8 = (Button)findViewById(R.id.LvL8);
        LvL9 = (Button)findViewById(R.id.LvL9);
        LvL10 = (Button)findViewById(R.id.LvL10);
        LvL11 = (Button)findViewById(R.id.LvL11);
        LvL12 = (Button)findViewById(R.id.LvL12);
        LvL13 = (Button)findViewById(R.id.LvL13);



        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.LvL1:
                       // if(ColorButton==1){
                        //    BVE.setBackgroundColor(Color.BLUE);
                       // }
                        i = new Intent(LevelStructurRight.this, LevelVariaty1.class);
                       Life=0;
                      Length=1;//начальное количество кнопок
                      TimeOver=7;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL2: i = new Intent(LevelStructurRight.this, LevelVariaty1.class);
                       // if(ColorButton==2){
                       //     BE.setBackgroundColor(Color.BLUE);
                       // }
                        Life=1;
                        Length=3;//начальное количество кнопок
                        TimeOver=15;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL3: i = new Intent(LevelStructurRight.this, LevelVariaty1.class);
                        Life=1;
                        Length=4;//начальное количество кнопок
                        TimeOver=22;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL4:
                        i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=1;
                        Length=3;//начальное количество кнопок
                        TimeOver=18;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL5: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=2;
                        Length=4;//начальное количество кнопок
                        TimeOver=22;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL6: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=2;
                        Length=5;//начальное количество кнопок
                        TimeOver=24;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL7: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=2;
                        Length=6;//начальное количество кнопок
                        TimeOver=24;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL8: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=3;
                        Length=7;//начальное количество кнопок
                        TimeOver=27;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL9: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=3;
                        Length=7;//начальное количество кнопок
                        TimeOver=22;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL10: i = new Intent(LevelStructurRight.this, LevelVariaty1N5.class);
                        Life=4;
                        Length=9;//начальное количество кнопок
                        TimeOver=26;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;

                    case R.id.LvL11: i = new Intent(LevelStructurRight.this, LevelVariaty2.class);
                        Life=3;
                        Length=10;//начальное количество кнопок
                        TimeOver=24;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;

                    case R.id.LvL12: i = new Intent(LevelStructurRight.this, LevelVariaty2.class);
                        Life=3;
                        Length=12;//начальное количество кнопок
                        TimeOver=35;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;
                    case R.id.LvL13:
                        i = new Intent(LevelStructurRight.this, LevelVariaty2.class);
                        Life=1;
                        Length=13;//начальное количество кнопок
                        TimeOver=30;
                        i.putExtra("UpArLength",Integer.valueOf(Length));
                        i.putExtra("UpLife",Integer.valueOf(Life));
                        i.putExtra("UpTimeOver",Integer.valueOf(TimeOver));
                        startActivity(i); break;

                    default:

                }
            }
        };
       LvL1.setOnClickListener(listener);
        LvL2.setOnClickListener(listener);
        LvL3.setOnClickListener(listener);
        LvL4.setOnClickListener(listener);
        LvL5.setOnClickListener(listener);
        LvL6.setOnClickListener(listener);
        LvL7.setOnClickListener(listener);
        LvL8.setOnClickListener(listener);
        LvL9.setOnClickListener(listener);
        LvL10.setOnClickListener(listener);
        LvL11.setOnClickListener(listener);
        LvL12.setOnClickListener(listener);
        LvL13.setOnClickListener(listener);
    }
}
