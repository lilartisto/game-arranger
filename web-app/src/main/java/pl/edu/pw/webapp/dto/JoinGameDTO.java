package pl.edu.pw.webapp.dto;

public class JoinGameDTO {

    private Long gameId;

    public JoinGameDTO() {
    }

    public JoinGameDTO(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
