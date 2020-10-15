package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Dídac Cumelles Cenzano
 */

public class MainActivity extends AppCompatActivity {
    private ImageView dau1, dau2;
    private Button rollButton;
    private Button clearbutton;
    private boolean rollable = false;
    private int resultat1, resultat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dau1 = findViewById(R.id.dau1);
        dau2 = findViewById(R.id.dau2);
        rollButton = findViewById(R.id.roll_button);
        clearbutton = findViewById(R.id.clear_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollButton.setText(R.string.dices_rolled);
                rollable = true;

                resultat1 = roll(dau1);
                resultat2 = roll(dau2);
                comprovar();
            }
        });

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollable = false;
                resultat1 = 0;
                resultat2 = 0;
                rollButton.setText(R.string.roll_button);
                dau1.setImageResource(R.drawable.empty_dice);
                dau2.setImageResource(R.drawable.empty_dice);
            }
        });

        dau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rollable) {
                    resultat1 = roll(dau1);
                    comprovar();
                }
            }
        });

        dau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rollable) {
                    resultat2 = roll(dau2);
                    comprovar();
                }
            }
        });
    }

    public int roll(ImageView dau) {
        int num = (int) (Math.random() * (7 - 1) + 1);
        switch (num) {
            case 1:
                dau.setImageResource(R.drawable.dice_1);
                return 1;
            case 2:
                dau.setImageResource(R.drawable.dice_2);
                return 2;
            case 3:
                dau.setImageResource(R.drawable.dice_3);
                return 3;
            case 4:
                dau.setImageResource(R.drawable.dice_4);
                return 4;
            case 5:
                dau.setImageResource(R.drawable.dice_5);
                return 5;
            case 6:
                dau.setImageResource(R.drawable.dice_6);
                return 6;
            default:
                return 0;
        }
    }

    public void comprovar() {
        if (resultat1 == 6 && resultat2 == 6) {
            Toast.makeText(getApplicationContext(), "JACKPOT!!!", Toast.LENGTH_LONG).show();
        }
    }
}