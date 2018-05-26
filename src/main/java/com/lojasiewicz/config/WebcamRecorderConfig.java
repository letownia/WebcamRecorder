package com.lojasiewicz.config;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class WebcamRecorderConfig {
    public static WebcamRecorderConfig globalConfig;
    private String version;
    private Video video;
    private Database database;

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

    public static class Video{
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
