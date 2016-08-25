# Deck
Data structures course assignment using Java Vectors

This program is designed to create a vector that is a deck of cards.
The deck is initialized with the cards grouped by suits (hearts, clubs,
spades, and diamonds) then by card value order within each suit.
The listing of the cards is displayed on screen, then the deck is shuffled 
at least 20 times and displayed again.
 
The shuffling algorithm is the Fisher-Yates shuffle, using a new Random seed
with each shuffle pass. The function nextInt is pseudorandom based on the
seed, thus why I chose to change seeds each pass.

The only command line argument is an integer specifying the number of times to 
shuffle, if it is less than 20, it will shuffle 20 times, if greater, it will 
shuffle the specified number of times.
