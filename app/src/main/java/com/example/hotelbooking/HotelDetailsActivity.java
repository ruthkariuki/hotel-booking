package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_details_activity);

        Bundle extras = getIntent().getExtras();
        String details = extras.getString("details");
        String hotel = extras.getString("hotel");

        ImageView imageView = (ImageView) findViewById(R.id.hotel);
        TextView textView = (TextView) findViewById(R.id.label);

        HotelArrayAdapter.setImage(hotel, imageView);

        textView.setText(details);

        Button backButton = findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        Button bookButton = findViewById(R.id.book);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //link to the next activity
                Intent intent = new Intent(getApplicationContext(), BookHotelActivity.class);

                intent.putExtra("hotel", hotel);

                //start the next activity
                startActivity(intent);
            }
        });
    }
}