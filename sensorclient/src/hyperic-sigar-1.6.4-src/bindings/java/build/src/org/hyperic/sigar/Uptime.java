/*****************************************************
 * WARNING: this file was generated by -e
 * on Thu Mar 14 00:20:16 2013.
 * Any changes made here will be LOST.
 *****************************************************/
package org.hyperic.sigar;

import java.util.HashMap;
import java.util.Map;

/**
 * Uptime sigar class.
 */
public class Uptime implements java.io.Serializable {

    private static final long serialVersionUID = 1263L;

    public Uptime() { }

    public native void gather(Sigar sigar) throws SigarException;

    /**
     * This method is not intended to be called directly.
     * use Sigar.getUptime() instead.
     * @exception SigarException on failure.
     * @see org.hyperic.sigar.Sigar#getUptime
     */
    static Uptime fetch(Sigar sigar) throws SigarException {
        Uptime uptime = new Uptime();
        uptime.gather(sigar);
        return uptime;
    }

    double uptime = 0;

    /**
     * Get the Time since machine started in seconds.<p>
     * Supported Platforms: All.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code>uptime</code><br>
     * <li> Darwin: <code>uptime</code><br>
     * <li> FreeBSD: <code>uptime</code><br>
     * <li> HPUX: <code>uptime</code><br>
     * <li> Linux: <code>uptime</code><br>
     * <li> Solaris: <code>uptime</code><br>
     * <li> Win32: <code></code><br>
     * </ul>
     * @return Time since machine started in seconds
     */
    public double getUptime() { return uptime; }

    void copyTo(Uptime copy) {
        copy.uptime = this.uptime;
    }

    public Map toMap() {
        Map map = new HashMap();
        String struptime = 
            String.valueOf(this.uptime);
        if (!"-1".equals(struptime))
            map.put("Uptime", struptime);
        return map;
    }

    public String toString() {
        return toMap().toString();
    }

}
