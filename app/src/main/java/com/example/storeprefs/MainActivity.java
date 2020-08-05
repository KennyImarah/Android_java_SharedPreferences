package com.example.storeprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String MESSAGE_ID = "messages_pref";
    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add activity to view

        Button mainButton = findViewById(R.id.buttonMain);
        mTextView = findViewById(R.id.textview);
        mEditText = findViewById(R.id.editText);

        // setOnclick to context

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String message = mEditText.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE); // control access
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("message", message);


                editor.apply();  // save to disc


            }
        });

        // call data back

        SharedPreferences getSharedData = getPreferences(MODE_PRIVATE);
        String value = getSharedData.getString("message", "Message coming soon");

        mTextView.setText(value);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}