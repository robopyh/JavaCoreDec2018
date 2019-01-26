package com.javacore.file3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class CrazyLogger {
    private StringBuilder log = new StringBuilder();
    private Timer timer = new Timer();
    private int appearancesNumber;

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"));
            log.append(currentDateTime).append(" – ").append(appearancesNumber++).append(" appearance;\n");
        }
    };

    public void startLogging(long delay, long period) {
        timer.schedule(task, delay, period);
    }

    public void stopLogging() {
        timer.cancel();
    }

    public void showAllMessages() {
        System.out.println("\nCurrent log:\n" + log.toString());
    }

    public void findMessage(String query) {
        System.out.println("Querying for \"" + query + "\" ...");

        String[] logMessages = log.toString().split("\n");
        for (String message : logMessages) {
            if (message.contains(query)) {
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.startLogging(0L, 10000L);
        while (true) {
            Thread.sleep(30000);
            crazyLogger.showAllMessages();
            crazyLogger.findMessage("25");
        }
    }
}
