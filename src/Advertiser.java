import java.util.HashMap;


public class Advertiser implements Comparable<Advertiser> {
	private int id;
	private String name;
	private int budget;
	private int bid;
	private HashMap<String,Integer> query;
	public Advertiser(int id, String name, int budget, int bid, String[] keywords) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.bid = bid;
		query = new HashMap<String,Integer>();
		for(String keyword : keywords){
			query.put(keyword, 0);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public HashMap<String, Integer> getQuery() {
		return query;
	}
	public void setQuery(String keyword){
		HashMap<String, Integer> query = getQuery();
		query.put(keyword, query.get(keyword)+1);
		setBudget(getBudget() - getBid());
	}
	public boolean isAvailable(String keyword){
		return getQuery().containsKey(keyword) && getBudget() >= getBid();
	}
	public int compareTo(Advertiser ad) {
		if (this.getBid() < ad.getBid()) return 1;
		else if (this.getBid() == ad.getBid()) return 0;
		else return -1;
	}
}
