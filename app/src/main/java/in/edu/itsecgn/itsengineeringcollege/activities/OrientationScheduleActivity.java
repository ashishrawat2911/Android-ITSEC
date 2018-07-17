package in.edu.itsecgn.itsengineeringcollege.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class OrientationScheduleActivity extends AppCompatActivity {
    int position = 0;
    ZoomageView z1, z2, z3, z4, z5, z6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_schedule);
        setTitle("Orientation Schedule");
        z1 = findViewById(R.id.myZoomorientationView1);
        z2 = findViewById(R.id.myZoomorientationView2);
        z3 = findViewById(R.id.myZoomorientationView3);
        z4 = findViewById(R.id.myZoomorientationView4);
        z5 = findViewById(R.id.myZoomorientationView5);
        z6 = findViewById(R.id.myZoomorientationView6);
        Glide.with(this).load(MyConstants.ORIENTATION_1).into(z1);
        Glide.with(this).load(MyConstants.ORIENTATION_2).into(z2);
        Glide.with(this).load(MyConstants.ORIENTATION_3).into(z3);
        Glide.with(this).load(MyConstants.ORIENTATION_4).into(z4);
        Glide.with(this).load(MyConstants.ORIENTATION_5).into(z5);
        Glide.with(this).load(MyConstants.ORIENTATION_6).into(z6);
        showImages(0);
    }

    public void next(View view) {
        position++;
        if (position >= 5) {
            position = 5;
            showImages(position);
        } else {
            showImages(position);
        }
    }

    private void showImages(int position) {
        switch (position) {
            case 0:
                z1.setVisibility(View.VISIBLE);
                z2.setVisibility(View.GONE);
                z3.setVisibility(View.GONE);
                z4.setVisibility(View.GONE);
                z5.setVisibility(View.GONE);
                z6.setVisibility(View.GONE);
                break;
            case 1:
                z1.setVisibility(View.GONE);
                z2.setVisibility(View.VISIBLE);
                z3.setVisibility(View.GONE);
                z4.setVisibility(View.GONE);
                z5.setVisibility(View.GONE);
                z6.setVisibility(View.GONE);
                break;
            case 2:
                z1.setVisibility(View.GONE);
                z2.setVisibility(View.GONE);
                z3.setVisibility(View.VISIBLE);
                z4.setVisibility(View.GONE);
                z5.setVisibility(View.GONE);
                z6.setVisibility(View.GONE);
                break;
            case 3:
                z1.setVisibility(View.GONE);
                z2.setVisibility(View.GONE);
                z3.setVisibility(View.GONE);
                z4.setVisibility(View.VISIBLE);
                z5.setVisibility(View.GONE);
                z6.setVisibility(View.GONE);
                break;
            case 4:
                z1.setVisibility(View.GONE);
                z2.setVisibility(View.GONE);
                z3.setVisibility(View.GONE);
                z4.setVisibility(View.GONE);
                z5.setVisibility(View.VISIBLE);
                z6.setVisibility(View.GONE);
                break;
            case 5:
                z1.setVisibility(View.GONE);
                z2.setVisibility(View.GONE);
                z3.setVisibility(View.GONE);
                z4.setVisibility(View.GONE);
                z5.setVisibility(View.GONE);
                z6.setVisibility(View.VISIBLE);
                break;
        }

    }


    public void previous(View view) {
        position--;
        if (position < 0) {
            position = 0;
            showImages(position);
        } else {

            showImages(position);
        }
    }


}
