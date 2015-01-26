package tools;

import java.io.File;

public class Filewalker { 

    public void walk(String path) { 

        File root = new File(path); 

        for (File f : root.listFiles()) { 
            if (f.isDirectory()) { 
                walk(f.getAbsolutePath()); 
                System.err.println("Dir:" + f.getAbsoluteFile()); 
            } 
            else { 
                System.err.println("File:" + f.getAbsoluteFile()); 
            } 
        } 
    } 

    public static void main(String[] args) { 
        Filewalker fw = new Filewalker(); 
        fw.walk("c:\\" ); 
    }
} 
