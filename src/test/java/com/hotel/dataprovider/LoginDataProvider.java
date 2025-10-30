package com.hotel.dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

     @DataProvider(name = "loginData")
	 public Object[][] getDataFromCSV() throws IOException {
	        String path = "src/test/resources/testdata/loginData.csv";
	        List<Object[]> records = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	            String line;
	            boolean header = true;
	            while ((line = br.readLine()) != null) {
	                if (header) { // skip header row
	                    header = false;
	                    continue;
	                }
	                String[] fields = line.split(",");
	                String userName = fields[0].trim();
	                String password = fields[1].trim();
	                records.add(new Object[]{userName, password});
	            }
	        }

	        Object[][] data = new Object[records.size()][2];
	        for (int i = 0; i < records.size(); i++) {
	            data[i] = records.get(i);
	        }
	        return data;
	    }
}
