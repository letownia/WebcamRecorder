package com.lojasiewicz.webcam.publisher;

import java.awt.image.BufferedImage;

public class NewImageEvent extends ImageEvent {

    private BufferedImage image;

    public NewImageEvent(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
