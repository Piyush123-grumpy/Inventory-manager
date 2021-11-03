
public class category {
	private int sn;
	private String category_id,category,quantity;
	category(){
		
	}
	category(int sn,String category_id,String category,String quantity){
		this.sn=sn;
		this.category_id=category_id;
		this.category=category;
		this.quantity=quantity;
		
	}
	public int getsn() {
		return sn;
	}
	public String getCategory_id() {
		return category_id;
	}
	public String getCategory() {
		return category;
	}
	public String getquantity() {
		return quantity;
	}
}
