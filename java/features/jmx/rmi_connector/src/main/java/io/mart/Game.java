package io.mart;

public class Game implements GameMBean {
	
	private String pLayerName;
	
	
	@Override
	public void playFootball(String clubName) {
		System.out.println(pLayerName + " playing football for " + clubName);
	}
	
	
	@Override
	public String getPlayerName() {
		System.out.println("Return player name " + pLayerName);
		return pLayerName;
	}
	
	
	@Override
	public void setPLayerName(String playerName) {
		System.out.println("Set player name to " + playerName);
		this.pLayerName = playerName;
	}
}
