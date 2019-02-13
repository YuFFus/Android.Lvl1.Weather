package com.yuriy.fedak.weather;

import android.content.Context;
import android.widget.Toast;

public class ViewUtility {
    public static void makeToast (Context context, String toast){
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
