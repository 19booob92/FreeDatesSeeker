package org.commit.luxmed.notifier.utils;

import org.junit.Assert;
import org.junit.Test;

public class ProperyLoaderTest {

	private PropertyLoader classUnderTest;
	
	@Test
	public void shouldReturnStringContainsUrl() {
		classUnderTest = PropertyLoader.instance();
		
		String urlFromProperties = classUnderTest.url();
		
		Assert.assertTrue(urlFromProperties.contains("https:"));
	}
	
}
