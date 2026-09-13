import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEmailBuilder implements EmailBuilder {
    protected String sender;
    protected final List<String> recipients = new ArrayList<>();
    protected final List<String> ccRecipients = new ArrayList<>();
    protected String subject;
    protected String body;
    protected final List<String> attachments = new ArrayList<>();
    protected String priority = "NORMAL";
    protected boolean isHtml = false;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    @Override
    public EmailBuilder setSender(String sender) {
        if (sender != null && !isValidEmail(sender)) {
            throw new IllegalArgumentException("Invalid sender email format: " + sender);
        }
        this.sender = sender;
        return this;
    }

    @Override
    public EmailBuilder addRecipient(String recipient) {
        if (recipient != null && !recipient.isBlank()) {
            if (!isValidEmail(recipient)) {
                throw new IllegalArgumentException("Invalid recipient email format: " + recipient);
            }
            this.recipients.add(recipient);
        }
        return this;
    }

    @Override
    public EmailBuilder addCcRecipient(String ccRecipient) {
        if (ccRecipient != null && !ccRecipient.isBlank()) {
            if (!isValidEmail(ccRecipient)) {
                throw new IllegalArgumentException("Invalid CC email format: " + ccRecipient);
            }
            this.ccRecipients.add(ccRecipient);
        }
        return this;
    }

    @Override
    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public EmailBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public EmailBuilder addAttachment(String attachmentPath) {
        if (attachmentPath != null && !attachmentPath.isBlank()) {
            this.attachments.add(attachmentPath);
        }
        return this;
    }

    @Override
    public EmailBuilder setPriority(String priority) {
        if (priority != null && !priority.isBlank()) {
            this.priority = priority.toUpperCase();
        }
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
}