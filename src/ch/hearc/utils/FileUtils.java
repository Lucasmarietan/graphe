package ch.hearc.utils;

import ch.hearc.business.Graph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    public static void save(Graph g, String filename) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {

            fos = new FileOutputStream(new File(filename));
            out = new ObjectOutputStream(fos);
            out.writeObject(g);

        } catch (Exception ex) {

            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void load(){

    }
}


