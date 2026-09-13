public class EmailDirector {

    public Email constructWelcomeEmail(EmailBuilder builder, String recipientEmail, String userName) {
        return builder
                .setSender("no-reply@company.com")
                .addRecipient(recipientEmail)
                .setSubject("Welcome to Our Platform!")
                .setBody("Hello " + userName + ",\n\nThank you for joining us. We are excited to have you on board!")
                .setPriority("NORMAL")
                .build();
    }

    public Email constructSystemAlert(EmailBuilder builder, String adminEmail, String alertDetails) {
        return builder
                .setSender("alert-system@company.com")
                .addRecipient(adminEmail)
                .setSubject("CRITICAL: System Incident Detected")
                .setBody("System Administrator,\n\nAn anomaly was detected:\n" + alertDetails)
                .setPriority("URGENT")
                .build();
    }

    public Email constructPasswordResetEmail(EmailBuilder builder, String recipientEmail, String resetToken) {
        return builder
                .setSender("security@company.com")
                .addRecipient(recipientEmail)
                .setSubject("Password Reset Request")
                .setBody("You requested a password reset. Use this token: " + resetToken + "\nIf you did not request this, ignore this email.")
                .setPriority("HIGH")
                .build();
    }
}