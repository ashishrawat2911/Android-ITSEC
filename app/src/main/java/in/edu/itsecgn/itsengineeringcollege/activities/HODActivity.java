package in.edu.itsecgn.itsengineeringcollege.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class HODActivity extends AppCompatActivity {
    ImageView profileImage;
    TextView name, desc;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
        setTitle("Head of Department");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(HODActivity.this);
        name = findViewById(R.id.profileName);
        desc = findViewById(R.id.profileDesc);
        profileImage = findViewById(R.id.profileImage);

        if (sharedPreferences.getBoolean(MyConstants.GUEST_LOGIN, true)) {
            Glide.with(this)
                    .load(MyConstants.LOGIN_IN_REQUIRED_LINK)
                    .thumbnail(0.5f)
                    .into(profileImage);
        } else {
            if (sharedPreferences.getString(MyConstants.COURSE, "btech").equals("btech")) {
                Glide.with(this)
                        .load(MyConstants.DIRECTOR_IMAGE_URL)
                        .thumbnail(0.5f)
                        .into(profileImage);
                setProfileText(name, "O.P Chaudhary");
                setProfileText(desc, "Designation: Professor & Head \n" +
                        "\nDepartment: Applied Sciences and Humanities\n" +
                        "\n\nDr. O. P. Chaudhary is an alumnus of Gorakhpur University. He specializes in Pure Mathematics (Differential Manifolds). In his two decade long teaching career he has taught subjects like Engineering Mathematics, Complex variables, Business statistics and Numerical analysis. \n" +
                        "\n\nHe has presided over many seminars, been resource to a number of workshops and has also been entrusted with several administrative capacities. Dr. Chaudhary has written five text books for engineers. He also has eleven research papers in internationals and national journals to his credit. His interest lies in Differential Manifolds and he is the member of ISTE. \n" +
                        "\n\nHe worked as a member of Board of Studies in APJ Abdul Kalam Technical University and SPOC of NPTEL courses. He also rendered various services assigned by University as Co-ordinator of UPSEE counseling, Controller of Examinations and Incharge of Digital evaluation.\n" +
                        "\n\nHe loves reading books, writing and listening music.\n");
            } else if (sharedPreferences.getString(MyConstants.COURSE, "btech").equals("mba")) {
                Glide.with(this)
                        .load(MyConstants.HOD_MBA_PICTURE)
                        .thumbnail(0.5f)
                        .into(profileImage);
                setProfileText(name, "");
                setProfileText(desc, "");
            }

        }
    }

    void setProfileText(TextView t, String s) {
        t.setText(s);
    }
}
