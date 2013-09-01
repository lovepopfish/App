import java.util.HashMap;


public class Question {
	HashMap<Integer,Advertiser> ads;
	int profit;
	public Question(){
		Input input = new Input();
		this.ads = input.getAds();
		profit = 0;
	}

	public void begin(String keyword){
		handleRequest request = new handleRequest(keyword,ads);
		Advertiser ad = request.runRequest();
		if (ad!=null){
			profit += ad.getBid();
			ads.put(ad.getId(), ad);			
		}
	}
	
	public static void main(String[] args){
		Question q = new Question();
		String[] input = new String[]{"a","a","a","b","b","a","b"};
		for (String s:input){
			q.begin(s);
			System.out.println("Profit ---> " + q.profit);
		}
	}
}
