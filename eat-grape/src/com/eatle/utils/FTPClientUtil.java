package com.eatle.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.apache.commons.net.util.TrustManagerUtils;

/** 
 * @corpor: sxit
 * @author: tanyouzhong
 * @Description: FTP客户端工具
 * @date: 2013-3-12 下午05:22:41
 */
public final class FTPClientUtil
{
	/**
	 * @Description: 上传操作类型
	 */
	public static final int TYPE_UPLOAD = 0;

	/**
	 * @Description: 下载操作类型
	 */
	public static final int TYPE_DOWNLOAD = 1;

	/**
	 * @Description: FTP操作提示(类似Dos下的“ftp /?”命令)
	 */
	public static final String USAGE = "Usage: ftp [options] <hostname> <username> <password> [<remote file> [<local file>]]\n"
			+ "\nDefault behavior is to download a file and use ASCII transfer mode.\n"
			+ "\t-a - use local active mode (default is local passive)\n"
			+ "\t-b - use binary transfer mode\n"
			+ "\t-c cmd - issue arbitrary command (remote is used as a parameter if provided) \n"
			+ "\t-d - list directory details using MLSD (remote is used as the pathname if provided)\n"
			+ "\t-e - use EPSV with IPv4 (default false)\n"
			+ "\t-f - issue FEAT command (remote and local files are ignored)\n"
			+ "\t-h - list hidden files (applies to -l and -n only)\n"
			+ "\t-k secs - use keep-alive timer (setControlKeepAliveTimeout)\n"
			+ "\t-l - list files using LIST (remote is used as the pathname if provided)\n"
			+ "\t-L - use lenient future dates (server dates may be up to 1 day into future)\n"
			+ "\t-n - list file names using NLST (remote is used as the pathname if provided)\n"
			+ "\t-p true|false|protocol[,true|false] - use FTPSClient with the specified protocol and/or isImplicit setting\n"
			+ "\t-s - store file on server (upload)\n"
			+ "\t-t - list file details using MLST (remote is used as the pathname if provided)\n"
			+ "\t-w msec - wait time for keep-alive reply (setControlKeepAliveReplyTimeout)\n"
			+ "\t-T  all|valid|none - use one of the built-in TrustManager implementations (none = JVM default)\n"
			+ "\t-PrH server[:port] - HTTP Proxy host and optional port[80] \n"
			+ "\t-PrU user - HTTP Proxy server username\n"
			+ "\t-PrP password - HTTP Proxy server password\n"
			+ "\t-# - add hash display during transfers\n";

	/**
	 * @Description: 单例对象
	 */
	private static FTPClientUtil instanse;
	
	private boolean storeFile = false, binaryTransfer = false, listFiles = false, listNames = false, hidden = false;
	private boolean localActive = false, useEpsvWithIPv4 = false, feat = false, printHash = false;
	private boolean mlst = false, mlsd = false;
	private boolean lenient = false;
	private long keepAliveTimeout = -1;
	private int controlKeepAliveReplyTimeout = -1;
	private int minParams = 3; // listings require 3 params
	private String protocol = null; // SSL protocol
	private String doCommand = null;
	private String trustmgr = null;
	private String proxyHost = null;
	private int proxyPort = 80;
	private String proxyUser = null;
	private String proxyPassword = null;
	private String server, username, password;
	private FTPClient ftp;
	
	/**
	 * @Description: 构造函数私有化
	 */
	private FTPClientUtil()
	{
		
	}
	
	/**
	 * @Description: 获取单例
	 */
	public static FTPClientUtil getInstanse()
	{
		if(instanse == null)
		{
			instanse = new FTPClientUtil();
		}
		return instanse;
	}
	
