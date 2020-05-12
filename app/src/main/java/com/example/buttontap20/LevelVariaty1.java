package com.example.buttontap20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;

import android.view.View;

import android.view.Window;
import android.widget.Button;

import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;
import static android.hardware.camera2.params.RggbChannelVector.BLUE;
import static java.lang.Thread.sleep;


public class LevelVariaty1 extends AppCompatActivity {
    Button LDB, RDB, LUB, RUB,EndStelth;
    TextView Info, Time,SequenceNum;
    Intent intent,i1;
    public int ArLength,Fsh,EndTime,Fsh1,ButNum, TimeOver,ALP,Uper,TimeOverPub, Life,LDBi,RDBi,LUBi,RUBi,MillisSec,MillisSecScore, n, ModLvLd;
    public String TextPut,EndToast,SomeInfo;

    public int ar[];
    public int arButs[];
    public int arW[];

    public int arS[];
    public int arWS[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_variaty1);
        intent = getIntent();
        ArLength = intent.getExtras().getInt("UpArLength");
        TimeOver = intent.getExtras().getInt("UpTimeOver");
        Life = intent.getExtras().getInt("UpLife");
        Uper = 0;Fsh1=ArLength;ButNum=0;SomeInfo=" ";TextPut=" ";
        final int ar[] = new int[ArLength];
        final int arW[] = new int[ArLength];
final int arButs[]={1,2,3,4};
Fsh=1;EndTime=10;Life++;MillisSecScore=0;
/*if(ArLength==1){
    MillisSec=2000;
}else{ MillisSec=1000;}*/
       /* final Thread tTime = new Thread(new Runnable() {
            public void run() {
                Info.setText("Я верю в вас");
                for (int i=TimeOver;i>=0;i--){
                    TextPut=Integer.toString(i);
                    Time.setText(TextPut);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i==1){
                        Reload();
                    }
                }
            }
        });


        final Thread EndNext = new Thread(new Runnable() {
            public void run() {
                while(true){
                    if(Uper+1==arS.length){
                        Info.setText("Хорошо");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);
                        tTime.stop();
                        break;
                    }
                }
            }
        });*/


        arS = ar;
        ALP=0;



        LDB = (Button) findViewById(R.id.LDB);
        RDB = (Button) findViewById(R.id.RDB);
        LUB = (Button) findViewById(R.id.LUB);
        RUB = (Button) findViewById(R.id.RUB);
        EndStelth = (Button) findViewById(R.id.EndStelth);

        Time = (TextView) findViewById(R.id.Time);
        Info = (TextView) findViewById(R.id.Info);
        SequenceNum = (TextView) findViewById(R.id.SequenceNum);

