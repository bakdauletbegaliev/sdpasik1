import java.util.Collections;
import java.util.List;

public class Email {
    private final String sender;
    private final List<String> recipients;
    private final List<String> ccRecipients;
    private final String subject;
    private final String body;
    private final List<String> attachments;
    private final String priority;
    private final boolean isHtml;


    Email(String sender, List<String> recipients, List<String> ccRecipients,
          String subject, String body, List<String> attachments,
          String priority, boolean isHtml) {
        this.sender = sender;
        this.recipients = Collections.unmodifiableList(recipients);
        this.ccRecipients = Collections.unmodifiableList(ccRecipients);
        this.subject = subject;
        this.body = body;
        this.attachments = Collections.unmodifiableList(attachments);
        this.priority = priority;
        this.isHtml = isHtml;
    }

    public String getSender() { return sender; }
    public List<String> getRecipients() { return recipients; }
    public List<String> getCcRecipients() { return ccRecipients; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public List<String> getAttachments() { return attachments; }
    public String getPriority() { return priority; }
    public boolean isHtml() { return isHtml; }

    @Override
    public String toString() {
        return String.format(
                "Email [%n  From: %s%n  To: %s%n  Cc: %s%n  Subject: %s%n  Body: %s%n  Attachments: %s%n  Priority: %s%n  Format: %s%n]",
                sender, recipients, ccRecipients, subject, body, attachments, priority, isHtml ? "HTML" : "Plain Text"
        );
    }
}