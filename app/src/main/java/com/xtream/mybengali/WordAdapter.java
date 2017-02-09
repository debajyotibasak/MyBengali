package com.xtream.mybengali;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DROID on 30-01-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //Resource Id for background color
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> wordList, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordList);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView bengaliTextView = (TextView) listItemView.findViewById(R.id.bengali_text_view);
        // Get the bengali translation from the current Word object and
        // set this text on the name TextView
        bengaliTextView.setText(currentWord.getBengaliTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Checking if the view has an image or not
        if (currentWord.hasImage()) {
            // Set the ImageView to the Image of present
            imageView.setImageResource(currentWord.getImageResourceId());
            // setting the visibilty to Visible for reuse in future
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Setting visibility to Gone when no image to avoid malfunction of code.
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 1 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
