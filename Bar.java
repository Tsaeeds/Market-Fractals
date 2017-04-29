

public class Bar {
 
	private float open, close, high, low, adjClose, volume;
	
	Date date;
	public Bar(){
		open = 0;
		close = 0;
		high = 0;
		low = 0;
		adjClose = 0;
		 
	}
public Bar(Date d, float o, float h, float l, float c , float adjC, float v ){
	setOpen(o);
	setClose(c);
	setHigh(h);
	setLow(l);
	setAdjClose(adjC);
	setVolume(v);
	 date = new Date(d);
	
	}
public Bar(String b ){
	
	String[] a = b.split(",");
	setDate(a[0]);
	setOpen(Float.parseFloat(a[1]));
	setClose(Float.parseFloat(a[2]));
	setHigh(Float.parseFloat(a[3]));
	setLow(Float.parseFloat(a[4]));
	setAdjClose(Float.parseFloat(a[5]));
	setVolume(Float.parseFloat(a[6]));
}

public void setDate(String d){
	date = new Date(d);
}

public void setOpen(float o){
	if(o<0)
		System.out.println("Invalid Entry");
	else
	    open = o;
}
public void setClose(float c){
	if(c<0)
		System.out.println("Invalid Entry");
	else
	    close = c;
}
public void setHigh(float h){
	if(h<0)
		System.out.println("Invalid Entry");
	else
	high = h;
}
public void setLow(float l){
	if(l<0)
		System.out.println("Invalid Entry");
	else
	    low = l;
}
public void setAdjClose(float adjC){
	if(adjC<0)
		System.out.println("Invalid Entry");
	else
        adjClose = adjC;	
}
public void setVolume(float v){
	if(v<0)
		System.out.println("Invalid Entry");
	else
	    volume = v;
}
public float different(){
	return high - low;
}
public void display(){
	
	System.out.println("Date: " + date);
	System.out.println("Open: " + open);
	System.out.println("High: " + high);
	System.out.println("Low: " + low);
	System.out.println("Close: " + close);
	System.out.println("Adj Close: " + adjClose);
	System.out.println("Volume: " + volume);
	
	
}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    	
		Bar b = new Bar("01/28/2014,34.5,56.4,78.6,67.4,87.9,32.5");
		
		b.display();
		
		}
	}


