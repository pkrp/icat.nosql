/*
 * Main.java
 *
 * Created on 15-Aug-2007, 12:49:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package icat3wstestother;

import clientadmin.*;
import icat3wstest.*;
import javax.xml.ws.BindingProvider;
import static icat3wstest.Constants.*;
/**
 *
 * @author gjd37
 */
public class SessionAdminUtil {
    
    /** Creates a new instance of Main */
    public static String login(String username) throws Exception{
        
        try {
                        
            long time = System.currentTimeMillis();
            
            // TODO process result here
            java.lang.String result = ICATAdminSingleton.getInstance().loginAdmin(username);
            SID = result;
            System.out.println(" Logged in successfully with SID = "+result+" as user "+username);
            
            System.out.println("\nTime taken: "+(System.currentTimeMillis() - time)/1000f+" seconds");
            System.out.println("------------------------------------------------------------------\n");
            assert true;
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
            assert false;
            
          //  throw ex;
            return null;
            // TODO handle custom exceptions here
        }
    }
    
    public static void logout(String sid) throws Exception{
        
        try {
            
            long time = System.currentTimeMillis();
            
            // TODO process result here
            ICATSingleton.getInstance().logout(sid);
            
            System.out.println(" Logged out successfully with SID = "+sid);
            
            System.out.println("\nTime taken: "+(System.currentTimeMillis() - time)/1000f+" seconds");
            System.out.println("------------------------------------------------------------------\n");
            assert true;
            
        } catch (Exception ex) {
            System.out.println("Exception logging out\n"+ex);
            assert false;
            throw ex;
            // TODO handle custom exceptions here
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String sid = login("bob");
        //String sid = loginLifetime(System.getProperty("user.name"), System.getProperty("usersso.password"), 2);
         if(sid != null) logout(sid);
    }
    
}
