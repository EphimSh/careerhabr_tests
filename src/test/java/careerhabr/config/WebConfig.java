package careerhabr.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseURL")
    @DefaultValue("https://career.habr.com/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1980x1180")
    String getBrowserSize();
    @Key("pageLoadStrategy")
    String getPageLoadStrategy();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("apiBasePath")
    @DefaultValue("api/frontend/")
    String getBasePath();

}
