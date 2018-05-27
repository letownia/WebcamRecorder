package com.lojasiewicz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lojasiewicz.webcam.guice.WebcamModule;
import com.lojasiewicz.webcam.producer.WebcamImageProducer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


//import java.util.Scanner;

public class WebcamRecorderMain {
    public static final String propertiesFile = "src/main/resources/app.yaml";

    public static void main(String args[]) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        Injector injector = Guice.createInjector(new WebcamModule());
        WebcamImageProducer controller = injector.getInstance(WebcamImageProducer.class);
//
//        Yaml yaml = new Yaml();
//        try (InputStream in = Files.newInputStream(Paths.get(propertiesFile))) {
//            WebcamRecorderConfig.globalConfig  = yaml.loadAs(in, WebcamRecorderConfig.class);
//            System.out.println(WebcamRecorderConfig.globalConfig.toString());
//        }catch(IOException e){
//            throw e;
//        }
//        JFrame f = new JFrame();//creating instance of JFrame
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////        f.setLocation(200, 200);
//        f.setSize(400, 500);//400 width and 500 height
//        f.setVisible(true);//making the frame visible
////        f.pack();
//
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();

//        for (int i = 0; i < 5; i++) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            addImage(f,webcam.getImage());
//        }
//        BufferedImage temp = webcam.getImage();
//        addImage(f, temp);
//        ImageIO.write(temp, "PNG", new File("hello-world.png"));
//
//        f.dispose();
//        System.out.println("Welcome to WebcamRecorder Application");
//        System.out.println("Enter filename:");
//        smooth("dupa.txt");
    }
//
//    public static void addImage(JFrame frame, BufferedImage image){
////        frame.setContentPane();
//        frame.getContentPane().removeAll();
//        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
//        frame.invalidate();
//        frame.validate();
//        frame.repaint();
//    }
////
//    public static void smooth(String filename) {
//        IplImage image = cvLoadImage(filename);
//        if (image != null) {
//            cvSmooth(image, image);
//            cvSaveImage(filename, image);
//            cvReleaseImage(image);
//        }
//    }
}