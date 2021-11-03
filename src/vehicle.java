
public class vehicle {
	private int sn;
	private String vehicle_id,vehicle_name,vehicle_status,vehicle_driver;
	vehicle(int sn,String vehicle_id,String vehicle_name,String vehicle_status,String vehicle_driver){
		this.sn=sn;
		this.vehicle_id=vehicle_id;
		this.vehicle_name=vehicle_name;
		this.vehicle_status=vehicle_status;
		this.vehicle_driver=vehicle_driver;
	}
	public int getsn() {
		return sn;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public String getVehicle_status() {
		return vehicle_status;
	}
	public String getVehicle_driver() {
		return vehicle_driver;
	}
}
