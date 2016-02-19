package com.dimkas71.demo;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {


        String resouceName = "data.csv";
        InputStream is = Main.class.getClassLoader().getResourceAsStream(resouceName);

        if (is != null) {

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] splitted = line.split(";");

                String name = splitted[0];
                String dateOfBirthAsString = splitted[1];

                System.out.println(dateOfBirthAsString);


            }

            br.close();

            is.close();
        } else
             System.out.println(String.format("don't find file with name %s", resouceName));

        }

}
