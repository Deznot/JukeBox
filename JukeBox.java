import java.io.*;
import java.util.*;

public class JukeBox {
    ArrayList<Song> songList = new ArrayList<Song>();
    public static void main(String[] args) {
        new JukeBox().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

    public void getSongs(){
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                addSong(line);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    };

    public void addSong(String lineToParse) {
        String [] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}

class Song {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String t, String artist, String rating, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm(){
        return bpm;
    }

    public String toString() {
        return title;
    }

}   
