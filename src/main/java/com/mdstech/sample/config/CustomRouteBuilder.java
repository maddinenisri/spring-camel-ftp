package com.mdstech.sample.config;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by srini on 8/8/17.
 */
@Component
public class CustomRouteBuilder extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomRouteBuilder.class);

    @Value("${ftp.servername}")
    private String serverName;

    @Value("${ftp.user}")
    private String user;

    @Value("${ftp.port}")
    private String port;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.directory}")
    private String directory;

    @Override
    public void configure() throws Exception {
        LOGGER.info("Initializing routes ...");

        String uri =
                String.format("ftp://%s@%s:%s/%s?password=%s&stepwise=true&passiveMode=true&delete=true&filter=#textFileFilter",
                        user,
                        serverName,
                        port,
                        directory,
                        password);

        String fileUrl = "file:target/download?noop=true";

        LOGGER.info("Initializing routes ..." + uri);

        from(uri)
                .convertBodyTo(String.class).to(fileUrl)
                .log("Downloaded file ${file:name} complete.");

//        from("file:target/upload?filter=#textFileFilter").to(uri);
    }
}
