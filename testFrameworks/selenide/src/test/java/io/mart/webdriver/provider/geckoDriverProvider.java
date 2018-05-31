package io.mart.webdriver.provider;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class geckoDriverProvider implements WebDriverProvider {

	@Override
	public WebDriver createDriver(DesiredCapabilities capabilities) {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		ProfilesIni firefoxProfile = new ProfilesIni();
		FirefoxProfile profile = firefoxProfile.getProfile("certificateIssue");
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		return new FirefoxDriver(capabilities);
	}
}