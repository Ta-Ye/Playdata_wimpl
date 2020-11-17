package wimpl.controller;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import wimpl.model.dto.ParkingArea;
import wimpl.service.WhereIsMyParkingLotService;
import wimpl.view.EndView;

@NoArgsConstructor
@Slf4j
public class WhereIsMyParkingLotController {

	private static WhereIsMyParkingLotController instance = new WhereIsMyParkingLotController();
	private WhereIsMyParkingLotService service = WhereIsMyParkingLotService.getInstance();

	public static WhereIsMyParkingLotController getInstance() {
		return instance;
	}
	
	//service 1 : 내 주변 주차장
		public void getNear(double MyLatitude, double MyLongtide) {
			log.info("위치 검색시도 : " + MyLatitude + " " + MyLongtide);
			
			for (double compare= 0.01; compare<0.04; compare+=0.01) {
				ArrayList<ParkingArea> ParkingLotList = service.getNear(MyLatitude, MyLongtide, compare);
				if (ParkingLotList!=null) {
					EndView.parkingLotListView(ParkingLotList);
					return;
				} else {
					EndView.messageView("범위내에 주차장이 없습니다.");
					EndView.messageView("범위를 늘립니다.");
				}
			}
			EndView.messageView("주변에 주차장이 없습니다.");
		}

		//service 2: 주차장 검색
		public void getParkingArea(String ParkingAreaName) {
			log.info("이름 검색시도 : " + ParkingAreaName);
			
			ArrayList<ParkingArea> ParkingLotList = service.getParkingArea(ParkingAreaName);
			if (ParkingLotList.size()!=0) {
				EndView.parkingLotListView(ParkingLotList);
			} else {
				EndView.messageView("해당 이름의 주차장이 없습니다.");
			}
		}
		
		//service 3: 가격 검색
		public void getCheapArea(double MyLatitude, double MyLongtide, int price) {
			log.info("가격 검색시도 : " + price);
			
			ArrayList<ParkingArea> ParkingLotList = service.getCheapArea(MyLatitude, MyLongtide, price);
			if (ParkingLotList.size()!=0) {
				EndView.parkingLotListView(ParkingLotList);
			} else {
				EndView.messageView("조건을 만족하는 주차장이 없습니다.");
			}
		}
	
}
