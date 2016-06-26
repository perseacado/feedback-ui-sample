package org.github.perseacado.feedbackui.sample;

import com.github.perseacado.feedbackui.slack.SlackAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Marco Eigletsberger, 26.06.16.
 */
@SpringBootApplication(exclude = SlackAutoConfiguration.class)
public class FeedbackUiSampleApp {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackUiSampleApp.class, args);
    }
}
