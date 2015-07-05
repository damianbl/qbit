package eu.softelo.microservices.qbit;

import eu.softelo.microservices.qbit.service.TodoService;
import io.advantageous.qbit.http.HttpTransport;
import io.advantageous.qbit.server.ServiceEndpointServer;
import io.advantageous.qbit.servlet.QBitHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletConfig;

import static io.advantageous.qbit.server.EndpointServerBuilder.endpointServerBuilder;

public class DispatcherServlet extends QBitHttpServlet {
    private static final String SERVICES_API_PROXY_URI_PREAMBLE = "/services/qbit/";

    private ServiceEndpointServer serviceServer;

    @Autowired
    private TodoService todoService;

    @Override
    protected void stop() {
        serviceServer.stop();
    }

    @Override
    protected void wireHttpServer(HttpTransport httpTransport, ServletConfig servletConfig) {
        serviceServer = endpointServerBuilder().setHttpTransport(httpTransport)
                .setUri(SERVICES_API_PROXY_URI_PREAMBLE)
                .build().initServices(todoService).startServer();
    }
}
