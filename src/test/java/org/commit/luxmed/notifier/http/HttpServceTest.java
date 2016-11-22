package org.commit.luxmed.notifier.http;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Test;

public class HttpServceTest {

	private HttpService classUnderTest;
	
	@Test
	public void shouldReturnCookies() throws ClientProtocolException, IOException {
		classUnderTest = new HttpService();
		
		Optional<List<Cookie>> cookiesFromFirstPage = classUnderTest.getCookiesFromFirstPage();
		
		Assertions.assertThat(cookiesFromFirstPage.get()).hasSize(1);
	}
	
	@Test
	public void shouldReturnCookieWithNameASNETString() throws ClientProtocolException, IOException {
		classUnderTest = new HttpService();
		
		Optional<List<Cookie>> cookiesFromFirstPage = classUnderTest.getCookiesFromFirstPage();
		
		Assertions.assertThat(cookiesFromFirstPage.get().get(0).getName()).contains("ASP.NET");
	}
	
	@Test
	public void shouldGetAtLeast4CookiesAfterLogin() throws ClientProtocolException, IOException {
		classUnderTest = new HttpService();
		
		classUnderTest.login();
		
		List<Cookie> cookiesAfterLogin = classUnderTest.getCookies().get();
		
		Assertions.assertThat(cookiesAfterLogin).areAtLeastOne(new Condition<Cookie>() {
		
			@Override
			public boolean matches(Cookie value) {
				return value.getName().contains("LXToken");
			}
			
		});
	}
	
	@Test
	public void shouldContainsAtLeast4Cookies() throws ClientProtocolException, IOException {
		classUnderTest = new HttpService();
		
		classUnderTest.login();
		
		List<Cookie> cookiesAfterLogin = classUnderTest.getCookies().get();
		
		long cookiesAmount = cookiesAfterLogin.size();
		
		Assertions.assertThat(cookiesAmount).isGreaterThanOrEqualTo(4);
	}
	
}
