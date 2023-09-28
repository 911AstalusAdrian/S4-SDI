package ro.ubb.remoting.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.ubb.remoting.common.StudentService;
import ro.ubb.remoting.server.service.StudentServiceImpl;

@Configuration
public class ServerConfig {
    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(StudentService.class);
        rmiServiceExporter.setService(new StudentServiceImpl());
        rmiServiceExporter.setServiceName("StudentService");
        return rmiServiceExporter;
    }
}
