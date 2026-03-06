public class PlaySongs {
    public void playSong(String songID, char premium, int ads) {
        switch (premium) {
            case 'Y':
            case 'y':
                System.out.println("This is a premium song. Please buy it to play without the ads.");
                break;
            case 'N':
            case 'n':
                System.out.println("Thank you for choosing this song. Hope you enjoy listening to it...");
                playAd(ads, premium);
                break;
            default:
                System.out.println("Invalid premium status.");
        }
    }

    private void playAd(int ads, char premium) {
        if (premium == 'N' || premium == 'n') {
            if (ads <= 0) {
                System.out.println("No ads to play.");
                return;
            }
            for (int i = 1; i <= ads; i++) {
                System.out.println("Playing Ad " + i);
            }
        }
    }
}
