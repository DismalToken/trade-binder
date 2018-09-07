//package com.dismaltoken.tradebinder;
////import java.io.BufferedReader;
////import java.io.InputStream;
////import java.io.InputStreamReader;
////import java.net.URL;
////import java.net.URLEncoder;
////import org.testng.annotations.Test;
////
////public class ScryfallScraperTest {
////    @Test
////    public void firstScryfall() throws Exception {
////        final String pattern = "https://scryfall.com/search?as=text&order=name&page=%d&q=%s&unique=cards";
////        final String query = "(c:W OR c:U OR c:B OR c:R or c:G or c:C)";
////        final String urlString = String.format(pattern, 1, URLEncoder.encode(query, "ASCII"));
////        final URL url = new URL(urlString);
////        final InputStream inputStream = url.openStream();
////        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
////        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
////        String line;
////        while(null != (line = bufferedReader.readLine())) {
////            System.out.println(line);
////        }
////    }
////}
package com.dismaltoken.tradebinder;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

public class ScryfallScraperTest {
    private static final int numPages = 306;
    private static final String outputFileName = "foo.txt";
    @Test
    public void firstScryfall() throws IOException {
        ArrayList<String> allNames = allNamesGetter();
        Assert.assertTrue(allNames.size() >= 60);
        writeNamesIntoFile(allNames, outputFileName);
    }

    @Test
    public void page306() throws IOException {
        writeNamesIntoFile(nameGetter(306), "bar.txt");
    }

    private ArrayList<String> allNamesGetter() throws IOException {
        ArrayList<String> allNames = new ArrayList<String>();
        for(int i = 1; i <= numPages; i++) {
            ArrayList<String> theseNames = nameGetter(i);
            allNames.addAll(theseNames);
        }
        return allNames;
    }

    private ArrayList<String> nameGetter(int pageNumber) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        final InputStream inputStream = getInputStream(pageNumber);
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String thisLine;
        String previousLine = "";
        while (null != (thisLine = bufferedReader.readLine())) {
            if (previousLine.contains("<h6 class=\"card-text-title\">")) {
                thisLine = thisLine.trim();
                thisLine = thisLine.replace("&#39;", "'");
                thisLine = thisLine.replace("&quot;", "\"");
                list.add(thisLine);
            }
            previousLine = thisLine;
        }
        return list;
    }

    private InputStream getInputStream(int i) throws IOException {
        final String pattern = "https://scryfall.com/search?as=text&order=name&page=%d&q=%s&unique=cards";
        final String query = "(c:W OR c:U OR c:B OR c:R or c:G or c:C)";
        final String urlString = String.format(pattern, i, URLEncoder.encode(query, "ASCII"));
        final URL url = new URL(urlString);
        return url.openStream();
    }

    private void writeNamesIntoFile(ArrayList<String> names, String fileName) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        writeNames(bufferedWriter, names);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private void writeNames(BufferedWriter bufferedWriter, ArrayList<String> names) throws IOException {
        for (final String name : names) {
            bufferedWriter.write(name);
            bufferedWriter.write("\n");
        }
    }
}





