// Exercise 1: User Validation
public record UserForm(String email, String password, int age) {
    // Compact constructor — validates on creation
    public UserForm {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank.");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be blank.");
        }
    }
}
