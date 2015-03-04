package br.com.mvalle.ids.sniffer;

import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  

import org.jnetpcap.Pcap;  
import org.jnetpcap.PcapIf;  
import org.jnetpcap.packet.PcapPacket;  
import org.jnetpcap.packet.PcapPacketHandler; 
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
/**
 *
 * @author mvalle
 */
public class Sniffer {
    private List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with NICs  
    private StringBuilder errbuf = new StringBuilder(); // For any error msgs 
    private PcapIf selectedDevice;
    private Pcap pcap;
    private PcapPacketHandler<String> jpacketHandler;
  
    public Sniffer(){
        listDevices();
        selectedDevice = selectDevice(1);
        openDevice(selectedDevice);
        packetHandler();
        capturePackets();
    }
  
    public void listDevices(){
        int r = Pcap.findAllDevs(alldevs, errbuf);  
        if (r == Pcap.NOT_OK || alldevs.isEmpty()) {  
                System.err.printf("Can't read list of devices, error is %s", errbuf.toString());  
            return;  
        }  

        System.out.println("Network devices found:");  

        int i = 0;  
        for (PcapIf device : alldevs) {  
            String description =  
                (device.getDescription() != null) ? device.getDescription()  
                    : "No description available";  
            System.out.printf("#%d: %s [%s]\n", i++, device.getName(), description);  
        }  
    }

    
    private PcapIf selectDevice(int deviceId){
        PcapIf device = alldevs.get(1); // We know we have atleast 1 device   (parameter changed from 0 to 1)
        System.out  
            .printf("\nChoosing '%s' on your behalf:\n",  
                (device.getDescription() != null) ? device.getDescription()  
                    : device.getName());
        return device;
    }
    

    private void openDevice (PcapIf device){
        int snaplen = 64 * 1024;           // Capture all packets, no trucation  
        int flags = Pcap.MODE_PROMISCUOUS; // capture all packets  
        int timeout = 10 * 1000;           // 10 seconds in millis  
        pcap =  
            Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);  

        if (pcap == null) {  
            System.err.printf("Error while opening device for capture: "  
                + errbuf.toString());  
            return;  
        }        
    }
    
   
    private void packetHandler(){
    jpacketHandler = new PcapPacketHandler<String>() {                 
            final Tcp tcp=new Tcp();
            final Ip4 ip = new Ip4(); 

            public void nextPacket(PcapPacket packet, String user) {  
                final Tcp tcp=new Tcp();
                    if(packet.hasHeader(tcp)){
                    if(packet.hasHeader(ip)){

                    packet.getHeader(tcp);
                    System.out.printf("Received packet at %s caplen=%-4d len=%-4d %s %s\n",  
                    new Date(packet.getCaptureHeader().timestampInMillis()),   
                    packet.getCaptureHeader().caplen(),  // Length actually captured  
                    packet.getCaptureHeader().wirelen(), // Original length   
                    user,FormatUtils.ip(ip.source())                              // User supplied object  
                    );  
                    //JBuffer buffer = packet;
                    //int size=packet.size();
                    byte[] arr=packet.getByteArray(0, packet.size());
                }}}

        }; 
    }
    
    
    private void capturePackets(){
        pcap.loop(pcap.LOOP_INFINITE  , jpacketHandler, "Received Packet");  
        pcap.close();  
    }
}
