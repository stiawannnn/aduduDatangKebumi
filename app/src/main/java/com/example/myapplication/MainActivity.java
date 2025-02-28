package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView diceImage;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan variabel dengan elemen di XML
        diceImage = findViewById(R.id.imageView);
        Button rollButton = findViewById(R.id.button);

        // Event klik tombol untuk melempar dadu
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        // Pilih angka acak dari 1 sampai 6
        int diceNumber = random.nextInt(6) + 1;

        // Pilih gambar dadu sesuai angka
        int diceImageId = getDiceImage(diceNumber);

        // Ubah gambar di ImageView
        diceImage.setImageDrawable(ContextCompat.getDrawable(this, diceImageId));

    }

    private int getDiceImage(int diceNumber) {
        switch (diceNumber) {
            case 1:
                return R.drawable.dice_1;
            case 2:
                return R.drawable.dice_2;
            case 3:
                return R.drawable.dice_3;
            case 4:
                return R.drawable.dice_4;
            case 5:
                return R.drawable.dice_5;
            default:
                return R.drawable.dice_6;
        }
    }
}
