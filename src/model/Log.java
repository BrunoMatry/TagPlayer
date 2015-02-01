package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import tools.database.MyFileWriter;

public class Log {
    private static DateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
    
    private static void log(String state, String message) {
        String logMessage = "[" + state + "]" + dateFormat.format(new Date()) + " " + message;
        System.out.println(logMessage);
        MyFileWriter.writeLog(logMessage);
    }
    
    public static void addTagLog(String musicFileName, String tagName) {
        Log.log("Tag", " \"" + tagName + "\" added on file \"" + musicFileName + "\"");
    }

    public static void onCloseLog() {
        Log.log("Closed", " Successfully saved database");
    }
    
    public static void onOpeningLog() {
        Log.log("Open", "");
    }

    public static void onInternalErrorLog(String message) {
        Log.log("Internal Error", message);
    }
}
