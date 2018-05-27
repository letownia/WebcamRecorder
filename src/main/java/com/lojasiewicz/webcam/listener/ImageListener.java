package com.lojasiewicz.webcam.listener;

import com.lojasiewicz.webcam.publisher.ImageEvent;

public interface ImageListener {
    void processImageEvent(ImageEvent imageEvent);
    void shutdownProcessing();
}
