# Gavin Frazar

# Roderic Deichler

### Description

  * A program which provides a set of minigames for the user to complete.

### User Stories

  * As a user I can start a session so that I can see the start button.
  * As a user, I can click a button so that I can play a game of Lights Out.
  * As a user, I can click a button so that I can play an SQL injection minigame.
  * As a user, I can play in a GUI interface from Java Swing, so that I can better enjoy the game.
 
  
### Software
  * The software runs in both the in a GUI environment. It currently shows the minigames available as soon as you click start.
   
### User Should Stories
  * As a user, I would like to have more minigames to play.
  * As a user, I would like to have a more robust main menu.
  * As a user, I would like there to be sounds.
  * As a user, I would like there to be negative reinforcement to help me improve.
  * As a user, I would like to visualize a timer to see how long I have to win.
   
### README.md Review
  * The README.md is not very well put together. It needs to be updated to include more information, but this is not surprising since it is a GreenField project.
  
### Build.XML
  * The build.xml file is in good shape and is an Ant Build.XML
  
### Current Issues
  * The current issues are:
    1. Create several more minigames
    2. Improve GUI 
    3. Implement a timer
    4. Add sound effects
    5. Randomly assign minigames to play
 
### Additional Issues
  * All current issues are additional issues, because this is a GreenField project.
  
### Assessment of the Code
  * It's clear how the classes relate to one another. Every minigame extends the MiniGame class.
  * The code is easy to understand. It is readable and straightforward.
  
#####  Advice to anyone wanting to understand the code:
  * Every minigame will extend the MiniGame class and use it to make a new Frame.
  * The MainGameFrame creates the GUI environment from which all minigames are initialized.
  
### Test Coverage
  * As of the time of writing there are no tests yet implemented.
  * There are huge opportunities for expanding test coverage
