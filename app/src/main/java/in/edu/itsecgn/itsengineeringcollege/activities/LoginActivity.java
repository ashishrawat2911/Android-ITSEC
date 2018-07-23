package in.edu.itsecgn.itsengineeringcollege.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

public class LoginActivity extends AppCompatActivity {
    EditText usernameLogin, passwordLogin;
    SharedPreferences sharedPreferences;
    TextView loginAlert;
    SharedPreferences.Editor sharedPreferencesEditor;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        usernameLogin = findViewById(R.id.usernameLogin);
        loginAlert = findViewById(R.id.loginAlert);
        passwordLogin = findViewById(R.id.passwordLogin);
    }

    public void login(View view) {
        if (Validate()) {
            loginAlert.setText(null);
            loadProgressBar();
            loadData();
        }

    }

    private void startActivityIntent() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void loadData() {

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, MyConstants.STUDENT_JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject object = new JSONObject(response);

                            JSONArray array = object.getJSONArray("students");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jo = array.getJSONObject(i);
                                if (usernameLogin
                                        .getText()
                                        .toString()
                                        .trim()
                                        .equals(jo.getString("email")) &&
                                        passwordLogin
                                                .getText()
                                                .toString()
                                                .equals(jo.getString("password"))) {
                                    Toast.makeText(LoginActivity.this, "welcome " + jo.getString("name"), Toast.LENGTH_SHORT).show();

                                    Log.i("Login activity", jo.getString("name"));
                                    setUserSharedPreferences(true, false, jo.getString("branch"), jo.getString("mentor_id"), jo.getString("section"));
                                    progress.dismiss();
                                    startActivityIntent();
                                    break;
                                }


                            }
                            if (!sharedPreferences.getBoolean(MyConstants.LOGGED_IN, false)) {
                                Toast.makeText(LoginActivity.this, "Details not found", Toast.LENGTH_SHORT).show();
                                progress.dismiss();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progress.dismiss();
                Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private boolean Validate() {
        if (usernameLogin.getText().toString().equals("")) {
            loginAlert.setText(R.string.empty_email_field);
            return false;
        } else if (passwordLogin.getText().toString().equals("")) {
            loginAlert.setText(R.string.empty_password_field);
            return false;
        } else if (usernameLogin.getText().toString().equals("") || passwordLogin.getText().toString().equals("")) {
            loginAlert.setText(R.string.empty_email_and_password);
            return false;
        }
        return true;
    }

    void setUserSharedPreferences(boolean b, boolean g, String branch, String mentor, String section) {
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putBoolean(MyConstants.LOGGED_IN, b);
        sharedPreferencesEditor.putBoolean(MyConstants.GUEST_LOGIN, g);
        sharedPreferencesEditor.putString(MyConstants.COURSE, branch);
        sharedPreferencesEditor.putString(MyConstants.MENTOR_ID, mentor);
        sharedPreferencesEditor.putString(MyConstants.SECTION, section);
        sharedPreferencesEditor.apply();
    }

    private void loadProgressBar() {
        progress = new ProgressDialog(LoginActivity.this);
        progress.setTitle("Logging in");
        progress.setMessage("Please wait....");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
    }

    public void guestLogin(View view) {
        setUserSharedPreferences(true, true, "", "", "A");
        startActivityIntent();
    }
}
