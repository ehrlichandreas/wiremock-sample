#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package};

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.ehrlichandreas.wiremock.WireMockServer;

@Configuration
@PropertySource(value = "${symbol_dollar}{standalone.properties-path:classpath:standalone.properties}", ignoreResourceNotFound = true)
public class Executable {
    private static String WIREMOCK_SERVER_PORT_PROPERTY_NAME = "wiremock.server.port";
    private static String WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME = "wiremock.stubs.directory";
    private static String WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME = "wiremock.stubs.root-context";

    public static void main(String[] args) {
        final WireMockCreater wireMockCreater = loadWireMockCreater();
        final WireMockServer wireMock = wireMockCreater.createWireMock();
        wireMock.start();
    }

    public static WireMockCreater loadWireMockCreater() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(Executable.class.getPackage().getName());
        context.refresh();

        final int wiremockServerPort = Integer.parseInt(context.getEnvironment().getProperty(WIREMOCK_SERVER_PORT_PROPERTY_NAME));
        final String wiremockStubsDirectory = context.getEnvironment().getProperty(WIREMOCK_STUBS_DIRECTORY_PROPERTY_NAME);
        final String wiremockStubsRootContext = context.getEnvironment().getProperty(WIREMOCK_STUBS_ROOT_CONTEXT_PROPERTY_NAME);

        final WireMockProperties wireMockProperties = WireMockProperties.of(wiremockServerPort, wiremockStubsDirectory, wiremockStubsRootContext);

        return WireMockCreater.of(wireMockProperties);
    }
}
