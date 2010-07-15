/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package queryet;

/**
 *
 * @author mike
 */
public class ServerObjects {

    public static class MasterServerList {

        private String address;
        private int port;

        public MasterServerList(String address, int port) {
            this.address = address;
            this.port = port;
        }

        public String getAddress() {
            return address;
        }

        public int getPort() {
            return port;
        }
    }


    public static class ServerInfo {

        private String address;
        private int port;
        private String name;
        private long ping;
        private boolean privateServer;
        private int maxPlayers;
        private int currentPlayers;
        private String map;
        private String gameName;
        private int gameType;

        public ServerInfo() {
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String addr) {
            address = addr;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port2) {
            port = port2;
        }

        public String getName(){
            return name;
        }

        public void setName(String name2){
            name = name2;
        }

        public long getPing() {
            return ping;
        }

        public void setPing(long ping2) {
            ping = ping2;
        }

        public boolean getPrivateServer() {
            return privateServer;
        }

        public void setPrivateServer(boolean status) {
            privateServer= status;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }

        public void setMaxPlayers(int max) {
            maxPlayers = max;
        }

        public int getCurrentPlayers() {
            return currentPlayers;
        }

        public void setCurrentPlayers(int players) {
            currentPlayers = players;
        }

        public String getMap() {
            return map;
        }

        public void setMap(String map2) {
            map = map2;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String game) {
            gameName = game;
        }

        public int getGameType() {
            return gameType;
        }

        public void setGameType(int type) {
            gameType = type;
        }

    }

}
