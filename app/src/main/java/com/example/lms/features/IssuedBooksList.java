package com.example.lms.features;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.example.lms.BooksAdapter;
import com.example.lms.R;
import com.example.lms.database.DbIssueBook;

import java.util.ArrayList;

public class IssuedBooksList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BooksAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_books_list);

        recyclerView = findViewById(R.id.RvIssuedBooks);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        DbIssueBook dbIssueBook = new DbIssueBook(getApplicationContext());
        dbIssueBook.open();
        final ArrayList<String> BooksName;
        BooksName = dbIssueBook.getName();
        dbIssueBook.close();
        myAdapter = new BooksAdapter(getApplicationContext(),BooksName);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new BooksAdapter.onItemClick() {
                    @Override
                    public void onItemClicked(int position) {

                        Intent intent = new Intent(getApplicationContext(),
                                IssuedBooksDataDisplay.class);

                        String Id = "";
                        String Id1="";
                        Id = BooksName.get(position).trim();
                        String[] arrOfData=new String[Id.length()] ;
                        for(int i=0;i<arrOfData.length;i++)
                        {
                            arrOfData[i]= String.valueOf(Id.charAt(i));
                        }
                        if(arrOfData.length>0)
                        {
                            Id1= arrOfData[0];
                        }



                        Toast.makeText(IssuedBooksList.this, Id, Toast.LENGTH_SHORT).show();

                        intent.putExtra("DataId",Id1);

                        startActivity(intent);

                    }
                });
    }
}
