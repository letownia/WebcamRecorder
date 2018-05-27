package com.lojasiewicz.webcam.listener;

import com.lojasiewicz.GifSequenceWriter;
import com.lojasiewicz.config.WebcamRecorderConfig;
import com.lojasiewicz.webcam.publisher.ImageEvent;
import com.lojasiewicz.webcam.publisher.NewImageEvent;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImageStreamCollector implements ImageListener {
    private WebcamRecorderConfig config;
    private boolean initialized = false;
    private int  TARGET_IMAGE_TYPE = BufferedImage.TYPE_INT_RGB;
    private GifSequenceWriter writer;
    private ImageOutputStream outputStream;

    @Inject
    public ImageStreamCollector(WebcamRecorderConfig config){
        this.config = config;
        init();

        // write out the first image to our sequence...
//        writer.writeToSequence(firstImage);
//        for (int i = 1; i < args.length - 1; i++) {
//            BufferedImage nextImage = ImageIO.read(new File(args[i]));
//            writer.writeToSequence(nextImage);
//        }
//
//        writer.close();
    }

    private static String generateFileName(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_kk_mm");
        return LocalDateTime.now().format(formatter) + ".gif";
    }

    public synchronized void init() {
//        if(initialized){
//            return;
//        }
//        System.out.println("initializing with imgType " + imageType);
//        if (imageType < BufferedImage.TYPE_INT_RGB ||
//                imageType > BufferedImage.TYPE_BYTE_INDEXED){
//            return;
//        }
        try {
            outputStream =  new FileImageOutputStream(new File(config.getVideo().getStorageDirectory() + generateFileName()));
            writer = new GifSequenceWriter(outputStream, TARGET_IMAGE_TYPE, 1, false);
        } catch (IOException e) {
            e.printStackTrace();
            return;
            //System.exit(0);
        }
        initialized = true;
    }

    @Override
    public void processImageEvent(ImageEvent imageEvent) {
//        if( imageEvent instanceof InitialImageEvent){
//            if( ! initialized){
//                init(((InitialImageEvent)imageEvent).getImage().getType());
//            }
//        }else
         if( imageEvent instanceof NewImageEvent){
//            if (!initialized) {
//                init(((NewImageEvent) imageEvent).getImage().getType());
//            }
            try {
                BufferedImage image = ((NewImageEvent) imageEvent).getImage();
                if(image.getType() != TARGET_IMAGE_TYPE){
                    image = convertImage(image, TARGET_IMAGE_TYPE);
                }
                writer.writeToSequence(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        ImageIO.write(temp, "PNG", new File("hello-world.png"));

    }

    private static BufferedImage convertImage(BufferedImage src, int targetType){
        BufferedImage img = new BufferedImage(src.getWidth(), src.getHeight(), targetType);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(src, 0, 0, null);
        g2d.dispose();
        return img;
    }
    @Override
    public void shutdownProcessing() {
        try {
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}