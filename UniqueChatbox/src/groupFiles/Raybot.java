package groupFiles;

import java.util.*;
public class Raybot {
	static Scanner scan;
	static String user;
	static boolean inLoop;
	static String response;
	//declare group classes
	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
	}
	public static void createTopics() {
		scan = new Scanner(System.in);
		//initialize group stuff
	}
	public static void print(String x){
		System.out.println(x);
	}
	public static void promptInput(){
		print(user+", please input a string.");
		String userInput = scan.nextLine();
		print("Please input an integer.");
		int number = scan.nextInt();
		print("You typed "+userInput+".");
		print("You typed "+number+".");
	}
	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			print("Greetings, "+user+". How are you?");
			response = getInput();
			if(findKeyword(response, "good", 0)>=0)
				print("I'm so happy you are good.");
			
			//switch between chat boxes here
		}
	}
	public static int findKeyword(String searchString, String key, int startIndex) {
		String phrase = searchString.trim().toLowerCase();
		key.toLowerCase();
		int psn = phrase.indexOf(key);
		while(psn>=0){
			String before = " ";
			String after = " ";
			if(psn+key.length() < phrase.length()){
				after = phrase.substring(psn+key.length(), psn+key.length()+1);
			}
			if(psn>0){
				before = phrase.substring(psn-1, psn).toLowerCase();
			}
			if(before.compareTo("a")<0 && after.compareTo("a")<0){
				if(noNegations(phrase, psn))
				return psn;
			}
			psn = phrase.indexOf(key, psn+1);
		}
		return -1;
	}
	//helper methods are private.
	private static boolean noNegations(String phrase, int index){
		if(index-3 >= 0 && phrase.substring(index-3, index).equals("no ")){
			return false;
		}
		if(index-4 >= 0 && phrase.substring(index-4, index).equals("not ")){
			return false;
		}
		if(index-6 >= 0 && phrase.substring(index-6, index).equals("never ")){
			return false;
		}
		if(index-4 >= 0 && phrase.substring(index-4, index).equals("n't ")){
			return false;
		}
		return true;
	}
	public static void promptName(){
		print("Hi there.");
		print("What's your name?");
		user = scan.nextLine();
		print("Ok, fine.");
		print("I'll call you "+user+".");
	}
	public static String skipLines(String x, int cutOff){
		String returnString = "";
		while(x.length() > 0){
			String currentLine = "";
			String nextWord = "";
			while(currentLine.length() + nextWord.length() <= cutOff && x.length() > 0){
				currentLine += nextWord;
				x = x.substring(nextWord.length());
				int endOfWord = x.indexOf(" ");
				if(endOfWord == -1)
					endOfWord = x.length()-1;
				nextWord= x.substring(0, endOfWord+1);
			}
			returnString += currentLine+"\n";
		}
		return returnString;
	}
	public static String getInput(){
		return scan.nextLine();
	}

}