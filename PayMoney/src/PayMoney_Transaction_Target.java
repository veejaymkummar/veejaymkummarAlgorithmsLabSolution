import java.util.*;  
public class PayMoney_Transaction_Target {
	static void TargetAchievedStatus(int TransactionArray[], int Target)
	{ 
		int Sum = 0;
		//loop to find the sum of all the transactions till the target is met
		for (int i = 0; i<TransactionArray.length; i++ )
		{
			Sum = Sum + TransactionArray[i];
			//At each iteration check if the Sum is greater than the Target
			if (Sum >= Target)
			{
				System.out.println("Target Achieved after " + Integer.toString(i+1) + " Transactions");
				break;
			}
		}
		/*Post the loop is completed for the number of transactions in array Still if the
		 * Sum is less than the target the print the message that Target is not achieved
		 */
		if (Sum<Target)
		{
			System.out.println("Given Target is not achieved");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in); //Create a Scanner object to take inputs from user
		
		//input for the number of transactions for Array Size
		int TransactionSize = 0;
		System.out.println("Please Enter the total number of transactions.");
		TransactionSize = sc.nextInt();
		
		//loop for user input for the number of transactions 
		int[] Transactions = new int[TransactionSize];
		for (int i = 0; i< Transactions.length; i++) 
		{
			System.out.print ("Enter the Transaction Amount Number " + Integer.toString(i+1) + ": ");
			Transactions[i] = sc.nextInt();
			System.out.println();
		}
		
		//Input from user for the total number of targets to be achieved 
		int TotalNoOfTargets=0;
		System.out.print("Enter the total no of targets that needs to be achieved: ");
		TotalNoOfTargets = sc.nextInt();
		System.out.println();
		
	
		/*loop for the total number of targets to be achieved and call the function
		TargetAchievedStatus to know at what transaction number the target is achieved*/
		for (int j = 0; j<TotalNoOfTargets; j++)
		{
			int Target=0;
			System.out.print("Enter the Target: ");
			Target = sc.nextInt();
			System.out.println();
			
			TargetAchievedStatus(Transactions, Target);
		}
		
		sc.close();
	}

}
