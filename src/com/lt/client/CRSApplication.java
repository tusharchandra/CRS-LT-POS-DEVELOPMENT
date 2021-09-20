package com.lt.client;

import java.util.Scanner;

import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

public class CRSApplication {

	static boolean isloggedin = false;


	public static void main(String[] args) throws Exception
	{
		
		Scanner in1 = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		crsApplication.displayMainMenu();

		int selection = in1.nextInt(); 
		switch(selection)
		{ 

		case 1: 
			crsApplication.login();
			break;

		case 2: 
			crsApplication.singup();
			break;

		case 3: 
			crsApplication.passwordUpdate();
			break;

		default : 
			break;
		}
	}

	public  void displayMainMenu()
	{
		System.out.println("\n"+"**************************************");
		System.out.println("Welcome to Course Registration System");
		System.out.println("**************************************");
		System.out.println("Select the below option to proceed further");
		System.out.println("1. Login"+"\n"+ "2. Signup"+"\n"+"3. Update Password"+"\n"+"4. Exit"+"\n");
		System.out.println("Enter choice : ");
	}

	public boolean login() throws Exception
	{
		UserInterface user= new UserImplService();

		Scanner in = new Scanner(System.in);
		
		System.out.println("\n:::::User Login:::::\n"); 
		
		System.out.println("Enter Username"); 
		String username = in.nextLine();
		System.out.println("Enter password"); 
		String password = in.nextLine();

		isloggedin=user.login(username, password);
		int roleId = user.getRole(username);

		if(isloggedin) {
			if(roleId==1)
			{
				StudentInterface student = new StudentImplService();
				int studentId =student.getStudentId(username);
				boolean isApproved = student.isApproved(studentId);
				if(isApproved) {
					StudentMenu studentMenu=new StudentMenu();
					studentMenu.studentChecklist(studentId);
				}else {
					System.out.println("You have not been approved by the admin!!! Please Contact Admin");
					isloggedin=false;
				}
			}
			else if(roleId==2)
			{
				ProfessorMenu professorMenu= new ProfessorMenu();
				professorMenu.professorChecklist(username);
			}
			else if(roleId==3)
			{
				AdminMenu adminMenu=new AdminMenu();
				adminMenu.adminChecklist();
			}
			else
			{
				System.out.println("Invalid Credential!!!");
			}
		}else {
			System.out.println("\nUserName and Password is invalid\n");
			login();
		}
		return false;

	}

	public  void singup() throws Exception
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Username");
		String username = in.next();

		System.out.println("Enter Password");
		String password = in.next();

		System.out.println("Enter Contact");
		long contact = in.nextLong();   

		System.out.println("Enter emailID");
		String email = in.next();

		System.out.println("Enter Address");
		String address = in.next();

		System.out.println("Enter Branch");
		String branch = in.next();

		StudentInterface sI= new StudentImplService();
		sI.signup(username, password, contact, email, address, branch);
	}

	public  void passwordUpdate()
	{
		UserInterface userImpl= new UserImplService();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter username to be updated :"+"\n");    
		String uname = in.nextLine(); 
		System.out.print("Enter new password to be updated :"+"\n");    
		String pwrd = in.nextLine(); 

		if(userImpl.updatePassword(uname,pwrd))
			System.out.println("\nYour Password Update Successfully......");
		else
			System.out.println("\nPassword not updated.....");
			
	}
}

