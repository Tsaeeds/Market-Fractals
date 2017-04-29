

public class Date {
	private int day;
	private int month;
	private int year;
	public static int[] Days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  
	//default constructor 
	public Date() {
		day = 1;
		month = 1;
		year = 2000;
	}
	public Date(Date d){
		
		this.month = d.month;
		this.day = d.day;
		this.year = d.year;
	}
	public Date(int m, int d, int y) {
		setYear(y);
		setMonth(m);
		setDay(d);
	}
	public Date(String strD){
		String [] convertedDate = strD.split("/");
		if (convertedDate.length != 3){
			System.out.println("Invalid date format");
		}
		int a,b,c;
		a = Integer.parseInt(convertedDate[0]);
		b = Integer.parseInt(convertedDate[1]);
		c = Integer.parseInt(convertedDate[2]);
		if(setMonth(a) && setDay(b) && setYear(c)){
	   month = a;
		day = b;
		year = c; 
		}else
			System.out.println("Invalid date format");
	    
	}
	//accessors
	public int getDay() {return day;}
	public int getMonth(){return month;}
	public int getYear(){return year;}
	//mutators
	public boolean setYear(int y) {
		if (y <0)
			return false;
		year = y;
		return true;
	}
	public boolean setMonth(int m) {
		if (m < 1 || m>12 )
			return false;
		month = m;
		return true;
	}
	public boolean isLeap(int y){
		if (y%4 == 0 && y%100!=0)
			return true;
		return false;
	}
	public boolean setDay(int d){
		if (month == 2) {
			if (isLeap(year) && (day > 29 || day < 1))
				return false;
			else if (!isLeap(year) && (day > 28 || day < 1))
				return false;
			return true;
		}
		if (d<1 || d>Days[month]) 
			return false;
		return true;
	}
	public boolean isGreater(Date d){
		if (this.year > d.year)
			return true;
		else if (this.year == d.year) {
			if (this.month > d.month){
				return true;
			} else if (this.month == d.month){
				if (this.day>=d.day)
					return true;
				return false;
			}else 
				return false;	
		}else 
			return false;
	}
	//computer how many days elapsed since the beginning of the year
	//example daysSinceYear("02/12/2001") = 31 for January + 12 for February
	private int daysSinceYear(Date d) {
		int sumDays = 0;
		for (int i =1; i<d.month; i++){
			sumDays += Days[i];
		}
		sumDays += d.day;
		if (d.month > 2 && isLeap(d.year))
			sumDays++;
		return sumDays;
	}
	public int diff(Date right) {
		Date small = this, large = right;
		if (this.isGreater(right)){
			small = right;
			large = this;
		}
			
			int numDays = 0;
			for (int i = small.year; i < large.year; i++){
				if (isLeap(i))
					numDays += 366;
				else 
					numDays += 365;
			}
			int DaysInFirstDate = daysSinceYear(small);
			int DaysInSecondYear = daysSinceYear(large);
			//-1 to exclude the last day
			return (numDays+DaysInSecondYear-DaysInFirstDate+1);	
	}
	public String toString(){
		String st = month+"/"+day+"/"+year;
		return st;
	}
	
	public static void main(String[] args){
		Date D1 = new Date("01/12/1992");
		Date D2 = new Date("05/23/2004");
		System.out.println("Diff = " + D1.diff(D2));
		System.out.println("Diff = " + D2.diff(D1));
		
	}
	
	
}