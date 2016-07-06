package com.bignerdranch.android.criminalintent;

import java.util.UUID;

/**
 * Created by aaron on 7/5/16.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }
}
