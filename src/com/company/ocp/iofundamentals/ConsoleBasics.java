package com.company.ocp.iofundamentals;

import java.io.*;

/**
 * Created by bikra on 12/19/2019 9:53 AM.
 */
public class ConsoleBasics {
    public static void main(String[] args) throws IOException {
        String line = "";
        try(
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        Writer w = new BufferedWriter(new OutputStreamWriter(System.out))) {
            while (!(line = c.readLine()).equals("exit"))
                if(line != null) {
                    w.write(line);
                    w.write(line);
                    w.append(line, 0, 4);
                }
            w.flush();
        }

        //Console c = System.console();
        //Writer w = c. writer();

    }
}
