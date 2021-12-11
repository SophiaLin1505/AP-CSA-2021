import java.util.ArrayList;
import java.util.Scanner;

public class HawaiianWords4 {
	public static void main(String[] args) {
		input();
	}

	public static void input() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a hawaiian word to pronounce");
		String word = keyboard.nextLine();
		System.out.println(finalString(word));
		System.out.println("Do you want to enter another word? Y/YES/N/NO ");
		String answer = keyboard.nextLine();
		answer = answer.toLowerCase();

		if (answer.equals("y") || answer.equals("yes")) {
			input();

		} else if (answer.equals("n") || answer.equals("no")) {
			System.out.println("ok bye :)");
		}

		else {
			wrongInput();
		}
	}

	public static void wrongInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Y, YES, N or NO");
		System.out.println("Do you want to enter another word? Y/YES/N/NO");
		String answer = keyboard.nextLine();
		if (answer.equals("y") || answer.equals("yes")) {
			input();
		} else if (answer.equals("n") || answer.equals("no")) {
			System.out.println("k bye :)");
		} else {
			wrongInput();
		}
	}

	public static boolean isValid(String a) {

		a = a.toLowerCase();
		for (int i = 0; i < a.length() - 1; i++) {
			boolean isValid = a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o'
					&& a.charAt(i) != 'u' && a.charAt(i) != 'p' && a.charAt(i) != 'k' && a.charAt(i) != 'h'
					&& a.charAt(i) != 'l' && a.charAt(i) != 'm' && a.charAt(i) != 'n' && a.charAt(i) != 'w'
					&& a.charAt(i) != 39 && a.charAt(i) != ' ';
			if (isValid) {

				return false;
			}
		}
		return true;

	}

	public static String isValid1(String a) {
		char b = a.charAt(0);

		if (isValid(a) == false) {
			for (int i = 0; i < a.length() - 1; i++) {
				boolean isValid = a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o'
						&& a.charAt(i) != 'u' && a.charAt(i) != 'p' && a.charAt(i) != 'k' && a.charAt(i) != 'h'
						&& a.charAt(i) != 'l' && a.charAt(i) != 'm' && a.charAt(i) != 'n' && a.charAt(i) != 'w'
						&& a.charAt(i) != 39 && a.charAt(i) != ' ';
				if (isValid) {
					b = a.charAt(i);
				}
			}

		}
		return b + " is not a valid Hawaiian character";
	}

	public static ArrayList<String> toArray(String a) {
		a = a.toLowerCase();
		ArrayList<String> Words = new ArrayList<>();
		if (isValid(a) == true) {
			for (int i = 0; i < a.length(); i++) {

				Words.add(a.substring(i, i + 1));

			}

		}

		return Words;

	}

	public static ArrayList<String> Format(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 1; i++) {
			if (word.get(i).equals("a") || word.get(i).equals("e") || word.get(i).equals("i") || word.get(i).equals("o")
					|| word.get(i).equals("u")) {
				word.add(i + 1, "-");

			}

		}
		return word;

	}

	public static ArrayList<String> constantsW(ArrayList<String> word) {

		for (int i = 2; i < word.size(); i++) {
			word.set(i, word.get(i).toLowerCase());
			if ((word.get(i - 2).equals("i") || word.get(i - 2).equals("e")) && (word.get(i).equals("w"))) {
				word.set(i, "v");

			}
		}
		return word;
	}

	public static ArrayList<String> vowelA(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 2; i++) {
			word.set(i, word.get(i).toLowerCase());
			if (word.get(i).equals("a") && (word.get(i + 2).equals("i") || word.get(i + 2).equals("e"))) {
				word.set(i, "eye");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("a") && (word.get(i + 2).equals("o") || word.get(i + 2).equals("u"))) {
				word.set(i, "ow");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("a")) {
				word.set(i, "ah");
			}

		}
		if (word.get(word.size() - 1).equals("a")) {
			word.set(word.size() - 1, "ah");
		}

		return word;
	}

	public static ArrayList<String> vowelE(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 2; i++) {

			if (word.get(i).equals("e") && (word.get(i + 2).equals("i"))) {
				word.set(i, "ay");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("e") && (word.get(i + 2).equals("u"))) {
				word.set(i, "eh-oo");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("e")) {
				word.set(i, "eh");
			}

		}
		if (word.get(word.size() - 1).equals("e")) {
			word.set(word.size() - 1, "eh");
		}

		return word;
	}

	public static ArrayList<String> vowelI(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 2; i++) {
			if (word.get(i).equals("a") && (word.get(i + 2).equals("u"))) {
				word.set(i, "ew");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("i")) {
				word.set(i, "ee");
			}

		}
		if (word.get(word.size() - 1).equals("i")) {
			word.set(word.size() - 1, "ee");
		}

		return word;
	}

	public static ArrayList<String> vowelO(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 2; i++) {
			if (word.get(i).equals("o") && (word.get(i + 2).equals("i"))) {
				word.set(i, "oy");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("o") && (word.get(i + 2).equals("u"))) {
				word.set(i, "ow");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("o")) {
				word.set(i, "oh");
			}

		}
		if (word.get(word.size() - 1).equals("o")) {
			word.set(word.size() - 1, "oh");
		}

		return word;
	}

	public static ArrayList<String> vowelU(ArrayList<String> word) {

		for (int i = 0; i < word.size() - 2; i++) {
			if (word.get(i).equals("u") && (word.get(i + 2).equals("i"))) {
				word.set(i, "ooey");
				word.remove(i + 2);
				i -= 2;
			} else if (word.get(i).equals("u")) {
				word.set(i, "oo");
			}

		}
		if (word.get(word.size() - 1).equals("u")) {
			word.set(word.size() - 1, "oo");
		}

		return word;
	}

	public static ArrayList<String> FinalArray(String a) {
		ArrayList<String> original = Format(toArray(a));
		if (original.size() > 0) {
			for (int i = 0; i < original.size(); i++) {

				if (original.get(i).equals("a")) {
					vowelA(original);

				} else if (original.get(i).equals("e")) {
					constantsW(original);
					vowelE(original);

				} else if (original.get(i).equals("i")) {
					constantsW(original);
					vowelI(original);
				} else if (original.get(i).equals("o")) {
					vowelO(original);
				} else if (original.get(i).equals("u")) {
					vowelU(original);
				}
			}
			for (int i = 0; i < original.size() - 1; i++) {
				if (original.get(i).equals("-") && original.get(i + 1).equals("-")) {
					original.remove(i);
					i--;
				} else if (original.get(i).equals("-") && original.get(i + 1).equals(" ")) {
					original.remove(i);
					i--;
				} else if (original.get(i).equals("-") && original.get(i + 1).equals("'")) {
					original.remove(i);
					i--;
				}

			}

			if (original.get(original.size() - 1).equals("-")) {
				original.remove(original.size() - 1);
			}
		}
		return original;
	}

	public static String finalString(String a) {
		ArrayList<String> finalArray = FinalArray(a);
		String FinalWord = "";
		if (finalArray.size() > 0) {
			for (int i = 0; i < finalArray.size(); i++) {
				FinalWord = FinalWord + finalArray.get(i);
			}

			a = a.toUpperCase();
			return a + " is pronounced " + FinalWord;
		} else {
			return isValid1(a);
		}
	}
}
