package in.edu.itsecgn.itsengineeringcollege.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class SyllabusActivity extends AppCompatActivity {
    String bTechUrl = "https://aktu.ac.in/pdf/syllabus/Syllabus1819/allnew/AICTE%20Syllabus%202018-19%20-Common.pdf";
    String mBAUrl = "https://aktu.ac.in/pdf/syllabus/Syllabus1819/allnew/Final%20%20MBA%20I%20year%20%20Syllabus%20as%20per%20AICTE%20Model%20curriculam%20%202018.pdf";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        setTitle("Syllabus");
        imageView = findViewById(R.id.syllabusItsLogo);
        Glide.with(this)
                .load(MyConstants.ITS_LOGO_IMAGE)
                .into(imageView);
    }

    public void bTechSyllabus(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(bTechUrl));
        startActivity(i);
    }

    public void mBASyllabus(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(mBAUrl));
        startActivity(i);
    }
}
