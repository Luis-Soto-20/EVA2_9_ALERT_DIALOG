package com.mario.eva2_9_alert_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Date;

public class MyAlertDialogFragment extends DialogFragment{
    public static DialogFragment newInstance(int title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        args.putString("message", "Message Line 1\nMessage Line 2");
        frag.setArguments(args);
        return frag;

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");
        int icon = getArguments().getInt("icon");
        String message = getArguments().getString("message");
        return new AlertDialog.Builder(getActivity())
                .setIcon(icon)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Positive",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                ((MainActivity) getActivity())
                                        .doPositiveClick(new Date());
                            }
                        })
                .setNegativeButton("Negative",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                ((MainActivity) getActivity())
                                        .doNegativeClick(new Date());
                            }
                        })
                .setNeutralButton("Neutral",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                ((MainActivity) getActivity())
                                        .doNeutralClick(new Date());
                            }
                        }).create();
    }
}
