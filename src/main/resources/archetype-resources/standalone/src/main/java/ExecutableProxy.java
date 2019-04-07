package ${package};

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.ehrlichandreas.wiremock.starter.WireMockProxyStarter;

@Configuration
@PropertySource(value = "${symbol_dollar}{standalone.properties-path:classpath:standalone.properties}", ignoreResourceNotFound = true)
public class ExecutableProxy extends WireMockProxyStarter {
    private static String WIREMOCK_SERVER_PORT_PROPERTY_NAME = "wiremock.server.port";
    private static String WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME = "wiremock.stubs.directory";
    private static String WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME = "wiremock.stubs.root-context";
    private static String WIREMOCK_PROXY_PROPERTIES_PREFIX_NAME = "wiremock.proxy.properties.prefix";

    public static void main(String[] args) {
        WireMockProxyStarter wireMockStarter = new ExecutableProxy();
        wireMockStarter.startWireMockServer();
    }

    public String getWiremockServerPortPropertyName() {
        return WIREMOCK_SERVER_PORT_PROPERTY_NAME;
    }

    public String getWiremockStubsDirectoryPropertyName() {
        return WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME;
    }

    public String getWiremockStubsRootContextPropertyName() {
        return WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME;
    }

    public String getWiremockProxyPropertiesPrefix() {
        return WIREMOCK_PROXY_PROPERTIES_PREFIX_NAME;
    }
}
