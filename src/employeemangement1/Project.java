package employeemangement1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
//import java.util.Iterator;
//import java.util.ConcurrentModificationException;
import java.util.Scanner;
//import java.util.UUID;
//import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("serial")
 class Employee implements Serializable{

	 int id;
	 String FirstName;
	 String LastName;
     float salary;
	 String contact_no;
	 String email_id;
	 boolean attendence;
	//static int counter =0;
	
	
	public Employee(int id, String FirstName,String LastName,float salary, String contact_no, String email_id,boolean attendence)
	{
		this.id =id;// counter++;
		this.FirstName = FirstName;
		this.LastName=LastName;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
	   this.attendence = attendence;
	
	}
	
	public String toString()
	{
		return "\nEmployee Details :" + "\nID: " + this.id + "\nFirstName: " + this.FirstName +"\nLastName: " + this.LastName +"\nSalary: " + 
				this.salary + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id+ "\nattendence: "+ this.attendence;
	}
	
}

public class Project
{	
	private static int id ;
//	private static int uniqueKey;
//	private static String In;

    public static int nextId() {
   return ++id;
  }

	public static boolean isValid(String email_id) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email_id == null) 
	            return false; 
	        return pat.matcher(email_id).matches(); 
	    } 
	   public static boolean find(String contact_no) 
	    { 
	        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	         Matcher m = p.matcher(contact_no); 
	        return (m.find() && m.group().equals(contact_no)); 
	    }
	static void display(ArrayList<Employee> al)
	{
		System.out.println("\n--------------Employee List---------------\n");
//		System.out.println(String.format("%-10s%-15s%-15s%-10s%-20s%-10s", "ID","FirstName","LastName","salary","contact-no","Email-Id"));
//		
//		
//		System.out.println("id");
//		System.out.println("FirstName");
//		System.out.println("LastName");
//		System.out.println("salary");
//		System.out.println("contact_no");
//		System.out.println("email_id");
//		int count=1;
		for(Employee e : al)
		{
//			System.out.println(count);
//			System.out.println(String.format("%-10s%-20s%-15s%-5s%-15s%-10s",e.id,e.FirstName,e.LastName,e.salary,e.contact_no,e.email_id));

		    System.out.println("ID: " + e.id);
			System.out.println("FirstName: "+e.FirstName);
			System.out.println("LastName"+e.LastName);
			System.out.println("salary: "+e.salary);
			System.out.println("contact_no: "+e.contact_no);
			System.out.println("email_id: "+e.email_id);
		    System.out.println("attendence: "+e.attendence);
//			count++;
	//		Project.display(al);
	
	}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		
		int id = 0;
		String FirstName = null;
		String LastName = null;
		float salary = 0;
		String contact_no = null;
		String email_id = null;
		boolean attendence = false;
		

		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> al = new ArrayList<Employee>();
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos =null;
		
		try{
			 File file = new File("sagar.txt"); 
		f = new File("sagar.txt");
			if(file.exists())
			{
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				al = (ArrayList<Employee>)ois.readObject();
			
			}
			
		}
		catch(Exception exp){
			System.out.println(exp);
		}
		do
		{
			System.out.println("\n*********Welcome to the Employee Management System**********\n");
			System.out.println("1). Add Employee to the DataBase\n" +
								"2). Search for Employee\n" +
								"8). Edit Employee details\n" +
								"9). Delete Employee Details\n" +
								"10). Display all Employees working in this company\n" +
								"11). EXIT\n");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:  System.out.println("\nEnter the following details to ADD list:\n");

                     System.out.println("Enter ID :");

                           Scanner sca = new Scanner(System.in);
                 try {
                                  id = sca.nextInt();
                            
                        }
                        catch (InputMismatchException e) {
                           System.out.println("InputMismatchException : Invalid , Please Enter digits Only Which Should be unique.Try Again!! ");
                                             sca.nextLine();
                                             
                                          //    sca.nextInt();
                                             break;
                                            
                        }
			
			
			
			
		/*	System.out.println("\nEnter the following details to ADD list:\n");
			System.out.println("Enter ID :");
			id = sc.nextInt();
		
			 UUID uniqueKey = UUID.randomUUID();
			    System.out.println (uniqueKey);

                 */
                      
						System.out.println("Enter FirstName :" );			
							FirstName = sc.next();
				
						  String name =FirstName;
					      String regexName = "^[a-zA-Z]*$";				
					      System.out.println("The name is: " + name);
					      System.out.println("Is the above name valid? " + name.matches(regexName));
				
					      
					      
					      
					    //   Scanner str = new Scanner(System.in);
				/*		 try {  
						   
					      if(name.matches(regexName)==false)
					    	 // System.out.println("Invalid");
					      {   name=str.next();
					      }
					   }catch(Exception e) {  
					    	  System.out.println("Invalid.......");
					    	 str.next();
					    	 break;
					      }*/
					      
					System.out.println("Enter LastName :" );
						LastName = sc.next();
						  String name1 = LastName;
					      String regexName1 ="^[a-zA-Z]*$";
				
					      System.out.println("The name is: " + name1);  
					   System.out.println("Is the above name valid? " + name1.matches(regexName1));
						
						
						
						
						
					/*	Scanner input1=new Scanner(System.in);
						//String LastName="";
						//System.out.println("Enter your LastName : ");
						LastName=input1.nextLine();
						
						
						
						
			/*		      Scanner str1 = new Scanner(System.in);
					      if(name1.matches(regexName1)==false)
					      {   // name=str.nextLine();
					    	  System.out.println("Invalid.......");
					    	  str1.hasNext();
					    	  str1.nextLine();
					      }
					      
					      
					      
					      */
					
						System.out.println("Enter Salary :");
						Scanner scf = new Scanner(System.in);
						try{
							salary = scf.nextInt();
						} catch (InputMismatchException e) {
	                           System.out.println("InputMismatchException : Invalid,Please Enter digits Only.Again Enter your Choice. ");
                                           scf.nextLine();
                                       //     scf.nextInt();
                                           break;
                                               }
					
						System.out.println("Enter Contact No :");
				
						contact_no = sc.next();
					    if (find(contact_no))  
				            System.out.println("Valid Number");         
				        else 
				            System.out.println("Invalid Number");         
				
						System.out.println("Enter Email-ID :");
						email_id = sc.next();
						 if (isValid(email_id)) 
					            System.out.print("Valid Email_Id"); 
					        else
					            System.out.print("Invalid Email_Id"); 
						
						 
						 
						 
						 
						 
						 
						 
						 
						 System.out.println("\nEnter Attendence(In/Out) :");
						 String attend = sc.next();
						
						/* attendence = false;
						 
						 if(attend.equalsIgnoreCase("In")) {
							 attendence = true; 
						}*/
				   if(attend.equalsIgnoreCase("Out"))	 {
					attendence=false;
				   }
					
					
						 
						 
						 
						 
				if(attend.equalsIgnoreCase("In")){
				attendence=true;
				} 
						 
						 
						 
						 
			
				
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						al.add(new Employee(id, FirstName,LastName, salary, contact_no, email_id,attendence));
						display(al);
						break;
			
			case 2: System.out.println("Enter the Employee ID to search :");
					id = sc.nextInt();
					int i=0;
					for(Employee e: al)
					{
						if(id == e.id)
						{
							System.out.println(e+"\n");
							i++;
						}
					}
					if(i == 0)
					{
						System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
					}
					break;
			case 3: System.out.println("Enter the Employee FirstName to search :");
			FirstName = sc.next();
			int m=0;
			for(Employee e: al)
			{
				if(FirstName == e.FirstName)
				{
					System.out.println(e+"\n");
					m++;
				}
			}
			if(m == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid FirstName!!");
			}
			break;
			case 4: System.out.println("Enter the Employee LastName to search :");
			id = sc.nextInt();
			int r=0;
			for(Employee e: al)
			{
				if(LastName == e.LastName)
				{
					System.out.println(e+"\n");
					r++;
				}
			}
			if(r == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid LastName!!");
			}
			break;
			case 5: System.out.println("Enter the Employee Salary to search :");
			id = sc.nextInt();
			float q=0;
			for(Employee e: al)
			{
				if(salary == e.salary)
				{
					System.out.println(e+"\n");
					q++;
				}
			}
			if(q == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid Salary!!");
			}
			break;
			case 6: System.out.println("Enter the Employee contact_no to search :");
			id = sc.nextInt();
			float t=0;
			for(Employee e: al)
			{
				if(contact_no == e.contact_no)
				{
					System.out.println(e+"\n");
					t++;
				}
			}
			if(t == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid contact_no!!");
			}
			break;
			case 7: System.out.println("Enter the Employee Salary to search :");
			id = sc.nextInt();
			float u=0;
			for(Employee e: al)
			{
				if(email_id  == e.email_id )
				{
					System.out.println(e+"\n");
					u++;
				}
			}
			if(u == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid email_id !!");
			}
			break;
			
			case 8: System.out.println("\nEnter the Employee ID to EDIT the details");
					id = sc.nextInt();
					int j=0;
					for(Employee e: al)
					{
						if(id == e.id)
						{	
							j++;
						do{
							int ch1 =0;
							System.out.println("\nEDIT Employee Details :\n" +
												"1). Employee ID\n" +
												"2). FirstName\n" +
												"3). LastName\n" +
												"4). Salary\n" +
												"5). Contact No.\n" +
												"6). Email-ID\n" +
												"7). Attendence\n"+
												"8). GO BACK\n");
							System.out.println("Enter your choice : ");
							ch1 = sc.nextInt();
							switch(ch1)
							{
							case 1: System.out.println("\nEnter new Employee ID:");
									e.id =sc.nextInt();
									System.out.println(e+"\n");
									break;
							case 2: System.out.println("Enter new Employee FirstName:");
								    e.FirstName =sc.next();
									System.out.println(e+"\n");
									break;
							
							case 3: System.out.println("Enter new Employee LastName:");
									e.LastName =sc.next();
									System.out.println(e+"\n");
									break;
									
							case 4: System.out.println("Enter new Employee Salary:");
									e.salary =sc.nextFloat();
									System.out.println(e+"\n");
									break;
									
							case 5: System.out.println("Enter new Employee Contact No. :");
									e.contact_no =sc.next();
									System.out.println(e+"\n");
									break;
									
							case 6: System.out.println("Enter new Employee Email-ID :");
									e.email_id =sc.next();
									System.out.println(e+"\n");
									break;
									
							case 7: System.out.println("Enter new Employee attendence :");
							e.attendence =sc.nextBoolean();
							System.out.println(e+"\n");
							break;
									
							case 8: j++;
									break;
									
							default : System.out.println("\nEnter a correct choice from the List :");
										break;
							
							}
							}
						while(j==1);
						}
					}
					if(j == 0)
					{
						System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
					}
				
					continue;
					
			case 9: System.out.println("\nEnter Employee ID to DELETE from the Databse :");		

		
				    id = sc.nextInt();
					int k=0;
					try{
					for(Employee e: al)
					{
						
						if(id == e.id)
						{
								al.remove(e);
								display(al);
								k++;
						}
					}
					if(k == 0)
					{
						System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
					}
					}
					catch(Exception ex){
						System.out.println(ex);
					}
					break;
			
			case 10: try {
					al = (ArrayList<Employee>)ois.readObject();
				
				} catch (ClassNotFoundException e2) {
					
					System.out.println(e2);
				} catch (Exception e2) {
					
					System.out.println(e2);
				}
					display(al);
					break;
			
			case 11: try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(al);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
				finally{
					try {
						fis.close();
						ois.close();
						fos.close();
						oos.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
					System.out.println("\n Thank you.You have chosen EXIT !! Saving Files and closing the tool.");
					sc.close();
					System.exit(0);
					break;
					
			default : System.out.println("\nEnter a correct choice from the List :");
						break;
			
			}
		}
		while(true);
	
	
	}
	
}
