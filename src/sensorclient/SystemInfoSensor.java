//package com.orient.sensor.system;

import MachineConfig;
import java.net.*;

import java.io.BufferedReader;   
import java.io.File;   
import java.io.FileReader;  

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.hyperic.sigar.SysInfo;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.thoughtworks.xstream.XStream;

/**
 * SystemInfoSensor
 * 
 * 系统信息探针
 * 
 */



public class SystemInfoSensor{

	private String data; 	//采集日期
	private String time; 	//采集时间
    
	/*
     *  	以下信息从配置文件中读取
     */
	//本机运行应用系统
	private String App; 	
	//多个应用系统名称，以|隔离
	private String MultiApp; 
	//本机系统类型：AS-J2EE服务器 DB-数据库服务器	Tux-Tuxedo Any-其他类型
	private String Type; 	
	 
				
    /*
     * SysInfoData
     */
	private String hostname; 	//主机名称
	private String OSname; 		//操作系统及版本
	
	private String CpuType; //CPU 类型
	private String CpuMhz; 	//CPU 主频速度
	private String CpuTotalCores; 		//CPU 核心数
	private String CpuTotalIdlePercent; //CPU 空闲率
	
	private String usedMem; 	// 已使用内存总量
	private String MemPercent; 	//内存空闲率
	
	private String ActiveDiskUsage; //监控磁盘使用率
	private String ActiveDiskFree;  //监控磁盘空闲空间
	private String ActiveDiskRead;  //监控磁盘读
	private String ActiveDiskWrite; //监控磁盘写
	
	private String IPaddress; 	// eth0 IP地址
	private String MacAddress; 	// 第一张网卡物理地址
	private long NetRxBytes; 	//接收总字节数
	private long NetTxBytes; 	//发送总字节数
	private long NetRxErrors; //接收错误包数
	private long NetTxErrors; 	//发送错误包数
	
	private String MultiIPaddress; 	// eth1 第二张IP地址 
	private String MultiMacAddress; //第二张网卡物理地址
	private long NetRxBytes_2; 	//接收总字节数
	private long NetTxBytes_2; 	//发送总字节数
	private long NetRxErrors_2; 	//接收错误包数
	private long NetTxErrors_2; 	//发送错误包数
	
	public SystemInfoSensor() {
	}

	public void populate(Sigar sigar, String cfgFile) throws SigarException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//设置日期格式
		date = df.format(new Date());

		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");		//设置时间格式
		time = df.format(new Date());

		// 从控制文件中读取配置
		MachineConfig cfg = readConfigfile(cfgFile);
		
		App = cfg.getApp();
		MultiApp = cfg.getMultiApp();
		Type = cfg.getType();
		ActiveDisk = cfg.getActiveDisk();
		
        hostname = getPlatformName();//获取计算机主机名  
		
		OSname = GetOSInfo(); //获取操作系统类型

        /*
         * 获取CPU的相关信息
         */
		getCpuTotal();

		/*
		 * 获取内存信息
		 */
		getPhysicalMemory();
		
