package application.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;
    private static final int RETRY_TIMEOUT = 4000;

    @Override
    public boolean retry (final ITestResult iTestResult) {
        if (!iTestResult.isSuccess ()) {
            try {
                Thread.sleep(RETRY_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (retryCount < MAX_RETRY_COUNT) {
                Logger.get().info("Retrying test " + iTestResult.getName () + " with status " + getResultStatusName (
                        iTestResult.getStatus ()) + " for the " + (retryCount+ 1) + " time(s).");
                retryCount++;
                return true;
            }
        }
        return false;
    }

    public String getResultStatusName(int status) {
        switch (status) {
            case 1:
                return "SUCCESS";
            case 2:
                return "FAILURE";
            case 3:
                return "SKIP";
            default:
                return null;
        }
    }
}