        EndStelth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);
                    startActivity(i1);
                    finish();
                } catch (Exception e) {

                }

            }
        });

           LDB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(Fsh==1){
                        Fsh--;
                        shuffleArray(arButs);
                        for (int t=0;t<arButs.length;t++) {
                            switch (t) {
                                case 0://0
                                    LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                    break;
                                case 1://1
                                    RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                    break;
                                case 2:
                                    LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                    break;
                                case 3://3
                                    RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                    break;

                                default:

                            }
                            // ButNum++;
                        }
                        LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                        RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                        LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                        RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                        //сделай setBackground для всех кнопок
                        //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                        Thread ButOns = new Thread(new Runnable() {
                                    public void run() {
                                        Info.setText("Смотри вниз и запоминай!");

                                        for (int i = 0; i < ar.length; i++) {
                                            ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                            SomeInfo=SomeInfo + ar[i]+" ";
                                            SequenceNum.setText(SomeInfo);

                                            SequenceNum.setTextColor(GREEN);

                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                    }
                                });
                                ButOns.start();
                                final Thread Sequence = new Thread(new Runnable() {
                                    public void run() {
                                        try {
                                            Thread.sleep(ar.length*1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        SequenceNum.setText("");
                                        LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");
                                        SomeInfo="Удачи!";
                                //    LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                                Info.setText(SomeInfo);
                                for (int i=TimeOver;i>=0;i--){
                                    EndTime=i;
                                    TextPut=Integer.toString(i);
                                    Time.setText(TextPut);
                                    if(TimeOver/2<i){
                                        Time.setTextColor(GREEN);
                                    }else{
                                        if(TimeOver/5<i){
                                            Time.setTextColor(Color.parseColor("#ff8800"));
                                        }else{Time.setTextColor(RED);}
                                    }
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                               /* if(Uper==ar.length) {
                                    break;
                                }*/
                                    if (EndTime==0) {
                                        BadEnd();
                                        break;
                                    }
                                    if (Life == 0) {

                                        BadEnd();
                                        break;
                                    }
                                    if(Uper==ar.length) {
                                        GoodEnd();
                                        break;

                                    }
                                   /* if(Uper+1==arS.length){
                                        Info.setText("Хорошо");
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                                    }*/
                                }
                            }
                        });
                        Sequence.start();

                        final Thread Check = new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(ar.length*1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                while(true){
                                    if (EndTime==0) {
                                        BadEnd();
                                        break;
                                    }
                                    if (Life == 0) {

                                        BadEnd();
                                        break;
                                    }
                                    if(Uper==ar.length) {
                                        GoodEnd();
                                        break;

                                    }

                                }
                            }
                        });
                        Check.start();

                    }else {
                        for (int i = Uper; i < ar.length; ) {
                            if (ar[i] == LDBi){

                                new Thread(new Runnable() {
                                    public void run() {
                                        LDB.setBackgroundColor(Color.BLUE);
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        LDB.setBackgroundColor(Color.parseColor("#ff8800"));

                                    }
                                }).start();
                                Uper++;
                            } else {

                                new Thread(new Runnable() {
                                    public void run() {
                                        LDB.setBackgroundColor(RED);
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        LDB.setBackgroundColor(Color.YELLOW);

                                    }
                                }).start();
                                    Life--;

                            }

                            break;
                        }

                    }//}
                }
            });

        RDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                  /*  Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
                  //  LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);
                    Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                Info.setText(SomeInfo);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");

                        //    LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                            for (int i=TimeOver;i>=0;i--){
                                TextPut=TextPut+i+" ";
                                Time.setText(TextPut);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(i==1){
                                    Reload();
                                }
                                if(Uper+1==arS.length){
                                    Info.setText("Хорошо");
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);
break;

                                }
                            }
                        }
                    });
                    Sequence.start();*/
                if(Fsh==1){
                    Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");

                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);

                                SequenceNum.setTextColor(GREEN);

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                    ButOns.start();
                    final Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            SequenceNum.setText("");
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");
                            SomeInfo="Удачи!";
                            //    LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                            Info.setText(SomeInfo);
                            for (int i=TimeOver;i>=0;i--){
                                EndTime=i;
                                TextPut=Integer.toString(i);
                                Time.setText(TextPut);
                                if(TimeOver/2<i){
                                    Time.setTextColor(GREEN);
                                }else{
                                    if(TimeOver/5<i){
                                        Time.setTextColor(Color.parseColor("#ff8800"));
                                    }else{Time.setTextColor(RED);}
                                }
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                               /* if(Uper==ar.length) {
                                    break;
                                }*/
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {

                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                    GoodEnd();
                                    break;

                                }
                                   /* if(Uper+1==arS.length){
                                        Info.setText("Хорошо");
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                                    }*/
                            }
                        }
                    });
                    Sequence.start();

                    final Thread Check = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            while(true){
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {

                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                    GoodEnd();
                                    break;

                                }

                            }
                        }
                    });
                    Check.start();

                }else {
                    for (int i = Uper; i < ar.length; ) {
                        if (ar[i] == RDBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    RDB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));

                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    RDB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    RDB.setBackgroundColor(Color.YELLOW);

                                }
                            }).start();

                                Life--;
                        }

                        break;
                    }

                }//}
            }
        });
        LUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if(Fsh>0){
                    Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
                 //   LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);
                    Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                Info.setText(SomeInfo);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");

                           // LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                            Info.setText("Я верю в вас");
                            for (int i=TimeOver;i>=0;i--){
                                TextPut=TextPut+i+" ";
                                Time.setText(TextPut);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(i==1){
                                    Reload();
                                }
                                if(Uper+1==arS.length){
                                    Info.setText("Хорошо");
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                                }
                            }
                        }
                    });
                    Sequence.start();*/
                if(Fsh==1){
                    Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");

                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);

                                SequenceNum.setTextColor(GREEN);

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                    ButOns.start();
                    final Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            SequenceNum.setText("");
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");
                            SomeInfo="Удачи!";
                            //    LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                            Info.setText(SomeInfo);
                            for (int i=TimeOver;i>=0;i--){
                                EndTime=i;
                                TextPut=Integer.toString(i);
                                Time.setText(TextPut);
                                if(TimeOver/2<i){
                                    Time.setTextColor(GREEN);
                                }else{
                                    if(TimeOver/5<i){
                                        Time.setTextColor(Color.parseColor("#ff8800"));
                                    }else{Time.setTextColor(RED);}
                                }
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                               /* if(Uper==ar.length) {
                                    break;
                                }*/
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {

                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                    GoodEnd();
                                    break;

                                }
                                   /* if(Uper+1==arS.length){
                                        Info.setText("Хорошо");
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                                    }*/
                            }
                        }
                    });
                    Sequence.start();

                    final Thread Check = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            while(true){
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {

                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                    GoodEnd();
                                    break;

                                }

                            }
                        }
                    });
                    Check.start();
                }else {
                    for (int i = Uper; i < ar.length; ) {
                        if (ar[i] == LUBi){
                            if(Life==0){
                                Info.setText("Ты уже проиграл! Поздно!");
                            }
                            new Thread(new Runnable() {
                                public void run() {
                                    LUB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));

                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    LUB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    LUB.setBackgroundColor(Color.YELLOW);

                                }
                            }).start();
                                Life--;
                        }

                        break;
                    }

                }//}
            }
        });

        RUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if(Fsh>0){
                    Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                       // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
//LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);
                    Thread Shower = new Thread(new Runnable() {
                        public void run() {
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo = SomeInfo + ar[i] + " ";
                                Info.setText(SomeInfo);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");
                            Info.setText("Я верю в вас");
                        }
                        });Shower.start();

                         //   LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);

                    Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            for (int i = TimeOver; i >= 0; i--) {
                                TextPut = TextPut + i + " ";
                                Time.setText(TextPut);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (i == 1) {
                                    Reload();
                                }
                            }
                        }
                    });
                    Sequence.start();

                    Thread LevelUp = new Thread(new Runnable() {
                        public void run() {

                            if(Uper+1==arS.length){
                                Info.setText("Хорошо");
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                            }
                        }
                    });
                    LevelUp.start();

                       // }
                   // });
                   // Sequence.start();*/
                if(Fsh==1){
                    Fsh--;
                    shuffleArray(arButs);
                    for (int t=0;t<arButs.length;t++) {
                        switch (t) {
                            case 0://0
                                LDB.setText(String.valueOf(arButs[t]));  LDBi=arButs[t];
                                break;
                            case 1://1
                                RDB.setText(String.valueOf(arButs[t])); RDBi=arButs[t];
                                break;
                            case 2:
                                LUB.setText(String.valueOf(arButs[t])); LUBi=arButs[t];
                                break;
                            case 3://3
                                RUB.setText(String.valueOf(arButs[t])); RUBi=arButs[t];
                                break;

                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");

                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(4) + 1;//[1:4]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);

                                SequenceNum.setTextColor(GREEN);

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                    ButOns.start();
                    final Thread Sequence = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            SequenceNum.setText("");
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");
                            SomeInfo="Удачи!";
                            //    LDB.setEnabled(true);RDB.setEnabled(true);LUB.setEnabled(true);RUB.setEnabled(true);
                            Info.setText(SomeInfo);
                            for (int i=TimeOver;i>=0;i--){
                                EndTime=i;
                                TextPut=Integer.toString(i);
                                Time.setText(TextPut);
                                if(TimeOver/2<i){
                                    Time.setTextColor(GREEN);
                                }else{
                                    if(TimeOver/5<i){
                                        Time.setTextColor(Color.parseColor("#ff8800"));
                                    }else{Time.setTextColor(RED);}
                                }
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                               /* if(Uper==ar.length) {
                                    break;
                                }*/
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {

                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                    GoodEnd();
                                    break;

                                }

                                   /* if(Uper+1==arS.length){
                                        Info.setText("Хорошо");
                                        try {
                                            sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);


                                    }*/
                            }
                        }
                    });
                    Sequence.start();

                    final Thread Check = new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(ar.length*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            while(true){
                                if (EndTime==0) {
                                    BadEnd();
                                    break;
                                }
                                if (Life == 0) {
                                    BadEnd();
                                    break;
                                }
                                if(Uper==ar.length) {
                                   GoodEnd();
                                    break;
                                }

                            }
                        }
                    });
                    Check.start();
                }else {
                    for (int i = Uper; i < ar.length; ) {
                        if (ar[i] == RUBi){
if(Life==0){
    Info.setText("Ты уже проиграл! Поздно!");
}
                        new Thread(new Runnable() {
                            public void run() {
                                RUB.setBackgroundColor(Color.BLUE);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                            }
                        }).start();
                            Uper++;
                    } else {

                        new Thread(new Runnable() {
                            public void run() {
                                RUB.setBackgroundColor(RED);
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                RUB.setBackgroundColor(Color.YELLOW);

                            }
                        }).start();
                            Life--;
                    }

                    break;
                }

                }//}

            }
        });




    }
