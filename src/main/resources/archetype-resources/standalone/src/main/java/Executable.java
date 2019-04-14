package ${package};

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.ehrlichandreas.wiremock.starter.WireMockProxyStarter;

@Configuration
@PropertySource(value = "${symbol_dollar}{standalone.properties-path:classpath:standalone.properties}", ignoreResourceNotFound = true)
public class Executable extends WireMockProxyStarter {
    private static String WIREMOCK_SERVER_PORT_PROPERTY_NAME = "wiremock.server.port";
    private static String WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME = "wiremock.stubs.directory";
    private static String WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME = "wiremock.stubs.root-context";
    private static String WIREMOCK_PROXY_PROPERTIES_PREFIX_NAME = "wiremock.proxy.properties.prefix";
    private static String WIREMOCK_INIT_PROXIED_SERVERS_PROPERTY_NAME = "wiremock.init.proxied-servers";

    public static void main(String[] args) {
        WireMockProxyStarter wireMockStarter = new ExecutableProxy();
        wireMockStarter.startWireMockServer();
    }

    @Override
    public String getWiremockServerPortPropertyName() {
        return WIREMOCK_SERVER_PORT_PROPERTY_NAME;
    }

    @Override
    public String getWiremockStubsDirectoryPropertyName() {
        return WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME;
    }

    @Override
    public String getWiremockStubsRootContextPropertyName() {
        return WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME;
    }

    @Override
    public String getWiremockProxyPropertiesPrefix() {
        return WIREMOCK_PROXY_PROPERTIES_PREFIX_NAME;
    }

    @Override
    public String getWiremockInitProxiedServersPropertyName() {
        return WIREMOCK_INIT_PROXIED_SERVERS_PROPERTY_NAME;
    }
}
