package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
    
    public static void log(String s) {
        System.out.println(s);
    }
    
    private static String getTime() {
        return dateFormat.format(new Date());
    }
    
    public static void addTagLog(String musicFileName, String tagName) {
        Log.log("[Tag]" + getTime() + " \"" + tagName + "\" added on file \"" + musicFileName + "\"");
    }

    public static void onCloseLog() {
        Log.log("[Closed]" + getTime() + " Successfully saved database");
    }
}
