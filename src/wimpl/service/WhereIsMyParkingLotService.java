package wimpl.service;

import java.util.ArrayList;
import java.util.Comparator;

import lombok.NoArgsConstructor;
import wimpl.mode.WimplModelVirtualDB;
import wimpl.model.dto.ParkingArea;

class NearComparator implements Comparator<ParkingArea> {
	@Override
	public int compare(ParkingArea o1, ParkingArea o2) {
		double oo1 = o1.getLatitude() * o1.getLongtide();
		double oo2 = o2.getLatitude() * o2.getLongtide();
		if (oo1 > oo2) {
			return 1;
		}else if (oo1 < oo2) {
			return 0;
		}else {
			return -1;
		}
	}
}

class PriceComparator implements Comparator<ParkingArea>{
	@Override
	public int compare(ParkingArea o1, ParkingArea o2) {
		int oo1 = o1.getStandardPrice();
		int oo2 = o2.getStandardPrice();
		if (oo1 > oo2) {
			return 1;
		}else if (oo1 < oo2) {
			return 0;
		}else {
			return -1;
		}
	}
}

class Matching {
	public static int match(String s1, String s2) {
		
		String[]ss1=s1.split("");
		String[]ss2=s2.split("");
		
		ArrayList<String> jacar1 = new ArrayList<>();
		for (int i=0; i<s1.length()-1; i++) {
			if (!ss1[i].equals(" ") && !ss1[i+1].equals(" ")) { 
				jacar1.add(ss1[i]+ss1[i+1]);
			}
		}
		
		ArrayList<String> jacar2 = new ArrayList<>();
		for (int i=0; i<s2.length()-1; i++) {
			if (!ss2[i].equals(" ") && !ss2[i+1].equals(" ")) { 
				jacar2.add(ss2[i]+ss2[i+1]);
			}
		}
		
		int ans1=0, ans2=0;
		for (String s : jacar1) {
			if (jacar2.contains(s)) {
				ans1++;
				jacar2.remove(s);
			}
			ans2++;
		}
		ans2+=jacar2.size();
		return (65536*ans1)/ans2;
	}
}







@NoArgsConstructor
public class WhereIsMyParkingLotService {

	private static WhereIsMyParkingLotService instance = new WhereIsMyParkingLotService();

	private WimplModelVirtualDB ParkingAreaData = WimplModelVirtualDB.getInstance();

	public static WhereIsMyParkingLotService getInstance() {
		return instance;
	}

	public ArrayList<ParkingArea> getDB() {
		return this.ParkingAreaData.getparkingLotList();
	}

	//service 1 : 내 주변 주차장
	public ArrayList<ParkingArea> getNear(double MyLatitude, double MyLongtide, double compare) {
		
		ArrayList<ParkingArea> NearArea = new ArrayList<>();
		ArrayList<ParkingArea> arr = ParkingAreaData.getparkingLotList();
		
		for (ParkingArea i : arr) {
			double Lati = Math.abs(MyLatitude - i.getLatitude());
			double Loti = Math.abs(MyLongtide - i.getLongtide());
			if (Lati < compare && Loti < compare) {
				NearArea.add(i);
			}
		}
		NearArea.sort(new NearComparator());
		return NearArea;
	}

	//service 2: 주차장 검색
	public ArrayList<ParkingArea> getParkingArea(String ParkingAreaName) {
		
		ArrayList<ParkingArea> arr = ParkingAreaData.getparkingLotList();
		ArrayList<ParkingArea> answer = new ArrayList<>();
		
		for (ParkingArea i : arr) {
			if (Matching.match(ParkingAreaName,i.getName())>25000)
				answer.add(i);
		}
		return answer;
	}
	
	//service 3: 가격 검색
	public ArrayList<ParkingArea> getCheapArea(double MyLatitude, double MyLongtide, int price) {
		
		ArrayList<ParkingArea> CheapArea = new ArrayList<>();
		ArrayList<ParkingArea> arr = getNear(MyLatitude, MyLongtide, 0.03);
		arr.sort(new PriceComparator());

		for (ParkingArea i : arr) {
			if (i.getStandardPrice()<=price)
				CheapArea.add(i);
			else
				break;
		}
		return CheapArea;
	}
}
