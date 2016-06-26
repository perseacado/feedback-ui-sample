package org.github.perseacado.feedbackui.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.github.perseacado.feedbackui.sample.SampleFeedbackService.*;

/**
 * @author Marco Eigletsberger, 26.06.16.
 */
@Controller
@RequestMapping("/sample")
public class SampleFeedbackController {

    private static final String VIEW_FEEDBACK_SAMPLE = "feedback-sample";

    @RequestMapping(method = RequestMethod.GET)
    public String showSamplePage() {
        return VIEW_FEEDBACK_SAMPLE;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.POST)
    public String setProperties(
            @RequestParam String slackToken,
            @RequestParam String slackUsername,
            @RequestParam String slackChannel,
            HttpSession session) {
        session.setAttribute(SLACK_TOKEN, slackToken);
        session.setAttribute(SLACK_USERNAME, slackUsername);
        session.setAttribute(SLACK_CHANNEL, slackChannel);
        return "redirect:/sample";
    }
}