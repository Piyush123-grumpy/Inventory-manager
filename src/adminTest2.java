import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class adminTest2 {

	@Test
	public void test() {
		admin tst = new admin();
		ArrayList<category> result= tst.categorydetail();
		assertEquals(result,result);
	}

}
