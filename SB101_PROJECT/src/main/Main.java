package main;

import java.util.Scanner;

import custom.ConsoleColors;
import useCases.AssignTheComplaintToTheEngineerUseCase;
import useCases.GetListOfAllComplaintsUseCase;
import useCases.GetListOfAllEngineersUseCase;
import useCases.HodLoginUseCase;
import useCases.RegisterANewEngineerUseCase;
import useCases.RemoveAnEngineerFromSystemUseCase;

public class Main {
	public static void main(String[] args) {
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Welcome To Online Hardware And Software Support System"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"------------------------------------------------------"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE + "+------------------+" + "\n"
												+ "| 1. HOD           |" + "\n"
												+ "| 2. Engineer      |" + "\n"
												+ "| 3. Employee      |" + "\n"
												+ "| 4. Exit          |" + "\n"
												+ "+------------------+" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + "Please choose a number from above options" + ConsoleColors.RESET);
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch(choice) {

		case 1:
			System.out.println();
			System.out.println(ConsoleColors.ROSY_PINK + "Welcome HOD! Please Login to your account." + ConsoleColors.RESET);
			HodLoginUseCase hodLogin = new HodLoginUseCase();
			hodLogin.loginHod();
			while(true) {
				System.out.println(ConsoleColors.PURPLE + "+---------------------------------------+" + "\n"
														+ "| 1. Register An Engineer.              |" + "\n"
														+ "| 2. Get List Of Engineers.             |" + "\n"
														+ "| 3. Remove An Engineer From System.    |" + "\n"
														+ "| 4. Get The List Of complaints.        |" + "\n"
														+ "| 5. Assign a Complaint To An Engineer. |" + "\n"
														+ "| 6. Logout                             |" + "\n"
														+ "+---------------------------------------+" + ConsoleColors.RESET);

				int choose=sc.nextInt();

				if(choose == 1) {
					System.out.println();
					RegisterANewEngineerUseCase register = new RegisterANewEngineerUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Enter The Credentials Of Engineer."+ConsoleColors.RESET);
					register.engineerRegistrationByHod();
				}

				else if(choose == 2) {
					System.out.println();
					GetListOfAllEngineersUseCase getEng = new GetListOfAllEngineersUseCase();
					System.out.println(ConsoleColors.GREEN_BACKGROUND+"List Of Engineers"+ConsoleColors.RESET);
					getEng.listOfEngineers();
				}				

				else if(choose == 3) {
					System.out.println();
					RemoveAnEngineerFromSystemUseCase removeEng = new RemoveAnEngineerFromSystemUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Enter ID To Remove The Engineer."+ConsoleColors.RESET);
					removeEng.engineerRemove();
				}

				else if(choose == 4) {
					System.out.println();
					GetListOfAllComplaintsUseCase getComplaints = new GetListOfAllComplaintsUseCase();
					System.out.println(ConsoleColors.GREEN_BACKGROUND+"List Of Complaints"+ConsoleColors.RESET);
					getComplaints.listOfComplaints();
				}

				else if(choose == 5) {
					System.out.println();
					AssignTheComplaintToTheEngineerUseCase assignEng = new AssignTheComplaintToTheEngineerUseCase();
					System.out.println(ConsoleColors.ROSY_PINK+"Assign a Complaint To An Engineer"+ConsoleColors.RESET);
					assignEng.assignComplaint();
				}

				else if(choose == 6) {
					System.out.println();
					Main.main(args);
				}

				else {
					System.out.println(ConsoleColors.RED_BACKGROUND+"Invalid Choice. Please Enter The Correct Choice."+ConsoleColors.RESET);
					System.out.println();
				}

			}

		}

	}

}