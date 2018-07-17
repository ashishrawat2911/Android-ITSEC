package in.edu.itsecgn.itsengineeringcollege.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class AnnualCalenderActivity extends AppCompatActivity {
    ZoomageView myCalender1, myCalender2, myCalender3, myCalender4, myCalender5;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annual_calender);
        myCalender1 = findViewById(R.id.myCalenderZoomView1);
        myCalender2 = findViewById(R.id.myCalenderZoomView2);
        myCalender3 = findViewById(R.id.myCalenderZoomView3);
        myCalender4 = findViewById(R.id.myCalenderZoomView4);
        myCalender5 = findViewById(R.id.myCalenderZoomView5);
        setTitle("Annual Calender");
        Glide.with(this).load(MyConstants.ANNUAL_CALENDER_1).into(myCalender1);
        Glide.with(this).load(MyConstants.ANNUAL_CALENDER_2).into(myCalender2);
        Glide.with(this).load(MyConstants.ANNUAL_CALENDER_3).into(myCalender3);
        Glide.with(this).load(MyConstants.ANNUAL_CALENDER_4).into(myCalender4);
        Glide.with(this).load(MyConstants.ANNUAL_CALENDER_5).into(myCalender5);
        showImages(0);
    }

    public void nextCalender(View view) {
        position++;
        if (position >= 4) {
            position = 4;
            showImages(position);
        } else {
            showImages(position);
        }
    }

    public void backCalender(View view) {
        position--;
        if (position < 0) {
            position = 0;
            showImages(position);
        } else {

            showImages(position);
        }
    }

    private void showImages(int position) {
        switch (position) {
            case 0:
                myCalender1.setVisibility(View.VISIBLE);
                myCalender2.setVisibility(View.GONE);
                myCalender3.setVisibility(View.GONE);
                myCalender4.setVisibility(View.GONE);
                myCalender5.setVisibility(View.GONE);

                break;
            case 1:
                myCalender1.setVisibility(View.GONE);
                myCalender2.setVisibility(View.VISIBLE);
                myCalender3.setVisibility(View.GONE);
                myCalender4.setVisibility(View.GONE);
                myCalender5.setVisibility(View.GONE);

                break;
            case 2:
                myCalender1.setVisibility(View.GONE);
                myCalender2.setVisibility(View.GONE);
                myCalender3.setVisibility(View.VISIBLE);
                myCalender4.setVisibility(View.GONE);
                myCalender5.setVisibility(View.GONE);

                break;
            case 3:
                myCalender1.setVisibility(View.GONE);
                myCalender2.setVisibility(View.GONE);
                myCalender3.setVisibility(View.GONE);
                myCalender4.setVisibility(View.VISIBLE);
                myCalender5.setVisibility(View.GONE);

                break;
            case 4:
                myCalender1.setVisibility(View.GONE);
                myCalender2.setVisibility(View.GONE);
                myCalender3.setVisibility(View.GONE);
                myCalender4.setVisibility(View.GONE);
                myCalender5.setVisibility(View.VISIBLE);

                break;
            case 5:
                myCalender1.setVisibility(View.GONE);
                myCalender2.setVisibility(View.GONE);
                myCalender3.setVisibility(View.GONE);
                myCalender4.setVisibility(View.GONE);
                myCalender5.setVisibility(View.GONE);

                break;
        }

    }
}

