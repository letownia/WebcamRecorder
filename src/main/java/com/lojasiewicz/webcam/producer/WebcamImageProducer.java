package com.lojasiewicz.webcam.producer;

import com.github.sarxos.webcam.Webcam;
import com.lojasiewicz.config.WebcamRecorderConfig;
import com.lojasiewicz.webcam.publisher.ImagePublisher;
import com.lojasiewicz.webcam.publisher.InitialImageEvent;
import com.lojasiewicz.webcam.publisher.NewImageEvent;

import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebcamImageProducer implements ImageProducer{

    private static final int INITIAL_DELAY = 5;
    private static final int INTERVAL_MS = 1000;

    private ImagePublisher imagePublisher;
    private Webcam webcam;

    @Inject
    public WebcamImageProducer(ImagePublisher imagePublisher, WebcamRecorderConfig config){
        this.imagePublisher = imagePublisher;
        init(config.getVideo().getInitialDelaySeconds());
        produceImages(config.getVideo().getIntervalMilliseconds());

    }

    private class ProduceImage implements Runnable {
        @Override
        public void run() {
            imagePublisher.publish(new NewImageEvent(webcam.getImage()));
        }
    }

    private void produceImages(int intervalMilliseconds) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new ProduceImage(), intervalMilliseconds, intervalMilliseconds, TimeUnit.MILLISECONDS);
    }


    private void init(int numSecondsDelay){
        webcam = Webcam.getDefault();
        webcam.open();
        /** Webcam only starts working after a delay..*/
        for (int i = 0; i < numSecondsDelay; i++) {
            imagePublisher.publish(new InitialImageEvent(webcam.getImage()));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
