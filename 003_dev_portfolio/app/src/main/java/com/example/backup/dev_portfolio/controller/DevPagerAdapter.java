package com.example.backup.dev_portfolio.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.backup.dev_portfolio.views.AboutFragment;
import com.example.backup.dev_portfolio.views.ContactFragment;
import com.example.backup.dev_portfolio.views.EducationFragment;
import com.example.backup.dev_portfolio.views.WorkFragment;

/**
 * Created by Backup on 1/4/2018.
 */

public class DevPagerAdapter extends FragmentPagerAdapter
{
    public DevPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: return new AboutFragment();
            case 1: return new WorkFragment();
            case 2: return new EducationFragment();
            case 3: return new ContactFragment();
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0: return "ABOUT";
            case 1: return "WORK";
            case 2: return "EDUCATION";
            case 3: return "CONTACT";
        }
        return super.getPageTitle(position);
    }
}
