package org.torrenzo.sixthroot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.torrenzo.sixthroot.SixthrootApplicationFX.StageReadyEvent;

@Component
public class SixthrootInitializer implements ApplicationListener<SixthrootApplicationFX.StageReadyEvent> {

    private final String appTitle;
    private final Resource fxmlResource;
    private final ApplicationContext ctx;

    public SixthrootInitializer(@Value("${spring.application.ui.main.title}") String appTitle,
                                @Value("classpath:/main.fxml") Resource fxmlResource,
                                ApplicationContext ctx) {
        this.appTitle = appTitle;
        this.fxmlResource = fxmlResource;
        this.ctx = ctx;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(fxmlResource.getURL());
            loader.setControllerFactory(ctx::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = event.getStage();
            stage.setScene(scene);
            stage.setTitle(appTitle);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
