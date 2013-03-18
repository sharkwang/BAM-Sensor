//package sensorclient.hardware;

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

private class MachineConfig{

	private String App; 	//本机运行应用系统
	private String MultiApp; //多个应用系统名称，以|隔离
	private String Type; 	//本机系统类型：AS-J2EE服务器 DB-数据库服务器 
				//Tux-Tuxedo Any-其他类型
	private String ActiveDisk;

	public String getApp(){
		return App;
	}

	public String getMultiApp(){
		return MultiApp;
	}

	public String getType(){
		return Type;
	}
	public String getActiveDisk(){
		return Type;
	}
	
	public void MachineConfig(){
	
	}
	
}

private class SystemData{
	private String data; 	//采集日期
	private String time; 	//采集时间
 /*
  *  	以下信息从配置文件中读取
  */
	private String App1; 	//本机运行应用系统
	private String MultiApp; //多个应用系统名称，以|隔离
	private String Type; 	//本机系统类型：AS-J2EE服务器 DB-数据库服务器 
				//Tux-Tuxedo Any-其他类型
        // 系统信息
	private String hostname; 	//主机名
	private String OSname; 	//操作系统及版本
	private String CpuType; //CPU 类型
	private String CpuMhz; //CPU 主频速度
	private String CpuTotalCores; //CPU 核心数
	private String CpuTotalIdlePercent; //CPU 空闲率
	private String usedMem; // 已使用内存总量
	private String MemPercent; //内存空闲率
	private String ActiveDiskUsage; //监控磁盘使用率
	private String ActiveDiskRead; //监控磁盘读
	private String ActiveDiskWrite; //监控磁盘写
	private String IPaddress; 	// IP地址
	private String MacAddress; 	// 第一张网卡物理地址
	private String NetRxBytes; 	//接收总字节数
	private String NetTxBytes; 	//发送总字节数
	private String NetRxErrors; 	//接收错误包数
	private String NetTxError; 	//发送错误包数
	private String MultiIPaddress; 	// 第二张IP地址 
	private String MultiMacAddress; //第二张网卡物理地址
	private String NetRxBytes_2; 	//接收总字节数
	private String NetTxBytes_2; 	//发送总字节数
	private String NetRxErrors_2; 	//接收错误包数
	private String NetTxError_2; 	//发送错误包数
	
	public void SystemData(){

	}
}


public class SystemInfoSensor{

	private String data; 	//采集日期
	private String time; 	//采集时间
 /*
  *  	以下信息从配置文件中读取
  */
	private String App; 	//本机运行应用系统
	private String MultiApp; //多个应用系统名称，以|隔离
	private String Type; 	//本机系统类型：AS-J2EE服务器 DB-数据库服务器 
				//Tux-Tuxedo Any-其他类型
        // 系统信息
	private String hostname; 	//主机名称
	private String OSname; 	//操作系统及版本
	private String CpuType; //CPU 类型
	private String CpuMhz; //CPU 主频速度
	private String CpuTotalCores; //CPU 核心数
	private String CpuTotalIdlePercent; //CPU 空闲率
	private String usedMem; // 已使用内存总量
	private String MemPercent; //内存空闲率
	private String ActiveDiskUsage; //监控磁盘使用率
	private String ActiveDiskRead; //监控磁盘读
	private String ActiveDiskWrite; //监控磁盘写
	private String IPaddress; 	// IP地址
	private String MacAddress; 	// 第一张网卡物理地址
	private String NetRxBytes; 	//接收总字节数
	private String NetTxBytes; 	//发送总字节数
	private String NetRxErrors; 	//接收错误包数
	private String NetTxError; 	//发送错误包数
	private String MultiIPaddress; 	// 第二张IP地址 
	private String MultiMacAddress; //第二张网卡物理地址
	private String NetRxBytes_2; 	//接收总字节数
	private String NetTxBytes_2; 	//发送总字节数
	private String NetRxErrors_2; 	//接收错误包数
	private String NetTxError_2; 	//发送错误包数
	
	public SystemInfoSensor() {
	}

	public void populate(Sigar sigar, String cfgFile) throws SigarException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		date = df.format(new Date());

		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
		time = df.format(new Date());

		// 从控制文件中读取配置
		MachineConfig cfg = readConfigfile(cfgFile);
		
		App = cfg.getApp();
		MultiApp = cfg.getMultiApp();
		Type = cfg.getType();

                hostname = getPlatformName();//获取计算机主机名  
		
		OSname = GetOSInfo(); //获取操作系统类型

        	// 获取CPU的相关信息
		getCpuTotal();

		// 获取内存信息
		getPhysicalMemory();

		
	}
       
	// 内存信息
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
			CpuTotalIdlePercent =  CpuPerc.format(cpu.getIdle(); 

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

	
	public MachineConfig readConfigfile(String Filename) throws Exception {

	        String configXML = "";   
        	
		
		File f = new File(fileName);   
        	FileReader fileReader = new FileReader(f);   
        	BufferedReader reader = new BufferedReader(fileReader);   
        	String line = "";   
        	
		while ((line = reader.readLine()) != null)   
        	{   
             		configXML = configXML + line;   
        	}   
        	reader.close();   
		f.close();
	
		XStream xstream = new XStream();
 		MachineConfig config = (MachineConfig)xstream.fromXML(configXML);

		return config;

	}

	public static CpuData gather(Sigar sigar) throws SigarException {
		CpuData data = new CpuData();
		data.populate(sigar);
		return data;
	}

        public void nowCpuPerc() {
                Sigar sigar = new Sigar();

                CpuPerc cpu;
                try {
                        cpu = sigar.getCpuPerc();
                        printCpuPerc(cpu);
                } catch (SigarException e) {
                        e.printStackTrace();
                }
        }

	public static void main(String[] args) throws Exception {
		Sigar sigar = new Sigar();
		CpuData cpuData = CpuData.gather(sigar);
		XStream xstream = new XStream();
		xstream.alia("SystemInfoSensor", SystemInfoSensor.class);
		System.out.println(xstream.toXML(cpuData));
	}

}

