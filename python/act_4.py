print("ROCK PAPER SCISSORS")
print("-------------------")

Name1 = input("Enter Player 1 Name : ")
Name2 = input("Enter Player 2 Name : ")

player1Score=0
player2Score=0

play="Y"

while play=="Y":

    player1Choice = input(Name1+"'s choice - Enter rock/paper/scissors : ").lower()
    player2Choice = input(Name2+"'s choice - Enter rock/paper/scissors : ").lower()

    if player1Choice == player2Choice:
        print("It's a tie")
    elif player1Choice=="rock" and player2Choice=="paper":
        print(Name2, "wins the round")
        player2Score+=1
    elif player1Choice=="rock" and player2Choice=="scissors":
        print(Name1, "wins the round")
        player1Score+=1
    elif player1Choice=="paper" and player2Choice=="rock":
        print(Name1, "wins the round")
        player1Score+=1
    elif player1Choice=="scissors" and player2Choice=="rock":
        print(Name2, "wins the round")
        player2Score+=1
    elif player1Choice=="paper" and player2Choice=="scissors":
        print(Name2, "wins the round")
        player2Score+=1
    elif player1Choice=="scissors" and player2Choice=="paper":
        print(Name1, "wins the round")
        player1Score+=1
    else:
        print("Invalid Input. You have not entered rock/paper/scissors")

    play=input("Do you want to continue playing(Y/N) : ")

print("Final Score")
print("-----------")

print(Name1+"'s score ",player1Score)
print(Name2+"'s score ",player2Score)