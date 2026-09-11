public class SecureEmailBuilder extends AbstractEmailBuilder {

    private static final String CONFIDENTIAL_DISCLAIMER =
            "\n\n--- CONFIDENTIAL ---\nThis email and any attachments are confidential and intended solely for the recipient.";

    public SecureEmailBuilder() {
        this.priority = "HIGH";
        this.isHtml = false;
    }

    @Override
    public Email build() {
        validateState();

        String securedSubject = "[SECURE] " + subject;
        String securedBody = body + CONFIDENTIAL_DISCLAIMER;

        return new Email(sender, recipients, ccRecipients, securedSubject, securedBody, attachments, priority, false);
    }
}