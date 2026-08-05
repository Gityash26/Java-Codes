/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------------------- Polymorphism in Interfaces ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /============\     ________     ____________       ________________
   | Cell_phone  |    |__GPS__|    |__Camera___|      |_Media_Player__|
   \============/        |              |                   |
        |                |              |                   |
        |______________  |   ___________|                   |              
                      |  |  |   ____________________________|
                      |  |  |  | 
                 /==================\
                |    Smartphone     |  
                \==================/   

-> Polymorphism allows us to use the smartphone either as a CellPhone for calling or GPS or 
   Camera or MediaPlayer any form at a time. 

-> To implement these functionality we take the reference of specific interface such as GPS, Camera, 
    Cellphone or Meiaplayer and create the object of Smartphone class.

-> Example: GPS s = new Samrtphone();

-> Now, the object only call the methods of GPS class.
*/

interface GPS {
    void TrackLocation();
}

interface Camera {
    void clickSnap();

    void recordVideo();
}

interface MediaPlayer {
    void playMusic();
}

class Myphone {
    public void callNumber(int num) {
        System.out.println("Calling... + " + num);
    }

    public void receiveCall() {
        System.out.println("Connecting...");
    }
}

class MySmartphone extends Myphone implements GPS, Camera, MediaPlayer {
    public void TrackLocation() {
        System.out.println("Tracking your Location...");
    }

    public void clickSnap() {
        System.out.println("Clicking picture...");
    }

    public void recordVideo() {
        System.out.println("Recording Video....");
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }
}

public class p6_Polymorphism {
    public static void main(String args[]) {

        System.out.println("\n~~~~~~~~~~~~~ Using Smartphone as a GPS ~~~~~~~~~~~~~~\n");
        GPS g = new MySmartphone();
        g.TrackLocation();

        System.out.println("\n~~~~~~~~~~~~~ Using Smartphone as a Camera ~~~~~~~~~~~~~~\n");
        Camera cam = new MySmartphone();
        cam.clickSnap();
        cam.recordVideo();

        System.out.println("\n~~~~~~~~~~~~~ Using Smartphone as a Mediaplayer ~~~~~~~~~~~~~~\n");
        MediaPlayer mp = new MySmartphone();
        mp.playMusic();

    }
}