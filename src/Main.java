// Test client execution
public class Main {
    public static void main(String[] args) {
        EmailDirector director = new EmailDirector();

        EmailBuilder htmlBuilder = new HtmlEmailBuilder();
        Email welcomeEmail = director.constructWelcomeEmail(htmlBuilder, "john.doe@example.com", "John Doe");
        System.out.println("=== DIRECTED HTML EMAIL ===");
        System.out.println(welcomeEmail);

        EmailBuilder secureBuilder = new SecureEmailBuilder();
        Email alertEmail = director.constructSystemAlert(secureBuilder, "admin@company.com", "Database CPU usage > 95%");
        System.out.println("=== DIRECTED SECURE EMAIL ===");
        System.out.println(alertEmail);

        Email passwordResetEmail = director.constructPasswordResetEmail(htmlBuilder, "user@example.com", "TOKEN-98765");
        System.out.println("=== DIRECTED PASSWORD RESET EMAIL ===");
        System.out.println(passwordResetEmail);

        Email customSecureEmail = new SecureEmailBuilder()
                .setSender("legal@company.com")
                .addRecipient("client@external.com")
                .addCcRecipient("partner@external.com")
                .setSubject("Contract Review")
                .setBody("Please find attached the updated terms for Q4.")
                .addAttachment("/docs/contract_q4.pdf")
                .build();

        System.out.println("=== CUSTOM SECURE EMAIL ===");
        System.out.println(customSecureEmail);

        try {
            System.out.println("=== VALIDATION TEST ===");
            new HtmlEmailBuilder()
                    .setSubject("Invalid Email Test")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Caught Expected Error: " + e.getMessage());
        }
    }
}