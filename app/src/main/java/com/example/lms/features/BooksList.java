package com.example.lms.features;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.example.lms.BooksAdapter;
import com.example.lms.R;
import com.example.lms.database.dbHelper;

import java.util.ArrayList;
public class BooksList extends AppCompatActivity {

    RecyclerView recyclerView;
    BooksAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        recyclerView=findViewById(R.id.RvList);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        dbHelper db=new dbHelper(getApplicationContext());
        db.open();
        final ArrayList<String> BooksName;
        BooksName=db.getName();
        db.close();
        myAdapter=new BooksAdapter(this.getApplicationContext(),BooksName);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new BooksAdapter.onItemClick() {
            @Override
            public void onItemClicked(int position) {

                Intent intent=new Intent(getApplicationContext(),
                        StatsShow.class);

                String name="";
                name= BooksName.get(position).trim();

                Toast.makeText(BooksList.this, name, Toast.LENGTH_SHORT).show();

                intent.putExtra("name",name);

                startActivity(intent);
            }
        });
    }
}
