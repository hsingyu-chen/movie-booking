import java.util.ArrayList;
import java.util.Scanner;
public interface ReservationDetail {
	public abstract int linearSearch(String title, ArrayList<Movie> movie);
	public abstract void printMovie(ArrayList<Movie> movie);
	public abstract void bubbleSort(ArrayList<Customer> cust);
	public abstract int binarySearch(ArrayList<Customer> cust, Customer a);
}
