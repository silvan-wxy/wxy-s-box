public class Main {
    public static void main(String[] args) {
        MusicBox mbox = new MusicBox("S34TG65", "Y", "Raindrops", "Misty",
                "The path less traveled", "Country", "BZEE Music", "Rhythm Divine");

        MusicBox mbox2 = new MusicBox("1234", "N", "ra", "light",
                "bad day", "kpop", "sun Music", "Vibes");

        PlaySongs playsong = new PlaySongs();
        playsong.playSong(mbox.getSongID(), mbox.getPremiumSong(), 2);
        playsong.playSong(mbox2.getSongID(), mbox2.getPremiumSong(), 1);
        UserRegistration userReg = new UserRegistration();
        userReg.registration();
        System.out.println(userReg);
    }
}
