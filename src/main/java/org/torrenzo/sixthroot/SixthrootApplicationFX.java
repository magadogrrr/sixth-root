package org.torrenzo.sixthroot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class SixthrootApplicationFX extends Application {

    private ConfigurableApplicationContext ctx;

    @Override
    public void init() {
        ctx = new SpringApplicationBuilder(SixthrootApplication.class).run();
    }

    @Override
    public void start(Stage stage) {
        ctx.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        ctx.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {

        public StageReadyEvent(Stage source) {
            super(source);
        }

        public Stage getStage() {
            return (Stage) getSource();
        }
    }
}
