package com.example.lms.features;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lms.R;

public class Books_stats_menu extends AppCompatActivity {
    ImageView issueBooks,AllBooks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_stats_menu);
        issueBooks = findViewById(R.id.IvIssuedBook);
        AllBooks = findViewById(R.id.IvAllBooks);
        AllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Books_stats_menu.this,
                        BooksList.class);
                startActivity(intent);
            }
        });

        issueBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Books_stats_menu.this,
                        IssuedBooksList.class);
                startActivity(intent);



            }

        });
    }
}
