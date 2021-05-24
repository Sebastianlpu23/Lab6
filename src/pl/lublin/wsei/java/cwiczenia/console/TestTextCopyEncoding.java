package pl.lublin.wsei.java.cwiczenia.console;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Instant;

public class TestTextCopyEncoding {
    public static void main (String[] args) throws IOException {

        BufferedReader in = null;
        BufferedWriter out = null;

        System.out.println("Domyślne kodowanie: " + Charset.defaultCharset().displayName());

        long startTime = Instant.now().toEpochMilli();

        try {
            in = new BufferedReader(new FileReader("dzieweczki.txt"));
            out = new BufferedWriter(new FileWriter("dzieweczki_java.txt"));
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }

        catch (IOException e) {
            System.out.println("IOException: " +e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        System.out.println("Czas wykonania w nanosekundach: " + (Instant.now().toEpochMilli() - startTime));
    }
}