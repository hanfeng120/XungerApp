package club.xunger.andapp.core.utils;

import android.content.Context;
import android.widget.Toast;

public class XungerToast {
    private static Toast toast;
    private static Context context;

    public static void init(Context context) {
        XungerToast.context = context;
        toast = new Toast(context);
    }

    private static void doShowToast(String message, int length) {
        toast.cancel();
        toast = Toast.makeText(context, message, length);
        toast.show();

    }

    public static void longToast(String toast) {
        doShowToast(toast, Toast.LENGTH_LONG);
    }

    public static void longToast(int id) {
        longToast(context.getString(id));
    }

    public static void shortToast(String toast) {
        doShowToast(toast, Toast.LENGTH_SHORT);
    }

    public static void shortToast(int id) {
        shortToast(context.getString(id));
    }

    public static void customToast(String toast, int length) {
        doShowToast(toast, length);
    }

    public static void customToast(int id, int length) {
        customToast(context.getString(id), length);
    }
}
