import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class adminTest {

	@Test
	public void test() {
		admin tst = new admin();
		ArrayList<brand> result= tst.branddetail();
		assertEquals(result,result);
	}

}
