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

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);

        System.out.println("check " + songList.get(6).equals(songList.get(7)));

        HashSet<Song> setSong = new HashSet<Song>();
        setSong.addAll(songList);
        System.out.println(setSong);

        NameCompare nCompare = new NameCompare();
        TreeSet<Song> treeSetSong = new TreeSet<Song>(nCompare);
        treeSetSong.addAll(songList);
        System.out.println(treeSetSong);


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
        Song song = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(song);
    }

    class NameCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getTitle().compareTo(two.getTitle());
        }
    }

    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }
}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
 
    public boolean equals(Object aSong) {
        //title this is string. String has method quals.
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
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
        return title + '-' + artist;
    }

    public int compareTo(Song inSong) {
        //return this.title.compareTo(inSong.getTitle());
        int minLength = Math.min(this.title.length(), inSong.title.length());
        for (int i = 0; i < minLength; i++) {
            if((int) this.title.charAt(i) == (int) inSong.title.charAt(i)) {
                continue;
            }else if((int) this.title.charAt(i) > (int) inSong.title.charAt(i)){
                return 1;
            }else {
                return -1;
            }
        }
        if (this.title.length() > inSong.title.length()) {
            return 1;
        }else {
            return -1;
        }
    }

   
}
