# BlackjackProject

### Description

This program uses classes to create a functional command line blackjack game. This is a card game, so the cards are created first. Enums are used for Rank and Suit. The deck is created as an ArrayList of cards, in it's own concrete class. Generally, cards can be removed (dealt) or shuffled (methods). As cards are dealt in blackjack they either go to a Dealer's or Player's hand. There are no common cards or anything, so a general concrete class for Hand is used to accept the dealt cards. Hand value and any logic dealing with the hand itself is handled in the class and kept separate from the core (non-hand) game logic. This Hand class can be  easily converted to an abstract class if we decide later to build additional card games by moving the blackjack hand specific logic out of the class (keeping the methods that maintain the cards).


### Lessons Learned
The For/For loop used to build the deck from the enums was clever and it was helpful that we pretty much had the Deck class complete before starting the homework. I think I would have got there, but the For/for loop is the way to go and I'm glad I got to see that before starting. Remembering that an Object removed from an ArrayList is returned from that method is key (and putting it in the correct hand). I originally made a Player concrete class but I wasn't getting much value from that, so I just added player as a field in Hand and did a lot of the logic of the game there. I think overdid conditional checking. If I have time, I'll go back and improve the code readability by removing any redundant logic.
