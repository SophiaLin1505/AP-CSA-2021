import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
// My plus one is importing the en.txt file so everyone who plays gets a random word, and then to make this game a game of pure chance I also made a random number of guesses each time the user plays.  
class Main {
  public static void main(String[] args) {
    String words = randomWord(importFile("ene.txt"));
    int r = randomGuess();
    Hangman game = new Hangman(words, r);
    game.play();
    
  }

public static ArrayList<String> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return words;
  }

  public static String randomWord(ArrayList<String> commonW){
    String randomWord = "";
    int r = (int)(Math.random()*commonW.size());
    randomWord = commonW.get(r);
    return randomWord;
}
public static int randomGuess(){
  int r = (int)(Math.random()*15 + 1);
  return r;
}
  //the Hangman class is below, this is called in the main 
  
  
  
 import java.util.*;


public class Hangman
{
  // the secret word
  private String word;
  
  // a string that shows which letters in word have and have not been guessed yet
  private String hint;
  
  // how many guesses the player has left
  private int numGuessesLeft;
  int secondsLeft = 0;
 
  
  public Hangman(String secret, int numGuesses)
  {
    this.word = secret;
    this.numGuessesLeft = numGuesses;
    
    initHint();
  }
  
  /** Initialize the hint instance variable so that it contains
   *  a ? for each letter in word. If word is "hello" then hint should be "?????"
   */
  public void initHint()
  {
    hint = "";
    for(int i = 0; i<this.word.length(); i++){
      hint = "?"+ hint;
    }

  }
  
  /** Checks if word contains letter. If it does, return true; 
   *  otherwise, decrement numGuessesLeft by 1 and return false.
   *  Precondition: letter contains exactly 1 character
   */
  public boolean checkGuess(String letter)
  { 
    
    if(word.indexOf(letter) > -1){
      return true;
    } else{
      this.numGuessesLeft --;
      return false;
    }
      
    
    
  }



