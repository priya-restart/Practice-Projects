let humanScore = 0;
let computerScore = 0;
let currentRoundNumber = 1;

// Write your code below:
generateTarget = () => {

  return Math.floor(Math.random() * 10);
}

compareGuesses = (human, computer, secretTarget) => {
        humandiff = Math.abs(secretTarget - human);
        compdiff =  Math.abs(secretTarget - computer);
        if (humandiff <= compdiff) {
          return true;
        }
        else {
          return false;
        }
}

updateScore = winner => {

  if (winner === 'human')
{
  humanScore++;

}
else if(winner === 'computer')
{
  computerScore++;
}
}

advanceRound = () => {
  currentRoundNumber++;
}