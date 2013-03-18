package sensorclient;

import java.io.*;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class Getsysinfo{
	
	public Getsysinfo(){
	};
	public static void main(String[] args) throws Exception{
		
		long free=0;
		long use=0;
		long total=0;
		int Mb=1024*1024;

		Runtime rt=Runtime.getRuntime();
		total=rt.totalMemory();
		free=rt.freeMemory();
		use=total-free;
		
		System.out.println("系统内存已用的空间为:" + use/Mb + " GB");
		System.out.println("系统内存的空闲空间为:" + free/Mb + " GB");
		System.out.println("系统总内存空间为:" + total/Mb + " GB");

		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		
		long physicalFree=osmxb.getFreePhysicalMemorySize()/Mb;
		long physicalTotal=osmxb.getTotalPhysicalMemorySize()/Mb;
		long physicalUse=physicalTotal-physicalFree;
		String os=System.getProperty("os.name");
		System.out.println("操作系统的版本："+os);
		System.out.println("系统物理内存已用的空间为：" + physicalFree + " MB");
		System.out.println("系统物理内存的空闲空间为：" + physicalUse + " MB");
		System.out.println("总物理内存：" + physicalTotal +" MB");
		
		ThreadGroup parentThread;
		for (parentThread = Thread.currentThread().getThreadGroup(); parentThread.getParent() != null; parentThread = parentThread.getParent());
		
		int totalThread = parentThread.activeCount();

		System.out.println("获得线程总数:"+totalThread);
		
		double cpuRatio=0;
		if(os.toLowerCase().startsWith("windows")){
			cpuRatio=this.getCpuRatioForWindows();
		}else{ 
			cpuRatio=this.getCpuRateForLinux(); 
		}
		System.out.println("CPU利用率:"+cpuRatio+"%"); 
	}
}
