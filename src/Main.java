import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var inputStream = new BufferedReader(new FileReader("active_deposits.txt"));
        var userIds = new StringBuilder();
        userIds.append("(");
        int i = 0;
        var userId = inputStream.readLine();;
        while (userId != null) {
            System.out.println(userId);
            userIds.append("'").append(userId).append("',");
            userId = inputStream.readLine();
            i++;
        }
        userIds.deleteCharAt(userIds.length() - 1);
        userIds.append(")");
        System.out.println(i);
        System.out.println(userIds);
    }

}
