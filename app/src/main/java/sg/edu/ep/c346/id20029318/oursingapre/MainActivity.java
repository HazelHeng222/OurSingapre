package sg.edu.ep.c346.id20029318.oursingapre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDes, etSqKM;
    Button btnInsert, btnShowList;
    RatingBar rateBarStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getTitle().toString() + " ~ " + getResources().getText(R.string.title_activity_main));

        etName = findViewById(R.id.etName);
        etDes = findViewById(R.id.etDes);
        etSqKM = findViewById(R.id.etSqKM);
        btnInsert = findViewById(R.id.btnInsertIsland);
        btnShowList = findViewById(R.id.btnShowList);
        rateBarStars = findViewById(R.id.ratingBarStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String description = etDes.getText().toString().trim();
                if (name.length() == 0 || description.length() == 0) {
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String areaKM2_str = etSqKM.getText().toString().trim();
                int areaKM2 = Integer.valueOf(areaKM2_str);

                DBHelper dbh = new DBHelper(MainActivity.this);
                int rating = (int) rateBarStars.getRating();
                dbh.insertIsland(name, description, areaKM2, rating);
                dbh.close();

                Toast.makeText(MainActivity.this, "Island inserted", Toast.LENGTH_LONG).show();
                etName.setText("");
                etDes.setText("");
                etSqKM.setText("");


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }

}