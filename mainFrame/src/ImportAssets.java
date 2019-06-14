



import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImportAssets extends mainDraw{
    /**
   * This method imports all the basic pictures that is going to be used in the game
   * Including the background images and the chractermovement
   */
    public void importation(){
        try { 
                    scoreBoard = ImageIO.read(new File("Score board.png")); 
          tutorial = ImageIO.read(new File("Tutorial.png")); 
            about = ImageIO.read(new File("About.png")); 
            completeDeath = ImageIO.read(new File("Game Over.png")); 
            mainMenu1 = ImageIO.read(new File("Menu/1.png")); 
            mainMenu2 = ImageIO.read(new File("Menu/2.png")); 
            mainMenu3 = ImageIO.read(new File("Menu/3.png")); 
            mainMenu4 = ImageIO.read(new File("Menu/4.png")); 
            mainMenu5 = ImageIO.read(new File("Menu/5.png")); 
            backgroundMap1 = ImageIO.read(new File("Maps/Map1.png")); 
            backgroundMap2 = ImageIO.read(new File("Maps/Map2.png")); 
            backgroundMap3 = ImageIO.read(new File("Maps/Map3.png")); 
            stationaryA = ImageIO.read(new File("MainChar/stationaryA.png")); 
            stationaryB = ImageIO.read(new File("MainChar/stationaryB.png"));
            jumpA = ImageIO.read(new File("MainChar/jumpA.png")); 
            jumpB = ImageIO.read(new File("MainChar/jumpB.png")); 
            forward1 = ImageIO.read(new File("MainChar/1A.png")); 
            forward2 = ImageIO.read(new File("MainChar/2A.png")); 
            forward3 = ImageIO.read(new File("MainChar/3A.png"));
            forward4 = ImageIO.read(new File("MainChar/4A.png")); 
            forward5 = ImageIO.read(new File("MainChar/5A.png")); 
            forward6 = ImageIO.read(new File("MainChar/6A.png")); 
            forward7 = ImageIO.read(new File("MainChar/7A.png")); 
            forward8 = ImageIO.read(new File("MainChar/8A.png")); 
            forward9 = ImageIO.read(new File("MainChar/9A.png")); 
            backward1 = ImageIO.read(new File("MainChar/1B.png")); 
            backward2 = ImageIO.read(new File("MainChar/2B.png")); 
            backward3 = ImageIO.read(new File("MainChar/3B.png"));
            backward4 = ImageIO.read(new File("MainChar/4B.png")); 
            backward5 = ImageIO.read(new File("MainChar/5B.png")); 
            backward6 = ImageIO.read(new File("MainChar/6B.png")); 
            backward7 = ImageIO.read(new File("MainChar/7B.png")); 
            backward8 = ImageIO.read(new File("MainChar/8B.png")); 
            backward9 = ImageIO.read(new File("MainChar/9B.png")); 
        } catch (IOException e) { 
            //Not handled. 
        }
    }
}