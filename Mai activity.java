package com.example.p5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure your layout file is activity_main.xml

        EditText editTextSearch = findViewById(R.id.editTextSearch);
        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editTextSearch.getText().toString().trim();

                if (!query.isEmpty()) {
                    // URL encode the query
                    String encodedQuery = Uri.encode(query);
                    Uri uri = Uri.parse("https://www.google.com/search?q=" + encodedQuery);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else {
                    editTextSearch.setError("Please enter a search query");
                }
            }
        });
    }
}
