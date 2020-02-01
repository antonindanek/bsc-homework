package homework.loading;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import homework.data.MemoryStorage;

public class InputFileReaderTest {
	
	@Before
	public void setup() {
		MemoryStorage.getInstance().removeAll();
	}
	
	@Test
	public void testInputFileReader() throws InterruptedException {
		// MemoryStorage could be also mocked using Mockito but since it's quite simple, why not use the real implementation
		new InputFileReader(MemoryStorage.getInstance(), new String [] {"src/test/resources/test.input"}).start();
		
		// there is some space for improvement here so we don't have to wait and hope it will be finished
		Thread.sleep(1000);
		
		Assert.assertEquals(3, MemoryStorage.getInstance().readAll().size());
	}

}
