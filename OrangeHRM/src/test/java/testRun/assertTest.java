package testRun;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertTest {
	@Test
	public void hardAssert() {
		Assert.assertEquals(1, 2);
	}

}
