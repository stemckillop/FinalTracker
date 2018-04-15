package com.drkdagron.finaltracker;

public class LifeManager {
    static LifeManager lifeManager;
    public static LifeManager getInstance() {
        if (lifeManager == null)
            lifeManager = new LifeManager();

        return lifeManager;
    }

    public class Player {
        public String Name;
        public int Life;
        public int Infect;
        public int Experience;
        public int Energy;
        public int CmdrTax;

        public Player() {
            Life = 20;
            Name = "Player";
            Infect = 0;
            Experience = 0;
            Energy = 0;
            CmdrTax = 0;
        }
    }
    public Player[] players;

    public LifeManager() {
        players = new Player[2];
        resetPlayers();
    }

    public LifeManager(int p) {
        players = new Player[p];
        resetPlayers();
    }

    /*
    /This function will reset the players lives and names (usually used if going from 3 players -> 4 players
    */
    public void resetPlayers() {
        for (int i =0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    /*
    /This function will reset the players lives but not touch any names they may have chosen (used for game resets)
    */
    public void restartPlayers() {
        for (int i =0; i < players.length; i++) {
            players[i].Life = 20;
            players[i].Infect = 0;
            players[i].Experience = 0;
            players[i].Energy = 0;
            players[i].CmdrTax = 0;
        }
    }

}
