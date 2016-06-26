package org.github.perseacado.feedbackui.sample;

import com.github.perseacado.feedbackui.core.FeedbackMessage;
import com.github.perseacado.feedbackui.core.FeedbackService;
import com.github.perseacado.feedbackui.slack.SlackConfigurationProperties;
import com.github.perseacado.feedbackui.slack.SlackFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author Marco Eigletsberger, 26.06.16.
 */
@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SampleFeedbackService implements FeedbackService {

    public static final String SLACK_TOKEN = "slack_token";
    public static final String SLACK_USERNAME = "slack_username";
    public static final String SLACK_CHANNEL = "slack_channel";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void processFeedback(FeedbackMessage feedbackMessage) {
        final SlackConfigurationProperties slackProperties = new SlackConfigurationProperties();
        slackProperties.setToken((String) httpSession.getAttribute(SLACK_TOKEN));
        slackProperties.setUsername((String) httpSession.getAttribute(SLACK_USERNAME));
        slackProperties.setChannel((String) httpSession.getAttribute(SLACK_CHANNEL));
        final SlackFeedbackService feedbackService = new SlackFeedbackService(slackProperties);
        feedbackService.processFeedback(feedbackMessage);
    }
}
