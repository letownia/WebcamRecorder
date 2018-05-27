package com.lojasiewicz.webcam.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.lojasiewicz.config.WebcamRecorderConfig;
import com.lojasiewicz.webcam.listener.ImageListener;
import com.lojasiewicz.webcam.listener.ImagePreviewWindow;
import com.lojasiewicz.webcam.listener.ImageStreamCollector;
import com.lojasiewicz.webcam.publisher.ImagePublisher;
import com.lojasiewicz.webcam.publisher.ImagePublisherImpl;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebcamModule extends AbstractModule {

    public static final String propertiesFile = "src/main/resources/app.yaml";

    @Override
    protected void configure() {
        Multibinder<ImageListener> multibinder= Multibinder.newSetBinder(binder(), ImageListener.class);
        multibinder.addBinding().to(ImagePreviewWindow.class);
        multibinder.addBinding().to(ImageStreamCollector.class);

        Yaml yaml = new Yaml();
        InputStream in = null;
        try{
            in = Files.newInputStream(Paths.get(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        bind(WebcamRecorderConfig.class).toInstance(yaml.loadAs(in, WebcamRecorderConfig.class));
        bind(ImagePublisher.class).to(ImagePublisherImpl.class);
    }
}
