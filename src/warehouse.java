
public class warehouse {
	private int sn;
	private String ware_id,total_products,ware_name,location,contact,incharge;
	warehouse(int sn, String ware_id,String ware_name,String location,String contact, String incharge,String total_products){
		this.sn=sn;
		this.ware_id=ware_id;
		this.ware_name=ware_name;
		this.location=location;
		this.contact=contact;
		this.incharge=incharge;
		this.total_products=total_products;
	}
	public String getWare_id() {
		return ware_id;
	}
	public String getWare_name() {
		return ware_name;
	}
	public String getLocation() {
		return location;
	}
	public String getContact() {
		return contact;
	}
	public String getIncharge() {
		return incharge;
	}
	public String getTotal_products() {
		return total_products;
	}
	public int getSn() {
		return sn;
	}
}
