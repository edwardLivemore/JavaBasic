package com.example.java_basic.DesignMode.AdapterPattern;

public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        switch (audioType.toLowerCase()){
            case "vlc":
                advancedMediaPlayer = new VlcPlayer();
                break;
            case "mp4":
                advancedMediaPlayer = new Mp4Player();
                break;
            default: break;
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()){
            case "vlc":
                advancedMediaPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedMediaPlayer.playMp4(fileName);
                break;
            default:
                break;
        }
    }
}
