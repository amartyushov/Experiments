package io.mart;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SimpleProxyTest {
	
	@Test
	public void testName() throws Exception {
		
		// start the proxy
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);
		
		proxy.start(0);
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setAcceptUntrustedCertificates(true);
		
		myprofile.setPreference("network.proxy.type", 1);
		myprofile.setPreference("network.proxy.http", "localhost");
		myprofile.setPreference("network.proxy.http_port", proxy.getPort());
		myprofile.setPreference("network.proxy.ssl", "localhost");
		myprofile.setPreference("network.proxy.ssl_port", proxy.getPort());
		
		
		// get the Selenium proxy object
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		
		// configure it as a desired capability
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		
		// start the browser up
		WebDriver driver = new FirefoxDriver(capabilities);
		
		// enable more detailed HAR capture, if desired (see CaptureType for the complete list)
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		
		// create a new HAR with the label "yahoo.com"
		proxy.newHar("google.com");
		
		// open yahoo.com
		driver.get("http://google.com");
		
		// get the HAR data
		Har har = proxy.getHar();
		
		driver.close();
	}
}
