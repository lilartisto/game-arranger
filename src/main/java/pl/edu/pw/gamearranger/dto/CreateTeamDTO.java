package pl.edu.pw.gamearranger.dto;

public class CreateTeamDTO {

    private Long captainId;
    private String name;

    public CreateTeamDTO() {
    }

    public CreateTeamDTO(Long captainId, String name) {
        this.captainId = captainId;
        this.name = name;
    }

    public Long getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Long captainId) {
        this.captainId = captainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
