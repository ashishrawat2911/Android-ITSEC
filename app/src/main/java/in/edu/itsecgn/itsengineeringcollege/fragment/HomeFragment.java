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
import in.edu.itsecgn.itsengineeringcollege.adaptor.MainListAdaptor;
import in.edu.itsecgn.itsengineeringcollege.model.MainList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    List<MainList> personList, studentMaterialList, extraList, newsEventsList;
    private RecyclerView personRecyclerView, studentRecyclerView, extraRecyclerView, newsRecyclerView;
    MainListAdaptor personRecyclerViewAdaptor, studentRecyclerViewAdaptor, extraRecyclerViewAdaptor, newsRecyclerAdaptor;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("I.T.S Engineering College");

        personRecyclerView = view.findViewById(R.id.personRecyclerView);
        studentRecyclerView = view.findViewById(R.id.studentsRecyclerView);
        extraRecyclerView = view.findViewById(R.id.extraRecyclerView);
        newsRecyclerView = view.findViewById(R.id.newsEventsRecyclerView);
        addData();
        addAdaptor();
        setAdapter();

        return view;
    }

    void setAdapter() {
        personRecyclerView.setAdapter(personRecyclerViewAdaptor);
        personRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        extraRecyclerView.setAdapter(extraRecyclerViewAdaptor);
        extraRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        newsRecyclerView.setAdapter(newsRecyclerAdaptor);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        studentRecyclerView.setAdapter(studentRecyclerViewAdaptor);
        studentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    void addAdaptor() {
        studentRecyclerViewAdaptor = new MainListAdaptor(getContext(), studentMaterialList);
        personRecyclerViewAdaptor = new MainListAdaptor(getContext(), personList);
        extraRecyclerViewAdaptor = new MainListAdaptor(getContext(), extraList);
        newsRecyclerAdaptor = new MainListAdaptor(getContext(), newsEventsList);
    }

    void addData() {
        personList = new ArrayList<>();
        studentMaterialList = new ArrayList<>();
        extraList = new ArrayList<>();
        newsEventsList = new ArrayList<>();
        personList.add(new MainList(2, "ED"));
        personList.add(new MainList(2, "HOD"));
        personList.add(new MainList(2, "Mentor"));
        studentMaterialList.add(new MainList(3, "Orientation Schedule"));
        studentMaterialList.add(new MainList(3, "Student Handbook"));
        studentMaterialList.add(new MainList(3, "Time Table"));
        studentMaterialList.add(new MainList(3, "BTech/MBA Syllabus"));
        studentMaterialList.add(new MainList(3, "Academic Calender"));
        extraList.add(new MainList(4, "Annual Calender"));
        extraList.add(new MainList(4, "Bus Route"));
        extraList.add(new MainList(4, "Sports"));
        extraList.add(new MainList(4, "Hostel Rules"));
        newsEventsList.add(new MainList(5, "Extra Curricular Activities"));
        newsEventsList.add(new MainList(5, "News Events"));
        newsEventsList.add(new MainList(5, "Notice and announcements"));
    }
}
