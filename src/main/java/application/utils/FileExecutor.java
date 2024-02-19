package application.utils;

import java.io.File;
import java.io.IOException;

public class FileExecutor {

        public static void executeAllureServe() {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("bash", "allure-serve.sh");
                processBuilder.directory(new File(System.getProperty("user.dir")));
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
}
