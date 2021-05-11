package com.maxkorte;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);

        try{
            File quellDatei = new File(args[0]);
            File zielDatei = new File(args[1]);

            if(!quellDatei.exists() || quellDatei.isDirectory()){
                System.out.println("Erstes Argument muss eine existierende Datei sein!");
                System.exit(1);
            }

            if(zielDatei.exists()){
                System.out.println("Datei existiert bereits!");
                System.exit(1);
            }

            zielDatei.getParentFile().mkdirs();

            Path quellPath = quellDatei.toPath();
            Path zielPath = zielDatei.toPath();
            Path ergebnisPath = Files.copy(quellPath, zielPath);
            ergebnisPath.toFile();

            System.out.println("Datei wurde kopiert!");
            System.exit(0);
        } catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }


    }
}
