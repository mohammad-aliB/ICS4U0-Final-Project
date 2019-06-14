import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class mainDraw extends JComponent {
    int enemyKilled = 0;
    int myX =3400;
    int myY = 300;
    int goalY = 0;
    int jump = 0;
    int lastDirection = 1;
    int horizontalMotion = 0;
    int verticalMotion = 0;
    int lastValidX = 600;
    int startSlides = -1;
    int startBattle = -1;
    int delay = 5;
    int ignore = 1;
    int hearts = 3;
    int gameState = 0;
    int menuState = 0;
    int enter = 0;
    int motionCycle = 0;
    int level = 0;
    int combatSelection = 0;
    int startTime=0;
    int timer=0;
    mapHeight mapHeight;
    friendlySprite sprite;
   /**
   * Set all the variables to the origins
   */
    public void defaultVars() {
      timer=0;
        enemyKilled = 0;
        myX = 400;
        myY = 300;
        goalY = 0;
        jump = 0;
        lastDirection = 1;
        horizontalMotion = 0;
        verticalMotion = 0;
        lastValidX = 600;
        startSlides = -1;
        startBattle = -1;
        delay = 1;
        ignore = 1;
        hearts = 3;
        gameState = 0;
        menuState = 0;
        enter = 0;
        motionCycle = 0;
        level = 0;
        mapHeight = new mapHeight();
        sprite = new friendlySprite();
        combatSelection = 0;
        timer=0;
    }
    static BufferedImage scoreBoard, about,temp,tutorial, completeDeath, mainMenu1, mainMenu2, mainMenu3, mainMenu4, mainMenu5, backgroundMap1, backgroundMap2, backgroundMap3, jumpA, jumpB, stationaryA, stationaryB, forward1, forward2, forward3, forward4, forward5, forward6, forward7, forward8, forward9, backward1, backward2, backward3, backward4, backward5, backward6, backward7, backward8, backward9;
    /**
   * When escape has been pressed this method is triggered
   */
    public void escapePressed(){
    gameState=3;
    repaint();
    }
      /**
   * Detects when you press left or right
   */
    public void setHorizontalMotion(int a, int b) {
        horizontalMotion = a;
        lastDirection = b;
        repaint();
    }
      /**
   * Detects when you press up or down
   */
    public void setVerticalMotion(int a, int b) {
        verticalMotion = a;
        jump = b;
        repaint();
    }
      /**
   * Detects when you press enter
   */
    public void enterPressed() {
        enter = 1;

        repaint();
    }
    public void importAssets() {
        ImportAssets a = new ImportAssets();
        a.importation();
        defaultVars();
    }
      /**
   * This method draws hearts according to the coordinates given
   */
    public void drawHeart(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.red);
        int[] triangleX = {
            x - 2 * width / 18,
            x + width + 2 * width / 18,
            (x - 2 * width / 18 + x + width + 2 * width / 18) / 2
        };
        int[] triangleY = {
            y + height - 2 * height / 3,
            y + height - 2 * height / 3,
            y + height
        };
        g.fillOval(
            x - width / 12,
            y,
            width / 2 + width / 6,
            height / 2);
        g.fillOval(
            x + width / 2 - width / 12,
            y,
            width / 2 + width / 6,
            height / 2);
        g.fillPolygon(triangleX, triangleY, triangleX.length);
    }
      /**
   * This method draw enemy and make sure it dispears after the plyaer wins"
   */
    public void drawEnemies(int level, Graphics g) {
      if(level==1){
         int[] locations = {
            1000,
          3392,
           4864,
          5632,
        };
        String[] fileNames = {
            "Fridge (64).png",
          "Plane .png",
          "case (64).png",
          "sink(64).png"
          
        };
        for (int A = enemyKilled; A < locations.length; A++) {
            if ((locations[A] - myX) < 400) {
                try {
                    temp = ImageIO.read(new File("enemy Sprites/" + fileNames[A]));
                  
                    g.drawImage(temp, locations[A] - myX + 360, mapHeight.height(level, locations[A]) - 32, null);
                } catch (IOException e) {
                }
            }
        }
    }
           else if(level==2){
         int[] locations = {
            992,
          2336,
           4320,
          5760,
        };
        String[] fileNames = {
            "Mustard.png",
          "ICE (1).png",
          "devil.png",
          "Book of Creation64.png"
          
        };
        for (int A = enemyKilled; A < locations.length; A++) {
            if ((locations[A] - myX) < 400) {
                try {
                    temp = ImageIO.read(new File("enemy Sprites/" + fileNames[A]));
                    g.drawImage(temp, locations[A] - myX + 360, mapHeight.height(level, locations[A]) - 32, null);
                } catch (IOException e) {
                }
            }
        }
    }
          else if(level==3){
         int[] locations = {
            1440,
           4128,
          5760,
        };
        String[] fileNames = {
            "Pencil box.png",
          "Ruler (64).png",
          "Library.png"
          
        };
        for (int A = enemyKilled; A < locations.length; A++) {
            if ((locations[A] - myX) < 400) {
                try {
                    temp = ImageIO.read(new File("enemy Sprites/" + fileNames[A]));
                      if(fileNames[A]=="Library.png")
                     g.drawImage(temp, locations[A] - myX + 360, mapHeight.height(level, locations[A]) - 96, null);
                    else
                    g.drawImage(temp, locations[A] - myX + 360, mapHeight.height(level, locations[A]) - 32, null);
                } catch (IOException e) {
                }
            }
        }
    }
    }
