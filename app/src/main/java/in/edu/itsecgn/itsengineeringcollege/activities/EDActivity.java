package in.edu.itsecgn.itsengineeringcollege.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class EDActivity extends AppCompatActivity {
    ImageView profileImage;
    TextView name, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Executive Director");
        setContentView(R.layout.activity_ed);
        name = findViewById(R.id.profileName);
        desc = findViewById(R.id.profileDesc);
        profileImage = findViewById(R.id.profileImage);
        setProfileText(name, "Prof. (Dr.) Vikas Singh");

        setProfileText(desc, getString(R.string.director_desc));
        Glide.with(this)
                .load(MyConstants.DIRECTOR_IMAGE_URL)
                .thumbnail(0.5f)
                .into(profileImage);
    }

    void setProfileText(TextView t, String s) {
        t.setText(s);
    }


}
