package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}