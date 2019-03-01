package com.ismailhakkiaydin.telefonrehberi;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.time.DayOfWeek;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentResolver cr = this.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME},"",null,"");
        SimpleCursorAdapter adp = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cur,new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME},
                new int[]{android.R.id.text1});

        ListView lst = new ListView(this);
        lst.setAdapter(adp);


        this.setContentView(lst);
    }
}
