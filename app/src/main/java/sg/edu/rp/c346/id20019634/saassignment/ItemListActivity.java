package sg.edu.rp.c346.id20019634.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    EditText etName, etYear, etMonth, etDay;
    Button btnAdd, btnUpdate, btnDelete;
    ListView lvProducts;
    ArrayList<String> alProducts;
    Spinner spnMonths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        etName = findViewById(R.id.editTextProductName);
        etDay = findViewById(R.id.editTextDay);
        etMonth = findViewById(R.id.editTextMonth);
        etYear = findViewById(R.id.editTextYear);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        lvProducts = findViewById(R.id.ListViewProducts);
        spnMonths = findViewById(R.id.spinner);

        alProducts = new ArrayList<String>();

        ArrayAdapter aaProducts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alProducts);
        lvProducts.setAdapter(aaProducts);

        spnMonths.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: // 1 month

                        break;

                    case 1: // 3 months

                        break;

                    case 2: // 6 months

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newProduct = etName.getText().toString();
                String newYear = etYear.getText().toString();
                String newMonth = etMonth.getText().toString();
                String newDay = etDay.getText().toString();

                if (newProduct.isEmpty() || newDay.isEmpty() || newMonth.isEmpty() || newYear.isEmpty()) {

                    Toast.makeText(ItemListActivity.this, "Please fill in all the mandatory details.", Toast.LENGTH_SHORT).show();

                } else {
                    String newEntry = "Expiries " + newYear + "-" + newMonth + "-" + newDay + " " + newProduct;

                    alProducts.add(newEntry);
                    Collections.sort(alProducts);
                    aaProducts.notifyDataSetChanged();
                    etName.setText(null);
                    etYear.setText(null);
                    etMonth.setText(null);
                    etDay.setText(null);

                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (alProducts.isEmpty() == true) {

                    Toast.makeText(ItemListActivity.this,"You don't have any products to delete.", Toast.LENGTH_SHORT).show();

                } else {
                    for (int i = 0; i < alProducts.size(); i++) {
                        if (alProducts.get(i).contains(etName.getText().toString())) {
                            alProducts.remove(i);
                            aaProducts.notifyDataSetChanged();

                        } else {
                            Toast.makeText(ItemListActivity.this,"This product does not exist in your list.", Toast.LENGTH_SHORT).show();

                        }

                    }

                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newProduct = etName.getText().toString();
                String newYear = etYear.getText().toString();
                String newMonth = etMonth.getText().toString();
                String newDay = etDay.getText().toString();

                if (alProducts.isEmpty() == true) {

                    Toast.makeText(ItemListActivity.this,"You don't have any products to update.", Toast.LENGTH_SHORT).show();

                } else if (newProduct.isEmpty() || newDay.isEmpty() || newMonth.isEmpty() || newYear.isEmpty()) {

                    Toast.makeText(ItemListActivity.this, "Please fill in all the mandatory details.", Toast.LENGTH_SHORT).show();

                } else {

                    for (int i = 0; i < alProducts.size(); i++) {
                        if (alProducts.get(i).contains(etName.getText().toString())) {

                            String updateEntry = "Expiries " + newYear + "-" + newMonth + "-" + newDay + " " + newProduct;

                            alProducts.add(i, updateEntry);
                            aaProducts.notifyDataSetChanged();

                            break;

                        } else {
                            Toast.makeText(ItemListActivity.this,"This product does not exist in your list.", Toast.LENGTH_SHORT).show();

                        }

                    }

                }

            }
        });

    }
}