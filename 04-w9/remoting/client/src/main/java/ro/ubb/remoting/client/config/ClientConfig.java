package ro.ubb.remoting.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.remoting.client.service.StudentServiceClient;
import ro.ubb.remoting.client.ui.ClientConsole;
import ro.ubb.remoting.common.StudentService;

@Configuration
public class ClientConfig {
    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/StudentService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        return rmiProxyFactoryBean;
    }

    @Bean
    ClientConsole clientConsole() {
        return new ClientConsole(studentServiceClient());
    }

    @Bean
    StudentService studentServiceClient() {
        return new StudentServiceClient();
    }
}
