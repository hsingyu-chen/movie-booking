
public class Movie extends Theatre{
	
	private String title;
	private String rating;
	private String date;
	private String time;
	private String length;
	private int numSeat;
	private String[][] seat;
	
	public Movie() {
		super();		title = "";
		rating = "";
		length = "";
		date = "";
		time = "";
		numSeat = 150;
		seat = new String[10][15];
		for (int i = 0 ; i < 10 ; i++) {
			for (int j = 0; j < 15 ; j++) {
				seat[i][j] = "O";
			}
		}
	}
	
	public Movie(String title, String rating, String length,  String date, String time) {
		this.title = title;
		this.rating = rating;
		this.length = length;
		this.date = date;
		this.time = time;
		numSeat = 150;
		seat = new String[10][15];
		for (int i = 0 ; i < 10 ; i++) {
			for (int j = 0; j < 15 ; j++) {
				seat[i][j] = "O";
			}
		}
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getLength() {
		return length;
	}
	
	public int getNumSeat() {
		return numSeat;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void printSeat() {
		int n;
		System.out.print("     ");
		for(n = 1 ; n <= 9 ; n++) {
			System.out.print(n + "   ");
		}
		for(n = 10 ; n <=15 ; n++) {
			System.out.print(n + "  ");
		}
		System.out.println();
		for (int i = 0 ; i < 9 ; i++) {
			System.out.print((i+1) + ":  ");
			for (int j = 0; j < 15 ; j++) {
				System.out.print(" " + seat[i][j] + "  ");
			}
			System.out.print("\n");
		}
	     System.out.print("10: ");
		for(int k = 0; k < 15 ; k++) {
			System.out.print(" " + seat[9][k] + "  ");
		}
		System.out.print("\n");
	}
	
	public boolean availableSeats(int seatSold) {
		if(seatSold > numSeat) {
			return false;
		}else {
			return true;
		}
	}
	
	public void updateNumSeat(int seatSold) {
		numSeat = numSeat-seatSold;
	}
	
	public boolean seatAvailable(int row, int col) {
		if(seat[row-1][col-1].equals("X")) {
			return false;
		}else {
			return true;
		}
	}
	
	public void initializeSeat(int row, int col) {
		if(!(seat[row-1][col-1].equals("X")))
			seat[row-1][col-1] = "O";
	}
	
	public void seatChosen(int row, int col) {
		seat[row-1][col-1] = "X";
	}
	
	@Override public String toString() {
		 return  "Movie: " + title + "\nRating: " + rating
			    + "\nLength: " + length + "\n";
	 }
}
