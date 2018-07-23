package in.edu.itsecgn.itsengineeringcollege.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.jsibbold.zoomage.ZoomageView;

import in.edu.itsecgn.itsengineeringcollege.R;

public class TimeTableActivity extends AppCompatActivity {
    ZoomageView timeTable;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        setTitle("TimeTable");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(TimeTableActivity.this);
      /*  timeTable = findViewById(R.id.myZoomTimeTableView);
        String string = sharedPreferences.getString(MyConstants.SECTION, "A");
        if (string.equals("A") || string.equals("B") || string.equals("C")) {
            Glide.with(this)
                    .load(MyConstants.SPORT_CALENDER)
                    .thumbnail(0.5f)
                    .into(timeTable);
        } else {
            Glide.with(this)
                    .load(MyConstants.SPORT_CALENDER)
                    .thumbnail(0.5f)
                    .into(timeTable);
        }
    }*/
    }
}
