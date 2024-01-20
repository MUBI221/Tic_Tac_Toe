package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalselectedbox = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{0,4,8});

        String getplayerOneName = getIntent().getStringExtra("playerOne");
        String getplayerTwoName = getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getplayerOneName);
        binding.playerTwoName.setText(getplayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isboxSelected(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        }
        );
    }
    private void performAction(ImageView imageView, int selectedboxPosition) {
        boxPositions[selectedboxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage);
            if (checkResults()){
                ResultDialog resultDialog = new ResultDialog(MainActivity.this,binding.playerOneName.getText().toString()
                +" is the winner!",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else if (totalselectedbox == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this,"Draw!",MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }else {
                totalselectedbox++;
                changeplayerTurn(2);
            }
            else {
                imageView.setImageResource(R.drawable.ximage);
                if (checkResults()){
                    ResultDialog resultDialog = new ResultDialog(MainActivity.this,binding.playerTwoName.getText().toString()
                            +" is the winner!",MainActivity.this);
                    resultDialog.setCancelable(false);
                    resultDialog.show();
                }else if (totalselectedbox == 9) {
                    ResultDialog resultDialog = new ResultDialog(MainActivity.this,"Draw!",MainActivity.this);
                    resultDialog.setCancelable(false);
                    resultDialog.show();
                }else {
                    totalselectedbox++;
                    changeplayerTurn(2);
                }


            }
            }

            }


//    private boolean checkResults() {
//        return false;
//    }


    private void changeplayerTurn(int currentplayerTurn) {
        playerTurn = currentplayerTurn;
        if (playerTurn == 1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }
    private boolean checkResults() {

        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
          final  int[] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == boxPositions[combination[1]] && boxPositions[combination[1]] == boxPositions[combination[2]] && boxPositions[combination[0]] != 0) {
                response = true;
                break;
            }}
        return false;
    }

    private boolean isboxSelected(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public static void restartMatch() {
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        totalselectedbox = 1;
        playerTurn = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }

}


