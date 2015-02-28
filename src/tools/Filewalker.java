package tools;

import java.io.File;
import java.util.ArrayList;

public class Filewalker {
    private ArrayList<File> files;

    public Filewalker(String path) {
        files = new ArrayList<>();
        this.walk(path); 
    }
    
    private void walk (String path) {
        File root = new File(path);
        for (File f : root.listFiles()) { 
            if (f.isDirectory()) { 
                walk(f.getAbsolutePath());  
            } else if(!f.isHidden() && f.isFile()) {
                files.add(f);
            }
        }
    }
    
    public ArrayList<File> getFiles() {
        return files;
    }
} 
