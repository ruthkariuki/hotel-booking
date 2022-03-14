package com.example.hotelbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] hotelNames;

    public HotelArrayAdapter(Context context, String[] hotelNames) {
        super(context, R.layout.list_image, hotelNames);
        this.context = context;
        this.hotelNames = hotelNames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_image, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.hotel);
        textView.setText(hotelNames[position]);

        // Change icon based on name
        setImage(hotelNames[position], imageView);

        return rowView;
    }

    public static void setImage(String hotelName, ImageView imageView) {

        if (hotelName.equals("crowne")) {
            imageView.setImageResource(R.drawable.crowne);
        } else if (hotelName.equals("eka")) {
            imageView.setImageResource(R.drawable.eka);
        } else if (hotelName.equals("four_points")) {
            imageView.setImageResource(R.drawable.four_points);
        } else if(hotelName.equals("jacaranda")){
            imageView.setImageResource(R.drawable.jacaranda);
        } else if (hotelName.equals("sarova")) {
            imageView.setImageResource(R.drawable.sarova);
        }
    }
}
