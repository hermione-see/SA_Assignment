package sg.edu.rp.c346.id20019634.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

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



    }
}