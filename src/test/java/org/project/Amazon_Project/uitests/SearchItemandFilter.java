package org.project.Amazon_Project.uitests;

import java.io.IOException;

import org.project.Amazon_Project.pageobjects.ActionClass;
import org.project.Amazon_Project.pageobjects.ReadData;
import org.project.Amazon_Project.pageutils.CategoryPage;
import org.project.Amazon_Project.pageutils.HomePage;
import org.project.Amazon_Project.base.BaseClass;
import org.testng.annotations.Test;

public class SearchItemandFilter extends BaseClass {

	@Test
	public void SearchItemandApplyFilter() throws IOException, InterruptedException {
		HomePage home = new HomePage(driver);
		CategoryPage item = new CategoryPage(driver);
		ReadData data = new ReadData();
		ActionClass action = new ActionClass(driver);
		home.OpenHomePage();
		// Applying wait to manually enter captcha value
		action.ImplicitWait(10);
		home.ClickOnSearch();
		home.SearchFor(data.GetItemName2());
		item.ClickOnPriceFilter();
		item.ValidatePriceOfAllItem();

	}

}
