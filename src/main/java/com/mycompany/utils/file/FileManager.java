/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.file;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jean
 */
public class FileManager {
    private static final JFileChooser CHOOSER;
    
    static{
        
        CHOOSER = new JFileChooser();
        CHOOSER.setAcceptAllFileFilterUsed(true);        
    }
    
    public static void setSourceLocation(String path){
        CHOOSER.setCurrentDirectory(new File(path));
    }
    
    public static File getFile(Component parent){
        CHOOSER.setMultiSelectionEnabled(false);
        CHOOSER.showOpenDialog(parent);
        
        return CHOOSER.getSelectedFile();
    }
    
    public static File[] getFiles(Component parent){
        CHOOSER.setMultiSelectionEnabled(true);
        CHOOSER.showOpenDialog(parent);
        
        return CHOOSER.getSelectedFiles();
    }
    
    private static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
}
