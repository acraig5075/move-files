package net.za.acraig.movefiles;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class QuickPrefsActivity extends PreferenceActivity
	{

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.pref);
		}

	}
