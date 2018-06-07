import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
 
 
 
public class Sound extends Thread {
     
	static URL u1;//l'url de ton fichier son
    static AudioClip s1;//le son créé depuis ton url
    
 
    public Sound() {
    	this.u1=u1;
    	this.s1=s1;
    	
      
    }
    
    public static URL getU1() {
		return u1;
	}
	public static void setU1(URL u1) {
		Sound.u1 = u1;
	}
	public static AudioClip getS1() {
		return s1;
	}
	public static void setS1(AudioClip s1) {
		Sound.s1 = s1;
	}
	
	
    public static void jouer(URL u1) {
    	
        s1 = Applet.newAudioClip(u1);
        s1.play();
    }
    public static void jouerEnBoucle(URL u1) {
    	
        s1 = Applet.newAudioClip(u1);
        s1.loop();
    }
    public void arreter(URL u1) {
    	
        s1 = Applet.newAudioClip(u1);
        s1.stop();
    }
}