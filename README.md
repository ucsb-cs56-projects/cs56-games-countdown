# cs56-games-countdown

Project Description:

The countdown game contains a GUI in which a user can play a series of randomly selected mini-games.

project history
===============
```
W18 | GavinFrazar | RodericD5
```

Running the game:

To run the game, use "ant run".

Important Information for Future Developers:

* The MiniGame class is the abstract basis for all minigames, and extending it will make creating new games much easier.
 
W18 Final Remarks (Gavin Frazar & Roderic Deichler)

This project is essentially an arcade with many minigames. There is supposed to be a timer for each game, but we did not implement that. It currently does not launch random games as intended - for testing reasons, we have the main menu set up so that you can choose which minigame you want to start. The idea of the finished game is that it launches random games and the user plays one after another until the player loses some arbitrary number of minigames.

Features you should add: timer in each game, add more games, implement a scoreboard, add some kind of overall "life" system (e.g. lose 3 minigames -> loss screen displayed, score shown, score saved and added to leaderboard). Implement a "random game" button that starts a random game.

Known Bugs: The whack-a-mole minigame always places the button in the top-center region of the screen when the game starts. Make this random somehow. Also the whack-a-mole minigame does not scale the bounds that the button can appear in when the screen is resized.

Advice: Derive every minigame you make from the Minigame class.
