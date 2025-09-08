package com.gqt.testngtestcases;

import org.testng.annotations.DataProvider;

public class ShadiRegisterDatas {

    @DataProvider(name = "RegisterData")
    public Object[][] regDataProvider() {
        return new Object[][] {
        	 {"Anushka", "Sharma", "Male", "anushka1@gmail.com", "Pass@123"},
             {"Virat", "Kohli", "Female", "virat2@gmail.com", "Pass@234"},
             {"Deepika", "Padukone", "Male", "deepika3@gmail.com", "Pass@345"},
             {"Ranveer", "Singh", "Female", "ranveer4@gmail.com", "Pass@456"},
             {"Alia", "Bhatt", "Male", "alia5@gmail.com", "Pass@567"}
        };
    } 
}
