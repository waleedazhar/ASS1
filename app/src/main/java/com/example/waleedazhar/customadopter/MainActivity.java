package com.example.waleedazhar.customadopter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> Contactlist = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 1000; i++) {
            Contactlist.add(new Contact(Integer.toString(i),Integer.toString(i++),"M"));
            Contactlist.add(new Contact(Integer.toString(i),Integer.toString(i++),"M"));
            Contactlist.add(new Contact(Integer.toString(i),Integer.toString(i+1),"F"));

        }
        final ArrayAdapter<Contact> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.Contact1);

        list.setAdapter(adapter);
        registerClickCallback();
    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.Contact1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Contact clicked = Contactlist.get(position);
                String message = "Calll  " + position
                        + " number     " + clicked.getNum();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();


                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode(clicked.getNum().trim())));
                //callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(callIntent);
                } catch (Exception e) {


                }






        }
        });
    }





    private class MyListAdapter extends ArrayAdapter<Contact> {
        public MyListAdapter() {
            super(MainActivity.this, R.layout.contactview, Contactlist);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.contactview, parent, false);
            }

            //
            Contact current = Contactlist.get(position);

            // Fill the view

            // Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.tusername);
            makeText.setText(current.getName());


            // Condition:
            TextView condionText1 = (TextView) itemView.findViewById(R.id.tnumber);
            condionText1.setText(current.getNum());



            // Condition:
            TextView condionText = (TextView) itemView.findViewById(R.id.tgender);
            condionText.setText(current.getGender());

            return itemView;
        }


    }
}





