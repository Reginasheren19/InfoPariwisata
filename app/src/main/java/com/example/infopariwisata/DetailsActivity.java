package com.example.infopariwisata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private ImageView placeImage;
    private TextView placeName;
    private TextView placeLocation;
    private TextView about;
    private TextView placeDetails;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toast.makeText(this, "Detail wisata berhasil diakses", Toast.LENGTH_SHORT).show();

        placeImage = findViewById(R.id.imagedetails);
        placeName = findViewById(R.id.placename);
        placeLocation = findViewById(R.id.placelocation);
        about = findViewById(R.id.about);
        placeDetails = findViewById(R.id.placedetails);
        backButton = findViewById(R.id.backButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("placename");
        String location = intent.getStringExtra("placelocation");
        int imageResId = intent.getIntExtra("imagedetails", 0);
        String details = intent.getStringExtra("placedetails");

        placeName.setText(name);
        placeLocation.setText(location);
        placeImage.setImageResource(imageResId);
        placeDetails.setText(details);

        backButton.setOnClickListener(v -> finish());

    }
}
