package com.example.buttontap20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;
import static android.hardware.camera2.params.RggbChannelVector.BLUE;
import static java.lang.Thread.sleep;

public class LevelVariaty2 extends AppCompatActivity {

    Button LDB, RDB,MUB,MDB, LUB, RUB,LMB,MMB,RMB,EndStelth;
    TextView Info, Time,SequenceNum;
    Intent intent,i1;
    public int ArLength,EndTime,Fsh1,Fsh,ButNum, TimeOver,Uper,TimeOverPub, Life,LDBi,MDBi,MUBi,RDBi,LUBi,RUBi,LMBi,MMBi,RMBi,MillisSec,MillisSecScore;
    public String TextPut,EndToast,SomeInfo;

    public int ar[];
    public int arButs[];
    public int arW[];

    public int arS[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_variaty2);

        intent = getIntent();
        ArLength = intent.getExtras().getInt("UpArLength");
        TimeOver = intent.getExtras().getInt("UpTimeOver");
        Life = intent.getExtras().getInt("UpLife");
        Uper = 0;Fsh1=ArLength;ButNum=0;SomeInfo=" ";TextPut=" ";
        final int ar[] = new int[ArLength];
        final int arButs[]={1,2,3,4,5,6,7,8,9};
        Fsh=1;EndTime=10;Life++;MillisSecScore=0;

        arS = ar;

        LDB = (Button) findViewById(R.id.LDB);
        RDB = (Button) findViewById(R.id.RDB);
        LUB = (Button) findViewById(R.id.LUB);
        RUB = (Button) findViewById(R.id.RUB);
        MUB = (Button) findViewById(R.id.MUB);
        MDB = (Button) findViewById(R.id.MDB);
        LMB = (Button) findViewById(R.id.LMB);
        MMB = (Button) findViewById(R.id.MMB);
        RMB = (Button) findViewById(R.id.RMB);
        EndStelth = (Button) findViewById(R.id.EndStelth);

        Time = (TextView) findViewById(R.id.Time);
        Info = (TextView) findViewById(R.id.Info);
        SequenceNum = (TextView) findViewById(R.id.SequenceNum);

        EndStelth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    i1 = new Intent(LevelVariaty2.this, LevelStructurRight.class);
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#e976cf"));
                    RUB.setBackgroundColor(Color.parseColor("#fee7a7"));
                    MUB.setBackgroundColor(Color.parseColor("#9b6a8e"));
                    RMB.setBackgroundColor(Color.parseColor("#337afe"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));

                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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

        MDB.setOnClickListener(new View.OnClickListener() {
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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
                        if (ar[i] == MDBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    MDB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));

                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    MDB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    MDB.setBackgroundColor(Color.YELLOW);

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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи.. .";
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

        LMB.setOnClickListener(new View.OnClickListener() {
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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
                        if (ar[i] == LMBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    LMB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));

                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    LMB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    LMB.setBackgroundColor(Color.YELLOW);

                                }
                            }).start();
                            Life--;

                        }

                        break;
                    }

                }//}
            }
        });

        MMB.setOnClickListener(new View.OnClickListener() {
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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
                        if (ar[i] == MMBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    MMB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));

                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    MMB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    MMB.setBackgroundColor(Color.YELLOW);

                                }
                            }).start();
                            Life--;

                        }

                        break;
                    }

                }//}
            }
        });

        RMB.setOnClickListener(new View.OnClickListener() {
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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
                        if (ar[i] == RMBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    RMB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    RMB.setBackgroundColor(Color.parseColor("#337afe"));
                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    RMB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    RMB.setBackgroundColor(Color.YELLOW);

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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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

                            new Thread(new Runnable() {
                                public void run() {
                                    LUB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    LUB.setBackgroundColor(Color.parseColor("#e976cf"));

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

        MUB.setOnClickListener(new View.OnClickListener() {
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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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
                        if (ar[i] == MUBi){

                            new Thread(new Runnable() {
                                public void run() {
                                    MUB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    MUB.setBackgroundColor(Color.parseColor("#9b6a8e"));


                                }
                            }).start();
                            Uper++;
                        } else {

                            new Thread(new Runnable() {
                                public void run() {
                                    MUB.setBackgroundColor(RED);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    MUB.setBackgroundColor(Color.YELLOW);

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
                            case 4://3
                                MUB.setText(String.valueOf(arButs[t])); MUBi=arButs[t];
                                break;
                            case 5://3
                                MDB.setText(String.valueOf(arButs[t])); MDBi=arButs[t];
                                break;
                            case 6://3
                                LMB.setText(String.valueOf(arButs[t])); LMBi=arButs[t];
                                break;
                            case 7://3
                                MMB.setText(String.valueOf(arButs[t])); MMBi=arButs[t];
                                break;
                            case 8://3
                                RMB.setText(String.valueOf(arButs[t])); RMBi=arButs[t];
                                break;
                            default:

                        }
                        // ButNum++;
                    }
                    LDB.setBackgroundColor(Color.parseColor("#ff8800"));
                    RDB.setBackgroundColor(Color.parseColor("#99cc00"));
                    LUB.setBackgroundColor(Color.parseColor("#aa66cc"));
                    RUB.setBackgroundColor(Color.parseColor("#69e7da"));
                    MUB.setBackgroundColor(Color.parseColor("#ab67cc"));
                    MDB.setBackgroundColor(Color.parseColor("#55e0da"));
                    LMB.setBackgroundColor(Color.parseColor("#99e7ba"));
                    MMB.setBackgroundColor(Color.parseColor("#cb57fc"));
                    RMB.setBackgroundColor(Color.parseColor("#88e6dc"));
                    //сделай setBackground для всех кнопок
                    //     LDB.setEnabled(false);RDB.setEnabled(false);LUB.setEnabled(false);RUB.setEnabled(false);

                    Thread ButOns = new Thread(new Runnable() {
                        public void run() {
                            Info.setText("Смотри вниз и запоминай!");
                            for (int i = 0; i < ar.length; i++) {
                                ar[i] = new Random().nextInt(9) + 1;//[1:6]
                                SomeInfo=SomeInfo + ar[i]+" ";
                                SequenceNum.setText(SomeInfo);
                                if(i<ar.length/2){
                                    SequenceNum.setTextColor(GREEN);
                                }else{
                                    if(i<ar.length*0.8){
                                        SequenceNum.setTextColor(Color.parseColor("#ff8800"));
                                    }else{
                                        SequenceNum.setTextColor(RED);
                                    }

                                }
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
                            LDB.setText("");RDB.setText("");LUB.setText("");RUB.setText("");MDB.setText("");MUB.setText("");LMB.setText("");MMB.setText("");RMB.setText("");
                            SomeInfo="Удачи...";
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

                            new Thread(new Runnable() {
                                public void run() {
                                    RUB.setBackgroundColor(Color.BLUE);
                                    try {
                                        sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    RUB.setBackgroundColor(Color.parseColor("#fee7a7"));


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
