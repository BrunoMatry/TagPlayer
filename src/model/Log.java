package model;

public class Log {
    public static void log(String s) {
        System.out.println(s);
    }
    
    public static void addTagLog(String musicFileName, String tagName) {
        Log.log("[Tag] \"" + tagName + "\" added on file \"" + musicFileName + "\"");
    }
}
