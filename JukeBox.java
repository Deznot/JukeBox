import java.io.*;
import java.util.*;

public class JukeBox {
    ArrayList<String> songList = new ArrayList<String>();
    public static void main(String[] args) {
        new JukeBox().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
    }

    public void getSongs(){
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    };
}
