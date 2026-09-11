public interface EmailBuilder {
    EmailBuilder setSender(String sender);
    EmailBuilder addRecipient(String recipient);
    EmailBuilder addCcRecipient(String ccRecipient);
    EmailBuilder setSubject(String subject);
    EmailBuilder setBody(String body);
    EmailBuilder addAttachment(String filePath);
    EmailBuilder setPriority(String priority);
    EmailBuilder setHtmlFormat(boolean isHtml);
    Email build();
}