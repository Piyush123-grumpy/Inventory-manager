
public class product {
	private int sn;
	private String product_id,product_name,product_price;
	product(int sn,String product_id,String product_name,String product_price){
		this.sn=sn;
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_price=product_price;
	}
	public int getsn() {
		return sn;
	}
	public String getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
}
