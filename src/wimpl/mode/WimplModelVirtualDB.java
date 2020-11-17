package wimpl.mode;

import java.util.ArrayList;
import wimpl.model.dto.ParkingArea;

public class WimplModelVirtualDB {
	private static WimplModelVirtualDB instance = new WimplModelVirtualDB();
	private ArrayList<ParkingArea> parkingLotList = new ArrayList<ParkingArea>();

	private WimplModelVirtualDB() {
		parkingLotList.add(new ParkingArea("�����͹̳� ���������", 37.487816, 127.015973, "����Ư���� ���ʱ� ���ʵ� 1446-1", 46, 3000, 1000));
		parkingLotList.add(new ParkingArea("���� ����������", 37.486453, 127.014746, "����Ư���� ���ʱ� ���ʵ� 1600-2����", 35, 5000, 1500));
		parkingLotList.add(new ParkingArea("��������� ����3�����Ӵ��", 37.486632, 127.011267, "����Ư���� ���ʱ� ���ʵ� 1592-1", 51, 10000, 2000));
		parkingLotList.add(new ParkingArea("�¿�������", 37.487743, 127.029556, "����Ư���� ���ʱ� ����2��", 20, 3000, 3000));
		parkingLotList.add(new ParkingArea("���簳�߿� ������", 37.479556, 127.019185, "����Ư���� ���ʱ� ����1��", 40, 6500, 1000));
		parkingLotList.add(new ParkingArea("����������", 37.489041, 127.008638, "����Ư���� ���ʱ� ���ʵ� ������� 99", 3, 2000, 1000));
		



	}

	public static WimplModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<ParkingArea> getparkingLotList() {
		return parkingLotList;
	}
}