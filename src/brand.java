
public class brand {
	private int sn;
	private String brand_id, brand_name,brand_status;
	brand(int sn,String brand_id,String brand_name, String brand_status){
		this.sn=sn;
		this.brand_id=brand_id;
		this.brand_name=brand_name;
		this.brand_status=brand_status;
	
	}
	public String getBrand_id() {
		return brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public String getBrand_status() {
		return brand_status;
	}
	public int getSn() {
		return sn;
	}

}
