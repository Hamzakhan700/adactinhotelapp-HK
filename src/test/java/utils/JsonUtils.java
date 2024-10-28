package utils;


import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static Object[][] readJsonData(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            Object[][] data = new Object[jsonArray.length()][jsonArray.getJSONObject(0).length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                data[i][0] = jsonObject.getString("username");
                data[i][1] = jsonObject.getString("password");
                data[i][2] = jsonObject.getString("location");
                data[i][3] = jsonObject.getString("checkin");
                data[i][4] = jsonObject.getString("checkout");
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
