package pl.edu.pw.gamearranger.restapi.dto;

public class CreatePlayerDTO {

    private String firstName;
    private String lastName;

    public CreatePlayerDTO() {

    }

    public CreatePlayerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
