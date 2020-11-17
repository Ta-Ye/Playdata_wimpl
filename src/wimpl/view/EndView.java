package wimpl.view;

import java.util.ArrayList;
import wimpl.model.dto.ParkingArea;

public class EndView {

	// Ư�� ������ ���
	public static void parkingLotView(ParkingArea area) {
		if (area != null) {
			System.out.println(area);
		} else {
			System.out.println("�ش� �������� �������� �ʽ��ϴ�.");
		}
	}

	// ����Ʈ�� ��� ������ ���
		public static void parkingLotListView(ArrayList<ParkingArea> areaList) {
			for (ParkingArea area : areaList) {
				System.out.println(area);
			}
		}
	
	// ���ܰ� �ƴ� �ܼ� �޼��� ���
	public static void messageView(String message) {
		System.out.println(message);
	}

}
