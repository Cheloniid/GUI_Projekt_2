package model;

import model.entities.Player;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class DataToUpload {
    public String nickname;
    public long score;
    public LocalDateTime date;

    public String systemUserName;
    public String hostName;
    public String osName;

    public long secretCode;

    public DataToUpload(Player player){
        this.nickname = player.getName();
        this.score = player.getScore();
        this.date = LocalDateTime.now();

        this.systemUserName = System.getProperty("user.name");

        try {
            this.hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Error reading host name");
            this.hostName = "NA";
        }

        this.osName = System.getProperty("os.name");
        this.secretCode = generateCode();
    }

    public DataToUpload(String forbiddenNickname){
        this.nickname = forbiddenNickname;
        this.score = -1;
        this.date = LocalDateTime.now();

        this.systemUserName = System.getProperty("user.name");

        try {
            this.hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Error reading host name");
            this.hostName = "NA";
        }

        this.osName = System.getProperty("os.name");
    }

    private long generateCode(){
        long code = 89756;
        for (char c : this.nickname.toCharArray()) {
            code += c;
        }
        code += this.score;
        code *= this.date.getMinute();

        return code;
    }
}