		/*
		 * 获取监控文件系统信息
		 */
		getFileSystemInfo(ActiveDisk);
		
		
	}
    
	/*
	 *  取得网络信息
	 */
	public void getNetIfList() throws Exception {
		
		Sigar sigar = new Sigar();
		String ifNames[] = sigar.getNetInterfaceList();
		
		for (int i = 0; i < ifNames.length || i < 2; i++) {
			String name = ifNames[i];
			NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
			print("\nname = " + name);// 网络设备名

			if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress())
					|| (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
					|| NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
				continue;
			}

			
			if ((ifconfig.getFlags() & 1L) <= 0L) {
				//ethx not IFUP
				
				continue;
			}

			if (i = 0 ){
					
				IPaddress = ifconfig.getAddress();		// IP地址
				MacAddress = ifconfig.getHwaddr(); 		// MAC地址 

				try {
					NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
					NetRxBytes = ifstat.getRxBytes();		// 接收到的总字节数
					NetTxBytes = ifstat.getTxBytes();		// 发送的总字节数
					NetRxErrors = ifstat.getRxErrors();		// 接收到的错误包数
					NetTxErrors = ifstat.getTxErrors();		// 发送数据包时的错误数
				} catch (SigarNotImplementedException e) {
				} catch (SigarException e) {
					print(e.getMessage());
				}

			}
			
			if (i = 1){
				MultiIPaddress = ifconfig.getAddress();		// IP地址 - eth1
				MultiMacAddress = ifconfig.getHwaddr(); 	// MAC地址 - eth1

				try {
					NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
					NetRxBytes_2 = ifstat.getRxBytes();		// 接收到的总字节数
					NetTxBytes_2 = ifstat.getTxBytes();		// 发送的总字节数
					NetRxErrors_2 = ifstat.getRxErrors();	// 接收到的错误包数
					NetTxErrors_2 = ifstat.getTxErrors();	// 发送数据包时的错误数
				} catch (SigarNotImplementedException e) {
				} catch (SigarException e) {
					print(e.getMessage());
				}
				
				
			}
			
		
		}
	}

	
	/*
	 * 磁盘信息
	 * 取硬盘已有的分区及其详细信息（通过sigar.getFileSystemList()来获得FileSystem列表对象，然后对其进行编历）：
	 */
	public void getFileSystemInfo(String fsname) throws Exception {
		Sigar sigar = new Sigar();
		FileSystem fslist[] = sigar.getFileSystemList();
		DecimalFormat df = new DecimalFormat("#0.00");

		for (int i = 0; i < fslist.length; i++) {
			System.out.println("\n~~~~~~~~~~" + i + "~~~~~~~~~~");
			FileSystem fs = fslist[i];
			// 分区的盘符名称
			System.out.println("fs.getDevName() = " + fs.getDevName());
			// 分区的盘符名称
			System.out.println("fs.getDirName() = " + fs.getDirName());
			if (fs.getDirName != fsname)
				continue;
						
			System.out.println("fs.getFlags() = " + fs.getFlags());//
			// 文件系统类型，比如 FAT32、NTFS
			System.out.println("fs.getSysTypeName() = " + fs.getSysTypeName());
			// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
			System.out.println("fs.getTypeName() = " + fs.getTypeName());
			// 文件系统类型
			System.out.println("fs.getType() = " + fs.getType());

			FileSystemUsage usage = null;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
			} catch (SigarException e) {
				if (fs.getType() == 2)
					throw e;
				continue;
			}
			switch (fs.getType()) {
			case 0: // TYPE_UNKNOWN ：未知
				break;
			case 1: // TYPE_NONE
				break;
			case 2: // TYPE_LOCAL_DISK : 本地硬盘
				// 文件系统总大小
				System.out.println(" Total = " + df.format((float)usage.getTotal()/1024/1024) + "G");
				// 文件系统剩余大小
				System.out.println(" Free = " + df.format((float)usage.getFree()/1024/1024) + "G");
				// 文件系统可用大小
				System.out.println(" Avail = " + df.format((float)usage.getAvail()/1024/1024) + "G");
				// 文件系统已经使用量
				System.out.println(" Used = " + df.format((float)usage.getUsed()/1024/1024) + "G");
				double usePercent = usage.getUsePercent() * 100D;
				// 文件系统资源的利用率
				System.out.println(" Usage = " + df.format(usePercent) + "%");
				
				ActiveDiskUsage = df.format(usePercent);
				
				break;
			case 3:// TYPE_NETWORK ：网络
				break;
			case 4:// TYPE_RAM_DISK ：闪存
				break;
			case 5:// TYPE_CDROM ：光驱
				break;
			case 6:// TYPE_SWAP ：页面交换
				break;
			}
			System.out.println(" DiskReads = " + usage.getDiskReads());
			ActiveDiskRead = usage.getDiskReads();
			System.out.println(" DiskWrites = " + usage.getDiskWrites());
			ActiveDiskWrite = usage.getDiskWrite();
			
		}
		return;
	}

	
	
	/*
	 * 获取内存信息
	 */
    public void getPhysicalMemory() {
    
    	DecimalFormat df = new DecimalFormat("#0.00");
        Sigar sigar = new Sigar();
        Mem mem;
        
        try {
        	mem = sigar.getMem();

			// 已使用内存总量
			usedMem =  df.format((float)mem.getUsed() / 1024/1024/1024) + "G"; 
			//内存使用率
			MemPercent =  df.format((float)(mem.getUsed() /mem.getTotal()) ) + "%"; ; 
        } catch (SigarException e) {
            e.printStackTrace();
        }
		sigar.close();

        }



        // CPU的相关信息
        public void getCpuTotal() {
                Sigar sigar = new Sigar();

                CpuInfo[] infos;
                CpuPerc   perc;

                try {
                        infos = sigar.getCpuInfoList();
						perc = sigar.getCpuPerc();
						
						CpuTotalCores = infos.length; //CPU 核心数
						
			            CpuInfo info = infos[0];
						CpuType =  info.getVendor() + info.getModel(); //CPU 类型
						CpuMhz =  info.getMhz(); //CPU 主频速度
					
						//CPU 空闲率
						CpuTotalIdlePercent =  CpuPerc.format(cpu.getIdle()); 

                } catch (SigarException e) {
                        e.printStackTrace();

                }
		sigar.close();
        }


   // 取当前操作系统的信息
   public String GetOSInfo() {
        OperatingSystem OS = OperatingSystem.getInstance();

        // 操作系统类型
        return OS.getDescription();
	}
        
   // 取到当前操作系统的名称：
   public String getPlatformName() {
        String hostname = "";

        try {
        
        	hostname = InetAddress.getLocalHost().getHostName();
            
        } catch (Exception exc) {
        
        	Sigar sigar = new Sigar();
            
        	try {
            
        		hostname = sigar.getNetInfo().getHostName();
                
        	} catch (SigarException e) {
            
        		hostname = "localhost.unknown";
                
        	} finally {
            
        		sigar.close();
            }
        }
        return hostname;
    }


	public static SystemInfoSensor gather(Sigar sigar) throws SigarException {
		SystemInfoSensor data = new SystemInfoSensor();
		data.populate(sigar);
		return data;
	}

	public String GenSystemSensor() throws Exception {
		
		Sigar sigar = new Sigar();
		SystemInfoSensor sysinfodata = SystemInfoSensor.gather(sigar);
		XStream xstream = new XStream();
		xstream.alia("SystemInfoSensor", SystemInfoSensor.class);
		
		return xstream.toXML(sysinfodata);
	}
	
	
	public static void main(String[] args) throws Exception {
				
		Sigar sigar = new Sigar();
		SystemInfoSensor sysinfodata = SystemInfoSensor.gather(sigar);
		XStream xstream = new XStream();
		xstream.alia("SystemInfoSensor", SystemInfoSensor.class);
		System.out.println(xstream.toXML(sysinfodata));
	}

}

