//package com.orient.sensor.config;

import java.io.BufferedReader;   
import java.io.File;   
import java.io.FileReader;  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.thoughtworks.xstream.XStream;

public class MachineConfig{

	/*
	 * Sensor target Server info
	 */
	private String Server;	//t3://192.168.0.1:7001
	private String Queue;	//Target Queue JNDI name
	private String User;
	private String Passwd;
	
	/*
	 *  App Middleware DB and Hardware info
	 */
	private String App; 		//本机运行应用系统
	private String MultiApp; 	//多个应用系统名称，以|隔离
	private String Type; 		//本机系统类型：AS-J2EE服务器 DB-数据库服务器 
								//Tux-Tuxedo Any-其他类型
	private String ActiveDisk; 	//监控的本机磁盘 

	public MachineConfig(){
		
	}
	
	public String getServer(){
		return Server;
	}
	
	public String getQueue(){
		return Queue;
	}
	
	public String getUser(){
		return Queue;
	}

	public String getPasswd(){
		return Queue;
	}

	
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

	public static MachineConfig loadConfig(String filename) throws FileNotFoundException {

    	XStream xstream = new XStream();
    	xstream.alias("config", MachineConfig.class)
    	MachineConfig config = (MachineConfig)xstream.fromXML(new FileInputStream(filename));

		return config;

	}

	public static MachineConfig createConfig(String filename){
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Sensor config file start create:");
		 System.out.println("1. Input the Sensor server address[t3://ip:port]:");
		 
		 this.Server = sc.nextLine();
		 
		 System.out.println("2. Input the Sensor Active Queue[jms/demoQueue]:");
		 this.Queue = sc.nextLine();
		 
		 System.out.println("3. Input the Sensor server user name[weblogic]:");
		 this.User = sc.nextLine();
		 
		 System.out.println("4. Input the Sensor server password[welcome1]:");
		 this.Passwd = sc.nextLine();
		 
		 System.out.println("5. Input the main Application name in this server[bankapp]:");
		 this.App = sc.nextLine();
		 
		 System.out.println("6. Input others Applications name in this server[loanapp:testapp]:");
		 this.MultiApp = sc.nextLine();
		 
		 System.out.println("7. Input the machine Type[AS|Tux|DB|Any]:");
		 this.Type = sc.nextLine();
		 
		 System.out.println("8. Input the monitor file system[/opt]:");
		 this.ActiveDisk = sc.nextLine();

	     XStream xstream = new XStream();
		 xstream.alias("MachineConfig", MachineConfig.class);
         
         String xml = xstream.toXML(this);  
         try {  
             PrintWriter out = new PrintWriter(new BufferedWriter(  
                     new OutputStreamWriter(new FileOutputStream(filename),  
                             "UTF-8")));  
             out.write(xml);  
             out.close();  
             
             
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
         
         sc.close();
         return this;

	}
	
	public MachineConfig MachineConfig(String filename){
        
		 
		try {
			
			File f = new File(fileName);    
			
	        if (f.exists()) {
	           System.out.println("Sensor Info: load configuration from:" +  filename );
	           return loadConfig(filename);
	           
	        } else {
 	           System.out.println("Sensor Warning: config file does NOT exist! start create new config file");
	           System.out.println("Sensor config.xml start:");
	           
	           return createConfig(filename);;

	           } 
	        }

			
	
	}
	
	public void main(String[] args) throws Exception{
		
		MachineConfig = new MachineConfig(args[1]);
		
		
	}
}