package com.dismaltoken.tradebinder;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortNamesTest {
    @Test
    public void sortTest() throws IOException {
        ArrayList<String> names = readNamesFile();
        Collections.sort(names);
        for(String name : names) {
            System.out.println(name);
        }
    }

    private ArrayList<String> readNamesFile() throws IOException {
        ArrayList<String> names = new ArrayList<String>();
        File inputFile = new File("cardNames2018-09-06.txt");
        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while(null != (line = bufferedReader.readLine())) {
            names.add(line);
        }
        return names;
    }
}
