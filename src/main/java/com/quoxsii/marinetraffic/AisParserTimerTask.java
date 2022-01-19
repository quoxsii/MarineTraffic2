package com.quoxsii.marinetraffic;

import java.util.TimerTask;

public class AisParserTimerTask extends TimerTask {

    @Override
    public void run() {
        Thread thread = new Thread(new AisParserRunnable(), "parser");
        thread.start();
    }
}
