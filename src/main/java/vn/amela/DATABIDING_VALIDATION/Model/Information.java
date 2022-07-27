package vn.amela.DATABIDING_VALIDATION.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    @NotEmpty(message = "Name is empty")
    private String name;
    @NotEmpty(message = "Address is empty")
    private String address;
    @NotEmpty(message = "Phone number is empty")
    @Pattern(regexp = "^0.*$", message = "Phone number must start with 0", flags =         Pattern.Flag.CASE_INSENSITIVE)
    private String phoneNumber;
}
