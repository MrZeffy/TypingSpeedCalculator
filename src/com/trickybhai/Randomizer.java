package com.trickybhai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

public class Randomizer extends Main {

    //private static final Map<String, Integer> sent = new LinkedHashMap<>();

    //Used it for reading all the lines from selected file.
    public static void hashmapGenerator() throws IOException {
        InputStream file = Randomizer.class.getClassLoader().getResourceAsStream(Main.path);
        assert file != null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line;

        //Putting all the text in textFromFile.
        for (int i = 0; i < 10 && (line = reader.readLine()) != null; i++) {

            textFromFile.add(line);
        }
    }
}
