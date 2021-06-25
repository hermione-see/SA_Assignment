package sg.edu.rp.c346.id20019634.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLearn, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLearn = findViewById(R.id.buttonWebsite);
        btnNext = findViewById(R.id.buttonNext);

        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.samsung.com/sg/"));
                startActivity(intentUrl);
                Toast.makeText(MainActivity.this, "Proceeding to Website...", Toast.LENGTH_SHORT).show();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentItem = new Intent(MainActivity.this, ItemListActivity.class);

                startActivity(intentItem);

            }
        });

    }
}