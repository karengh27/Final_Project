import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class TermProjectOfficial
{
	public static void main(String[] args)
    {
		System.out.println("Prison Guard Game");
		
		int rounds = 1;
		
		//TYPE OF INDIVIDUAL 1:CHEATER 2:COPYCAT 3:GRUDGER
		int ind1 = 0; 
		int ind2 = 0;
		
		//Global Decision
		int dec1 = 0; 
		int dec2 = 0; 

		
		//INITIATE KEYBOARD
		Scanner keyboard = new Scanner(System.in);
		
		//GET DATA TO START GAME
		System.out.println("Enter the number of rounds: ");
		rounds = keyboard.nextInt();
  
	
		System.out.println("Choose Beetween: \n1: Cheater\n2: Copycat\n3: Grudger\n4: Random");
		
		System.out.println("Individual 1: ");
		while(ind1 == 0 || ind1>4) {
			ind1 = keyboard.nextInt();
		}
		
		System.out.println("Individual 2: ");
		while(ind2 == 0 || ind2>4) {
			ind2 = keyboard.nextInt();
		}
		
		
	int points1[] = new int[rounds];
	int points2[] = new int[rounds];
		
	//START THE GAME
	int i = 0; 
	while(i<rounds) {
		
		int decision = startgame(ind1, ind2, i, points1, points2);
		if(decision == 1) {
			points1[i] = 2; 
			points2[i] = 2;
		}
		else if(decision == 2) {
			points1[i] = 3;
			points2[i] = 0;
		}
		else if(decision == 3) {
			points1[i] = 0;
			points1[i] = 3;
		}
		else {
			points1[i] = 1;
			points2[i] = 1;
		}
		System.out.print("Turn ");
		System.out.println(i);
		System.out.print("Individual 1: ");
		System.out.println(points1[i]);
		System.out.print("Individual 2: ");
		System.out.println(points2[i]);
		i++;
	}
	//Game has Ended
	System.out.println("Game has Ended");
	//Karen do the graph here
	System.out.print("Individual 1: ");
	int l = 0; 
	while(l<points1.length) {
		System.out.print(points1[l]);
		System.out.print(" ");
		l++;
	}
	System.out.println();
	System.out.print("Individual 2: ");
	l = 0; 
	while(l<points2.length) {
		System.out.print(points2[l]);
		System.out.print(" ");
		l++;
	}
	
		
	
		
	}

	//1: Cheater 2:Copycat 3: Grudger 4:Random
	static int startgame(int ind1, int ind2, int turn, int[] points1, int[] points2) {
		
		
		if(ind1 == 1) {
			 if(ind2 == 1) {
				 return 4;
			 }
			 else if(ind2 == 2) {
				 return 4;
			 }
			 else if(ind2 == 3) {
				 if(turn == 0) {
					 return 2;
				 }
					 else return 4;
				 }
			 else{
				 if(random1_0() == 0) {
					 return 2;
				 }
				 else return 4;
			 	}
			 }
		
		if(ind1 == 2) {
			if(turn == 0) {
				if(ind2 == 1) {
					if(random1_0() == 0) {
						return 1;
					}
					else return 2; 
				}
				if(ind2 == 2) {
					if(random1_0() == 0) {
						if(random1_0() == 0) {
							return 1;
						}
						else return 2;
					}
					else {
						if(random1_0() == 0) {
							return 3;
						}
						else return 4;
					}
				}
				if(ind2 == 3) {
					if(random1_0() == 0) {
						return 1;
					}
					else return 2;
				}
				if(ind2 == 4) {
					if(random1_0() == 0) {
						if(random1_0() == 0) {
							return 1;
						}
						else return 2;
					}
					else {
						if(random1_0() == 0) {
							return 3;
						}
						else return 4;
					}
				}
			}
			else {
				if(ind2 == 1) {
					return 4;
				}
				else if(ind2 == 2) {
					if(HasCheater(1, turn, points1, points2)) {
						if(HasCheater(2, turn, points1, points2)) {
							return 4;
						}
						else return 3;
					}
					else {
						if(HasCheater(2, turn, points1, points2)) {
							return 2;
						}
						else return 1;
					}
				}
				else if(ind2 == 3) {
					if(HasCheater(1, turn, points1, points2)) {
						if(HasCheater(2, turn, points1, points2)) {
							return 4;
						}
						else return 3;
					}
					else {
						if(HasCheater(1, turn, points1, points2)) {
							return 2; 
						}
						else return 1;
					}
				}
				else {
					if(HasCheater(2, turn, points1, points2)) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 4;
						}
						else return 2;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 3;
						}
						else return 1;
					}
				}
			}
		}
		else if(ind1 == 3) {
			if(turn == 0) {
				if(ind2 == 1) {
					return 2; 
				}
				else if(ind2 == 2) {
					Random rand1 = new Random();
					boolean val = rand1.nextBoolean();
					if(val) {
						return 1;
						}
					else return 3;
				}
				else if(ind2 == 3) {
					return 1;
				}
				else {
					Random rand1 = new Random();
					boolean val = rand1.nextBoolean();
					if(val) {
						return 1;
						}
					else return 3;	
				}
			}
			else {
				if(ind2 == 1) {
					return 4;
				}
				else if(ind2 == 2) {
					if(HasCheater(2, turn, points1, points2)) {
						if(HasCheater(1, turn, points1, points2)) {
							return 4;
						}
						else return 2;	
					}
					else {
						return 1;
					}
				}
				else if(ind2 == 3) {
					return 1;
				}
				else {
					if(HasCheater(2, turn, points1, points2)) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 2;
							}
						else return 4;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 1;
							}
						else return 3;
					}
				}
			}
		}
		else {
			if(ind2 == 1) {
				Random rand1 = new Random();
				boolean val = rand1.nextBoolean();
				if(val) {
					return 3;
					}
				else return 4;
			}
			else if(ind2 == 2) {
				if(turn == 0) {
					if(random1_0() == 0) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 1;
							}
						else return 2;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 3;
							}
						else return 4;
					}
				}
				else {
					if(HasCheater(1, turn, points1, points2)) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 3;
							}
						else return 4;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 2;
							}
						else return 1;
					}
				}
			}
			else if(ind2 == 3){
				if(turn == 0) {
					if(random1_0() == 0) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 1;
							}
						else return 2;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 3;
							}
						else return 4;
					}
				}
				else {
					if(HasCheater(1, turn, points1, points2)) {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 3;
							}
						else return 4;
					}
					else {
						Random rand1 = new Random();
						boolean val = rand1.nextBoolean();
						if(val) {
							return 2;
							}
						else return 1;
					}
				}
			}
			else {
				if(random1_0() == 0) {
					Random rand1 = new Random();
					boolean val = rand1.nextBoolean();
					if(val) {
						return 1;
						}
					else return 2;
				}
				else {
				Random rand1 = new Random();
				boolean val = rand1.nextBoolean();
				if(val) {
					return 3;
					}
				else return 4;
			}	
			}
		}
		return 0;
		
	}
	
	static int random1_0() {
		Random rand1 = new Random();
		boolean val = rand1.nextBoolean();
		if(val) {
			return 1;
			}
		else return 0;
		
	}
	
	
	//returns true if cheated previous turn
	static boolean HasCheater(int ind, int turn, int points1[], int points2[]) {
		if(turn == 0) {
			return false;
		}
		else if(turn == 1) {
			if(ind == 1) {
				if(points1[turn] == 3 || points1[turn] == 1) {
					return true;
				}
				else return false;
			}
			else {
				if(points2[turn] == 3 || points2[turn] == 1) {
					return true;
				}
				else return false;
			}
		}
		else {
			
			if(ind == 1) {
				int val = points1[turn] - points1[turn-1];
				if(val == 3 || val == 1) {
					return true;
				}
				else return false;
			}
			else
			{
				int val = points2[turn] - points2[turn-1];
				if(val == 3 || val == 1) {
					return true;
				}
				else return false;
			}
		}
		
	}
}
