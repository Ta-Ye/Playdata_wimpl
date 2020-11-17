package wimpl.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingArea {
	
	// ������� ����
	private String Name;
	private double Latitude;	// ����
	private double Longtide;	// �浵
	private String location;
	private int CarNum;
	private int StandardPrice;
	private int PricePer;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("������ ��ȣ�� : ");
		builder.append(this.Name);
		builder.append(", ���� ������ ���� �� : ");
		builder.append(this.CarNum);
		builder.append(", �ּ� : ");
		builder.append(this.location);
		builder.append(", �⺻ ��� : ");
		builder.append(this.StandardPrice);
		builder.append(", 30�д� �߰� ��� : ");
		builder.append(this.PricePer);
		return builder.toString();
	}
}
