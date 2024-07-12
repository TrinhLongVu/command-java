package com.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleFile {
    private String _filename;

    public HandleFile(String filename) {
        this._filename = filename;
    }
    
    public List<String> readFile() {
        List<String> result = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(_filename);
             Scanner sc = new Scanner(inputStream, "UTF-8")) {
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                result.add(line);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + _filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + _filename);
        }
        
        return result;
    }
}
