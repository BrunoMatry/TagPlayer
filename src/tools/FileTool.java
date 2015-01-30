package tools;

import java.io.File;

public class FileTool {
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
        }
        return "";
    }
    
    public static String removeFileExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
}
