package sg.edu.ep.c346.id20029318.oursingapre;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Island> islandList;

    public  CustomAdapter (Context context, int resource, ArrayList<Island> objects) {

        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        islandList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView txtName = rowView.findViewById(R.id.txtName);
        TextView txtDescription = rowView.findViewById(R.id.txtDes);
        TextView txtSQKM = rowView.findViewById(R.id.txtSQKM);
        TextView txtStars = rowView.findViewById(R.id.txtStars);
        RatingBar rateStars = rowView.findViewById(R.id.ratingBar);



        // Obtain the Android Version information based on the position
        Island currIsland = islandList.get(position);

        String stars = "";
        if (currIsland.getStars() == 5){
            stars = "* * * * *";
            rateStars.setRating(5);
        }
        else if (currIsland.getStars() == 4){
            stars = "* * * *";
            rateStars.setRating(4);
        }
        else if (currIsland.getStars() == 3){
            stars = "* * *";
            rateStars.setRating(3);
        }
        else if (currIsland.getStars() == 2){
            stars = "* *";
            rateStars.setRating(2);
        }
        else if (currIsland.getStars() == 1){
            stars = "*";
            rateStars.setRating(1);
        }
        else {
            stars = "";
            rateStars.setRating(0);
        }
        // Set values to the TextView to display the corresponding information
        txtName.setText(currIsland.getName());
        txtDescription.setText(currIsland.getDescription());
        txtSQKM.setText(currIsland.getAreaKM2() + "");
        txtStars.setText(stars);
        txtStars.setTypeface(null, Typeface.BOLD); // tried to bold stars

        return rowView;
    }

}

