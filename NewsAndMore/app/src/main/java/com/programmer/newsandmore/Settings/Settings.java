package com.programmer.newsandmore.Settings;


import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;


import androidx.preference.PreferenceManager;

import com.programmer.newsandmore.R;


public class Settings extends PreferenceActivity {

    public static final String TAG = Settings.class.getSimpleName();
    private Ringtone ringtone;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        Load_setting();
    }

    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        final ListPreference lf = (android.preference.ListPreference) findPreference("ORIENTATION");

        String orien = sp.getString("ORIENTATION", "false");
        if ("1".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
            lf.setSummary(lf.getEntry());
        }
        else if ("2".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            lf.setSummary(lf.getEntry());
        }
        else if ("3".equals(orien)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            lf.setSummary(lf.getEntry());
        }

        lf.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference prefs, Object obj) {

                String items = (String) obj;
                if (prefs.getKey().equals("ORIENTATION")){
                    switch (items){
                        case "1":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
                            break;
                        case "2":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                            break;
                        case "3":
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                            break;
                    }
                    ListPreference lpp = (ListPreference) prefs;
                    lpp.setSummary(lpp.getEntries()[lpp.findIndexOfValue(items)]);
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        Load_setting();

        SharedPreferences sharedPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this);
        String path = sharedPreferences.getString("Ringtone", "");
        Log.v(TAG, "path: " + path);

        if (!path.isEmpty()) {
            ringtone = RingtoneManager.getRingtone(this, Uri.parse(path));
            ringtone.play();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (ringtone !=null && ringtone.isPlaying()) {
            ringtone.stop();
        }
        super.onPause();
    }
}