//i1 = new Intent(LevelVariaty1.this, LevelStructurRight.class);

        //Thread ShowFst = new Thread(new Runnable() {
            //@Override
          //  public void run() {
             /*   switch (arS[0]) {
                    case 0://0

                        LDB.setBackgroundColor(BLACK);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        LDB.setBackgroundColor(WHITE);

                        break;
                    case 1://1

                        RDB.setBackgroundColor(BLACK);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        RDB.setBackgroundColor(WHITE);



                        break;
                    case 2:

                        LUB.setBackgroundColor(BLACK);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        LUB.setBackgroundColor(WHITE);

                        break;
                    case 3://3
                        RUB.setBackgroundColor(BLACK);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        RUB.setBackgroundColor(WHITE);

                        break;

                    default:

                }
       //     }
        //});


}*/

    /*    public void Reload () {
            intent = getIntent();
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            overridePendingTransition(0, 0);
            startActivity(intent);
        }*/
    public void BadEnd () {
        EndStelth.setBackgroundColor(Color.RED);
        Time.setText("");EndToast="Ты проиграл! Выбери уровень проще...";
        Info.setText(EndToast);Info.setTextColor(RED);
    }
    public void GoodEnd () {
        EndStelth.setBackgroundColor(Color.BLUE);
        Time.setText("");//EndToast="Ты выйграл! Выбери уровень сложнее!";
        Info.setText("Ты выйграл! Выбери уровень сложнее!");//Info.setTextColor(BLUE);
    }
    static void shuffleArray(int[] RanAr) {
        Random rnd = new Random();
        for (int i = RanAr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = RanAr[index];
            RanAr[index] = RanAr[i];
            RanAr[i] = a;
        }
    }

    }
