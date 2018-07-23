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

public class RouteTwoFragment extends Fragment {

    List<BusRoute> busRouteList;
    private RecyclerView busRecyclerView;
    BusAdaptor busRecyclerViewAdaptor;

    public RouteTwoFragment() {
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

        busRouteList.add(new BusRoute("06:50 A.M.", "Mohan Nagar"));
        busRouteList.add(new BusRoute("06:55 A.M.", "Vasundhara Sec. 16"));
        busRouteList.add(new BusRoute("07:00 A.M.", "Anand Vihar (Metro Station)"));
        busRouteList.add(new BusRoute("07:05 A.M.", "Vaishali Sec. 04"));
        busRouteList.add(new BusRoute("07:10 A.M", "Indiarapuram (DPS)"));
        busRouteList.add(new BusRoute("07:15 A.M", "CISF Camp"));
        busRouteList.add(new BusRoute("07:22 A.M.", "Fortis Hospital (Sec. 62)"));
        busRouteList.add(new BusRoute("07:30 A.M.", "Adobe"));
        busRouteList.add(new BusRoute("07:40 A.M.", "Sec.- 25/26 Gate"));
        busRouteList.add(new BusRoute("07:45 A.M.", "Golf Course"));
        busRouteList.add(new BusRoute("07:55 A.M.", "Sec. 50 Noida"));
        busRouteList.add(new BusRoute("08:00 A.M", "Sec. 49 (Red Light)"));
        busRouteList.add(new BusRoute("08:10 A.M", "Sec. 100 Noida (Pathways School)"));
        busRouteList.add(new BusRoute("08:30 A.M", "I.T.S Engineering College"));
    }
}
