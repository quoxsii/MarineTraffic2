package com.quoxsii.marinetraffic;

import com.quoxsii.marinetraffic.services.AisApiClient;

public class AisParserThread implements Runnable{
    private AisApiClient aisApiClient;

    @Override
    public void run() {
        try {
            while (true) {
                System.out.printf("Parser started in thread %s\n", Thread.currentThread().getName());
                //aisApiClient.getAisDtoList();
                Thread.sleep(5000);
                System.out.printf("Parser executed in thread %s\n", Thread.currentThread().getName());
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
