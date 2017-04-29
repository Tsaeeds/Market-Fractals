
public class Downloader {

	yahooData data;
	private String [] allSymbols = {"AKS","AAPL","AMZN","BAC","BBY","BCS","BIDU","BRCD","C","CAT","CSCO","DAL","DOW","EMC","EPI","F","GE","GLW","GOOG","IBM","INTC","JPM","LVLT","MSFT","NFLX","NOK","NVS","S","SFD","SIRI","SYMC","TSN"};
	private String nSymbol,nDirectory;
	private Date strDate, endDate;
	public Downloader(){
		nSymbol = "";
		nDirectory = "";
		strDate = new Date();
		endDate = new Date();
		
	}
	public Downloader(String s, String d, Date sd, Date ed){
		nSymbol = s;
		nDirectory = d;
		strDate = new Date(sd);
		endDate = new Date(ed);
	}
	public Downloader(String s, String d, String sd, String ed){
		nSymbol = s;
		nDirectory = d;
		strDate = new Date(sd);
		endDate = new Date(ed);
	}
	public Downloader(String d, Date sd, Date ed){
		
		nDirectory = d;
		strDate = new Date(sd);
		endDate = new Date(ed);
	}
	public Downloader(String d, String sd, String ed){
		
		nDirectory = d;
		strDate = new Date(sd);
		endDate = new Date(ed);
	}
	public void loadAll(){
		for(int i = 0; i<allSymbols.length; i++){
			 data = new yahooData(allSymbols[i], nDirectory, strDate, endDate);
			if (data.load()) {
				System.out.println(allSymbols[i] + " data is downloaded");
			}else {
				System.out.println("Error!");
			}
			}
		}
	
	public void loadSpecific(){
		String [] aSymbol = nSymbol.split(",");
		for(int i = 0; i<aSymbol.length; i++){
			for(int j = 0; j<allSymbols.length; j++){
				if(aSymbol[i].equalsIgnoreCase(allSymbols[j])){
					 data = new yahooData(allSymbols[j], nDirectory , strDate, endDate);
					if (data.load()) {
						System.out.println(allSymbols[i] + " data is downloaded");
					}else {
						System.out.println("Error!");
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		//create yahooData object 
		Downloader d = new Downloader("C:/Data/AllData/", "03/23/2006", "05/23/2012");
		d.loadAll();
		Downloader s = new Downloader("AMZN,CAT", "C:/Data/omData/", "03/23/2006", "05/23/2012");
		s.loadSpecific();
	}
}
