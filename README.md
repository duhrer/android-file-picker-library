# What is this thing?

This project provides a simple file picker for apps that work with files.  It is meant to be added to an Android application and then listed as one of its available activities.

# Using the file picker in your project

To use the recorder in your project, you must do two things:

1. Include it in your Gradle dependencies.
2. Define the activity in your AndroidManifest.xml
3. To actually use the activity, your app should launch the file picker intent (see below).

If you want to see all of this wired together in a real project, check out the source for [Free Speech](https://bitbucket.org/duhrer/free-speech-for-android/).

## Including the file picker in your Gradle dependencies

In your Android project, you will need to add the dependency to any modules that use the file picker library.  You do this by editing the module (and not the project) `build.gradle` file and updating your `dependencies` block, as in this example:

    :::
    dependencies {
        compile 'com.blogspot.tonyatkins:picker:2.0.1'
    }

This library is published as an AAR file to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22picker%22) and [jCenter](https://bintray.com/bintray/jcenter/com.blogspot.tonyatkins%3Apicker/).  Once you've added the dependency, it should be available in your project as soon as you clean and rebuild the project.

If you want to see the list of available versions, check out either the Maven Central or JCenter links above.  Please note that the 1.x versions were designed to work with Maven.  You should only use 2.0.1 or higher with your Gradle project.

## Defining the activity in your AndroidManifest.xml

You will need to define the (external) activity in your `AndroidManifest.xml` file, as follows:

    :::xml
    <!--
         File picker activity, which requires the following external library project:
        https://bitbucket.org/duhrer/android-file-picker-library
    -->
    <activity
        android:name="com.blogspot.tonyatkins.picker.activity.FilePickerActivity"
        android:icon="@drawable/icon"
        android:label="@string/app_name" >
        <intent-filter>
            <action android:name="com.blogspot.tonyatkins.picker.action.FILE_PICKER" />

            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>

Note that you can choose the label and icon, in this example I have picked up the standard icon and app name for my existing project.  thus, when a user presses the "record" button, they simply see that my application can handle the recording for them.  They never have to know that they're using this library at all... :)

The comment pointing to the source URL isn't strictly necessary, but you should of course make it clear you're using the library (it's part of the license, after all).

## Launching the standard file picker intent

To be able to see this library in action, you also need to launch an intent whose action is `android.provider.MediaStore.RECORD_SOUND` (the standard intent for recording a sound), as in the following example:

    :::java
		Intent soundPickerIntent = new Intent(this, FilePickerActivity.class);
		soundPickerIntent.putExtra(FilePickerActivity.FILE_TYPE_BUNDLE, FileIconListAdapter.SOUND_FILE_TYPE);
		soundPickerIntent.putExtra(FilePickerActivity.CWD_BUNDLE, tempButton.getSoundPath());

The file picker supports a "file type" option, so that you can filter for images or sounds.  This is passed to the intent using the `FilePickerActivity.FILE_TYPE_BUNDLE` extra as in the previous example.  The supported options are:

1. `FileIconListAdapter.SOUND_FILE_TYPE`:
2. `FileIconListAdapter.IMAGE_FILE_TYPE`:
3. `FileIconListAdapter.BACKUP_FILE_TYPE`:

The file picker also supports a starting directory argument, passed using the `FilePickerActivity.CWD_BUNDLE` extra as in the previous example.

# Contributing

If you're using this library, giving credit is the least you can do.  If you want to do more, consider becoming a contributor.

The library could use a bit of work in terms of tests, design, adding additional translations, you name it.

If you would like to help, please get in touch or simply file an issue on BitBucket with a problem you've encountered or feature you'd like to see.
