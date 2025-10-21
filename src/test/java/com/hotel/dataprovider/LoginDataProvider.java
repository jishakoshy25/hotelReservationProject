package com.hotel.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	 @DataProvider(name = "loginData")
     public Object[][] getLoginData() {
         return new Object[][]{
             {"diana@example.com", "pass1234"},
             {"clark@example.com", "password"},
             {"ororo@example.com", "pa55w0rd!"},
             {"miles@example.com", "pass-pass"}
         };
     }
}
