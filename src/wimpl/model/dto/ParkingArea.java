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
	
	// 멤버변수 선언
	private String Name;
	private double Latitude;	// 위도
	private double Longtide;	// 경도
	private String location;
	private int CarNum;
	private int StandardPrice;
	private int PricePer;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("주자장 상호명 : ");
		builder.append(this.Name);
		builder.append(", 주차 가능한 차량 수 : ");
		builder.append(this.CarNum);
		builder.append(", 주소 : ");
		builder.append(this.location);
		builder.append(", 기본 요금 : ");
		builder.append(this.StandardPrice);
		builder.append(", 30분당 추가 요금 : ");
		builder.append(this.PricePer);
		return builder.toString();
	}
}
