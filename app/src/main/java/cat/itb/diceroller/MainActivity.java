package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Dídac Cumelles Cenzano
 */

public class MainActivity extends AppCompatActivity {
    private TextView dau1, dau2;
    private Button rollButton;
    private Button clearbutton;
    private boolean rollable = false;



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
                rollable=true;

                //No m'agrada com queda
                //rollButton.setBackgroundColor(Color.parseColor("lime"));
                roll(dau1);
                roll(dau2);

            }
        });

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollable=false;
                rollButton.setText(R.string.roll_button);
                dau1.setBackgroundResource(R.drawable.empty_dice);
                dau2.setBackgroundResource(R.drawable.empty_dice);
            }
        });

        dau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rollable) {
                    roll(dau1);
                }
            }
        });
        dau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rollable) {
                    roll(dau2);
                }
            }
        });
    }

    public void roll (TextView dau){
        int num = (int) (Math.random() * (7 - 1) + 1);
        switch (num) {
            case 1:
                dau.setBackgroundResource(R.drawable.dice_1);
                break;
            case 2:
                dau.setBackgroundResource(R.drawable.dice_2);
                break;
            case 3:
                dau.setBackgroundResource(R.drawable.dice_3);
                break;
            case 4:
                dau.setBackgroundResource(R.drawable.dice_4);
                break;
            case 5:
                dau.setBackgroundResource(R.drawable.dice_5);
                break;
            case 6:
                dau.setBackgroundResource(R.drawable.dice_6);
                break;
        }
    }
}