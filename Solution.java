import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String setNumbers = "0 1 2 3 4 5 6 7 8 9";
        String setSymbols = "A E I O U Y B C D F G H J K L M N P Q R S T V W X Z";


        List<String[]> strings = new ArrayList<>();
        strings.add(setNumbers.split(" "));
        strings.add(setSymbols.split(" "));

        Random random = new Random();

        StringBuilder stringBuffer = new StringBuilder();
        int count = 0;

        for (int i = 0; i < 8; i++) {
            String[] string = strings.get(random.nextInt(2));
            if (string.length > 10) {
                if (random.nextBoolean() && count < 2) {
                    stringBuffer.append(string[random.nextInt(26)].toUpperCase());
                    count++;
                } else {
                    stringBuffer.append(string[random.nextInt(26)].toLowerCase());
                }
            } else {
                stringBuffer.append(string[random.nextInt(10)]);
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream byteArrayInputStream = new ByteArrayInputStream(stringBuffer.toString().getBytes());
        BufferedInputStream inputStream = new BufferedInputStream(byteArrayInputStream);
        try {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                byteArrayOutputStream.write(data);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }


        return byteArrayOutputStream;
    }
}
