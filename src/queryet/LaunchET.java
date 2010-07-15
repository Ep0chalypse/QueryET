/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package queryet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author mike
 */
public class LaunchET {

    public static void startET(String binary, String server){
        Process badIdeaProc;
        BufferedReader reader;
        String lineRead = null;
        try {
                badIdeaProc = Runtime.getRuntime().exec(binary + " +connect " + server);
                reader = new BufferedReader(new InputStreamReader(badIdeaProc.getInputStream()));
                while ((lineRead = reader.readLine()) != null) {

                }
            } catch (Exception e) {
                System.out.println(e);
            }

    }

}
