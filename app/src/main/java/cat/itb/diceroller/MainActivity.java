package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView resultTextView;
    Button rollButton;
    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result_textview);
        rollButton = findViewById(R.id.roll_button);

        //resultTextView.setText("Ekisde");


        //Instanciacio anonima de classe
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Botó apretat", Toast.LENGTH_SHORT).show();
                rollButton.setText("Dice Rolled");
                num = (int)(Math.random() * (7 - 1) + 1);
                resultTextView.setText(String.valueOf(num));
            }
        });
    }
}