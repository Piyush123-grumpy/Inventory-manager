import static org.junit.Assert.*;
import javax.swing.JPanel;

import org.junit.Test;

public class adminTest3 {

	@Test
	public void test() {
	product pr=new product(1,"1","Tesla","999");
	pr.getsn();
	assertEquals(1,pr.getsn());
	
	}
	public void test2() {
		product pr=new product(1,"1","Tesla","999");
		pr.getProduct_id();
		assertEquals("1",pr.getsn());
	}
	public void test3() {
		product pr=new product(1,"1","Tesla","999");
		pr.getProduct_name();
		assertEquals("Tesla",pr.getProduct_name());
	}
	public void test4() {
		product pr=new product(1,"1","Tesla","999");
		pr.getProduct_price();
		assertEquals("999",pr.getProduct_price());
	}

}
