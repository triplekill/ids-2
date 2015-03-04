package ids;

import br.com.mvalle.ids.sniffer.Sniffer;


/**
 *
 * @author mvalle
 */
public class Ids {

    /**
     * @param args the command line arguments
     */
 
      
    /** 
     * Here is the output generated by this example : 
     *  
     *  Network devices found: 
     *  #0: \Device\NPF_{BC81C4FC-242F-4F1C-9DAD-EA9523CC992D} [Intel(R) PRO/100 VE]  
     *  #1: \Device\NPF_{E048DA7F-D007-4EEF-909D-4238F6344971} [VMware Virtual Ethernet Adapter] 
     *  #2: \Device\NPF_{5B62B373-3EC1-460D-8C71-54AA0BF761C7} [VMware Virtual Ethernet Adapter] 
     *  #3: \Device\NPF_GenericDialupAdapter [Adapter for generic dialup and VPN capture] 
     *  
     *  Choosing 'Intel(R) PRO/100 VE) ' on your behalf: 
     *  Received packet at Tue Nov 03 18:52:42 EST 2009 caplen=1362 len=1362 jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=82   len=82   jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=145  len=145  jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=62   len=62   jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=164  len=164  jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=62   len=62   jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=54   len=54   jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=1073 len=1073 jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=1514 len=1514 jNetPcap rocks! 
     *  Received packet at Tue Nov 03 18:52:45 EST 2009 caplen=279  len=279  jNetPcap rocks! 
     */  
      
        /** 
         * Main startup method 
         *  
         * @param args 
         *          ignored 
         */  
        public static void main(String[] args) {  
            Sniffer sniffer = new Sniffer();
            
        }  
    }  
    
