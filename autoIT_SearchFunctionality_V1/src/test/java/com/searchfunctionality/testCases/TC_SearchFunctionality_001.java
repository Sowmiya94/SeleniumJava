package com.searchfunctionality.testCases;

import org.testng.annotations.Test;
import com.searchfunctionality.pageObjects.SearchPage;

public class TC_SearchFunctionality_001 extends BaseClass {

	@Test
	public void searchFunction() throws InterruptedException {
		
		
		SearchPage search = new SearchPage(driver);
		
		search.clickBrandDropdown();
	
		search.selectBrand();
		
		search.selectMake();
		
		search.selectKilometerRange();

		search.scrollDown();
		
		search.moveToTop();
	}
}

