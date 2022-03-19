package com.example.myapplicationcomputo01senati.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplicationcomputo01senati.R;
import com.example.myapplicationcomputo01senati.claseComputadoras;
import com.example.myapplicationcomputo01senati.claseImpresoras;
import com.example.myapplicationcomputo01senati.claseTeclados;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                claseComputadoras tab1  = new claseComputadoras();
                return  tab1;
            case 1:
                claseImpresoras tab2  = new claseImpresoras();
                return  tab2;
            case 2:
                claseTeclados tab3  = new claseTeclados();
                return  tab3;
            default:
                return null;
        }
        //return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0: return "Computadoras";
            case 1: return "Impresoras";
            case 2: return "Teclados";

        }
        return  null;
        // return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}