package ru.ivanovds.GB.Lesson2HM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_3Two {

    private static final Logger logger = LogManager.getLogger(Task_3.class);

    public static void main(String[] args) {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";

        Task_3Two task3 = new Task_3Two();
        task3.read("example.txt");
        String text = task3.download(fileUrl, "example.txt");
        System.out.println(task3.change("Danil", text));
    }

    public String download(String url, String localFilename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fs = new FileOutputStream("example.txt")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fs.write(dataBuffer, 0, bytesRead);
                sb.append(new String(dataBuffer, StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

        return sb.toString();
    }

    public String change(String name, String fileContent) {
        char[] array = fileContent.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '%') {
                sb.append(name);
                i+=1;
                continue;
            }
            sb.append(array[i]);
        }

        return sb.toString();
    }

    public void read(String localFilename){
        try (BufferedReader r = new BufferedReader(new FileReader(localFilename))) {
            String word = r.readLine();
            logger.info(word);
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public void saveOnLocal(String fileName, String fileContent) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(fileName))) {
            w.write(fileContent);
            w.flush();
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public boolean removeFromLocale(String fileName) {
        try {
            File fileToDelete = Paths.get(fileName).toFile();
            Files.delete(fileToDelete.toPath());

            return true;
        } catch (IOException e) {
            logger.debug(e.getMessage());

            return false;
        }
    }
}
