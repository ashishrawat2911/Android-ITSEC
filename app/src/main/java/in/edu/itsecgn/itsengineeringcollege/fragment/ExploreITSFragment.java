package in.edu.itsecgn.itsengineeringcollege.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.activities.ExploreITSActivity;

import static in.edu.itsecgn.itsengineeringcollege.constants.MyConstants.ITS_URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreITSFragment extends Fragment {

    WebView webView;
    ProgressBar progressBar;

    public ExploreITSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore_it, container, false);
        getActivity().setTitle("Explore I.T.S");
        progressBar = view.findViewById(R.id.progressBarWebView);
        progressBar.setIndeterminate(true);
        webView = view.findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(ITS_URL);
        return view;
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
