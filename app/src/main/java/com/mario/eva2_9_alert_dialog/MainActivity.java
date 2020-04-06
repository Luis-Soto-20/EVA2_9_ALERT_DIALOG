package com.mario.eva2_9_alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button alertdialog;
    Button alertidalog2;
    Button alertdialog3;
    TextView txtmsg;
    Context activityContext;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContext = this;
        alertdialog = findViewById(R.id.btn_alertdialog);
        alertidalog2 = findViewById(R.id.btn_Costume);
        alertdialog3 = findViewById(R.id.btn_alert_frag);
        txtmsg = findViewById(R.id.edittxt_dialog);
        alertdialog.setOnClickListener(this);
        alertidalog2.setOnClickListener(this);
        alertdialog3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alertdialog:
                showMyAlertDialog(this);
                break;
            case R.id.btn_Costume:
                showCustomDialogBox();
                break;
            case R.id.btn_alert_frag:
                showMyAlertDialogFragment(this);
                break;
        }
    }
    public void showMyAlertDialog(MainActivity mainActivity){
        new AlertDialog.Builder(mainActivity)
                .setTitle("Terminator")
                .setMessage("are you shore you want to quit")
                .setPositiveButton("yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                msg = "yes" + Integer.toString(which);
                            }

        })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        msg = "cancel" + Integer.toString(which);

                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        msg = "no" + Integer.toString(whichButton);
                        closeContextMenu();
                    }
                })
                .create()
                .show();
    }
    @SuppressLint("SetTextI18n")
    private void showCustomDialogBox() {
        final Dialog customDialog = new Dialog(activityContext);
        customDialog.setTitle("Custom Dialog Title");
// match customDialog with custom dialog layout
        customDialog.setContentView(R.layout.costum_dialog_layout);
        ((TextView) customDialog.findViewById(R.id.txt_dialog))
                .setText("\nMessage line1\nMessage line2\n"+
                        "Dismiss: Back btn, Close, or touch outside");
        final EditText sd_txtInputData = (EditText) customDialog

                .findViewById(R.id.edittxt_dialog);

        ((Button) customDialog.findViewById(R.id.btn_close))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtmsg.setText(sd_txtInputData.getText().toString());
                        customDialog.dismiss();
                    }
                });
        customDialog.show();
    }
    private void showMyAlertDialogFragment(MainActivity mainActivity) {
        DialogFragment dialogFragment = MyAlertDialogFragment

                .newInstance(R.string.app_name);
        

    }
    @SuppressLint("SetTextI18n")
    public void doPositiveClick(Date time) {
        txtmsg.setText("POSITIVE - DialogFragment picked @ " + time);
    }
    @SuppressLint("SetTextI18n")
    public void doNegativeClick(Date time) {
        txtmsg.setText("NEGATIVE - DialogFragment picked @ " + time);
    }
    @SuppressLint("SetTextI18n")
    public void doNeutralClick(Date time) {
        txtmsg.setText("NEUTRAL - DialogFragment picked @ " + time);
    }


        }



