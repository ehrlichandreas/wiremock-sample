#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package};

import java.util.Objects;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.github.ehrlichandreas.wiremock.core.Options;

@Configuration
@PropertySource(value = "${symbol_dollar}{standalone.properties-path:classpath:standalone.properties}", ignoreResourceNotFound = true)
public class WireMockProperties {
    @Min(0)
    @Value("${symbol_dollar}{wiremock.server.port:8080}")
    private int serverPort;

    @Value("${symbol_dollar}{wiremock.stubs.directory:wiremock-stubs}")
    private String stubsDirectory;

    @Value("${symbol_dollar}{wiremock.stubs.root-context:}")
    private String stubsRootContext;

    public WireMockProperties() {
        this(Options.DEFAULT_PORT, "wiremock-stubs", Options.DEFAULT_ROOT_CONTEXT);
    }

    public WireMockProperties(final int serverPort, final String stubsDirectory, final String stubsRootContext) {
        this.serverPort = serverPort;
        this.stubsDirectory = stubsDirectory;
        this.stubsRootContext = stubsRootContext;
    }

    public static WireMockProperties of() {
        return new WireMockProperties();
    }

    public static WireMockProperties of(int serverPort, String stubsDirectory, String stubsRootContext) {
        return new WireMockProperties(serverPort, stubsDirectory, stubsRootContext);
    }

    public WireMockProperties withServerPort(int serverPort) {
        return of(serverPort, getStubsDirectory(), getStubsRootContext());
    }

    public WireMockProperties withStubsDirectory(String stubsDirectory) {
        return of(getServerPort(), stubsDirectory, getStubsRootContext());
    }

    public WireMockProperties withStubsRootContext(String stubsRootContext) {
        return of(getServerPort(), getStubsDirectory(), stubsRootContext);
    }

    public int getServerPort() {
        return this.serverPort;
    }

    public String getStubsDirectory() {
        return this.stubsDirectory;
    }

    public String getStubsRootContext() {
        return this.stubsRootContext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WireMockProperties)) return false;
        WireMockProperties that = (WireMockProperties) o;
        return getServerPort() == that.getServerPort() &&
                Objects.equals(getStubsDirectory(), that.getStubsDirectory()) &&
                Objects.equals(getStubsRootContext(), that.getStubsRootContext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServerPort(), getStubsDirectory(), getStubsRootContext());
    }

    @Override
    public String toString() {
        return "WireMockProperties{" +
                "serverPort=" + serverPort +
                ", stubsDirectory='" + stubsDirectory + '\'' +
                ", stubsRootContext='" + stubsRootContext + '\'' +
                '}';
    }
}
