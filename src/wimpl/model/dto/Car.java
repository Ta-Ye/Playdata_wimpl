package wimpl.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Car {
	// 멤버변수 선언
	private double Latitude;	// 위도
	private double Longtide;	// 경도
	private ParkingArea parklot;
	private boolean Parkingstatus = false;
	
	public Car (double Latitude, double Longtide){
		this.Latitude=Latitude;
		this.Longtide=Longtide;
	}
	
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	
	public void setLongtide(double longtide) {
		Longtide = longtide;
	}

	public void setParklot(ParkingArea parklot) {
		this.parklot = parklot;
		this.Parkingstatus= true;
	}

	public void returnParklot() {
		this.parklot = null;
		this.Parkingstatus= false;
	}

}
