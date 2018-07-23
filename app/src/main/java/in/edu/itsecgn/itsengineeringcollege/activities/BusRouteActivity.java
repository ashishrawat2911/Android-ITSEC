package in.edu.itsecgn.itsengineeringcollege.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.adaptor.BusFragAdaptor;
import in.edu.itsecgn.itsengineeringcollege.adaptor.HostelAdaptor;

public class BusRouteActivity extends AppCompatActivity {

    private SmartTabLayout mSmartTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route);
        setTitle("Bus Route");
        mSmartTabLayout = (SmartTabLayout) findViewById(R.id.tab_view_pager_fav);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_fav);
        mViewPager.setAdapter(new BusFragAdaptor(getSupportFragmentManager(), this));
        mSmartTabLayout.setViewPager(mViewPager);
    }
}
