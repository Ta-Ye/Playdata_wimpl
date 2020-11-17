package wimpl.mode;

import java.util.ArrayList;
import wimpl.model.dto.ParkingArea;

public class WimplModelVirtualDB {
	private static WimplModelVirtualDB instance = new WimplModelVirtualDB();
	private ArrayList<ParkingArea> parkingLotList = new ArrayList<ParkingArea>();

	private WimplModelVirtualDB() {
		parkingLotList.add(new ParkingArea("남부터미널 노상주차장", 37.487816, 127.015973, "서울특별시 서초구 서초동 1446-1", 46, 3000, 1000));
		parkingLotList.add(new ParkingArea("담이 유료주차장", 37.486453, 127.014746, "서울특별시 서초구 서초동 1600-2번지", 35, 5000, 1500));
		parkingLotList.add(new ParkingArea("노외주차장 서초3동사임당길", 37.486632, 127.011267, "서울특별시 서초구 서초동 1592-1", 51, 10000, 2000));
		parkingLotList.add(new ParkingArea("태열주차장", 37.487743, 127.029556, "서울특별시 서초구 서초2동", 20, 3000, 3000));
		parkingLotList.add(new ParkingArea("인재개발원 주차장", 37.479556, 127.019185, "서울특별시 서초구 서초1동", 40, 6500, 1000));
		parkingLotList.add(new ParkingArea("수원주차장", 37.489041, 127.008638, "서울특별시 서초구 서초동 반포대로 99", 3, 2000, 1000));
		



	}

	public static WimplModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<ParkingArea> getparkingLotList() {
		return parkingLotList;
	}
}