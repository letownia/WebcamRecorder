package com.lojasiewicz;

import com.lojasiewicz.config.WebcamRecorderConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

//import java.util.Scanner;

public class WebcamRecorderMain {
    public static final String propertiesFile = "src/main/resources/app.yaml";

    public static void main(String args[]) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        Yaml yaml = new Yaml();
        try (InputStream in = Files.newInputStream(Paths.get(propertiesFile))) {
            WebcamRecorderConfig config = yaml.loadAs(in, WebcamRecorderConfig.class);
            System.out.println(config.toString());
        }catch(IOException e){
            throw e;
        }
        System.out.println("Welcome to WebcamRecorder Application");
        System.out.println("Enter filename:");
    }

    public static void smooth(String filename) {
        IplImage image = cvLoadImage(filename);
        if (image != null) {
            cvSmooth(image, image);
            cvSaveImage(filename, image);
            cvReleaseImage(image);
        }
    }
}