	/**
	 * @Description: 连接FTP服务器
	 * @param params: <p>连接FTP服务器配置参数(最小长度为3)</p>
	 * <p>参照命令：ftp [options] [hostname:port] [username] [password] [remote file] [local file]</p>
	 * <p>举例1：new String[5] {"hostname:port", "username", "password"}</p>
	 * <p>举例2：new String[6] {"-p", "true", "hostname:port", "username", "password"}</p>
	 * <p>举例3：new String[7] {"-b", "-p", "true", "hostname:port", "username", "password"}</p>
	 */
	public void connect(String[] params)
	{
		int base = 0;
		for (base = 0; base < params.length; base++)
		{
			if (params[base].equals("-s"))
			{
				storeFile = true;
			}
			else if (params[base].equals("-a"))
			{
				localActive = true;
			}
			else if (params[base].equals("-b"))
			{
				binaryTransfer = true;
			}
			else if (params[base].equals("-c"))
			{
				doCommand = params[++base];
				minParams = 3;
			}
			else if (params[base].equals("-d"))
			{
				mlsd = true;
				minParams = 3;
			}
			else if (params[base].equals("-e"))
			{
				useEpsvWithIPv4 = true;
			}
			else if (params[base].equals("-f"))
			{
				feat = true;
				minParams = 3;
			}
			else if (params[base].equals("-h"))
			{
				hidden = true;
			}
			else if (params[base].equals("-k"))
			{
				keepAliveTimeout = Long.parseLong(params[++base]);
			}
			else if (params[base].equals("-l"))
			{
				listFiles = true;
				minParams = 3;
			}
			else if (params[base].equals("-L"))
			{
				lenient = true;
			}
			else if (params[base].equals("-n"))
			{
				listNames = true;
				minParams = 3;
			}
			else if (params[base].equals("-p"))
			{
				protocol = params[++base];
			}
			else if (params[base].equals("-t"))
			{
				mlst = true;
				minParams = 3;
			}
			else if (params[base].equals("-w"))
			{
				controlKeepAliveReplyTimeout = Integer.parseInt(params[++base]);
			}
			else if (params[base].equals("-T"))
			{
				trustmgr = params[++base];
			}
			else if (params[base].equals("-PrH"))
			{
				proxyHost = params[++base];
				String parts[] = proxyHost.split(":");
				if (parts.length == 2)
				{
					proxyHost = parts[0];
					proxyPort = Integer.parseInt(parts[1]);
				}
			}
			else if (params[base].equals("-PrU"))
			{
				proxyUser = params[++base];
			}
			else if (params[base].equals("-PrP"))
			{
				proxyPassword = params[++base];
			}
			else if (params[base].equals("-#"))
			{
				printHash = true;
			}
			else
			{
				break;
			}
		}

		int remain = params.length - base;
		if (remain < minParams) // server, user, pass, remote, local [protocol]
		{
			System.err.println(USAGE);
			System.exit(1);
		}

		server = params[base++];
		int port = 0;
		String parts[] = server.split(":");
		if (parts.length == 2)
		{
			server = parts[0];
			port = Integer.parseInt(parts[1]);
		}
		username = params[base++];
		password = params[base++];

//		if (params.length - base > 0)
//		{
//			remote = params[base++];
//		}
//
//		if (params.length - base > 0)
//		{
//			local = params[base++];
//		}

		if (protocol == null)
		{
			if (proxyHost != null)
			{
				System.out.println("Using HTTP proxy server: " + proxyHost);
				ftp = new FTPHTTPClient(proxyHost, proxyPort, proxyUser,
						proxyPassword);
			}
			else
			{
				ftp = new FTPClient();
			}
		}
		else
		{
			FTPSClient ftps;
			if (protocol.equals("true"))
			{
				ftps = new FTPSClient(true);
			}
			else if (protocol.equals("false"))
			{
				ftps = new FTPSClient(false);
			}
			else
			{
				String prot[] = protocol.split(",");
				if (prot.length == 1)
				{ // Just protocol
					ftps = new FTPSClient(protocol);
				}
				else
				{ // protocol,true|false
					ftps = new FTPSClient(prot[0], Boolean
							.parseBoolean(prot[1]));
				}
			}
			ftp = ftps;
			if ("all".equals(trustmgr))
			{
				ftps.setTrustManager(TrustManagerUtils
						.getAcceptAllTrustManager());
			}
			else if ("valid".equals(trustmgr))
			{
				ftps.setTrustManager(TrustManagerUtils
						.getValidateServerCertificateTrustManager());
			}
			else if ("none".equals(trustmgr))
			{
				ftps.setTrustManager(null);
			}
		}

		if (printHash)
		{
			ftp.setCopyStreamListener(createListener());
		}
		if (keepAliveTimeout >= 0)
		{
			ftp.setControlKeepAliveTimeout(keepAliveTimeout);
		}
		if (controlKeepAliveReplyTimeout >= 0)
		{
			ftp.setControlKeepAliveReplyTimeout(controlKeepAliveReplyTimeout);
		}
		ftp.setListHiddenFiles(hidden);

		// suppress login details
		ftp.addProtocolCommandListener(new PrintCommandListener(
				new PrintWriter(System.out), true));

		try
		{
			int reply;
			if (port > 0)
			{
				ftp.connect(server, port);
			}
			else
			{
				ftp.connect(server);
			}
			System.out.println("Connected to " + server + " on "
					+ (port > 0 ? port : ftp.getDefaultPort()));

			// After connection attempt, you should check the reply code to verify success.
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply))
			{
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
__transfer:
			if (!ftp.login(username, password))
			{
				ftp.logout();
				break __transfer;
			}
		}
		catch (IOException e)
		{
			if (ftp.isConnected())
			{
				try
				{
					ftp.disconnect();
				}
				catch (IOException f)
				{
					// do nothing
				}
			}
			System.err.println("Could not connect to server.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * @Description: 传输文件（上传或下载）
	 * @param type: <p>FTP操作类型（可通过本类的常量决定）</p>
	 */
	public boolean transfer(String local, String remote, int type)
	{
		boolean result = false;
		try
		{
			System.out.println("Remote system is " + ftp.getSystemType());

			if (binaryTransfer)
			{
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
			}

			// Use passive mode as default because most of us are
			// behind firewalls these days.
			if (localActive)
			{
				ftp.enterLocalActiveMode();
			}
			else
			{
				ftp.enterLocalPassiveMode();
			}

			ftp.setUseEPSVwithIPv4(useEpsvWithIPv4);

			if (storeFile)
			{
				InputStream input;

				input = new FileInputStream(local);

				ftp.storeFile(remote, input);

				input.close();
			}
			else if (listFiles)
			{
				if (lenient)
				{
					FTPClientConfig config = new FTPClientConfig();
					config.setLenientFutureDates(true);
					ftp.configure(config);
				}

				for (FTPFile f : ftp.listFiles(remote))
				{
					System.out.println(f.getRawListing());
					System.out.println(f.toFormattedString());
				}
			}
			else if (mlsd)
			{
				for (FTPFile f : ftp.mlistDir(remote))
				{
					System.out.println(f.getRawListing());
					System.out.println(f.toFormattedString());
				}
			}
			else if (mlst)
			{
				FTPFile f = ftp.mlistFile(remote);
				if (f != null)
				{
					System.out.println(f.toFormattedString());
				}
			}
			else if (listNames)
			{
				for (String s : ftp.listNames(remote))
				{
					System.out.println(s);
				}
			}
			else if (feat)
			{
				// boolean feature check
				if (remote != null)
				{ // See if the command is present
					if (ftp.hasFeature(remote))
					{
						System.out.println("Has feature: " + remote);
					}
					else
					{
						if (FTPReply.isPositiveCompletion(ftp.getReplyCode()))
						{
							System.out.println("FEAT " + remote
									+ " was not detected");
						}
						else
						{
							System.out.println("Command failed: "
									+ ftp.getReplyString());
						}
					}

					// Strings feature check
					String[] features = ftp.featureValues(remote);
					if (features != null)
					{
						for (String f : features)
						{
							System.out
									.println("FEAT " + remote + "=" + f + ".");
						}
					}
					else
					{
						if (FTPReply.isPositiveCompletion(ftp.getReplyCode()))
						{
							System.out.println("FEAT " + remote
									+ " is not present");
						}
						else
						{
							System.out.println("Command failed: "
									+ ftp.getReplyString());
						}
					}
				}
				else
				{
					if (ftp.features())
					{
						// Command listener has already printed the output
					}
					else
					{
						System.out.println("Failed: " + ftp.getReplyString());
					}
				}
			}
			else if (doCommand != null)
			{
				if (ftp.doCommand(doCommand, remote))
				{
					// Command listener has already printed the output
					// for(String s : ftp.getReplyStrings()) {
					// System.out.println(s);
					// }
				}
				else
				{
					System.out.println("Failed: " + ftp.getReplyString());
				}
			}
			else
			{
				if (type == TYPE_DOWNLOAD)
				{
					OutputStream output = new FileOutputStream(local);
					result = ftp.retrieveFile(remote, output);
					output.close();
				}
				else
				{
					InputStream input = new FileInputStream(local);
					result = ftp.storeFile(remote, input);
					input.close();
				}
			}
			ftp.noop(); // check that control connection is working OK
		}
		catch (FTPConnectionClosedException e)
		{
			System.err.println("Server closed connection.");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @Description: 退出，与服务器断开连接
	 */
	public void disconnect()
	{
		try
		{
			ftp.logout();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ftp.isConnected())
			{
				try
				{
					ftp.disconnect();
				}
				catch (IOException e)
				{
					System.out.println(e);
				}
			}
		}
	}

	private static CopyStreamListener createListener()
	{
		return new CopyStreamListener()
		{
			private long megsTotal = 0;

			public void bytesTransferred(CopyStreamEvent event)
			{
				bytesTransferred(event.getTotalBytesTransferred(), event
						.getBytesTransferred(), event.getStreamSize());
			}

			public void bytesTransferred(long totalBytesTransferred,
					int bytesTransferred, long streamSize)
			{
				long megs = totalBytesTransferred / 1000000;
				for (long l = megsTotal; l < megs; l++)
				{
					System.err.print("#");
				}
				megsTotal = megs;
			}
		};
	}
}