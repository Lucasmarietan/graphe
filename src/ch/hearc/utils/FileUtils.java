package ch.hearc.utils;

import ch.hearc.business.Graph;

import java.io.*;
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

    public static Graph load(String filename) {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        Graph g = null;
        try {
            fis = new FileInputStream(new File(filename));
            in = new ObjectInputStream(fis);
            g = (Graph) in.readObject();
        } catch (Exception ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return g;
    }
}


