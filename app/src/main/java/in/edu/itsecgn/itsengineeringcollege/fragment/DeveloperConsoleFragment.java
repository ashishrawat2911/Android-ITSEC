package in.edu.itsecgn.itsengineeringcollege.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperConsoleFragment extends Fragment {

    ImageView facebook, twitter, instagram, ashishImage;
    Button email;
    ProgressBar progressBar;

    public DeveloperConsoleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_developer_console, container, false);
        progressBar = view.findViewById(R.id.progressBarDeveloper);
        facebook = view.findViewById(R.id.ashishFacebook);
        instagram = view.findViewById(R.id.ashishInstagram);
        twitter = view.findViewById(R.id.ashishTwitter);
        ashishImage = view.findViewById(R.id.ashishImage);
        email = view.findViewById(R.id.ashishEmail);
        progressBar.setIndeterminate(true);
        Glide.with(this)
                .load(MyConstants.ASHISH_IMAGE_LINK)
                .thumbnail(0.5f)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(ashishImage);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
setIntent(MyConstants.ASHISH_FACEBOOK_LINK);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(MyConstants.ASHISH_TWITTER_LINK);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(MyConstants.ASHISH_INSTAGRAM_LINK);

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, "ashishrawat2911@gmail.com");
                startActivity(intent);

            }
        });

        return view;

    }
    void setIntent(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
