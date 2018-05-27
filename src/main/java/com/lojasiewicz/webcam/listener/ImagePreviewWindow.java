package com.lojasiewicz.webcam.listener;

import com.lojasiewicz.config.WebcamRecorderConfig;
import com.lojasiewicz.webcam.publisher.ImageEvent;
import com.lojasiewicz.webcam.publisher.NewImageEvent;

import javax.inject.Inject;
import javax.swing.*;

public class ImagePreviewWindow implements ImageListener {

    private WebcamRecorderConfig config;
    private JFrame containerFrame;

    @Inject
    public ImagePreviewWindow(WebcamRecorderConfig config){
        this.config = config;
        containerFrame = new JFrame();//creating instance of JFrame
        containerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLocation(200, 200);
        containerFrame.setSize(config.getPreviewWindow().getWidth(), config.getPreviewWindow().getHeight());//400 width and 500 height
        containerFrame.setVisible(true);//making the frame visible
    }
    @Override
    public void processImageEvent(ImageEvent imageEvent) {
        if(imageEvent instanceof NewImageEvent) {
            NewImageEvent event = (NewImageEvent) imageEvent;
            containerFrame.getContentPane().removeAll();
            containerFrame.getContentPane().add(new JLabel(new ImageIcon(event.getImage())));
            containerFrame.invalidate();
            containerFrame.validate();
            containerFrame.repaint();
        }
    }

    @Override
    public void shutdownProcessing() {
        containerFrame.dispose();
    }
}
