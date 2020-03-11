package com.example.candidatesenario;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private EditText txt1, txt2, txt3, txt4, txt5;

    private int seconds = 120;
    private boolean stopTimer = false;

    int status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRandom = findViewById(R.id.btn_random);


        timer(); // here code for the timer is set

        txt1 = findViewById(R.id.edt_1);
        txt2 = findViewById(R.id.edt_2);
        txt3 = findViewById(R.id.edt_3);
        txt4 = findViewById(R.id.edt_4);
        txt5 = findViewById(R.id.edt_5);

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
//                showPopup();

                if (i == 4) {

                    SharedPreferences preferences5 = getSharedPreferences("PREFS5", 0);
                    boolean isShowCustomDialog5 = preferences5.getBoolean("showCustomDialog5", true);
                    if (isShowCustomDialog5) {
                        showCustomDialog5();
                    }
                }
                if (i == 1) {
                    SharedPreferences preferences2 = getSharedPreferences("PREFS2", 0);
                    boolean isShowCustomDialog2 = preferences2.getBoolean("showCustomDialog2", true);
                    if (isShowCustomDialog2) {
                        showCustomDialog2();
                    }
                }
                if (i == 0) {
                    SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                    boolean isShowCustomDialog = preferences.getBoolean("showCustomDialog", true);
                    if (isShowCustomDialog) {
                        showCustomDialog();
                    }
                }
                if (i == 2) {
                    SharedPreferences preferences3 = getSharedPreferences("PREFS3", 0);
                    boolean isShowCustomDialog3 = preferences3.getBoolean("showCustomDialog3", true);
                    if (isShowCustomDialog3) {
                        showCustomDialog3();
                    }
                }
                if (i == 3) {

                    SharedPreferences preferences4 = getSharedPreferences("PREFS4", 0);
                    boolean isShowCustomDialog4 = preferences4.getBoolean("showCustomDialog4", true);
                    if (isShowCustomDialog4) {
                        showCustomDialog4();
                    }

                }

            }
        }
    }



    private void showCustomDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.custom_popup, null);
        Button dialogButton = layoutView.findViewById(R.id.buttonOk);
        Button dialogButton2 = layoutView.findViewById(R.id.buttonNever);
        dialogBuilder.setView(layoutView);

        TextView alertT = findViewById(R.id.alertText);
//        alertT.setText("value 2 below 15 or above 35 during the process");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("showCustomDialog", false);
                editor.apply();
                alertDialog.dismiss();
            }
        });
    }

    private void showCustomDialog2() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.second_dialog, null);
        Button dialogButton = layoutView.findViewById(R.id.buttonOk2);
        Button dialogButton2 = layoutView.findViewById(R.id.buttonNever2);
        dialogBuilder.setView(layoutView);

        TextView alertT = findViewById(R.id.alertText2);
//        alertT.setText("value 2 below 15 or above 35 during the process");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences2 = getSharedPreferences("PREFS2", 0);
                SharedPreferences.Editor editor = preferences2.edit();
                editor.putBoolean("showCustomDialog2", false);
                editor.apply();
                alertDialog.dismiss();
            }
        });
    }

    private void showCustomDialog3() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        @SuppressLint("InflateParams") View layoutView = getLayoutInflater().inflate(R.layout.my_dialog3, null);
        Button dialogButton = layoutView.findViewById(R.id.buttonOk3);
        Button dialogButton2 = layoutView.findViewById(R.id.buttonNever3);
        dialogBuilder.setView(layoutView);

        TextView alertT = findViewById(R.id.alertText3);
//        alertT.setText("value 2 below 15 or above 35 during the process");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences3 = getSharedPreferences("PREFS3", 0);
                SharedPreferences.Editor editor = preferences3.edit();
                editor.putBoolean("showCustomDialog3", false);
                editor.apply();
                alertDialog.dismiss();
            }
        });
    }

    private void showCustomDialog4() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.my_dialog4, null);
        Button dialogButton = layoutView.findViewById(R.id.buttonOk4);
        Button dialogButton2 = layoutView.findViewById(R.id.buttonNever4);
        dialogBuilder.setView(layoutView);

        TextView alertT = findViewById(R.id.alertText4);
//        alertT.setText("value 2 below 15 or above 35 during the process");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences4 = getSharedPreferences("PREFS4", 0);
                SharedPreferences.Editor editor = preferences4.edit();
                editor.putBoolean("showCustomDialog4", false);
                editor.apply();

                alertDialog.dismiss();
            }
        });
    }

    private void showCustomDialog5() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.my_dialog5, null);
        Button dialogButton = layoutView.findViewById(R.id.buttonOk5);
        Button dialogButton2 = layoutView.findViewById(R.id.buttonNever5);
        dialogBuilder.setView(layoutView);

        TextView alertT = findViewById(R.id.alertText5);
//        alertT.setText("value 2 below 15 or above 35 during the process");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences5 = getSharedPreferences("PREFS5", 0);
                SharedPreferences.Editor editor = preferences5.edit();
                editor.putBoolean("showCustomDialog5", false);
                editor.apply();
                alertDialog.dismiss();
            }
        });
    }


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
