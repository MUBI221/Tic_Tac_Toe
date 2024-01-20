package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class ResultDialog extends Dialog {
    private final String message;
    private final MainActivity activity;

    public ResultDialog(NotNull context, String message, MainActivity Mainactivity) {

        super((Context) context);
        this.message = message;
        this.activity = Mainactivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.restartMatch();
                dismiss();
            }


        });
    }
}