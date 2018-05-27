package com.lojasiewicz.webcam.publisher;

import com.lojasiewicz.webcam.listener.ImageListener;

import javax.inject.Inject;
import java.util.Set;

public class ImagePublisherImpl implements ImagePublisher{
    private final Set<ImageListener> listeners;

    @Inject
    public ImagePublisherImpl(Set<ImageListener> listeners){
        this.listeners = listeners;
    }
//
//    @Override
//    public void register(ImageListener listener) {
//        listeners.add(listener);
//    }
//    @Override
//    public boolean unregister(ImageListener listener) {
//        return listeners.remove(listener);
//    }

    @Override
    public void publish(ImageEvent imageEvent) {
        listeners.forEach( l -> l.processImageEvent(imageEvent));
    }
}
