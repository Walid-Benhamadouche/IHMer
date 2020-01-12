import java.util.Date;

public class Replie {
    private String userNameReplie;
    private String textReplie;
    Date date;

    public Replie(String userNameReplie, String textReplie) {
        this.userNameReplie = userNameReplie;
        this.textReplie = textReplie;
    }

    public String getUserNameReplie() {
        return userNameReplie;
    }
    public String getTextReplie() {
        return textReplie;
    }

    public Date getDate() {
        return date;
    }

    public void setUserNameReplie(String userNameReplie) {
        this.userNameReplie = userNameReplie;
    }

    public void setTextReplie(String textReplie) {
        this.textReplie = textReplie;
    }
}
