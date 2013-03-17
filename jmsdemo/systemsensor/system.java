import java.io.*;
import com.sun.management.OperatingSystemMXBean;
import com.sun.management.ManagementFactory;

public class Tst{  
	public static String pt="./abc.txt";
	public Tst(){
	}  
	public static void main(String[] args) throws Exception{
		//free和use和total均为KB 
		long free=0; 
		long use=0; 
		long total=0;  
		int kb=1024;

		Runtime rt=Runtime.getRuntime();
		total=rt.totalMemory();
		free=rt.freeMemory();
		use=total-free;
		
		System.out.println("系统内存已用的空间为："+use/kb+" MB");
		System.out.println("系统内存的空闲空间为："+free/kb+" MB");
		System.out.println("系统总内存空间为："+total/kb+" MB");   

		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		
		long physicalFree=osmxb.getFreePhysicalMemorySize()/kb;
		long physicalTotal=osmxb.getTotalPhysicalMemorySize()/kb;
		long physicalUse=physicalTotal-physicalFree;
		String os=System.getProperty("os.name");
		System.out.println("操作系统的版本："+os);
		System.out.println("系统物理内存已用的空间为："+physicalFree+" MB");
		System.out.println("系统物理内存的空闲空间为："+physicalUse+" MB");
		System.out.println("总物理内存："+physicalTotal+" MB");

		// 获得线程总数 
        	ThreadGroup parentThread;
        	for (parentThread = Thread.currentThread().getThreadGroup(); parentThread.getParent() != null; parentThread = parentThread.getParent())
			;
		int totalThread = parentThread.activeCount();

		System.out.println("获得线程总数:"+totalThread);
	}
}
