package com.example.buttontap20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuRight extends AppCompatActivity {
final int Left=90;
Intent i;
TextView MainText;
Button Levels,Information,Exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu_right);
        Levels = (Button)findViewById(R.id.Levels);
        Information = (Button)findViewById(R.id.Information);
        Exit = (Button)findViewById(R.id.Exit);

       // if(Oi =="Ci"){
          //  Levels.setLayoutDirection(Left);

           // LinearLayout.LayoutParams linnear_lay = new LinearLayout.LayoutParams(250, 450); // высота и ширина
           // linnear_lay.rightMargin = 50; // отступ слева
           // Levels.setLayoutParams(linnear_lay);

           // linnear_lay.leftMargin = 50; // отступ слева
           // LR.setLayoutParams(linnear_lay);
       // }

//Levels.setLayoutParams(new LinearLayout.LayoutParams(171,524,50));
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.Levels:
                        Intent i = new Intent(MainMenuRight.this, LevelStructurRight.class);

                        //i.putExtra("Up",filelist);
                        startActivity(i); break;
                    case R.id.Information: i = new Intent(MainMenuRight.this, FullInformation.class);

                       // i.putExtra("Up",filelist);
                        startActivity(i); break;
                    case R.id.Exit: OnDestroy();
                        //i = new Intent(MainMenuRight.this, LevelVariaty1.class);
                        //int Ri=1;
                       // i.putExtra("Up",filelist);
                      //  startActivity(i);
                        break;

                    default:

                }
            }
        };
        Levels.setOnClickListener(listener);
        Information.setOnClickListener(listener);
        Exit.setOnClickListener(listener);

    }

    private void OnDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }

}
