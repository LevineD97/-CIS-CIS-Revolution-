import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Song {
    public static Songs songTitle;
    public static String songFile;
    public static String noteFile;
    public static String imageFile;
    
    public void playback() {
      TinySound.init();
      Music song = TinySound.loadMusic(songFile);
      song.play(true);
    }
    
    public Song(Songs s) {
        
        songTitle = s;
        
        if (songTitle == Songs.SANDSTORM) {
            songFile = "Sandstorm.wav";
            noteFile = "Sandstorm.txt";
            imageFile = "Sandstorm.png";
        }
        
        if (songTitle == Songs.DAFTPUNK) {
            songFile = "DaftPunk.wav";
            noteFile = "DaftPunk.txt";
            imageFile = "DaftPunk.png";
        }
        
        if (songTitle == Songs.ZELDA) {
            songFile = "Zelda.wav";
            noteFile = "Zelda.txt";
            imageFile = "Zelda.png";
        }
    }
}

enum Songs {SANDSTORM, DAFTPUNK, ZELDA}