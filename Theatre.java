import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormat;

public abstract class Theatre {


	private double amcPrice;
	private double cenPrice;
	private static double discount = 0.8;
	private boolean isAmc;
	
	public Theatre() {
		amcPrice = 13.69;
		cenPrice = 14.50;
	}
	
	public String getAmcPrice() {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(amcPrice);
	}
	
	public String getCenPrice() {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(cenPrice);
	}
	
	public void setAmcPrice (double amcPrice) {
		this.amcPrice = amcPrice;
	}
	
	public void setCenPrice (double cenPrice) {
		this.cenPrice = cenPrice;
	}
	
	public String discountAmc () {
		DecimalFormat df = new DecimalFormat("#.##");
		amcPrice = amcPrice * discount;
		return df.format(amcPrice);
	}
	
	public String discountCen () {
		DecimalFormat df = new DecimalFormat("#.##");
		cenPrice = cenPrice * discount;
		return df.format(cenPrice);
	}
	
	public static boolean isAmc(String input) {
		if(input.equalsIgnoreCase("B")) {
			return true;
		} 
		return false;
	}
	
	
}
