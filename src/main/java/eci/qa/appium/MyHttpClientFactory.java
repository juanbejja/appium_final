package eci.qa.appium;

import java.net.URL;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpClient.Builder;
import org.openqa.selenium.remote.internal.OkHttpClient;

public class MyHttpClientFactory implements org.openqa.selenium.remote.http.HttpClient.Factory{
	 
final OkHttpClient okHttpClient;
 
public MyHttpClientFactory(OkHttpClient okHttpClient) {
this.okHttpClient = okHttpClient;
}
 
@Override
public org.openqa.selenium.remote.http.HttpClient createClient(URL url) {
// TODO Auto-generated method stub
return (HttpClient) okHttpClient;
}
@Override
public void cleanupIdleClients() {
// TODO Auto-generated method stub
 
}
 
@Override
public Builder builder() {
return null;
}
}
