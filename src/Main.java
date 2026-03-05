public class Main{
    public static void main(String[] args) {
        
        MusicBox mbox = new MusicBox("S34TG65", 'Y', "Raindrops", "Misty", 
        "The path less traveled", "Country", "BZEE Music", "Rhythm Divine");

        PlaySongs playsong = new PlaySongs();
        
        playsong.playSong(mbox.getSongID(), mbox.getPremiumSong(), 2);

        
        // --- TODO

MusicBox mbox2 = new MusicBox("A12BC34", 'N', "Sunshine", "Bright", 
    "Happy day", "Pop", "Star Music", "Sunny Vibes");


playsong.playSong(mbox2.getSongID(), mbox2.getPremiumSong(), 1); to the MusicBox constructor, but initialise premiumSong to N and when calling the
         * playSong method, pass ads parameter as just 1
         * 
         * 
        */
        

    }
}




