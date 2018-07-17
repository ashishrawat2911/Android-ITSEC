package in.edu.itsecgn.itsengineeringcollege.adaptor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.edu.itsecgn.itsengineeringcollege.fragment.BoysHostelFragment;
import in.edu.itsecgn.itsengineeringcollege.fragment.GirlsHostelFragment;
import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.activities.HostelRulesActivity;

public class HostelAdaptor extends FragmentPagerAdapter {

    private HostelRulesActivity mContext;

    public HostelAdaptor(FragmentManager fm, HostelRulesActivity context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BoysHostelFragment();
            case 1:
                return new GirlsHostelFragment();

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
                return mContext.getResources().getString(R.string.boys);
            case 1:
                return mContext.getResources().getString(R.string.girls);

        }
        return null;
    }
}
