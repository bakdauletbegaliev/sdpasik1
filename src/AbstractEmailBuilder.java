import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEmailBuilder implements EmailBuilder {
    protected String sender;
    protected final List<String> recipients = new ArrayList<>();
    protected final List<String> ccRecipients = new ArrayList<>();
    protected String subject = "";
    protected String body = "";
    protected final List<String> attachments = new ArrayList<>();
    protected String priority = "NORMAL";
    protected boolean isHtml = false;

    @Override
    public EmailBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public EmailBuilder addRecipient(String recipient) {
        if (recipient != null && !recipient.isBlank()) {
            this.recipients.add(recipient);
        }
        return this;
    }

    @Override
    public EmailBuilder addCcRecipient(String ccRecipient) {
        if (ccRecipient != null && !ccRecipient.isBlank()) {
            this.ccRecipients.add(ccRecipient);
        }
        return this;
    }

    @Override
    public EmailBuilder setSubject(String subject) {
        this.subject = subject != null ? subject : "";
        return this;
    }

    @Override
    public EmailBuilder setBody(String body) {
        this.body = body != null ? body : "";
        return this;
    }

    @Override
    public EmailBuilder addAttachment(String filePath) {
        if (filePath != null && !filePath.isBlank()) {
            this.attachments.add(filePath);
        }
        return this;
    }

    @Override
    public EmailBuilder setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public EmailBuilder setHtmlFormat(boolean isHtml) {
        this.isHtml = isHtml;
        return this;
    }

    protected void validateState() {
        if (sender == null || sender.isBlank()) {
            throw new IllegalStateException("Email creation failed: 'sender' address is required.");
        }
        if (recipients.isEmpty()) {
            throw new IllegalStateException("Email creation failed: At least one recipient is required.");
        }
    }

    @Override
    public abstract Email build();
}