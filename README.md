[![](https://jitpack.io/v/mohappsdev/SwipeDismissLayout.svg)](https://jitpack.io/#mohappsdev/SwipeDismissLayout)

SwipeDismissLayout
===================

v1.3.0 by mohapps:

whether to swipe for dismiss or not will be determined based on touch area rather than a single child view's scrollability

(If views in the touched area can be scrolled in the same direction they can scroll otherwise swipe for dismiss can happen)

v1.2.0 by mohapps:

make activity dismissable by just a single line of code

support for more scrollable children

ignoring indirect swipes (children can scroll better)

v1.1.0 by mohapps:

added swipe from top, start, bottom, end with RTL support

migrated to AndroidX, updated Gradle and build tools


----------

SwipeDismissLayout is a viewgroup which if added as a parent viewgroup in the layout (activity) container, can enable the capability to finish the activity/fragment via slide down gesture.

----------

Requirements
-------------
**API Level 17+**

----------


Usage
-------------
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Add the dependency

        dependencies  {
	     implementation 'com.github.mohappsdev:SwipeDismissLayout:v1.3.0'
        }

Set translucent theme for that activity in AndroidManifest:

      <activity android:name="YourDismissFromStartActivity"
            android:theme="@style/SwipeDismissTheme">

Translucent theme includes:

         <item name="android:windowIsTranslucent">true</item>
         <item name="android:windowBackground">@android:color/transparent</item>

Do it Programmatically in onCreate

        Creator.createSwipeDismissLayout(this, true, DragFrom.START);

OR Wrap the activity you want to be dismissable in com.viewgroup.SwipeDismissLayout and set dismiss_direction:

        <com.viewgroup.SwipeDismissLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:swipe_enable="true"
    app:dismiss_direction="start">
     <!--Your Activity layout-->
        </com.viewgroup.SwipeDismissLayout>

If translucent theme causes your dismissable activity layout background to be transparent, set background for first layout element that you wrapped by com.viewgroup.SwipeDismissLayout

     <com.viewgroup.SwipeDismissLayout
     <!--Properties-->
     >
         <LinearLayout
         <!--Properties-->
         android:background="?android:colorBackground">
         </LinearLayout>
      </com.viewgroup.SwipeDismissLayout>



----------
Version
-------------
1.3.0

 ----------

## LICENSE

    Copyright 2020 mohapps

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
