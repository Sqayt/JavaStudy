package ru.ivanovds.yandex.writeFile;

import java.io.*;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

    }

    public void fileOracleJava7() {
        String s;
        String result = "null";

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((s = br.readLine()) != null) {
                String[] arr = s.split(" ");
                System.out.println(Arrays.toString(arr));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileOracleJava8() throws Exception {
        StreamTokenizer in = new StreamTokenizer(
                new BufferedInputStream(
                        new FileInputStream(new File("input.txt"))));
        PrintStream out = new PrintStream(new File("output.txt"));
        int word, res;
        in.nextToken();
        word = (int) in.nval;
        in.nextToken();
        res = (int) in.nval;
        out.println(word + " " + res);
    }

    public void fileJdkJava11() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
        String file = reader.readLine();
        String[] nums = file.split(" ");
        System.out.println(Arrays.toString(nums));

        FileWriter writer = new FileWriter(new File("output.txt"));
        writer.write(String.valueOf("test"));
        writer.flush();
    }


}
