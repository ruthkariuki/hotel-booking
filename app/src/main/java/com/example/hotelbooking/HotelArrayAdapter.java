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
    private final String[] values;

    public HotelArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_image, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_image, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.hotel);
        textView.setText(values[position]);

        // Change icon based on name
        setImage(values[position], imageView);

        return rowView;
    }

    public static void setImage(String value, ImageView imageView) {
        String s = value;

        if (s.equals("crowne")) {
            imageView.setImageResource(R.drawable.crowne);
        } else if (s.equals("eka")) {
            imageView.setImageResource(R.drawable.eka);
        } else if (s.equals("four_points")) {
            imageView.setImageResource(R.drawable.four_points);
        } else if(s.equals("jacaranda")){
            imageView.setImageResource(R.drawable.jacaranda);
        } else if (s.equals("sarova")) {
            imageView.setImageResource(R.drawable.sarova);
        }
    }
}
