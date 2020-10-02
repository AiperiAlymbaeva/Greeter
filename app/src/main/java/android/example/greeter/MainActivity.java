package android.example.greeter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name = " ";
    final static String nameVariableKey = "NAME_VARIABLE";
    final static String textViewTexKey = "TEXTVIEW_TEXT";

    TextView result;
    EditText name_edit;
    Button greet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.greeter);
        name_edit = (EditText) findViewById(R.id.name);
        greet = (Button) findViewById(R.id.button);


    }

    public void onClick(View view) {
        String printMessage = name_edit.getText().toString();
        if (printMessage.trim().isEmpty()) {
            Toast.makeText(this, "Please write your name!", Toast.LENGTH_SHORT).show();
        }
        else {
            result.setText("Hello, " + printMessage);
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(nameVariableKey, name);
        TextView nameView = (TextView) findViewById(R.id.greeter);
        outState.putString(textViewTexKey, nameView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name = savedInstanceState.getString(nameVariableKey);
        String textViewText= savedInstanceState.getString(textViewTexKey);
        TextView nameView = (TextView) findViewById(R.id.greeter);
        nameView.setText(textViewText);
    }

//    public void saveName(View view) {
//        EditText nameBox = (EditText) findViewById(R.id.name);
//        name = nameBox.getText().toString();
//    }
//    public void getName(View view) {
//        TextView nameView = (TextView) findViewById(R.id.greeter);
//        nameView.setText(name);
//    }
}
