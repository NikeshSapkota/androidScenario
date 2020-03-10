package com.example.candidatesenario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private EditText txt1, txt2, txt3, txt4, txt5;
    private PopupWindow popupWindow;

    private int seconds = 120;
    private boolean stopTimer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRandom = findViewById(R.id.btn_random);

        timer(); // here code for the timer is set

        txt1 = findViewById(R.id.edt_1);
        txt2 = findViewById(R.id.edt_2);
        txt3 = findViewById(R.id.edt_3);
        txt4 = findViewById(R.id.edt_4);
        txt5 = findViewById(R.id.edt_5);

//        popup_text1 = findViewById(R.id.popup_textView1);
//        TextView popup_text2 = findViewById(R.id.popup_textView2);
//       TextView  popup_text3 = findViewById(R.id.popup_textView3);
//       TextView  popup_text4 = findViewById(R.id.popup_textView4);
//       TextView  popup_text5 = findViewById(R.id.popup_textView5);


        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked();
            }
        }); // ---------end of btnRandomOnCLickListener


//        ------------------------------------------------------------------------------------------------------------


    }

    @SuppressLint("SetTextI18n")
    public void afterFiveSecond() {
//        showPopup();
        String value1 = txt1.getText().toString();
        String value2 = txt2.getText().toString();
        String value3 = txt3.getText().toString();
        String value4 = txt4.getText().toString();
        String value5 = txt5.getText().toString();

        String[] diffValues = {value1, value2, value3, value4, value5};

        // converting string array into a array of integer
        int[] intDiffValues = new int[diffValues.length];


        for (int i = 0; i < intDiffValues.length; i++) {
            intDiffValues[i] = Integer.parseInt(diffValues[i]);

            int modifiedValues;

            if (i == 0) {
                modifiedValues = intDiffValues[i] + 1;
                txt1.setText(Integer.toString(modifiedValues));
                System.out.println(modifiedValues + "the case 0 ");
            } else if (i == 1) {
                modifiedValues = intDiffValues[i] - 1;
                txt2.setText(Integer.toString(modifiedValues));
                System.out.println(modifiedValues + "the case 1 ");
            } else if (i == 2) {
                modifiedValues = intDiffValues[i] + 2;
                txt3.setText(Integer.toString(modifiedValues));
                System.out.println(modifiedValues + "the case 2 ");
            } else if (i == 3) {
                modifiedValues = intDiffValues[i] - 2;
                txt4.setText(Integer.toString(modifiedValues));
                System.out.println(modifiedValues + "the case 3 ");
            } else {
                modifiedValues = intDiffValues[i] + 3;
                txt5.setText(Integer.toString(modifiedValues));
                System.out.println(modifiedValues + "the case 4 ");
            }

            checking();
        }


        Toast.makeText(this, "five second is passed", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(MainActivity.this, Popup.class));

    }

    private void checking() {
        String value1 = txt1.getText().toString();
        String value2 = txt2.getText().toString();
        String value3 = txt3.getText().toString();
        String value4 = txt4.getText().toString();
        String value5 = txt5.getText().toString();

        String[] diffValuescheck = {value1, value2, value3, value4, value5};
        // converting string array into a array of integer
        int[] intDiffValuescheck = new int[diffValuescheck.length];
        for (int i = 0; i < intDiffValuescheck.length; i++) {
            intDiffValuescheck[i] = Integer.parseInt(diffValuescheck[i]);

            int valueNew = intDiffValuescheck[i];
            if ((valueNew < 15) || (valueNew > 35)) {
                showPopup();

                // some null object references
//                int a = i;
//                if (a == 0 && popup_text1.getVisibility() == View.GONE) {
////                    popup_text1.setVisibility(View.VISIBLE);
//                    Log.d("desc", "checking: ok not visible");
//                }
//                else if (a == 1) {
//                    popup_text2.setVisibility(View.VISIBLE);
//                } else if (a == 2) {
//                    popup_text3.setVisibility(View.VISIBLE);
//                } else if (a == 3) {
//                    popup_text4.setVisibility(View.VISIBLE);
//                }
//                 else if (a == 4 && popup_text1.getVisibility() == View.GONE) {
//                    popup_text5.setVisibility(View.VISIBLE);
//                }
//                else {
//                    Log.d("Error", "checking: error in visibility ");
//                }

            }
        }
    }


//    public void open(View view){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
//                alertDialogBuilder.setPositiveButton("yes",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface arg0, int arg1) {
//                                Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
//                            }
//                        });
//
//        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }


    private void showPopup() {


        // start coding for popup
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayoutMain);

        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.custom_popup, null);

        // use to check the height and width of the screen and   calculation is based on it
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

//        getWindow().setLayout((int) (width * .6) ,(int) (height * .6));


        // for the size
        popupWindow = new PopupWindow(container, (int) (width * .6), (int) (height * .2), true);
        // for placement
        popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY, (int) (width * .4), (int) (height * .2));

        container.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();

                return true;
            }
        }); // dismissing the container


    } // ending coding for popup

    private void timer() {

        final Handler handler1 = new Handler();
        handler1.post(new Runnable() {
            @Override
            public void run() {
                seconds = seconds - 5;
                if (seconds < 0) {
                    // DO SOMETHING WHEN TIMES UP
                    stopTimer = true;
                }
                if (!stopTimer) {
                    handler1.postDelayed(this, 5000);
                    afterFiveSecond();
                }
            }
        });
    }

    public void ButtonClicked() {
//        Random r = new Random();
        // initially setting the random numbers between 20 and 30
        int min = 20;
        int max = 30;

        // changing the seconds back to 120 or setting to 2 min as the button is clicked
        seconds = 120;

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            int random = new Random().nextInt((max - min) + 1) + min;
            arr[i] = random; // storing random integers in an array
            System.out.println(arr[i]); // printing each array element

            if (i == 0) {
                String r = Integer.toString(random);
                txt1.setText(r);
            } else if (i == 1) {
                String r = Integer.toString(random);
                txt2.setText(r);
            } else if (i == 2) {
                String r = Integer.toString(random);
                txt3.setText(r);
            } else if (i == 3) {
                String r = Integer.toString(random);
                txt4.setText(r);
            } else {
                String r = Integer.toString(random);
                txt5.setText(r);
            } // end of if else
        }// end of for


    }// ------------------ end of buttonClicked

}
