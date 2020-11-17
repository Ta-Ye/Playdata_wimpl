package wimpl.controller;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import wimpl.model.dto.ParkingArea;
import wimpl.service.WhereIsMyParkingLotService;
import wimpl.view.EndView;

@NoArgsConstructor
public class WhereIsMyParkingLotController {

	private static WhereIsMyParkingLotController instance = new WhereIsMyParkingLotController();
	private WhereIsMyParkingLotService service = WhereIsMyParkingLotService.getInstance();

	public static WhereIsMyParkingLotController getInstance() {
		return instance;
	}
	
	//service 1 : �� �ֺ� ������
		public void getNear(double MyLatitude, double MyLongtide) {
			for (double compare= 0.01; compare<0.04; compare+=0.01) {
				ArrayList<ParkingArea> ParkingLotList = service.getNear(MyLatitude, MyLongtide, compare);
				if (ParkingLotList!=null) {
					EndView.parkingLotListView(ParkingLotList);
					return;
				} else {
					EndView.messageView("�������� �������� �����ϴ�.");
					EndView.messageView("������ �ø��ϴ�.");
				}
			}
			EndView.messageView("�ֺ��� �������� �����ϴ�.");
		}

		//service 2: ������ �˻�
		public void getParkingArea(String ParkingAreaName) {
			ArrayList<ParkingArea> ParkingLotList = service.getParkingArea(ParkingAreaName);
			if (ParkingLotList.size()!=0) {
				EndView.parkingLotListView(ParkingLotList);
			} else {
				EndView.messageView("�ش� �̸��� �������� �����ϴ�.");
			}
		}
		
		//service 3: ���� �˻�
		public void getCheapArea(double MyLatitude, double MyLongtide, int price) {
			ArrayList<ParkingArea> ParkingLotList = service.getCheapArea(MyLatitude, MyLongtide, price);
			if (ParkingLotList.size()!=0) {
				EndView.parkingLotListView(ParkingLotList);
			} else {
				EndView.messageView("������ �����ϴ� �������� �����ϴ�.");
			}
		}
	
}
