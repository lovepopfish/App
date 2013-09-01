import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class handleRequest {
	String keyword;
	ArrayList<Advertiser> list;
	public handleRequest(String keyword, HashMap<Integer,Advertiser> ads){
		this.keyword = keyword;
		list = new ArrayList<Advertiser>();
		for (Advertiser ad:ads.values()){
			if (ad.isAvailable(keyword)){
				list.add(ad);
			}
		}
	}
	public Advertiser runRequest(){
		if (list.size() == 0) return null;
		Collections.sort(list);
		Advertiser ad = list.get(0);
		ad.setQuery(keyword);
		return ad;
	} 

}
