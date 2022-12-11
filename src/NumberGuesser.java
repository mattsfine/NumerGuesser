import java.lang.Math;
import java.util.Arrays;
import java.util.List;
public class NumberGuesser {
  static int turns = 0;
	static int[] guesses = new int[30];
	static int[] poss = new int[0];
	static int[] defnot = new int[1];
	static int max = 101;
	public static void guess() {
		for(int i = 0; i < guesses.length; i++) {
			int ranNum = 0;
			while(numIsOnArray(ranNum) ||ranNum == 0) {
				if((int)Math.random()*100 > 60 && poss.length >= 1) {ranNum = poss[(int)Math.random()*poss.length-1];} 
				else ranNum = (int)(Math.random()*max);
			}
			guesses[i] = ranNum;
      }
    }
      
	public static boolean numIsOnArray(int a) {
		for(int i=0; i < guesses.length; i++) {
			if(a==guesses[i]) {return true;}
		}
		return false;
	}
	
	public static void add(int toAdd) {
		poss = Arrays.copyOf(poss, poss.length + 1);
		poss[poss.length - 1] = toAdd;
	}
	
	public static void remove(int toRemove) {
		int[] temp = new int[0];
		for(int i = 0; i < poss.length; i++) {
			if(poss[i] != toRemove) {
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[temp.length-1] = poss[i];
			}
		}
		poss = temp;
	}
	
	public static void addGuesses() {
		List<Integer> templist = Arrays.asList(Arrays.stream(guesses).boxed().toArray(Integer[]::new));
		for(int i = 0; i < poss.length; i++) {
			if(!templist.contains(poss[i])) {
				defnot = Arrays.copyOf(defnot, defnot.length + 1);
				defnot[defnot.length - 1] = poss[i];
			}
		}
		poss = new int[0];
		for(int i = 0; i < guesses.length; i++) {
			if(!checkGuessed(guesses[i]) && !checkDefNot(guesses[i])) {
				add(guesses[i]);
			}
		}
	}
	public static void removeGuesses() {
		for(int i = 0; i < guesses.length; i++) {
			remove(guesses[i]);
			defnot = Arrays.copyOf(defnot, defnot.length + 1);
			defnot[defnot.length - 1] = guesses[i];
		}
	}

	
	public static boolean checkGuessed(int x) {
		for(int i = 0; i < poss.length; i++) {
			if(poss[i] == x) return true;
		}
		return false;
	}
	public static boolean checkDefNot(int x) {
		for(int i = 0; i < defnot.length; i++) {
			if(defnot[i] == x) return true;
		}
		return false;
	}
  public static void guessWindow() {
	if(poss.length != 1) {
	    guess();
	    turns++;
	    int[] temp = Arrays.copyOf(guesses, guesses.length);
	    Arrays.sort(temp);
	    String send = "<html>";
			for(int i = 0; i < temp.length; i++) {
				if(i % 5 == 0) {send+="<br>";}
				send+=(temp[i] + ", ");
				
			}
		send+="<html>";
	    Window.setGuess(send);
	    }
	else {
		Window.question.setText("Your number is " + poss[0] + ". It took " + turns + " tries.");
	}
  }
  


	public static void main(String[] args) {
    @SuppressWarnings("unused")
	Window x = new Window();
    guessWindow();
  }
}

