import random

total = 100

def coin_flip(guess, bet):
    #ensure minimum bet
    
    if bet <= 0:
        
        print("Your bet should be above 0.")
        return 0

    #Starts the game and flips the coin
    print("Try your luck with a coin flip")
    print("Let's flip a coin! You guessed " + guess)
    result = random.randint(1,2)

    # Prints the result of the coin flip. A 1 is heads, a 2 is tails
    if result == 1:
        print("The result of the flip - Heads!")
    elif result == 2:
        print("The result of the flip - Tails")

    # Determines if you won or lost and returns either bet or -bet
    if (guess == "Heads" and result == 1) or (guess == "Tails" and result == 2):
        print("You won " + str(bet)+" dollars!")
        return bet
    else:
        print("You lost " + str(bet)+" dollars!")
        print("//////////////////")
        return -bet

def higher_card(bet):
    #Ensure minimum bet
    if bet <= 0:
        print("Your bet should be above 0.")
        return 0

    # Draw two cards between 1 and 10 
    print("Try your luck with cards")
    print("Let's play a game of cards!")
    you = random.randint(1, 10)
    other = random.randint(1, 10)
    print("Your card  " + str(you))
    print("The other player's card " + str(other))

    #Find  who wins
    if  you > other:
        print("You won " + str(bet)+" dollars!")
        print("///////////////")
        return bet
    elif you < other:
        print("You lost " + str(bet)+" dollars!")
        print("------------------")
        return -bet
    else:
        print("It was a tie!")
        print("/////////////////////")
        return 0

def cho_han(guess, bet):
    #Makes sure your bet was above 0
    if bet <= 0:
    
        print("Your bet should be above 0.")
        return 0

    print("Try your luck with Cho-Han Game!")
    print("Let's play Cho-Han!")
    
    dice1 = random.randint(1, 6)
    dice2 = random.randint(1, 6)
    total = dice1 + dice2
    print("The sum of the two dice is " + str(total))

    if guess == "Even" and total % 2 == 0:
        print("You won " + str(bet)+" dollars!")
        print("//////////////////")
        return bet
    elif guess == "Odd" and total % 2 == 1:
        print("You won " + str(bet)+" dollars!")
        print("//////////////////")
        return bet
    else:
        print("You lost " + str(bet)+" dollars!")
        print("//////////////////")
        return -bet

def roulette(guess, bet):
    #Ensure bet above 0
    if bet <= 0:
        
        print("Your bet should be above 0.")
        
        return 0

    #Roulette wheel
    print("Try your luck with roulette")
    print("Let's play roulette!")
    result = random.randint(0, 37)
    if result == 37:
        print("The wheel landed on 00")
    else:
        print("The wheel landed on " + str(result))

    #Checks to see if we guessed Even and the result was even. 
    if guess == "Even" and result % 2 == 0 and result != 0:
        print(str(result) + " is an even number.")
        print("You won " + str(bet)+" dollars!")
        print("/////////////////")
        return bet

    #Checks to see if we guessed Odd and the result was odd. 
    elif guess == "Odd" and result % 2 == 1 and result != 37:
        print(str(result) + " is an odd number.")
        print("You won " + str(bet)+" dollars!")
        print("//////////////////")
        return bet

    # Guessing the same number should give 35 times the bet amount
    elif guess == result:
        print("You guessed " + str(guess) + " and the result was " + str(result))
        print("You won " + str(bet * 35)+" dollars!")
        print("////////////////////")
        return bet * 35

    
    else:
        print("You lost " + str(bet)+" dollars!")
        print("/////////////////////////////")
        return -bet

total += coin_flip("Heads", 20)
total += higher_card(7)
total += cho_han("Even", 5)
total += roulette("Even", 20)
print("Your total amount of money is " + str(total))