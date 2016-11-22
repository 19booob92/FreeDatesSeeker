package org.commit.luxmed.notifier.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class HttpEntityBuilder {

	public static HttpEntity createLoginFormEntity(String login, String pass) throws UnsupportedEncodingException {
		List<NameValuePair> loginFormEntity = new ArrayList<>();

		loginFormEntity.add(new BasicNameValuePair("Login", login));
		loginFormEntity.add(new BasicNameValuePair("Password", pass));

		return new UrlEncodedFormEntity(loginFormEntity, "UTF-8");
	}
	
}
