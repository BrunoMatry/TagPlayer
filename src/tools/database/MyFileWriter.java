package tools.database;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import model.Log;

public class MyFileWriter {
    
    public static void saveDataBase(Map<String, String> map) {
        try {
            try (Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("database.pdb"),
                            "utf-8"
                    )
            )) {
                for(Entry<String, String> entry : map.entrySet()) {
                    writer.append(
                        entry.getKey()
                        + entry.getValue()
                        + System.getProperty("line.separator")
                    );
                }
            }
        } catch (IOException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        }
    }

    public static void writeLog(String text) {
        try {
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.append(System.getProperty("line.separator") + text);
            }
        } catch (IOException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        }
    }
}
