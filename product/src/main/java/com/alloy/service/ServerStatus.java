package com.alloy.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by stevenma on 9/25/16.
 */
public class ServerStatus
{

    private String status;
    private String version;
    private String buildDate;

    public ServerStatus() throws Exception
    {
        this.status = "GREEN";

        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties"))
        {
            properties.load(inputStream);
            this.version = properties.getProperty("version");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        this.buildDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public String getStatus()
    {
        return status;
    }

    public String getVersion()
    {
        return version;
    }

    public String getBuildDate()
    {
        return buildDate;
    }
}
