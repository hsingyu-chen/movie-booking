import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation implements ReservationDetail{
	private static ArrayList<Customer> cust = new ArrayList<Customer>();
	private static ArrayList<Movie> movie1 = new ArrayList<Movie>();
	
	public static void main(String[] args) throws IOException{
		String theatre = "", t1= "", t2= "", t3 = "";
		String member;
		int customer = 0;
		int num =0;
		String option;
		File infile = new File("member.txt");
		Scanner input1 = new Scanner(infile);
		Scanner in = new Scanner(System.in);
		
		Reservation r = new Reservation();
		Scanner input = new Scanner(System.in);
     	boolean flag = true;
     	int month = 0, date = 0;
     	boolean more = true, more2 = true;
     	System.out.println("Welcome to Team 4 Movie Reservation App!\n");
			
     	
			System.out.print("Please select the theater you prefer A) Century\tB) AMC: ");
			theatre = in.next();
			while(!(theatre.equalsIgnoreCase("A") || theatre.equalsIgnoreCase("b"))){
	     		System.out.print("Please select the theater you prefer A) Century\tB) AMC: ");
	     		input1.nextLine();
	     		theatre = in.next();
	     	}
			
			if(theatre.equalsIgnoreCase("A")) {
				theatre = "century.txt";
				option = "A";
			}else {
				theatre = "amc.txt";
				option = "B";
			}
     	
			File a1 = new File(theatre);
			Scanner a = new Scanner(a1);
     	
     	
	     	while (more) {
		     	try {
		     		System.out.print("\nPlease enter the month you would like to watch (1-12): ");
		     		month = in.nextInt();
		     		more = false;
				     while(month<1 || month>12) {
				    	 in.nextLine();
				    	 System.out.print("Month invalid!");
				    	 System.out.print(" Please enter the month you would like to watch (1-12): ");
				    	 month = in.nextInt();
				     }
		     	}catch ( InputMismatchException e) {
		     		System.out.println("Only enter whole numbers between 1 to 12");
		     		in.nextLine();
		     	}
	     	}
	     	
	     	while(more2) {
		    	 try {
		    		 System.out.print("\nPlease enter the date you would like to watch (1-31): ");
				     date = in.nextInt();
				     more2 = false;
				     if(month == 4 && month == 6 && month == 9 && month == 11) {
				    	 while(date<1 || date>10) {				    		 
				    				 in.nextLine();
						    		 System.out.print("Date invalid!");
							    	 System.out.println("Please enter the date you would like to watch (1-31): ");
							    	 date = in.nextInt();				    		 
				    	 }
				     } else if(month == 2) {
				    	 while(date<1 || date>29) {				    		 
				    				 in.nextLine();
						    		 System.out.print("Date invalid! ");
							    	 System.out.println("Please enter the date you would like to watch (1-31): ");
							    	 date = in.nextInt();
				    	 }
				     } else {
				    	 while(date<1 || date>31) {
				    				 in.nextLine();
						    		 System.out.print("Date invalid!");
							    	 System.out.println("Please enter the date you would like to watch (1-31): ");
							    	 date = in.nextInt();
					     }
				     }
				     
		    	 }catch (InputMismatchException e){
		    		 System.out.println("Only enter whole numbers between 1 to 31");
		    		 in.nextLine();
		    	 }
		    	 
		     }
	     	
	     		String monthDate = month + "/" + date;
     		
	     		String line = "";
	     		String movie = "";
	     		String rating = "";
	     		String duration = "";
			while(a.hasNextLine()) {
				line = a.nextLine();
				if(line.length() > 0) {
					more = true;
					while(more) {
						try {
							movie = line;
							rating = a.nextLine();
							duration = a.nextLine();
							t1 = a.nextLine();
							t2 = a.nextLine();
							t3 = a.nextLine();
							
							more = false;
						}catch(InputMismatchException e) {
							System.out.println("Invalid file input !!!");
						}
					}
				Movie m1 = new Movie(movie, rating, duration, monthDate, t1);
				Movie m2 = new Movie(movie, rating, duration, monthDate, t2);
				Movie m3 = new Movie(movie, rating, duration, monthDate, t3);
				r.movie1.add(m1);
				r.movie1.add(m2);
				r.movie1.add(m3);
				}
			}
			a.close();

			String name, email, password, number = "";
			while(input1.hasNextLine()) {
				line = input1.nextLine();
				if(line.length() > 0) {
					name = line;
		    		email=input1.nextLine();
		    		number = input1.nextLine();
		    		password = input1.nextLine();
		    		Customer c = new Customer(name, email, number, password);
		        	r.cust.add(c);
				}			
	    	}
     		
	     	input1.close();
	     	
	     	r.bubbleSort(cust);
	     		while(flag) {
	     			r.printMovie(r.movie1);
	     			System.out.print("Enter the name of the movie you would like to watch from the list of movies given above: ");
			     	String m = input.nextLine();
		     		num = r.linearSearch(m, r.movie1);
		     		if(num == -1) {
		     			System.out.println("Error! Movie not found. ");
		     		}else {
		     			flag = false;
		     		}
	     		}
	     		String time = "";
	     		Movie mov = new Movie();
	     		while(!flag) {
	     			try {
	     			System.out.print("Enter one of the time choices from the list of movies (A/B/C): ");
	         		time = in.next();
	         		mov.setTime(time);
	         		flag = true;
	     			while(!(time.equalsIgnoreCase("A")||time.equalsIgnoreCase("B")||time.equalsIgnoreCase("C"))){
	     				System.out.println("Invalid! ");
	     				System.out.print("Enter one of the time choices from the list of movies (A/B/C): ");
	             		time = input.next();
	     			}	
	     			}catch(InputMismatchException e) {
	     				System.out.println("Invalid. Please enter A, B, or C.");
	    	     		in.nextLine();
	     			}
	     			
	     			
	     		}
	     		
	     		int tickets = 0;
	     		while (flag) {
	     			try {
	     			System.out.print("\nEnter the number of tickets: ");
	     			tickets = in.nextInt();
	     			flag = false;
	     			}
	     			catch (InputMismatchException e) {
	     				System.out.println("Your entry is incorrect. Please enter a positive whole number with no spaces");
	     				in.nextLine();
	     			}
	     			
	     		}
	     		Movie mo = new Movie();
	     		mo.printSeat();
	     		boolean more3 = true;
	     		while(more3) {
	     		while ( tickets != 0 ) {
	     			try {
					System.out.print("\nEnter the row number of the seat you want for ticket " + tickets + ": ");
					int row1 = in.nextInt();
					System.out.print("Enter the column number of the seat you want: ");
					int col1 = in.nextInt();
					System.out.println();
					more3 = false;
					if ( !mo.seatAvailable(row1, col1) ) {
						System.out.println("\nSeat is not available, please pick another seat.\n");
						mo.printSeat();
					}
					
					else {
						mo.seatChosen(row1, col1);
						mo.printSeat();
						mo.initializeSeat(row1, col1);
						mo.updateNumSeat(1);
						tickets--;
					}
	     		 } catch(IndexOutOfBoundsException e) {
	     			 System.out.println("Invalid number");
	     		 }
	     		}
	     	    }
	     		StringBuilder sbr = new StringBuilder(monthDate);
	     		if(time.equalsIgnoreCase("a")) {
	     			time = r.movie1.get(num).getTime();

	     			} else if(time.equalsIgnoreCase("b")) {
	     			time = r.movie1.get(num+1).getTime();

	     			} else {
	     			time = r.movie1.get(num+2).getTime();

	     			}
     			sbr = sbr.append(" " + time.substring(3));
	         	System.out.print("\nEnter your email: ");
	         	email = in.next();	         	
	         	System.out.print("Enter your phone number: ");
	         	String phone = in.next();	         	
	         	Customer c= new Customer(email, phone);
	            customer = r.binarySearch(r.cust, c);
	            
	         	if(customer == -1) {
	         		System.out.println("\nSorry, we cannot find you in the member list.");
	         		String choice;
	         		System.out.print("\nWould you like to be our member and enjoy 20% off? (y/n): ");
	         		choice = input.nextLine();
	         		
	         		if(choice.equalsIgnoreCase("y")) {
	         			r.printJoinMember(cust);
	         			if (!Theatre.isAmc(option)) {
	    					System.out.print("Thank you for your purchase!\n\nHere are your order confirmation details!: \n");
	    					System.out.println(r.movie1.get(num).toString() + "Time: " + sbr + 
	    							"\nPrice: $" + r.movie1.get(num).discountAmc() + " per ticket");					
	    		     		
	    		     		} else if(Theatre.isAmc(option)) {
	    					System.out.print("Thank you for your purchase!\n\nHere are your order confirmation details!: \n");
	    					System.out.println(r.movie1.get(num).toString() + "Time: " + sbr + 
	    							"\nPrice: $" + r.movie1.get(num).discountCen() + " per ticket");					
	    				}
	         		} else {
	         			if (!Theatre.isAmc(option)) {
	        	     		System.out.print("\nThank you for your purchase!\n\nHere are your order confirmation details!: \n");
	    					System.out.println(r.movie1.get(num).toString()  + "Time: " + sbr +  
	    							"\nPrice: $" + r.movie1.get(num).getCenPrice() + " per ticket");
	        	     		}
	        	     		
	         			 else if(Theatre.isAmc(option)){
	        	     		System.out.print("\nThank you for your purchase!\n\nHere are your order confirmation details!: \n");
	    					System.out.println(r.movie1.get(num).toString()  + "Time: " + sbr +  
	    							"\nPrice: $" + r.movie1.get(num).getAmcPrice() + " per ticket");
	        	     		}
	    		     	}
	         		
	         	} else {	         				
				if (!Theatre.isAmc(option)) {
					System.out.println("\nWelcome back, " + cust.get(customer).getName() + "!");
					System.out.print("Thank you for your purchase!\n\nHere are your order confirmation details!: \n");
					System.out.println(r.movie1.get(num).toString() + "Time: " + sbr + 
							"\nPrice: $" + r.movie1.get(num).discountAmc() + " per ticket");					
		     		
		     		} else if(Theatre.isAmc(option)) {
					System.out.println("\nWelcome back, " + cust.get(customer).getName() + "!");
					System.out.print("Thank you for your purchase!\n\nHere are your order confirmation details!: \n");
					System.out.println(r.movie1.get(num).toString() + "Time: " + sbr + 
							"\nPrice: $" + r.movie1.get(num).discountCen() + " per ticket");					
				}
		     		}     		
	         	input.close();
	     	}
	
	@Override public int binarySearch(ArrayList<Customer> cust,  Customer a) {
		int high = cust.size()-1;
		int low = 0;
		while (low<=high) {
			int mid = (low+high)/2;
			if(cust.get(mid).equals(a)) {
				return mid;
			}else if(((Comparable<Customer>) a).compareTo(cust.get(mid))<0) { //search the left half
    		    high = mid - 1;
    		}else { //search the right half
    		    low = mid+1;
    		} //end of while loop
    	}
		return -1;
	}

	@Override public int linearSearch(String title, ArrayList<Movie> movie) {
		for (int i = 0; i<movie1.size(); i++) {
			if ( movie.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1 ; 
	}
	
	@Override public void bubbleSort(ArrayList<Customer> cust) {
		for(int i = 0; i<=cust.size()-2; i++) {
    		for(int j=0; j<=cust.size()-i-2; j++) {
    			if(cust.get(j).compareTo(cust.get(j+1))>0) {
    				Customer temp = cust.get(j);
    				Customer temp2 = cust.get(j+1);
    				cust.set(j, temp2);
    				cust.set(j+1, temp);
    			}
    		}
    	}
       return;
	}
	
	public void printMovie(ArrayList<Movie> movie){
		for(int i = 0; i<movie1.size(); i++) {
     		if ( i == 0 || i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
     			System.out.println("Movie: " + movie1.get(i).getTitle() + "\nRating: " + movie1.get(i).getRating() + "\nLength:" + movie1.get(i).getLength()  
    					+"\nTime: " + movie1.get(i).getTime() + "\t" + movie1.get(i+1).getTime()+ "\t" + movie1.get(i+2).getTime() + "\n");
         		}
    		}
    	}
    	
    	private void printJoinMember(ArrayList<Customer> cust) throws IOException {
    		Scanner input = new Scanner(System.in);
    		
    					System.out.print("\nPlease enter your name: ");
    					String name = input.nextLine();
    					System.out.print("Please enter your email: ");
    					String email = input.nextLine();
    					System.out.print("Please enter your phone number: ");
    					String phone = input.nextLine();
    					System.out.print("Please enter your password: ");
    					String password = input.nextLine();
    					
    					Customer newCustomer = new Customer(name, email, phone, password);
    					cust.add(newCustomer);
    					
    					System.out.println("\nThank you " + name + ", you are now a member!");
    					
    					File outFile = new File("membership.txt");
    					PrintWriter out = new PrintWriter(outFile);
    					for(int i = 0; i < cust.size(); i++) {
    						out.println(cust.get(i));
    					}
    					out.close();
    	}
	  			  	
    }
