package com.example.lms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class LibraryMenu extends AppCompatActivity {
    ImageView issueBook,addBook,returnBook,newAccount,Stats;
    TextView TvissueBook,TvaddBook,TvreturnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_menu);

        addBook=findViewById(R.id.IvnewBook);
        issueBook=findViewById(R.id.IvIssueBook);
        returnBook=findViewById(R.id.IvReturnBook);
        newAccount=findViewById(R.id.IvAddAccount);
        Stats=findViewById(R.id.IvStats);
        TvaddBook=findViewById(R.id.TVNewBook);
        TvissueBook=findViewById(R.id.TVIssueBook);
        TvreturnBook=findViewById(R.id.TVReturnBook);
        Intent intent2= getIntent();
        final String choice =intent2.getStringExtra("userChoice");
        if(choice.equalsIgnoreCase("Student") || choice.equalsIgnoreCase("Faculty") )
        {
            addBook.setVisibility(View.INVISIBLE);
            issueBook.setVisibility(View.INVISIBLE);
            returnBook.setVisibility(View.INVISIBLE);
            TvreturnBook.setVisibility(View.INVISIBLE);
            TvissueBook.setVisibility(View.INVISIBLE);
            TvaddBook.setVisibility(View.INVISIBLE);

        }
        //Toast.makeText(this, choice, Toast.LENGTH_SHORT).show();

        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),
                        com.example.lms.register.class);
                startActivity(intent);
            }
        });


        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),
                        com.example.lms.addBook.class);
                startActivity(intent);

            }
        });
        Stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choice.equalsIgnoreCase("Student") || choice.equalsIgnoreCase("Faculty") )
                {
                    Intent intent=new Intent(getApplicationContext(),
                            com.example.lms.BooksList.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(),
                            com.example.lms.Books_stats_menu.class);
                    startActivity(intent);
                }

            }
        });
        issueBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),
                        com.example.lms.IssueBook.class);
                startActivity(intent);

            }
        });
        returnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),
                        com.example.lms.ReturnBook.class);
                startActivity(intent);
            }
        });

    }
}
