package wimpl.view;

import java.util.ArrayList;
import wimpl.model.dto.ParkingArea;

public class EndView {

	// 특정 주차장 출력
	public static void parkingLotView(ParkingArea area) {
		if (area != null) {
			System.out.println(area);
		} else {
			System.out.println("해당 주차장은 존재하지 않습니다.");
		}
	}

	// 리스트의 모든 주차장 출력
		public static void parkingLotListView(ArrayList<ParkingArea> areaList) {
			for (ParkingArea area : areaList) {
				System.out.println(area);
			}
		}
	
	// 예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}

}
