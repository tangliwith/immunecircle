package com.ecuca.immunecircle.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ecuca.immunecircle.ui.base.BaseMvpActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivitySwitcher {

    public static List<BaseMvpActivity> activities = new ArrayList<BaseMvpActivity>();

    public static void addActivity(BaseMvpActivity activity) {
        activities.add(activity);
    }

    public static void removeActivity(BaseMvpActivity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (BaseMvpActivity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static void start(final Activity from,
                             final Class<? extends Activity> to, final Bundle bundle, boolean isFinish) {
        start(from, new Intent(from, to).putExtras(bundle), isFinish);

    }

    public static void start(final Activity from,
                             final Class<? extends Activity> to, boolean isFinish) {
        start(from, new Intent(from, to), isFinish);
    }

    public static void start(final Activity from, final Intent intent, boolean isFinish) {
        from.startActivity(intent);
        if (isFinish) {
            from.finish();
        }

    }

    public static void finish(final Activity act) {
        act.finish();

    }

}
