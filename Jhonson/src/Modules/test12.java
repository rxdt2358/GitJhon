package Modules;

import java.io.IOException;

import Common.Global;

public class test12 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Global.initializeBrowser();
		Login.login();
		projectView.project();
	}

}
