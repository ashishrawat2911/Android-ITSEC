package in.edu.itsecgn.itsengineeringcollege.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.adaptor.BusAdaptor;
import in.edu.itsecgn.itsengineeringcollege.model.BusRoute;

public class RouteOneFragment extends Fragment {

    List<BusRoute> busRouteList;
    private RecyclerView busRecyclerView;
    BusAdaptor busRecyclerViewAdaptor;

    public RouteOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_route_one, container, false);
        busRecyclerView = view.findViewById(R.id.busRecyclerView);
        addData();
        busRecyclerViewAdaptor = new BusAdaptor(getContext(), busRouteList);
        busRecyclerView.setAdapter(busRecyclerViewAdaptor);
        busRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        return view;
    }

    private void addData() {
        busRouteList = new ArrayList<>();
        busRouteList.add(new BusRoute("06:55 A.M.", "Vasundhara Sector 16"));
        busRouteList.add(new BusRoute("06:57 A.M.", "Atal Chowk"));
        busRouteList.add(new BusRoute("07:00 A.M.", "Budh Chowk"));
        busRouteList.add(new BusRoute("07:05 A.M.", "Mohan Nagar"));
        busRouteList.add(new BusRoute("07:10 A.M", "New Bus Stand GZB"));
        busRouteList.add(new BusRoute("07:15 A.M", "Hapur More"));
        busRouteList.add(new BusRoute("07:17 A.M.", "Old Bus Stand"));
        busRouteList.add(new BusRoute("07:20 A.M.", "Hapur Chungi"));
        busRouteList.add(new BusRoute("07:23 A.M.", "Shastri Nagar"));
        busRouteList.add(new BusRoute("07:30 A.M.", "Lal Kuan"));
        busRouteList.add(new BusRoute("07:45 A.M.", "Vijay Nagar Police Chowki"));
        busRouteList.add(new BusRoute("07:50 A.M.", "Vijay Nagar Bypass"));
        busRouteList.add(new BusRoute("07:55 A.M.", "Exotica Appt."));
        busRouteList.add(new BusRoute("08:00 A.M", "Kisan Chowk (Chaar Murti)"));
        busRouteList.add(new BusRoute("08:20 A.M", "Surajpur"));
        busRouteList.add(new BusRoute("08:30 A.M", "I.T.S Engineering College"));
    }
}
