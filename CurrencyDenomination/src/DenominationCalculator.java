import java.util.*;  
public class DenominationCalculator 
{
	//BubbleSort Method
	static void SortDenominationArray(int Denominations[])
	{
		int temp = 0 ;
		for (int i = 0 ; i < Denominations.length; i++)
		{
			for (int j = 1 ; j< Denominations.length - i ; j++)
			{
				if (Denominations[j-1] < Denominations[j]) 
				{
					temp = Denominations[j-1];
					Denominations[j-1] = Denominations[j];
					Denominations[j]=temp;
				}
			}
		}
	}
	//Denominations Calculator for calculating minimum note to used to pay the amount
	static void DenominationsCalculator ( int Denominations[], int PayableAmount)
	{
		SortDenominationArray(Denominations); //Sorting the Array in decreasing order first
		//initialise the array to store the numbe of notes required per Denomination
		int NumberofNotesCounter[] = new int[Denominations.length];
		//Assigning the payable amount to a local variable for calculating the remaining amount
		int RemainingAmount = PayableAmount;
		
		//looping though the entire array of denomination to find the number of notes per denomination
		for (int i = 0; i < Denominations.length;i++)
		{
			//check to see if the remaining amount is greater or equal to the denomination value (one note)
			if (RemainingAmount >=  Denominations[i])
			{
			//if yes then we calculate the number of notes and store in notes counter
				NumberofNotesCounter[i] = RemainingAmount / Denominations[i];
				//reduce the remaining amount to find number of notes of which denomination are required 
				RemainingAmount = RemainingAmount - (Denominations[i] * NumberofNotesCounter[i]);
			}
		}
		//First Check is to see if the remaining amount is more than 0 after we have traversed through the entire denominations array
		if (RemainingAmount > 0 )
		{
			//if yes then the exact amount cannot be given
			System.out.println("Exact Amount cannot be given");
		}
		else
		{
			// if no that means we can pay the amount exactly
			System.out.println("The payable amount can be paid as per below showing minimum notes per Denomination");
			//Traverse through the entire denominations array 
			for (int j = 0 ; j< Denominations.length; j++)
			{
				//Print the number only if the notes count does not have a Zero
				if (NumberofNotesCounter[j] != 0)
				{
					System.out.println (Integer.toString(Denominations[j]) + ":" + NumberofNotesCounter[j]);
				}
			}
			
		}		
	}
	public static void main(String[] args) 
	{
		//Create a Scanner object to take inputs from user
		Scanner sc=new Scanner(System.in); 
		
		//Request input for the size of Denomination Array
		System.out.print("Enter the Size of currency Denominations : ");
		int Size = sc.nextInt();
		System.out.println();
		
		//Initialize the Denominations array as per the size received above
		int[] Denominations = new int[Size];
		//loop to take inputs from user as per the size of the array
		for (int i = 0 ; i < Size; i++)
		{
			System.out.print("Enter the denominations value number " + Integer.toString(i+1)+ ": ");
			Denominations[i]= sc.nextInt();
			System.out.println();
		}	
		//Take user input on the amount payable
		System.out.print("Enter the amount you want to pay : ");
		int PayableAmount = sc.nextInt(); 
		//Call the method to calculate the number the notes required per denomination and print the same
		DenominationsCalculator(Denominations, PayableAmount);
		
		sc.close();
	}

}
