package com.example.hotelbooking;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewHotelsActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewHotelsActivity extends AppCompatActivity {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static final String[][] HOTELS =
            new String[][]{{"crowne", "eka", "four_points", "jacaranda", "sarova"},
                    {
                            "Crowne Plaza is a British multinational chain of full service, upscale hotels headquartered in the United Kingdom. It caters to business travelers and the meetings and conventions market",
                            "Eka Hotel rooms are designed to provide the highest levels of Comfort, Convenience and Eﬃciency. The hotel has 167 air-conditioned rooms, of these 158 are Superior rooms, 2 rooms for guests with special needs, 4 Junior Suites and 3 Executive Suites. Guests staying in the Hotel have exclusive access to the gym and swimming pool.",
                            "Four Points by Sheraton Nairobi Hurlingham offer exceptional Kenyan hospitality and comfort. Each of our 96 guest rooms and suites are equipped with our Four Points signature bed and facilities that include wireless high-speed internet access, picturesque views and soundproof windows; some rooms feature balconies.",
                            "Jacaranda Hotels is a Kenyan landmark hotel group and has been a symbol of quality and elegance over the years. The Jacaranda Nairobi Hotel, located at the heart of Westlands, the Jacaranda Indian Ocean Beach Resort, an exclusive luxury resort in Diani, and Jacaranda Lake Elementaita Lodge, adjacent to Lake Elementaita on your way to Nakuru from Nairobi",
                            "Sarovar is the leading hotel management company in India. Sarovar Hotels span business, leisure and religious destinations"
                    }
            };

    public ViewHotelsActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewHotelsActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewHotelsActivity newInstance(String param1, String param2) {
        ViewHotelsActivity fragment = new ViewHotelsActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_hotels_activity);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(new HotelArrayAdapter(this, HOTELS[0]));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                //link to the next activity
                Intent intent = new Intent(getApplicationContext(), HotelDetailsActivity.class);
                intent.putExtra("details", HOTELS[1][position]);
                intent.putExtra("hotel", HOTELS[0][position]);
                //start the next activity
                startActivity(intent);

            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_hotels_activity, container, false);
    }
}