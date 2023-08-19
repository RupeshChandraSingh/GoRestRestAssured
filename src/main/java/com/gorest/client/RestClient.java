package com.gorest.client;

import java.util.Map;
import java.util.Properties;

import com.gorest.frameworkexception.GorestException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	private Properties properties;
	private String baseUri;
	private boolean isAuthorzationAdded = false;
	private static RequestSpecBuilder speckBuilder;

	public RestClient(Properties properties, String baseUri) {
		speckBuilder = new RequestSpecBuilder();
		this.properties = properties;
		this.baseUri = baseUri;
	}

	private void addAuthorizatoinHeader() {
		if (!isAuthorzationAdded) {
			speckBuilder.addHeader("Authorization", "Bearer" + properties.getProperty("token"));
			isAuthorzationAdded = true;
		}

	}

	private void setContentType(String contentType) {
		switch (contentType.toLowerCase()) {
		case "json":
			speckBuilder.setContentType(ContentType.JSON);
			break;
		case "text":
			speckBuilder.setContentType(ContentType.TEXT);
			break;
		case "html":
			speckBuilder.setContentType(ContentType.HTML);
			break;
		case "xml":
			speckBuilder.setContentType(ContentType.XML);
			break;
		case "multipart":
			speckBuilder.setContentType(ContentType.MULTIPART);
			break;
		default:
			System.out.println("Please pass the valid contentType....");
			throw new GorestException("INVALIDCONTENTTYPE");
		}

	}

	public RequestSpecification createRequestSpec(boolean addAuth) {
		
		speckBuilder.setBaseUri(baseUri);

		if (addAuth) {
			addAuthorizatoinHeader();
		}
		return speckBuilder.build();
	}
	
	public RequestSpecification createRequestSpec(Map<String, String> authHeader, boolean addAuth) {
		speckBuilder.setBaseUri(baseUri);
		if (addAuth) {
			addAuthorizatoinHeader();
		}
		if(authHeader != null) {
			speckBuilder.addHeaders(authHeader);
		}
		return speckBuilder.build();
	}
	
	public RequestSpecification createRequestSpec(Map<String, String> authHeader, Map<String, Object> queryParam, boolean addAuth) {
		speckBuilder.setBaseUri(baseUri);
		if (addAuth) {
			addAuthorizatoinHeader();
		}
		if(authHeader != null) {
			speckBuilder.addHeaders(authHeader);
		}
		if(queryParam != null) {
			speckBuilder.addQueryParams(queryParam);
		}
		return speckBuilder.build();
	}

	
	public RequestSpecification createRequestSpec(String contentType, Object requestBody, boolean addAuth) {
		speckBuilder.setBaseUri(baseUri);
		if (addAuth) {
			addAuthorizatoinHeader();
		}
		setContentType(contentType);
		if(requestBody != null) {
			speckBuilder.setBody(requestBody);
		}
		return speckBuilder.build();
	}
	
	public RequestSpecification createRequestSpec(String contentType, Map<String, String> authHeader,
			Object requestBody, boolean addAuth) {
		speckBuilder.setBaseUri(baseUri);
		if (addAuth) {
			addAuthorizatoinHeader();
		}
		setContentType(contentType);
		if(requestBody != null) {
			speckBuilder.setBody(requestBody);
		}
		if(authHeader != null) {
			speckBuilder.addHeaders(authHeader);
		}
		return speckBuilder.build();
	}
	
	public Response get(String serviceURL, boolean addAuth, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec(addAuth)).log().all()
				.when().log().all()
					.get(serviceURL);
		}
		return RestAssured.given(createRequestSpec(addAuth))
				.when()
					.get(serviceURL);
		
	}
	
	public Response get(String serviceURL, Map<String, String> authHeader, boolean addAuth, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec(authHeader, addAuth)).log().all()
					.when().log().all()
						.get(serviceURL);
		}
		return RestAssured.given(createRequestSpec(authHeader, addAuth))
				.when()
					.get(serviceURL);
	}
	
	
	public Response get(String serviceURL, Map<String, String> authHeader, Map<String, Object> queryParam,
			boolean addAuth, boolean log) {
		
		if(log) {
			
			return RestAssured.given(createRequestSpec(authHeader, queryParam, addAuth)).log().all()
				.when().log().all()
					.get(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(authHeader, queryParam, addAuth))
				.when()
					.get(serviceURL);
	}
	
	public Response post(String serviceURL, String contentType, Object requestBody, boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.post(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth))
				.when()
					.post(serviceURL);
	}
	
	public Response post(String serviceURL, String contentType, Map<String, String> authHeader, Object requestBody,
			boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.post(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, authHeader, requestBody, addAuth))
				.when()
					.post(serviceURL);
	}
	
	
	public Response put(String serviceURL, String contentType, Object requestBody, boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.put(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth))
				.when()
					.put(serviceURL);
	}
	
	public Response put(String serviceURL, String contentType, Map<String, String> authHeader, Object requestBody,
			boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.put(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, authHeader, requestBody, addAuth))
				.when()
					.put(serviceURL);
	}
	
	
	public Response patch(String serviceURL, String contentType, Object requestBody, boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.patch(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth))
				.when()
					.patch(serviceURL);
	}
	
	public Response patch(String serviceURL, String contentType, Map<String, String> authHeader, Object requestBody,
			boolean addAuth, boolean log) {
		if(log) {
			
			return RestAssured.given(createRequestSpec(contentType, requestBody, addAuth)).log().all()
				.when().log().all()
					.patch(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec(contentType, authHeader, requestBody, addAuth))
				.when()
					.patch(serviceURL);
	}
	
	public Response delete(String serviceUrl, boolean addAuth, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec(addAuth)).log().all()
				.when().log().all()
					.delete(serviceUrl);
	}
		return RestAssured.given(createRequestSpec(addAuth))
				.when()
					.delete(serviceUrl);
	}
}
