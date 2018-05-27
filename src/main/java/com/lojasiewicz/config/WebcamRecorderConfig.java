package com.lojasiewicz.config;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class WebcamRecorderConfig {
    private String version;
    private Video video;
    private Database database;
    private PreviewWindow previewWindow;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public PreviewWindow getPreviewWindow() {
        return previewWindow;
    }

    public void setPreviewWindow(PreviewWindow previewWindow) {
        this.previewWindow = previewWindow;
    }

    public static class PreviewWindow{
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public static class Video{
        private int initialDelaySeconds;
        private int intervalMilliseconds;
        private String storageDirectory;

        public String getStorageDirectory() {
            return storageDirectory;
        }

        public void setStorageDirectory(String storageDirectory) {
            this.storageDirectory = storageDirectory;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        public int getInitialDelaySeconds() {
            return initialDelaySeconds;
        }

        public void setInitialDelaySeconds(int initialDelaySeconds) {
            this.initialDelaySeconds = initialDelaySeconds;
        }

        public int getIntervalMilliseconds() {
            return intervalMilliseconds;
        }

        public void setIntervalMilliseconds(int intervalMilliseconds) {
            this.intervalMilliseconds = intervalMilliseconds;
        }
    }

    public static class Database{
        private String url;
        private int poolSize;
        private String password;
        private String username;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPoolSize() {
            return poolSize;
        }

        public void setPoolSize(int poolSize) {
            this.poolSize = poolSize;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


}
