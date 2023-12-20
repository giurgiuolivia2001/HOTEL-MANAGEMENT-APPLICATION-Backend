package ro.fortech.project.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UpdateUserRequest {
    @Schema(example = "6", required = true)
    private Long id;
    @Schema(example = "test", required = true)
    private String username;

    @Schema(example = "test2@yahoo.com", required = true)
    private String email;
    @Schema(example = "[\"client\"]", required = true)
    private List<String> roles;
    @Schema(example = "test123", required = true)
    private String password;

    @Schema(example = "TestUpdate", required = true)
    private String firstName;

    @Schema(example = "TestUpdate", required = true)
    private String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRole() {
        return this.roles;
    }

    public void setRole(List<String> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
