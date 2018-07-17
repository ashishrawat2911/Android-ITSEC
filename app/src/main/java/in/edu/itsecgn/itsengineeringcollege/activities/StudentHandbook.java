package in.edu.itsecgn.itsengineeringcollege.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.edu.itsecgn.itsengineeringcollege.R;

public class StudentHandbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_handbook);
        setTitle("Students HandBook");
    }
}
