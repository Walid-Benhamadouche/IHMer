import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Date;

public class Question {
    private String userName;
    private String qst;
    Date date;
    private ArrayList <Replie> replies;//, ArrayList replies
    public Question (String userName,String qst){
        this.userName=userName;
        this.qst=qst;
        this.replies=new ArrayList<>();
    }
    public void addReplie(String userNameReplie, String textReplie){
        Replie reply = new Replie(userNameReplie,textReplie);
        replies.add(reply);

    }

    public Replie getReply(int index){
        return replies.get(index);
    }

    public String getUserName() {
        return userName;
    }

    public String getQst() {
        return qst;
    }
    public int getRepliesCnter(){
        return replies.size();
    }

    public ArrayList<Replie> getReplies() {
        return replies;
    }
}
