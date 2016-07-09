package com.bignerdranch.android.criminalintent;

import android.content.Context;

/**
 * Created by aaron on 7/8/16.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
    }

    private CrimeLab(Context context) {
    
    }
}
