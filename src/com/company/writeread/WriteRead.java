package com.company.writeread;

import java.io.*;
import java.util.Arrays;

public class WriteRead {
    public static void writeRead() throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\czysty\\Documents\\GitHub\\TextEditorActual\\Text-Editor\\src\\com\\company\\Reader1");
        FileReader reader = new FileReader("C:\\Users\\czysty\\Documents\\GitHub\\TextEditorActual\\Text-Editor\\src\\com\\company\\Reader1");

        writer.write("fgdfgdfgfgdfg");
        writer.close();

        StringBuilder string = new StringBuilder();

        while (reader.ready()) {
            string.append(Character.toString(reader.read()));
        }
        System.out.println(string);

        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("erwrerwrwwwwwwwwwwwwwwwww");

        while (bufferedReader.ready()) {
            string.append(Character.toString(bufferedReader.read()));
        }

        reader.close();
        System.out.println(string);
    }
}
