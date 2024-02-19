package application.utils;

import org.testng.IExecutionListener;

import java.io.File;
import java.io.IOException;

public class AllureServeExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionFinish() {
        try {
            String scriptPath = "src/main/resources/bashScripts/allure-serve.sh";
            ProcessBuilder processBuilder = new ProcessBuilder("bash", scriptPath);
            processBuilder.directory(new File(System.getProperty("user.dir")));
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
