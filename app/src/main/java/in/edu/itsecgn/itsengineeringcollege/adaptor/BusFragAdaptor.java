package in.edu.itsecgn.itsengineeringcollege.adaptor;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.activities.BusRouteActivity;
import in.edu.itsecgn.itsengineeringcollege.fragment.RouteOneFragment;
import in.edu.itsecgn.itsengineeringcollege.fragment.RouteTwoFragment;

public class BusFragAdaptor extends FragmentPagerAdapter {

    private BusRouteActivity mContext;

    public BusFragAdaptor(FragmentManager fm, BusRouteActivity context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RouteOneFragment();
            case 1:
                return new RouteTwoFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return mContext.getResources().getString(R.string.route_1);
            case 1:
                return mContext.getResources().getString(R.string.route_2);

        }
        return null;
    }
}
