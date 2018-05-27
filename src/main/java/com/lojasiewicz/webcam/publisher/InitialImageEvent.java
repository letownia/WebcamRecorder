package com.lojasiewicz.webcam.publisher;

import java.awt.image.BufferedImage;

public class InitialImageEvent extends ImageEvent {
    private BufferedImage image;
    public InitialImageEvent(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
