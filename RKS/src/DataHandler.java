import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataHandler {
    public static String readFile(String file) throws IOException {
        StringBuilder stringBuilder;
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = null;
            stringBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public static String getTagStringValue(String data, String tagName) {
        data = data.replaceAll("\s", "");

        return data.substring(data.indexOf(tagName) + tagName.length() + 3,
                data.indexOf('\"', data.indexOf(tagName) + tagName.length() + 3));
    }

    public static int getTagIntValue(String data, String tagName) {
        data = data.substring(data.indexOf(tagName) + tagName.length() + 2);
        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(data);
        int endIndex = 0;

        if (matcher.find()) {
            endIndex = matcher.start();
        }

        return Integer.parseInt(data.substring(0, endIndex));
    }

    public static String[] getTagArray(String data, String tagName) {
        data = data.substring(data.indexOf(tagName) + tagName.length());
        data = data.substring(data.indexOf("[") + 1, data.indexOf("]")).trim();

        String[] dataArray = data.replaceAll("[\s]", "").split(",");
        int dataArraySize = dataArray.length / 3;
        String[] result = new String[dataArraySize];

        for (int i = 0; i < dataArray.length; i += 3) {
            result[i / 3] = dataArray[i] + dataArray[i + 1] + dataArray[i + 2];
        }

        return result;
    }
}
