#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package};

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.ehrlichandreas.wiremock.WireMockServer;

public class Executable {

    public static void main(String[] args) {
        final WireMockCreater wireMockCreater = loadWireMockCreater();
        final WireMockServer wireMock = wireMockCreater.createWireMock();
        wireMock.start();
    }

    public static WireMockCreater loadWireMockCreater() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(Executable.class.getPackage().getName());
        context.refresh();

        return context.getBean(WireMockCreater.class);
    }
}
