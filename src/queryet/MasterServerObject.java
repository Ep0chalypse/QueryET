/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package queryet;

/**
 *
 * @author mike
 */
public class MasterServerObject {

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
}
