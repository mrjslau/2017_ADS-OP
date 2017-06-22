import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner userInputScan;

	public static void main(String[] args){
		userInputScan = new Scanner(System.in);
		String userInput;
		ArrayList<Peak> peaks = new ArrayList<Peak>();
		FileReader fileReader = new FileReader();
		Peak actor = null, target = null, current = null;
		ArrayList<Peak> visited = new ArrayList<Peak>();
		ArrayList<Peak> path = new ArrayList<Peak>();
		
		fileReader.openFile("data.txt");
		fileReader.readFilebyLines();
	
		for (String names : fileReader.readStrings){
			String[] spParts = names.split(", ");
			int lenght = spParts.length;
			if(lenght > 1){
				ArrayList<String> brd = new ArrayList<String>();
				for(int i = 1; i < lenght; i++){
					brd.add(spParts[i]);
				}
				peaks.add(new Peak(spParts[0], brd));
			}	
			if(lenght == 1){
				peaks.add(new Peak(spParts[0]));
			}	
		}
		fileReader.closeFile();
		
		for (Peak p : peaks){
			for (String str : p.getBorders()){
				for (Peak search : peaks){
					if(search.getName().equals(str)){
						p.addRef(search);
					}
				}
			}
		}
		
		
		for (Peak p : peaks){
			System.out.println(p.getName());
			/*System.out.print(p.getName() + " borders: ");
			for (Peak r : p.getRefs()){
				System.out.print(r.getName() + " ");
			}
			System.out.println();*/
		}
		
		System.out.println();
		System.out.println("Choose main actor from the names provided above");
		userInput = userInputScan.nextLine();
		for (Peak p : peaks){
			if(p.getName().equals(userInput)){
				actor = p;
				break;
			}
		}
		
		System.out.println();
		System.out.println("Choose target (person to borrow from) from the names provided above");
		userInput = userInputScan.nextLine();
		for (Peak p : peaks){
			if(p.getName().equals(userInput)){
				target = p;
				break;
			}
		}
		System.out.println();
		System.out.println("------DFS------");
		System.out.println();
		System.out.println("STEPS:");
		System.out.println();
		
		///////// ------------------------ DFS ----------------
		boolean answerFound = false;
		boolean possible = false;
		visited.add(actor);
		path.add(actor);
		current = actor;
		do{
			if(current.equals(target)){
				System.out.println(current.getName());
				answerFound = true;
				possible = true;
				break;
			}
			System.out.println(current.getName());
			
			Peak temp = current;
			current = getNextPeak(current, visited);
			if(current == null){
				path.remove(temp);
				if(path.isEmpty()){
					possible = false;
					answerFound = true;
					break;
				}
				current = path.get(path.size() - 1);
			}
			else{
				path.add(current);
				visited.add(current);
			}
		}while(answerFound == false);
		
		if(possible){
			System.out.println();
			System.out.println("Borrowed.");
		}
		else{
			System.out.println();
			System.out.println("Not possible to borrow money from designated target.");
		}
		
		///////// ---------------------------------------------
		visited.clear();
		path.clear();
		
		System.out.println();
		System.out.println("------BFS------");
		System.out.println();
		System.out.println("STEPS:");
		System.out.println();
		///////// ------------------------ BFS ----------------
		answerFound = false;
		possible = false;
		visited.add(actor);
		current = actor;
		
		ArrayList<Peak> levelOne = new ArrayList<Peak>();
		levelOne.add(actor);
		ArrayList<Peak> levelTwo = new ArrayList<Peak>();
		System.out.println(current.getName());
		do{
			for(Peak p : levelOne){
				do{
					current = getNextPeak(p, visited);
					if(current == null){
						break;
					}
					if(current.equals(target)){
						System.out.println(current.getName());
						answerFound = true;
						possible = true;
						break;
					}
					if(current != null){
						System.out.println(current.getName());
						levelTwo.add(current);
						visited.add(current);
					}
				}while(current != null && answerFound == false);
				if(answerFound == true)
					break;
			}
			levelOne.clear();
			for(Peak newp : levelTwo){
				levelOne.add(newp);
			}
			levelTwo.clear();
			if(!possible){
			if(levelOne.isEmpty()){
				possible = false;
				answerFound = true;
			}
			}
				
			
		}while(answerFound == false);
		
		///////// ---------------------------------------------
		
		if(possible){
			System.out.println();
			System.out.println("Borrowed.");
		}
		else{
			System.out.println();
			System.out.println("Not possible to borrow money from designated target.");
		}
		
	
	}
	
	public static Peak getNextPeak(Peak p, ArrayList<Peak> vis){
		int visitedToken = 0;
		for(Peak next : p.getRefs()){
			visitedToken = 0;
			for(Peak visited : vis){
				if(next.equals(visited)){
					visitedToken = 1;
				}
			}
			if(visitedToken != 1){
				return next;
			}
		}
		return null;
	}
}
