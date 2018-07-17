package in.edu.itsecgn.itsengineeringcollege.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.edu.itsecgn.itsengineeringcollege.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsHostelFragment extends Fragment {

    TextView title, desc;
    public GirlsHostelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hostel, container, false);
        title=view.findViewById(R.id.hostelTitle);
        desc=view.findViewById(R.id.hosteldesc);
        title.setText("Girls Hostel Rules");
        desc.setText(getString(R.string.girls_hostel_rules));
        return view;
    }

}
