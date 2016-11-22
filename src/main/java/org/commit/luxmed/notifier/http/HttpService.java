package org.commit.luxmed.notifier.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.commit.luxmed.notifier.utils.HttpEntityBuilder;
import org.commit.luxmed.notifier.utils.PropertyLoader;

public class HttpService {

	private PropertyLoader propertyLoader;
	private HttpClient httpClient;
	private CookieStore cookies;

	public HttpService() {
		cookies = new BasicCookieStore();

		propertyLoader = PropertyLoader.instance();
		httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookies).build();
	}

	public InputStream login() throws ClientProtocolException, IOException {
		HttpUriRequest httpRequest = RequestBuilder.post(propertyLoader.url())
				.addHeader(HttpHeaders.ACCEPT, "text/html").addHeader(HttpHeaders.ACCEPT, "application/xhtml+xml")
				.addHeader(HttpHeaders.ACCEPT, "application/xml")
				.addHeader(HttpHeaders.HOST, "portalpacjenta.luxmed.pl")
				.addHeader(HttpHeaders.REFERER, "https://portalpacjenta.luxmed.pl/PatientPortal/Account/LogOn")
				.addHeader(HttpHeaders.CONNECTION, "keep-alive")
				.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
				.addHeader("Upgrade-Insecure-Requests", "1")
				.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US")
				.setEntity(HttpEntityBuilder.createLoginFormEntity(propertyLoader.login(), propertyLoader.password()))
				.build();

		HttpResponse response = httpClient.execute(httpRequest);

		return response.getEntity().getContent();
	}

	public Optional<List<Cookie>> getCookiesFromFirstPage() throws ClientProtocolException, IOException {

		HttpUriRequest httpRequest = RequestBuilder.get(propertyLoader.url()).addHeader(HttpHeaders.ACCEPT, "text/html")
				.addHeader(HttpHeaders.ACCEPT, "application/xhtml+xml").addHeader(HttpHeaders.ACCEPT, "application/xml")
				.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
				.addHeader(HttpHeaders.HOST, "portalpacjenta.luxmed.pl").build();

		httpClient.execute(httpRequest);

		List<Cookie> mainPageCookies = cookies.getCookies();

		return Optional.ofNullable(mainPageCookies);
	}

	public String downloadPage() {
		return "";
	}

	public Optional<List<Cookie>> getCookies() {
		return Optional.ofNullable(cookies.getCookies());
	}

}
