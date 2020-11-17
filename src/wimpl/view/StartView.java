package wimpl.view;

import wimpl.controller.WhereIsMyParkingLotController;
public class StartView {
	public static void main(String[] args) {
		WhereIsMyParkingLotController controller = WhereIsMyParkingLotController.getInstance();

		System.out.println("\n*** 01.  �� �ֺ� ������ �˻� ***");
		controller.getNear(37.486551, 127.020717);
		
		System.out.println("\n*** 02.  ������ �̸� �˻� ***");		
		System.out.println("\n*** 02-1.  ���� ��ġ�ϴ� ������ �̸� �˻� ***");
		System.out.println("�����͹̳� ���������");
		controller.getParkingArea("�����͹̳� ���������");

		System.out.println("\n*** 02-2.  ������ ��ġ�ϴ� ������ �̸� �˻� ***");
		System.out.println("���� ����");
		controller.getParkingArea("���� ����");
		
		System.out.println("\n*** 02-3.  ��ġ���� �ʴ� ������ �̸� �˻� ***");
		System.out.println("����������");
		controller.getParkingArea("����������");

		System.out.println("\n*** 03.   ���� �˻� ***");
		System.out.println("\n*** 03-1.  �˻� ������ ���� �������� �˻� ***");
		controller.getCheapArea(37.486551, 127.020717, 6000);
		System.out.println("\n*** 03-2.  �˻� �Ұ����� ���� �������� �˻� ***");
		controller.getCheapArea(37.486551, 127.020717, 2000);
	}
}






