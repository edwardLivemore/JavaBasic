package com.example.java_basic.DesignMode.AdapterPattern;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()){
            case "mp3":
                System.out.println("Playing mp3 file : " + fileName);
                break;
            case "vlc":
            case "mp4":
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
                break;
            default:
                System.out.println("Invalid media type: " + audioType);
                break;
        }
    }

//    AdvancedMediaPlayer advancedMediaPlayer;
//
//    @Override
//    public void play(String audioType, String fileName) {
//        switch (audioType.toLowerCase()){
//            case "mp3":
//                System.out.println("Playing mp3 file : " + fileName);
//                break;
//            case "vlc":
//                advancedMediaPlayer = new VlcPlayer();
//                advancedMediaPlayer.playVlc(fileName);
//                break;
//            case "mp4":
//                advancedMediaPlayer = new Mp4Player();
//                advancedMediaPlayer.playMp4(fileName);
//                break;
//            default:
//                System.out.println("Invalid media type: " + audioType);
//                break;
//        }
//    }
}
