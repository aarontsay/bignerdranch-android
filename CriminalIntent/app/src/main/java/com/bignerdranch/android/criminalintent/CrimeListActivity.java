package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by aaron on 7/8/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
