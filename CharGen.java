import java.util.Arrays;
import java.util.Scanner;

public class CharGen{
	
	public static void main(String[] args){
		
		CharGen charGen = new CharGen();
		
		//1. Stat roll
		
		System.out.println(" ");
		
		int str = charGen.statroll();
		System.out.println("Strength is " + str);
		
		int dex = charGen.statroll();
		System.out.println("Dexterity is " + dex);
		
		int con = charGen.statroll();
		System.out.println("Constitution is " + con);
		
		int intl = charGen.statroll();
		System.out.println("Intelligence is " + intl);
		
		int wis = charGen.statroll();
		System.out.println("Wisdom is " + wis);
		
		int cha = charGen.statroll();
		System.out.println("Charisma is " + cha);
		
		System.out.println(" ");
		
		//2. Choose Race
		String size = "Medium";
		int speed = 30;
		boolean darkvision = true;
		
		String race = charGen.race();
		
		if(race.equals("Dwarf")){
			
			con += 2;
			wis += 1;
			size = "Medium";
			speed = 25;
			darkvision = true;
			
		}else if(race.equals("Elf")){
			
			dex += 2;
			wis += 1;
			size = "Medium";
			darkvision = true;
			
		}else if(race.equals("Halfling")){

			dex += 2;
			wis += 1;
			size = "Small";
			speed = 25;
			darkvision = true;
		
		} else if (race.equals("Human")){
				
				str += 1;
				dex += 1;
				con += 1;
				intl += 1;
				wis += 1;
				cha += 1;
				size = "Medium";
				darkvision = false;
		}
		
		if(race.equals("Dwarf") || race.equals("Halfling") || race.equals("Human")){
		
			System.out.println("You are a " + race);	
			
		} else{

			System.out.println("You are an " + race);
		}		
		
		//Print final values
		System.out.println("Your Strength is " + str);
		System.out.println("Your Dexterity is " + dex);
		System.out.println("Your Constitution is " + con);
		System.out.println("Your Intelligence is " + intl);
		System.out.println("Your Wisdom is " + wis);
		System.out.println("Your Charisma is " + cha);
		
		System.out.println(" ");
		
		System.out.println("Your size is " + size);
		System.out.println("Your base walking speed is " + speed + " feet");
		
		if(darkvision == true){

			System.out.println("You have darkvision up to a range of 60 feet.");
			
		}
	}
	
	//Stat roll method
	public int statroll() {
        
		int[] statroll = new int[4];
		int total = 0;
		
		//Roll 1d6 4 times and populate statroll array with results
		for(int i = 1; i < 4; i++){
			
			int result = ((int)(Math.random() * 6) + 1);
			
			statroll[i] = result;
		
		}
		
		//Sort array into ascending order
		Arrays.sort(statroll);
		//Add total of dice rolls, omitting the lowest result at position [0] in the array
		total = statroll[1] + statroll[2] + statroll[3];
		
		return total;
	}	

	//Choose race method
	public String race(){
		
		Scanner scanner = new Scanner(System.in);
		boolean validResponse = false;
				
		while(validResponse == false){
			
			System.out.println("Choose a race; Dwarf, Elf, Halfling or Human");
			String ans = scanner.nextLine();
			
			if(ans.equals("Dwarf") || ans.equals("dwarf")){
			
				String race = "Dwarf";
				validResponse = true;
				return race;
		
			} else if (ans.equals("Elf") || ans.equals("elf")){
				
				String race = "Elf";
				validResponse = true;
				return race;
			
			} else if (ans.equals("Halfling") || ans.equals("halfling") || ans.equals("Hobbit") || ans.equals("hobbit")){
				
				String race = "Halfling";
				validResponse = true;
				return race;
				
			} else if (ans.equals("Human") || ans.equals("human")){
				
				String race = "Human";
				validResponse = true;
				return race;
			
			} else{
			
				System.out.println(ans + " is not a valid response");
				validResponse = false;
			
			}
		}
		
		return "";
	}
}	