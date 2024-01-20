package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText player1 = findViewById(R.id.playerOne);
        EditText player2 = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerOne = player1.getText().toString();
                String playerTwo = player2.getText().toString();

                if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "please enter a name", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerOne", playerOne);
                    intent.putExtra("playerTwo", playerTwo);
                    startActivity(intent);
                }
            }
        });

    }
}