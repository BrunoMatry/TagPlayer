package tools.database;

import controller.ApplicationParameters;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Log;
import model.MusicFile;
import model.MusicFileList;

public class MyFileReader {

    public static void loadInDba(MusicFileList list) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("database.pdb"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String filePath = line.substring(0, line.indexOf(ApplicationParameters.FILE_SEPARATOR));
                    MusicFile mf = list.getMusicFileFromFilePath(filePath);
                    if(mf != null) {
                        do {
                            line = line.substring(line.indexOf(ApplicationParameters.FILE_SEPARATOR)+1);
                            if(line.contains(ApplicationParameters.FILE_SEPARATOR)) {
                                mf.addTag(line.substring(0, line.indexOf(ApplicationParameters.FILE_SEPARATOR)));
                            } else {
                                mf.addTag(line);
                            }
                        } while(line.contains(ApplicationParameters.FILE_SEPARATOR));
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        } catch (IOException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        }
    }
    
}
