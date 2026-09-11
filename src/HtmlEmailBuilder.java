public class HtmlEmailBuilder extends AbstractEmailBuilder {

    public HtmlEmailBuilder() {
        this.isHtml = true;
    }

    @Override
    public Email build() {
        validateState();


        String htmlBody = body.startsWith("<html>") ? body : "<html><body><p>" + body + "</p></body></html>";

        return new Email(sender, recipients, ccRecipients, subject, htmlBody, attachments, priority, true);
    }
}

