package com.example.milahan;



import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHConnection {

	private final static String S_PATH_FILE_PRIVATE_KEY = "/Users/hdwang/.ssh/id_rsa";
	private final static String S_PATH_FILE_KNOWN_HOSTS = "/Users/ajacobsmo/.ssh/known_hosts";
	private final static String S_PASS_PHRASE = "";
	private final static int LOCAl_PORT = 3307;
	private final static int REMOTE_PORT = 3306; 
	private final static int SSH_REMOTE_PORT = 22;
	private final static String SSH_USER = "root";
	private final static String SSH_PASSWORD = "Rac67ine";
	private final static String SSH_REMOTE_SERVER = "132.74.59.101";
	private final static String MYSQL_REMOTE_SERVER = "132.74.59.101"; 
	
	private Session sesion; //represents each ssh session
	
	public void closeSSH ()
	{
	    sesion.disconnect();
	}
	
	public SSHConnection () throws Throwable
	{
	
	    JSch jsch = null;
	
	        jsch = new JSch();
	        jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
	        //jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY);
	
	        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
	
	        sesion.setPassword(SSH_PASSWORD);
	
	        Properties config = new Properties();
	        config.put("StrictHostKeyChecking", "no");
	        sesion.setConfig(config);
	
	        sesion.connect(); //ssh connection established!
	
	        //by security policy, you must connect through a fowarded port          
	        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);
	
	}
}


