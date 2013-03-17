/*****************************************************
 * WARNING: this file was generated by -e
 * on Thu Mar 14 00:20:16 2013.
 * Any changes made here will be LOST.
 *****************************************************/
package org.hyperic.sigar;

import java.util.HashMap;
import java.util.Map;

/**
 * ProcTime sigar class.
 */
public class ProcTime implements java.io.Serializable {

    private static final long serialVersionUID = 4030L;

    public ProcTime() { }

    public native void gather(Sigar sigar, long pid) throws SigarException;

    /**
     * This method is not intended to be called directly.
     * use Sigar.getProcTime() instead.
     * @exception SigarException on failure.
     * @see org.hyperic.sigar.Sigar#getProcTime
     */
    static ProcTime fetch(Sigar sigar, long pid) throws SigarException {
        ProcTime procTime = new ProcTime();
        procTime.gather(sigar, pid);
        return procTime;
    }

    long startTime = 0;

    /**
     * Get the Time process was started in seconds.<p>
     * Supported Platforms: All.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code>top, ps</code><br>
     * <li> Darwin: <code>top, ps</code><br>
     * <li> FreeBSD: <code>top, ps</code><br>
     * <li> HPUX: <code>top, ps</code><br>
     * <li> Linux: <code>top, ps</code><br>
     * <li> Solaris: <code>top, ps</code><br>
     * <li> Win32: <code>taskman</code><br>
     * </ul>
     * @return Time process was started in seconds
     */
    public long getStartTime() { return startTime; }
    long user = 0;

    /**
     * Get the Process cpu user time.<p>
     * Supported Platforms: All.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code>top, ps</code><br>
     * <li> Darwin: <code>top, ps</code><br>
     * <li> FreeBSD: <code>top, ps</code><br>
     * <li> HPUX: <code>top, ps</code><br>
     * <li> Linux: <code>top, ps</code><br>
     * <li> Solaris: <code>top, ps</code><br>
     * <li> Win32: <code>taskman</code><br>
     * </ul>
     * @return Process cpu user time
     */
    public long getUser() { return user; }
    long sys = 0;

    /**
     * Get the Process cpu kernel time.<p>
     * Supported Platforms: All.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code>top, ps</code><br>
     * <li> Darwin: <code>top, ps</code><br>
     * <li> FreeBSD: <code>top, ps</code><br>
     * <li> HPUX: <code>top, ps</code><br>
     * <li> Linux: <code>top, ps</code><br>
     * <li> Solaris: <code>top, ps</code><br>
     * <li> Win32: <code>taskman</code><br>
     * </ul>
     * @return Process cpu kernel time
     */
    public long getSys() { return sys; }
    long total = 0;

    /**
     * Get the Process cpu time (sum of User and Sys).<p>
     * Supported Platforms: All.
     * <p>
     * System equivalent commands:<ul>
     * <li> AIX: <code>top, ps</code><br>
     * <li> Darwin: <code>top, ps</code><br>
     * <li> FreeBSD: <code>top, ps</code><br>
     * <li> HPUX: <code>top, ps</code><br>
     * <li> Linux: <code>top, ps</code><br>
     * <li> Solaris: <code>top, ps</code><br>
     * <li> Win32: <code>taskman</code><br>
     * </ul>
     * @return Process cpu time (sum of User and Sys)
     */
    public long getTotal() { return total; }

    void copyTo(ProcTime copy) {
        copy.startTime = this.startTime;
        copy.user = this.user;
        copy.sys = this.sys;
        copy.total = this.total;
    }

    public Map toMap() {
        Map map = new HashMap();
        String strstartTime = 
            String.valueOf(this.startTime);
        if (!"-1".equals(strstartTime))
            map.put("StartTime", strstartTime);
        String struser = 
            String.valueOf(this.user);
        if (!"-1".equals(struser))
            map.put("User", struser);
        String strsys = 
            String.valueOf(this.sys);
        if (!"-1".equals(strsys))
            map.put("Sys", strsys);
        String strtotal = 
            String.valueOf(this.total);
        if (!"-1".equals(strtotal))
            map.put("Total", strtotal);
        return map;
    }

    public String toString() {
        return toMap().toString();
    }

}
