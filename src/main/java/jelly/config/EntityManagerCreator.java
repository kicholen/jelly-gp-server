package jelly.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@WebListener
public class EntityManagerCreator implements ServletContextListener {

    static EntityManagerFactory emf;

    public static EntityManager create() {
        if (emf == null) {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.username", getUserInfo().split(":")[0]);
            properties.setProperty("hibernate.connection.password", getUserInfo().split(":")[1]);
            if (isLocalUser()) {
                properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/");
            }

            emf = Persistence.createEntityManagerFactory("jellyeditor.persistence.unit", properties);
        }

        return emf.createEntityManager();
    }

    // todo figure out why listener events are not called
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("jellyeditor.persistence.unit");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        emf.close();
    }

    static Boolean isLocalUser() {
        return getUserInfo().split(":")[0].startsWith("post");
    }

    static String getUserInfo() {
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return dbUri != null ? dbUri.getUserInfo() : null;
    }
}