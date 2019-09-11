package io.mart;

/**
 * the interface name MUST be "model Class Name" + MBean
 */
public interface GameMBean {
	
	public void playFootball(String clubName);
	
	public String getPlayerName();
	
	public void setPLayerName(String pLayerName);
}
