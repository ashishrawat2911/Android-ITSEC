package in.edu.itsecgn.itsengineeringcollege.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class MentorActivity extends AppCompatActivity {
    ImageView profileImage;
    TextView name, desc;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        setTitle("Your Mentor");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MentorActivity.this);

        name = findViewById(R.id.profileName);
        desc = findViewById(R.id.profileDesc);
        profileImage = findViewById(R.id.profileImage);
        setProfileText(name, "");
        setProfileText(desc, "");
        if (sharedPreferences.getBoolean(MyConstants.GUEST_LOGIN, true)) {
            Glide.with(this)
                    .load(MyConstants.LOGIN_IN_REQUIRED_LINK)
                    .thumbnail(0.5f)
                    .into(profileImage);
            setProfileText(name, "");
            setProfileText(desc, "");
        } else {
            loadData(sharedPreferences.getString(MyConstants.MENTOR_ID, "0"));

        }
    }

    private void loadData(final String string) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, MyConstants.MENTOR_JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("mentor");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Toast.makeText(MentorActivity.this, "mentor id "+jsonObject.getString("mentor_id"), Toast.LENGTH_SHORT).show();

                        if (sharedPreferences.getString(MyConstants.MENTOR_ID,"0").equals(jsonObject.getString("mentor_id"))) {

                            setProfileImage(jsonObject.getString("mentor_image"));
                            setProfileText(name, jsonObject.getString("mentor_name"));
                            setProfileText(desc, jsonObject.getString("designation") + "\n\n" +
                                    jsonObject.getString("department") + "\n\n" + jsonObject.getString("description"));
                            break;
                        } else {
                            setProfileText(name, "");

                            setProfileText(desc, "");
                            break;
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(MentorActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        }
                , new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MentorActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(MentorActivity.this);
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    void setProfileImage(String url) {
        Glide.with(this)
                .load(url)
                .thumbnail(0.5f)
                .into(profileImage);
    }

    void setProfileText(TextView t, String s) {
        t.setText(s);
    }
}
