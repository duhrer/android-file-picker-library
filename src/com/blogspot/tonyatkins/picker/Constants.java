package com.blogspot.tonyatkins.picker;

import android.os.Environment;

public class Constants {
	public static final String ACTION_PICK_FILE = "com.blogspot.tonyatkins.picker.action.FILE_PICKER";
	public static final String TAG = "File Picker";
	public static final String HOME_DIR = Environment.getExternalStorageDirectory() != null ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/";
}
