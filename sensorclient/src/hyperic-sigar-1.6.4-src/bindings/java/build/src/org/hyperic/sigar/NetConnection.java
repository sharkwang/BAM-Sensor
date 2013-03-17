/*****************************************************
 * WARNING: this file was generated by -e
 * on Thu Mar 14 00:20:16 2013.
 * Any changes made here will be LOST.
 *****************************************************/
package org.hyperic.sigar;

import java.util.HashMap;
import java.util.Map;

/**
 * NetConnection sigar class.
 */
public class NetConnection implements java.io.Serializable {

    private static final long serialVersionUID = 12776L;

    public NetConnection() { }

    public native void gather(Sigar sigar) throws SigarException;

    /**
     * This method is not intended to be called directly.
     * use Sigar.getNetConnection() instead.
     * @exception SigarException on failure.
     * @see org.hyperic.sigar.Sigar#getNetConnection
     */
    static NetConnection fetch(Sigar sigar) throws SigarException {
        NetConnection netConnection = new NetConnection();
        netConnection.gather(sigar);
        return netConnection;
    }

    long localPort = 0;

    /**
     * Get the local_port.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return local_port
     */
    public long getLocalPort() { return localPort; }
    String localAddress = null;

    /**
     * Get the local_address.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return local_address
     */
    public String getLocalAddress() { return localAddress; }
    long remotePort = 0;

    /**
     * Get the remote_port.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return remote_port
     */
    public long getRemotePort() { return remotePort; }
    String remoteAddress = null;

    /**
     * Get the remote_address.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return remote_address
     */
    public String getRemoteAddress() { return remoteAddress; }
    int type = 0;

    /**
     * Get the type.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return type
     */
    public int getType() { return type; }
    int state = 0;

    /**
     * Get the state.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris, Win32.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return state
     */
    public int getState() { return state; }
    long sendQueue = 0;

    /**
     * Get the send_queue.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return send_queue
     */
    public long getSendQueue() { return sendQueue; }
    long receiveQueue = 0;

    /**
     * Get the receive_queue.<p>
     * Supported Platforms: Linux, FreeBSD, Solaris.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code></code><br>
     * <li> Darwin: <code></code><br>
     * <li> FreeBSD: <code></code><br>
     * <li> HPUX: <code></code><br>
     * <li> Linux: <code>netstat</code><br>
     * <li> Solaris: <code></code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return receive_queue
     */
    public long getReceiveQueue() { return receiveQueue; }

    void copyTo(NetConnection copy) {
        copy.localPort = this.localPort;
        copy.localAddress = this.localAddress;
        copy.remotePort = this.remotePort;
        copy.remoteAddress = this.remoteAddress;
        copy.type = this.type;
        copy.state = this.state;
        copy.sendQueue = this.sendQueue;
        copy.receiveQueue = this.receiveQueue;
    }
    public native String getTypeString();

    public native static String getStateString(int state);

    public String getStateString() {
        return getStateString(this.state);
    }

    public Map toMap() {
        Map map = new HashMap();
        String strlocalPort = 
            String.valueOf(this.localPort);
        if (!"-1".equals(strlocalPort))
            map.put("LocalPort", strlocalPort);
        String strlocalAddress = 
            String.valueOf(this.localAddress);
        if (!"-1".equals(strlocalAddress))
            map.put("LocalAddress", strlocalAddress);
        String strremotePort = 
            String.valueOf(this.remotePort);
        if (!"-1".equals(strremotePort))
            map.put("RemotePort", strremotePort);
        String strremoteAddress = 
            String.valueOf(this.remoteAddress);
        if (!"-1".equals(strremoteAddress))
            map.put("RemoteAddress", strremoteAddress);
        String strtype = 
            String.valueOf(this.type);
        if (!"-1".equals(strtype))
            map.put("Type", strtype);
        String strstate = 
            String.valueOf(this.state);
        if (!"-1".equals(strstate))
            map.put("State", strstate);
        String strsendQueue = 
            String.valueOf(this.sendQueue);
        if (!"-1".equals(strsendQueue))
            map.put("SendQueue", strsendQueue);
        String strreceiveQueue = 
            String.valueOf(this.receiveQueue);
        if (!"-1".equals(strreceiveQueue))
            map.put("ReceiveQueue", strreceiveQueue);
        return map;
    }

    public String toString() {
        return toMap().toString();
    }

}
