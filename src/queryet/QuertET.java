/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queryet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import queryet.MasterServerObject.MasterServerList;

/**
 *
 * @author mike
 */
public class QuertET {

    /**
     * @param args the command line arguments
     */

//    public static void main(String[] args) {
//        ArrayList<MasterServerList> masters = getListFromMaster();
//        for (MasterServerList m : masters) {
//            System.out.println(m.getAddress() + ":" + m.getPort());
//        }
//        System.out.println("Servers: " + masters.size());
//    }

    public static ArrayList<MasterServerList> getListFromMaster() {
        ArrayList<MasterServerList> finalList = new ArrayList<MasterServerList>();
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(2000);
            InetAddress IPAddress = InetAddress.getByName("192.246.40.60");
            byte[] receiveData = new byte[1024];
            byte[] message = "XXXXgetservers 84 full empty".getBytes();

            for (byte index = 0; index < 4; index++) {
                message[index] = (byte) 0xFF;
            }

            //creates packet to send
            DatagramPacket sendPacket = new DatagramPacket(message, message.length, IPAddress, 27950);
            //sends packet
            clientSocket.send(sendPacket);


            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

//            while(clientSocket.receive(sendPacket))

            for (int j = 0; j < 20; j++) {
                clientSocket.receive(receivePacket);
                String[] split = new String(receivePacket.getData(), "ISO-8859-1").split("\\\\");
                for (int i = 1; i < split.length; i++) {
                    if (split[i].length() != 6) {
                        continue;
                    }
                    String server = (int) split[i].charAt(0) + "." + (int) split[i].charAt(1) + "." + (int) split[i].charAt(2) + "." + (int) split[i].charAt(3);
                    int port = ((int) split[i].charAt(4) * 256 + (int) split[i].charAt(5));
                    finalList.add(new MasterServerList(server, port));
//                System.out.println((int) split[i].charAt(0) + "." + (int) split[i].charAt(1) + "." + (int) split[i].charAt(2) + "." + (int) split[i].charAt(3) + ":" + ((int) split[i].charAt(4) * 256 + (int) split[i].charAt(5)));
                }

            }

            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return finalList;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////
/*public static byte[] getListFromMaster() throws SocketException, UnknownHostException, IOException {
DatagramSocket clientSocket = new DatagramSocket();
clientSocket.setSoTimeout(2000);
InetAddress IPAddress = InetAddress.getByName("192.246.40.60");
byte[] receiveData = new byte[1024];

byte[] message = "XXXXgetservers 84 full empty".getBytes();
for (byte index = 0; index < 4; index++) {
message[index] = (byte) 0xFF;
}

//        sendData = sentence.getBytes();
DatagramPacket sendPacket = new DatagramPacket(message, message.length, IPAddress, 27950);
clientSocket.send(sendPacket);

System.out.println("client socket: " + clientSocket.isConnected());

DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
clientSocket.receive(receivePacket);
String modifiedSentence = new String(receivePacket.getData());
System.out.println("FROM SERVER:" + modifiedSentence);
clientSocket.close();

return receivePacket.getData();
//        return modifiedSentence;

}

public static String getHexString(byte[] b) throws Exception {
String result = "";
for (int i = 0; i < b.length; i++) {
result +=
Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
}
return result;
}

public static String getListFromMasterFuck() {
String finalString = "";
try {
DatagramSocket serverSocket = new DatagramSocket(9876);
byte[] recieveData = new byte[1024];
byte[] sendData = new byte[1024];

while (true) {
DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);
serverSocket.receive(recievePacket);
String sentance = new String(recievePacket.getData());
InetAddress IPAddr = recievePacket.getAddress();
int port = recievePacket.getPort();
String capitalSentance = sentance.toUpperCase();
sendData = capitalSentance.getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddr, port);
serverSocket.send(sendPacket);
}

} catch (Exception ex) {
Logger.getLogger(QuertET.class.getName()).log(Level.SEVERE, null, ex);
}
return finalString;
}

public static String getMasterList(int localPort, String ipStr, int port, String request) {

StringBuffer recStr = new StringBuffer();
DatagramSocket socket = null;
try {
if (localPort == 0) {
socket = new DatagramSocket();
} else {
socket = new DatagramSocket(localPort);
}
// default packet size
int packetSize = 12288;

InetAddress address = InetAddress.getByName(ipStr);
InetAddress inet = InetAddress.getByName(ipStr);

socket.connect(address, port);
System.out.println("socket.isConnected(): " + socket.isConnected());


DatagramPacket out = getDatagramPacket(request, inet, port);
socket.send(out);

byte[] data = new byte[packetSize];
DatagramPacket inPacket = new DatagramPacket(data, packetSize);
socket.setSoTimeout(2000);


// get the response
socket.receive(inPacket);

recStr = new StringBuffer(new String(inPacket.getData(), 0, inPacket.getLength(), "ISO-8859-1"));
System.out.println("Raw Packet: " + inPacket.getData());
System.out.println("Fuck:" + new String(inPacket.getData(), 0, inPacket.getLength(), "UTF8"));
//            recStr = new StringBuffer(new String(inPacket.getData(), 0, inPacket.getLength()));//, "ISO-8859-1"));

//            int qtimeout = 0;
// going to be more packets with the rest of the data in

} catch (Exception ex) {
recStr = new StringBuffer("");
} finally {
if (socket != null) {
socket.close();
}
}

return recStr.toString();
}

public static DatagramPacket getDatagramPacket(String request, InetAddress inet, int port) {
byte first = -1;
byte[] buffer = new byte[1400];
buffer[0] = first;
buffer[1] = first;
buffer[2] = first;
buffer[3] = first;
byte[] requestBytes;
try {
requestBytes = request.getBytes("ISO-8859-1");
//            requestBytes = request.getBytes();//.getBytes("ISO-8859-1");
} catch (Exception e) {
System.out.println("exception happened");
requestBytes = request.getBytes();
}
System.arraycopy(requestBytes, 0, buffer, 4, request.length());

return new DatagramPacket(buffer, request.length() + 4, inet, port);
}*/
