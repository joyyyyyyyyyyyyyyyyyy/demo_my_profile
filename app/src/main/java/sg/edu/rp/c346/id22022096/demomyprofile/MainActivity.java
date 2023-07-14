package sg.edu.rp.c346.id22022096.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise variables with UI
        editTextName = findViewById(R.id.editTextName);
        editTextGPA = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = editTextName.getText().toString();
        float gpa= Float.parseFloat(editTextGPA.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", strName);

        prefEdit.putString("gpa", String.valueOf(gpa));

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String strName = prefs.getString("name", "John");
        String gpa = prefs.getString("gpa", "0.0");

        editTextName.setText(strName);
        editTextGPA.setText(gpa + "");
    }
}