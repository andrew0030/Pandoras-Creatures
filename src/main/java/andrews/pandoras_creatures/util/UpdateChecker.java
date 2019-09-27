package andrews.pandoras_creatures.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker
{
	private static final String UPDATE_URL = "http://download1490.mediafire.com/la5xf3mlo54g/yjq2g4oyyc7eakg/version.txt?d1=1";
	
	private static boolean newVersionAvailable = false;
	
	public static void checkForUpdates()
	{
		new Thread("Update-Checker")
		{
			public void run()
			{
				try
				{
					URL url = new URL(UPDATE_URL);
					Scanner scanner = new Scanner(url.openStream());
					String latestVersion = scanner.nextLine();
					scanner.close();
					
					if(!Reference.VERSION.equals(latestVersion))
					{
						setNewVersionAvailable();
					}
				}
				catch(MalformedURLException e)
				{
					e.printStackTrace();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			};
		}.start();
	}
	
	public static synchronized void setNewVersionAvailable()
	{
		newVersionAvailable = true;
	}
	
	public static synchronized boolean isNewVersionAvailable()
	{
		return newVersionAvailable;
	}
}
