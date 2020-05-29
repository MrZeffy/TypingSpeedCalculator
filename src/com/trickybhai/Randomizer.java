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

        for (int i = 0; i < 10 && (line=reader.readLine())!=null; i++) {

                //sent.put(line, i);
                textFromFile.add(line);
        }

        /*
        // Unused methods and fields:
        int size = 0;
        int randomNum;
        ArrayList<Integer> x = new ArrayList<>();

        while (size < 2) {
            randomNum = ThreadLocalRandom.current().nextInt(0, sent.size());

            if (size == 0) {
                String key = getKeysFromValue(sent, randomNum);
                text += key;
            } else {

                while (x.contains(randomNum)) {
                    randomNum = ThreadLocalRandom.current().nextInt(0, sent.size());
                }

                String key = getKeysFromValue(sent, randomNum);
                text = text + " " + key;
            }
            size++;
            x.add(randomNum);
        }

        out = Arrays.asList(text.split("[/]"));
        text = text.replace("/", "");*/

    }

    /*public static String getKeysFromValue(Map<String, Integer> hm, Object value) {
        String z = "";
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                z = o.toString();
            }
        }
        return z;
    }*/

}
