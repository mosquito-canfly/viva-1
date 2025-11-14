### Problem Description

The task is to develop a game called "Dragon Egg Quest". A player should find 3 magical dragon eggs hidden in the royal vault. The vault has 10 treasure chests which is randomly numbered from 1 to 10. 2 of the chests are cursed which will penalize the player by deducting 2 attempts instead of 1. Each egg is hidden in different chests include cursed chests randomly. The player should find all dragon eggs within 10 attempts. The player can guess one chest each time. Intelligent feedback will be provided by the system after every guess:

- If the chest is cursed, a warning message will appear and extra attempts will be lost.
- If the chest contains an egg, a notifying message will appear.
- If the chest is empty, the system will calculate the distance to the nearest remaining dragon egg. It should display "Warm" if the egg is within 3 chests, or "Cold" otherwise. 

A directional hint will also be provided such as "Try a higher/lower chest number".

The game ends when all 3 eggs are found (Win) or when attempts run out (Lose).


### Solution Explanation

The task is solved by using Java with the Scanner class for user input and Random class for generating random chest locations.

The program starts by printing welcoming messages followed by declaring arrays:

* eggs (size 3): to store egg locations which are randomly generated.
* curse (size 2): to store cursed chest locations which are randomly generated.

The program is continued by using do-while loops nested inside for loops to ensure all random integer number generated for eggs and curses are unique. Three random egg chests and two random cursed chests will be generated at this stage. This method avoids two eggs or curses from occupying the same chest index logic.

After initializing number of attempts and found eggs, it's time to run the game inside a while loop by reading guesses from the player. The game will continue as long as attempt > 0 and found < 3. 

**Input Validation**: The program should check if the input is between 1-10. Invalid inputs will skip the logic by using continue. A message will appear and the player will be prompted to guess one more time. 

**Cursed Check**: After reading the input, the program iterates through the curse array using for a loop. If a match is found, a warning message will be prompted and extra attempt will be deducted.

**Egg Found**: The program iterates through the eggs array using a for loop. If a match is found, a notifying message will be prompted. The location in the array will be set to -1 to mark it as found and the found counter will be increase by 1. If all the eggs are found, a congrats message will be prompted and the game will be ended by using break.

**Hint Algorithm**: If no egg is found, the program calculates the absolute distance between the guess and every remaining egg (ignore those set to -1). It identifies the minimum distance and the specific nearest egg location. This nearest location is used to determine if the egg is far or near, and whether they should guess a higher number or a lower number. Hint messages will be prompted after this stage.

**Attempts Left**: The number of attempts will decrease by 1 per guess. The system will print the attempt(s) left after per guess. 

**End Game**: A conditional check outside the loop determines if the player successfully found 3 eggs when ran out of attempts. A notifying message will be prompted when the player lose the game if fail to find all the eggs.


### Sample Input And Output

Sample 1

![Sample input 1 page 1](sample-cases/Sample%20Output%201%20(1).png)

![Sample input 1 page 2](sample-cases/Sample%20Output%201%20(2).png)



Sample 2

![Sample input 2 page 1](sample-cases/Sample%20Output%202%20(1).png)

![Sample input 2 page 2](sample-cases/Sample%20Output%202%20(2).png)


### Source code

See [Q6.java](Q6.java)