void drawString(Graphics g, String text, int x, int y) {
    int lineHeight = g.getFontMetrics().getHeight();
    for (String line : text.split("\n"))
        g.drawString(line, x, y += lineHeight);
}
  /**
   * A built in method that does all the drawing includes the drawing of menu, level and gameplays.
   */
    public void paintComponent(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        if (gameState == 0) {
            if (enter == 1) {
                System.out.println("enter menu pressed");
                enter = 0;
                if(menuState==-1){
                    defaultVars();
                    repaint();
                }else if(menuState==3){
                    g.drawImage(about, 0, 0, null);

                            menuState=-1;
                            System.out.println("About me screen");

                }else if(menuState==4){
                  g.drawImage(tutorial, 0, 0, null);
                            menuState=-1;
                            System.out.println("Tutorial screen");
                }else if(menuState==5){
                  g.drawImage(scoreBoard, 0, 0, null);
                            menuState=-1;
                            System.out.println("HighScores");
                }
                else if (menuState == 0) {
                    gameState = 1;
                    level = 1;
                    repaint();
                } else if (menuState == 1) {
                    gameState = 1;
                    level = 2;
                    repaint();
                } else if (menuState == 2) {
                    gameState = 1;
                    level = 3;
                    repaint();
                }
                
            }
            if (jump == 1 && menuState > 0) {
                menuState--;
            } else if (jump == -1 && menuState < 5) {
                menuState++;
            }
            jump = 0;
            if (menuState == 0) {
                g.drawImage(mainMenu1, 0, 0, null);
            } else if (menuState == 1) {
                g.drawImage(mainMenu2, 0, 0, null);
            } else if (menuState == 2) {
              g.drawImage(mainMenu3, 0, 0, null);
            } else if (menuState == 3) {
              g.drawImage(mainMenu4, 0, 0, null);
            } else if (menuState == 4) {
              g.drawImage(mainMenu5, 0, 0, null);
            } else if (menuState == 5) {
              g.drawImage(mainMenu5, 0, 0, null);
            }
            if(menuState>=0){
              
              if (menuState == 0) {
                g.setColor(Color.red);
                g.drawString("Level one", 420, 240);
                g.setColor(Color.black);
              } else {
                g.drawString("Level one", 420, 240);
            }
            if (menuState ==  1) {
                g.setColor(Color.red);
                g.drawString("Level two", 420, 310);
                g.setColor(Color.black);
            } else {
                g.drawString("Level two", 420, 310);
            }
            if (menuState == 2) {
                g.setColor(Color.red);
                g.drawString("Level three", 420, 388);
                g.setColor(Color.black);
            } else {
                g.drawString("Level three", 420, 388);
            }
            if (menuState == 3) {
                g.setColor(Color.red);
                g.drawString("About", 420, 460);
                g.setColor(Color.black);
            } else {
                g.drawString("About", 420, 460);
            }
            if (menuState == 4) {
                g.setColor(Color.red);
                g.drawString("Tutorial", 420, 520);
                g.setColor(Color.black);
            } else {
                g.drawString("Tutorial", 420, 520);
            }
            if (menuState == 5) {
                g.setColor(Color.red);
                g.drawString("HighScores", 420, 580);
                g.setColor(Color.black);
            } else {
                g.drawString("HighScores", 420, 580);
            }
}
        } else if (gameState == 1) {
            if (horizontalMotion == 1 && startSlides == -1 && startBattle == -1) {
                myX = myX + lastDirection;
                if (level == 1) {
                    if (myX >= 5900) {//SET THE CORRECT X CORDINATE OF THE FLAG HERE
                        defaultVars();
                        gameState = 1;
                        level = 2;
                    }
                } else if (level == 2) {
                    if (myX >= 6000) { //SET THE CORRECT X CORDINATE OF THE FLAG HERE
                        defaultVars();
                        gameState = 1;
                        level = 3;
                    }
                } else if (level == 3) {
                    if (myX == 5888) { 
                      defaultVars();
                      gameState=0;
                      level=0;
                    }
                }
            }
       
        if (myY > mapHeight.height(level, myX)) {
            //refuse movement
            myX = myX - lastDirection;
        }
        goalY = mapHeight.height(level, myX);
        if (level == 1) {
            g.drawImage(backgroundMap1, -myX + 360, 0, null);
        } else if (level == 2) {
            g.drawImage(backgroundMap2, -myX + 360, 0, null);
        } else if (level == 3) {
            g.drawImage(backgroundMap3, -myX + 360, 0, null);
        }
        drawEnemies(level, g);
        if ((sprite.friendly(level, myX) != null || startSlides >= 0) && myY == mapHeight.height(level, myX)) {
            motionCycle = 0;
            g.drawImage(stationaryA, 280, myY - 30, null);

            if (startSlides == -1 && sprite.friendly(level, myX) != null) {
                startSlides++;
            } else if (horizontalMotion == 0) {
                if (startSlides == 0 && ignore == 1) {
                    ignore = 0;

                } else {
                    startSlides = startSlides + lastDirection;
                }
            }
            g.setColor(Color.black);
            g.fillRect(70, 80, 594, 554);
            g.setColor(Color.white);
            g.fillRect(74, 84, 586, 546);

            g.setColor(Color.black);
            if (startSlides >= 0 && startSlides < (sprite.friendly(level, myX).length/2)) {
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                // Determine the X coordinate for the text
                int x = 360 - (metrics.stringWidth(sprite.friendly(level, myX)[startSlides * 2 + 1])) / 2;
                try {
                    temp = ImageIO.read(new File("tutorialAssets/" + sprite.friendly(level, myX)[(startSlides * 2 + 2)]));
                    if(level==3)
                      g.drawImage(temp, 100,100, null);  
                    else
                    g.drawImage(temp, 290, 200, null);
                } catch (IOException e) {
                }
                if(level==1)
                  drawString(g,sprite.friendly(level, myX)[startSlides * 2 + 1],150,400);
                if(level==2)
                  drawString(g,sprite.friendly(level, myX)[startSlides * 2 + 1],100,300);
                if(level==3)
                   drawString(g,sprite.friendly(level, myX)[startSlides * 2 + 1],100,100);
            } else {
                //end prompt
                if (startSlides == -1) {
                    myX = myX - 2;
                } else {
                    myX = myX + 2;
                }
                startSlides = -1;
                horizontalMotion = 0;
                ignore = 1;
                repaint();
            }
        } else if ((sprite.enemy(level, myX) != null || startBattle >= 0)) {
            motionCycle = 0;
            g.drawImage(stationaryA, 280, myY - 30, null);

            if (startBattle == -1 && sprite.enemy(level, myX) != null) {
                startBattle++;
            } else if (startBattle == 0 && ignore == 1) {
                if (horizontalMotion == 0) { 
                    ignore = 0;
                    enter = 0;
                    combatSelection = 0;
                    System.out.println("ignoreing");
                }
            } else {
                System.out.println("CC");
                if (enter == 1) {
                    if (combatSelection+1 == sprite.enemyAnswers(level, myX)[startBattle]) {
                        System.out.println("AA");
                        startBattle = startBattle + 1;

                    } else {
                        System.out.println("BB");

                        if (hearts > 1) {
                            hearts--;
                        } else {
                            hearts = 0;
                            System.out.println("the ultamate DEATH");
                            g.drawImage(completeDeath, 0, 0, null);
                            defaultVars();
                            gameState=0;
                            level=0;
                        }
                    }
                    enter = 0;
                } else if (horizontalMotion == 1) {
                    System.out.println("horizontal motion in combat");
                    if ((combatSelection + lastDirection) >= 0 && (combatSelection + lastDirection) <= 3) {
                        combatSelection = combatSelection + lastDirection;
                    }
                    horizontalMotion = 0;
                }

            }


            System.out.println("start combar " + startBattle + " my x " + myX + "startbttl " + startBattle);
            if (startBattle >= 0 && startBattle < (sprite.enemy(level, myX).length/5)) {
              g.setColor(Color.black);
              g.fillRect(70, 80, 594, 554);
              g.setColor(Color.white);
              g.fillRect(74, 84, 586, 546);
              g.setColor(Color.black);
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                
                // Determine the X coordinate for the text
                int x = 360 - (metrics.stringWidth(sprite.enemy(level, myX)[1])) / 2;
                g.drawString(sprite.enemy(level, myX)[1], x, 80);

               
                // Determine the X coordinate for the text
                g.setColor(Color.black);         
                x = 360 - (metrics.stringWidth(sprite.enemy(level, myX)[(startBattle) * 5 + 2])) / 2;
                
                drawString(g,sprite.enemy(level, myX)[(startBattle) * 5 + 2], 100, 150); //the question

                
                x = 110+125 - (metrics.stringWidth(sprite.enemy(level, myX)[(startBattle) * 5 + 3])) / 2;
                if (combatSelection == 0) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);
                }
                g.drawString(sprite.enemy(level, myX)[(startBattle) * 5 + 3], 100, 400);
                
                 x = 110+125+250 - (metrics.stringWidth(sprite.enemy(level, myX)[(startBattle) * 5 + 4])) / 2;

                if (combatSelection == 1) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);

                }
                g.drawString(sprite.enemy(level, myX)[(startBattle) * 5 + 4], 100, 450);
                x = 110+125 - (metrics.stringWidth(sprite.enemy(level, myX)[(startBattle) * 5 + 5])) / 2;

                if (combatSelection == 2) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);

                }
                g.drawString(sprite.enemy(level, myX)[(startBattle) * 5 + 5], 100, 500);
                x = 110+125+250 - (metrics.stringWidth(sprite.enemy(level, myX)[(startBattle) * 5 + 6])) / 2;


                if (combatSelection == 3) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.black);

                }
                g.drawString(sprite.enemy(level, myX)[(startBattle) * 5+6], 100, 550);

            } else {
                //end prompt
                sprite.lastBoss(level, myX);
                if (startBattle == -1) {
                    myX = myX - 2;
                } else {
                    myX = myX + 2;
                }

                startBattle = -1;
                horizontalMotion = 0;
                ignore = 1;
                enemyKilled++;
                if (hearts != 0) {
                    repaint();
                } else {
                    defaultVars();
                    System.out.println("the system has no hearsts");
                }
            }
        } else if (jump > 0 && verticalMotion == 1) {
            if (jump < 75 && jump > 1 || myY == goalY) {
                myY--;
                jump++;
            } else {
                jump = 0;
                repaint();
            }
            motionCycle = 0;
            if (lastDirection == 1) {
                g.drawImage(jumpA, 280, myY - 30, null);
            } else {
                g.drawImage(jumpB, 280, myY - 30, null);
            }
        } else if (myY < goalY) {
            //circle is above ground
            myY++;
            motionCycle = 0;
            if (lastDirection == 1) {
                g.drawImage(jumpA, 280, myY - 30, null);
            } else {
                g.drawImage(jumpB, 280, myY - 30, null);
            }

            verticalMotion = 1;
            if (myY > 730) {
                if (hearts > 1) {
                    hearts--;
                    while (mapHeight.height(level, myX) > 700) {
                        if (myX > 0) {
                            myX--;
                        } else {
                            while (mapHeight.height(level, myX) > 700) {
                                myX++;
                            }
                        }
                    }
                    repaint();
                    myY = mapHeight.height(level, myX);

                    verticalMotion = 0;
                    horizontalMotion = 0;
                } else {
                    g.drawImage(completeDeath, 0, 0, null);
                    defaultVars();
                    gameState=0;
                    level=0;
                }
                //}

            }
        } else if (myY > mapHeight.height(level, myX)) {
            //refuse movement
        } else {
            verticalMotion = 0; 
            if (lastDirection == 1 && horizontalMotion == 1) {
                motionCycle++;
                if (motionCycle < 4) {
                    g.drawImage(forward1, 280, myY - 30, null);
                } else if (motionCycle < 8) {
                    g.drawImage(forward2, 280, myY - 30, null);
                } else if (motionCycle < 12) {
                    g.drawImage(forward3, 280, myY - 30, null);
                } else if (motionCycle < 16) {
                    g.drawImage(forward4, 280, myY - 30, null);
                } else if (motionCycle < 20) {
                    g.drawImage(forward5, 280, myY - 30, null);
                } else if (motionCycle < 24) {
                    g.drawImage(forward6, 280, myY - 30, null);
                } else if (motionCycle < 28) {
                    g.drawImage(forward7, 280, myY - 30, null);
                } else if (motionCycle < 32) {
                    g.drawImage(forward8, 280, myY - 30, null);
                } else if (motionCycle < 36) {
                    g.drawImage(forward9, 280, myY - 30, null);
                    motionCycle = 0;
                }
            } else if (lastDirection == -1 && horizontalMotion == 1) {
                motionCycle++;
                if (motionCycle < 4) {
                    g.drawImage(backward1, 280, myY - 30, null);
                } else if (motionCycle < 8) {
                    g.drawImage(backward2, 280, myY - 30, null);
                } else if (motionCycle < 12) {
                    g.drawImage(backward3, 280, myY - 30, null);
                } else if (motionCycle < 16) {
                    g.drawImage(backward4, 280, myY - 30, null);
                } else if (motionCycle < 20) {
                    g.drawImage(backward5, 280, myY - 30, null);
                } else if (motionCycle < 24) {
                    g.drawImage(backward6, 280, myY - 30, null);
                } else if (motionCycle < 28) {
                    g.drawImage(backward7, 280, myY - 30, null);
                } else if (motionCycle < 32) {
                    g.drawImage(backward8, 280, myY - 30, null);
                } else if (motionCycle < 36) {
                    g.drawImage(backward9, 280, myY - 30, null);
                    motionCycle = 0;
                }
            } else {
                if (lastDirection == 1) {
                    g.drawImage(stationaryA, 280, myY - 30, null);
                } else {
                    g.drawImage(stationaryB, 280, myY - 30, null);
                }
            }

        }
        for (int A = 0; A < hearts; A++) {
            if (myY != 485) {
                drawHeart(g, 30 * A + 30, 20, 20, 20);
            }
        }

        if ((horizontalMotion == 1 || verticalMotion == 1)) {
            try {
                Thread.sleep(delay);
                repaint();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } else {
            //draw stationary manz
            if (motionCycle != 0) {
                motionCycle = 0;
                repaint();
            }

        }
        }else if(gameState==3){
    defaultVars();
    repaint();
    }
    }
}