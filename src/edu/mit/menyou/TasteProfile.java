package edu.mit.menyou;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import edu.mit.menyou.Tastes.DummySectionFragment;
import edu.mit.menyou.Tastes.DummySectionFragment2;
import edu.mit.menyou.Tastes.DummySectionFragment3;
import edu.mit.menyou.Tastes.DummySectionFragment4;
import edu.mit.menyou.Tastes.DummySectionFragment5;
import edu.mit.menyou.Tastes.SectionsPagerAdapter;
import edu.mit.menyou.home.Home;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TasteProfile extends FragmentActivity {
	
	private static final List<String> dislikes_list = new ArrayList<String>();
	private static final List<String> likes_list = new ArrayList<String>();
	private static final List<String> allergies_full = new ArrayList<String>();
	private static final List<String> food_list = new ArrayList<String>();
	
	final static String allergiesKey = "edu.mit.menyou.allergies";
	final static String likesKey = "edu.mit.menyou.likes";
	final static String dislikesKey = "edu.mit.menyou.dislikes";

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollable_stuff);
		getActionBar().setDisplayShowTitleEnabled(false);

		findViewById(R.id.setup_button);
		
		// Create the adapter that will return a fragment for each of the four
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
	    public Fragment getItem(int position) {
	        // getItem is called to instantiate the fragment for the given page.
	        // Return a DummySectionFragment (defined as a static inner class
	        // below) with the page number as its lone argument.
	    switch (position) {
	        case 0:
	            Fragment fragment = new DummySectionFragment();
	            Bundle args = new Bundle();
	            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
	            fragment.setArguments(args);
	            return fragment;

	          case 1:
	            Fragment fragment2 = new DummySectionFragment2();
	            Bundle args2 = new Bundle();
	            args2.putInt(DummySectionFragment2.ARG_SECTION_NUMBER, position + 2);
	            fragment2.setArguments(args2);
	            return fragment2;

	          case 2:

	             Fragment fragment3 = new DummySectionFragment3();
	             Bundle args3 = new Bundle();
	             args3.putInt(DummySectionFragment3.ARG_SECTION_NUMBER, position + 3);
	             fragment3.setArguments(args3);
	             return fragment3;
	         
	          case 3:

		             Fragment fragment4 = new DummySectionFragment4();
		             Bundle args4 = new Bundle();
		             args4.putInt(DummySectionFragment4.ARG_SECTION_NUMBER, position + 3);
		             fragment4.setArguments(args4);
		             return fragment4;

	        default:
	            return null;
	    }}

		@Override
		public int getCount() {
			// Show 5 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section2).toUpperCase(l);
			case 1:
				return getString(R.string.title_section3).toUpperCase(l);
			case 2:
				return getString(R.string.title_section4).toUpperCase(l);
			case 3:
				return getString(R.string.title_section5).toUpperCase(l);
			}
			return null;
		}}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView2 = inflater.inflate(R.layout.fragment_scrollable_stuff_dummy2, container, false);
			allergies_full.add("egg");
			allergies_full.add("fish");
			allergies_full.add("milk");
			allergies_full.add("peanuts");
			allergies_full.add("soy");
			allergies_full.add("tree nuts");
			allergies_full.add("shellfish");
			allergies_full.add("wheat");
			final TextView allergies = (TextView) rootView2.findViewById(R.id.allergies);
			final ListView lv = (ListView) rootView2.findViewById(R.id.listView2);
			final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1, allergies_full);
			lv.setAdapter(adapter);
			
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		 	     public void onItemClick(AdapterView<?> adapter, View view, int position,long id) { 
			         // We know the View is a TextView so we can cast it
				         TextView clickedView = (TextView) view;
					     allergies.setText(allergies.getText()+" "+clickedView.getText().toString());
					     }
					});
			return rootView2;
		}
	}
	public static class DummySectionFragment2 extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment2() {}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView3 = inflater.inflate(R.layout.fragment_scrollable_stuff_dummy3, container, false);
			
			food_list.add("pad thai");
			final TextView likes = (TextView) rootView3.findViewById(R.id.likes);
			final ListView lv = (ListView) rootView3.findViewById(R.id.listView3);
			final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1, food_list);
			lv.setAdapter(adapter);
			
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		 	     public void onItemClick(AdapterView<?> adapter, View view, int position,long id) { 
			         // We know the View is a TextView so we can cast it
				         TextView clickedView = (TextView) view;
					     likes.setText(likes.getText()+" "+clickedView.getText().toString());
					     }
					});
			return rootView3;
			
		}
	}
	public static class DummySectionFragment3 extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment3() {}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_scrollable_stuff_dummy4, container, false);
			return rootView;
		}
	}
	public static class DummySectionFragment4 extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment4() {}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView5 = inflater.inflate(R.layout.fragment_scrollable_stuff_dummy5, container, false);
					      
	        rootView5.findViewById(R.id.setup_button).setOnClickListener(new View.OnClickListener() {
	                    
	                	public void onClick(View view) {
	                        Intent intent = new Intent(getActivity(), Home.class);
	                        startActivity(intent);
	                    }
	                });
			return rootView5;
	}
	}


}
