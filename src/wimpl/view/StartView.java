package wimpl.view;

import wimpl.controller.WhereIsMyParkingLotController;
public class StartView {
	public static void main(String[] args) {
		WhereIsMyParkingLotController controller = WhereIsMyParkingLotController.getInstance();

		System.out.println("\n*** 01.  내 주변 주차장 검색 ***");
		controller.getNear(37.486551, 127.020717);
		
		System.out.println("\n*** 02.  주차장 이름 검색 ***");		
		System.out.println("\n*** 02-1.  완전 일치하는 주차장 이름 검색 ***");
		System.out.println("남부터미널 노상주차장");
		controller.getParkingArea("남부터미널 노상주차장");

		System.out.println("\n*** 02-2.  적당히 일치하는 주차장 이름 검색 ***");
		System.out.println("담이 유료");
		controller.getParkingArea("담이 유료");
		
		System.out.println("\n*** 02-3.  일치하지 않는 주차장 이름 검색 ***");
		System.out.println("서울주차장");
		controller.getParkingArea("서울주차장");

		System.out.println("\n*** 03.   가격 검색 ***");
		System.out.println("\n*** 03-1.  검색 가능한 가격 범위에서 검색 ***");
		controller.getCheapArea(37.486551, 127.020717, 6000);
		System.out.println("\n*** 03-2.  검색 불가능한 가격 범위에서 검색 ***");
		controller.getCheapArea(37.486551, 127.020717, 2000);
	}
}






