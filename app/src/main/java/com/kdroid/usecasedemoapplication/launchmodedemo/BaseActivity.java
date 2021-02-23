package com.kdroid.usecasedemoapplication.launchmodedemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected static ActivityManager activityManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (activityManager == null) {
            activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        }

    }

    protected void startActivity(Activity activity, Class targetActivityClass) {
        Intent intent = new Intent(activity, targetActivityClass);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected static String getAppTaskState() {
        StringBuilder stringBuilder = new StringBuilder();
        int totalNumberOfTasks = activityManager.getRunningTasks(10).size();//Returns total number of tasks - stacks
        stringBuilder.append("\nNumber of task: "+activityManager.getAppTasks().size()+"\n\n");
        stringBuilder.append("\nTotal Number of Tasks: " + totalNumberOfTasks + "\n\n");

        List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(10);//returns List of RunningTaskInfo - corresponding to tasks - stacks

        for (ActivityManager.RunningTaskInfo info : taskInfo) {
            stringBuilder.append("Task Id: " + info.id + ", Number of Activities : " + info.numActivities + "\n");//Number of Activities in task - stack

            // Display the root Activity of task-stack
            stringBuilder.append("TopActivity: ").append(info.topActivity.getClassName().replace("com.kdroid.usecasedemoapplication.launchmodedemo.", "")).append("\n");

            // Display the top Activity of task-stack
            stringBuilder.append("BaseActivity:").append(info.baseActivity.getClassName().
                    replace("com.kdroid.usecasedemoapplication.launchmodedemo.", "")).append("\n");
            stringBuilder.append("\n\n");

        }
        return stringBuilder.toString();
    }

}


