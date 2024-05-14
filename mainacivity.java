package com.projects.icecreamgabunnn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Spinner id;
    RadioButton chocolate, vanilla, strawberry;
    CheckBox springkles, kisses, marshmallow, nips, cookies, syrup;
    ImageButton submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.ETmame);

        id = findViewById(R.id.SPid);

        chocolate = findViewById(R.id.RBchocolate);
        vanilla = findViewById(R.id.RBvanilla);
        strawberry = findViewById(R.id.RBstrawberry);

        springkles = findViewById(R.id.CBsprinkles);
        kisses = findViewById(R.id.CBkisses);
        marshmallow = findViewById(R.id.CBmarshmallow);
        nips = findViewById(R.id.CBnips);
        cookies = findViewById(R.id.CBcookies);
        syrup = findViewById(R.id.syrup);

        submit = findViewById(R.id.makeic);

        submit.setOnClickListener(v -> {
            String ICname = name.getText().toString();
            int spinnerID = Integer.parseInt(id.getSelectedItem().toString());

            String flavor = "";

            if(chocolate.isChecked()){
                flavor = "Chocolate";
            } else if (strawberry.isChecked()){
                flavor = "Strawberry";
            } else if (vanilla.isChecked()){
                flavor = "Vanilla";
            }

            String toppings = "Toppings: ";
            if (springkles.isChecked()){
                toppings += "Springkles, ";
            }
            if (kisses.isChecked()){
                toppings += "Kisses, ";
            }
            if (marshmallow.isChecked()){
                toppings += "Marshmallow, ";
            }
            if (nips.isChecked()){
                toppings += "Nips, ";
            }
            if (cookies.isChecked()){
                toppings += "Cookies, ";
            }
            if (syrup.isChecked()){
                toppings += "Syrup, " +
                        "";
            }

            Intent intent = new Intent(MainActivity.this, icecream.class);
            intent.putExtra("name", ICname);
            intent.putExtra("id", spinnerID);
            intent.putExtra("flavor", flavor);
            intent.putExtra("toppings", toppings);
            startActivity(intent);

        });

    }
}
