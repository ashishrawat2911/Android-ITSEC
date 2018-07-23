package in.edu.itsecgn.itsengineeringcollege.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.activities.ExploreITSActivity;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    ImageView imageView;
    TextView desc;
    Button visit;
    ProgressBar progressBar;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_about, container, false);
        getActivity().setTitle("About I.T.S");

        progressBar = view.findViewById(R.id.aboutProgressBar);
        imageView = view.findViewById(R.id.about_us_ImageView);
        desc = view.findViewById(R.id.itsdesc);
        visit = view.findViewById(R.id.about_visit);
        progressBar.setIndeterminate(true);
        Glide.with(this).load(MyConstants.ABOUT_US_IMAGE).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                desc.setText(getString(R.string.its_desc));
                visit.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ExploreITSActivity.class));
            }
        });
        return view;
    }

}
