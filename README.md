# Email Builder Design Pattern Implementation

## Project Overview
This project demonstrates the **Builder Creational Design Pattern** in Java, applied to an **Email Construction Engine**. Constructing complex email objects with optional parameters (CC recipients, attachments, HTML formatting, priority levels) often leads to unwieldy telescoping constructors. This implementation provides a fluent API to step-by-step assemble emails and generate distinct representations (`HtmlEmail` and `SecureEmail`).

## Architecture & Representations
* **Product (`Email.java`)**: Immutable class representing the final constructed email.
* **Builder (`EmailBuilder.java` / `AbstractEmailBuilder.java`)**: Declares and implements step-by-step construction logic with method chaining.
* **Concrete Builders**:
    * `HtmlEmailBuilder.java`: Wraps email bodies in HTML markup.
    * `SecureEmailBuilder.java`: Forces HIGH priority, adds a `[SECURE]` prefix to subjects, and appends a legal confidentiality disclaimer.
* **Director (`EmailDirector.java`)**: Provides pre-configured builds for common workflows (`Welcome Email`, `System Alert`).

## How to Build and Run

### Prerequisites
* Java Development Kit (JDK) 11 or higher installed.

### Execution via Command Line
1. Navigate to the `src` directory:
   ```bash
   cd src