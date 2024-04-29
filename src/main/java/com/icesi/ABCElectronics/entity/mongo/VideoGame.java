package com.icesi.ABCElectronics.entity.mongo;

public class VideoGame {
    private Boolean isPlayer;
    private String [] platforms;

    public VideoGame(Boolean isPlayer, String[] platforms) {
        this.isPlayer = isPlayer;
        this.platforms = platforms;
    }

    public Boolean getPlayer() {
        return isPlayer;
    }

    public void setPlayer(Boolean player) {
        isPlayer = player;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }
}
