import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Input {
	HashMap<Integer,Advertiser> ads = null;
	public Input(){
		ads = new HashMap<Integer,Advertiser>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/in.txt"));
			String line;
			while ((line = br.readLine())!=null){
				addAds(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	public void addAds (String line){
		String[] data = line.split(" ");
		int id = Integer.parseInt(data[0]);
		String name = data[1].substring(1,data[1].length()-1);
		int budget = Integer.parseInt(data[2]);
		int bid = Integer.parseInt(data[3]);
		String[] keywords = data[4].split(",");
		for(int i=0;i<keywords.length;i++){
			keywords[i] = keywords[i].substring(1,keywords[i].length()-1);
		}
		ads.put(id, new Advertiser(id,name,budget,bid,keywords));
	}
	public HashMap<Integer, Advertiser> getAds() {
		return ads;
	}
}
