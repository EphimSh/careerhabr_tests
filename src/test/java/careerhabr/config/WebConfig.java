package careerhabr.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/${env}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserversion")
    @DefaultValue("116.0")
    String getBrowserVersion();

    @Key("baseURL")
    @DefaultValue("https://career.habr.com/")
    String getBaseUrl();

    @Key("browsersize")
    @DefaultValue("1980x1180")
    String getBrowserSize();
    @Key("pageloadstrategy")
    String getPageLoadStrategy();

    @Key("remoteurl")
    String getRemoteUrl();

    @Key("apibasepath")
    @DefaultValue("api/frontend/")
    String getBasePath();

}
