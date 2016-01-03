package jelly.controller.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
public class EntityManagerCreator {

    @Bean
    public EntityManager dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.username", dbUri.getUserInfo().split(":")[0]);
        properties.setProperty("hibernate.connection.password", dbUri.getUserInfo().split(":")[1]);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jellyeditor.persistence.unit", properties);

        return emf.createEntityManager();
    }
}