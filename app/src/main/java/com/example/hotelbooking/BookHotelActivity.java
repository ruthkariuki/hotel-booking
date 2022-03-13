package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class BookHotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_hotel_activity);

        Bundle extras = getIntent().getExtras();
        String hotel = extras.getString("hotel");

        TextView textView = findViewById(R.id.hotel_booked);

        textView.setText("Booking " + hotel.toUpperCase());

        Button calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNum = ThreadLocalRandom.current().nextInt(3000, 10000 + 1);

                EditText nightsInput = findViewById(R.id.nights);
                EditText personsInput = findViewById(R.id.persons);

                int nights = Integer.parseInt(nightsInput.getText().toString());
                int persons = Integer.parseInt(personsInput.getText().toString());

                int total = randomNum * nights * persons;

                TextView totalsView = findViewById(R.id.totals);

                totalsView.setText("Ksh " + total);
            }
        });
    }
}