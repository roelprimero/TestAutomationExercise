import org.junit.Assert;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class KnowItQAExercises
{
    public String [] convertStringToArrayofString(String strInput){
        String after = strInput.trim().replaceAll(" +", " ");
        String[] output = after.split(" ");
        return output;
    }

    public String cleanURL(String strInput)
    {
        String output = strInput.split("service: ")[1].split("};")[0];
        output = output.replace("test", "prod");
        return output;
    }

    public Boolean dateRegex(String strInput)
    {
        String digits  = strInput.split("\\.")[1];
        int number =   Integer.parseInt(digits);
        return number >= 0 && number <= 31;
    }

    private final static String JSON_DATA =
        "{"
        + "  \"definition\": ["
        +       "{"
        + "  \"foo\":["
        +     "{"
        + "      \"defaultValue\" : \"defaultfoo\""
        + "     }"
        + "    ],"
        + "  \"bar\":["
        +     "{"
        + "      \"defaultValue\" : \"defaultbar\""
        + "     }"
        + "    ],"
        + "  \"baz\":["
        +     "{"
        + "      \"defaultValue\" : \"defaultbaz\""
        + "     }"
        + "    ],"
        + "  \"anyOther\":["
        +     "{"
        + "      \"defaultValue\" : \"defaultanyOther\""
        + "     }"
        + "    ]"
        + " }"
        + "]"
        + "}";


    public void jsonLikeData(String jsonData)
    {
        //treat the data as a JSON object and use an external library located in https://mvnrepository.com/artifact/org.json/json/20220320
        final JSONObject obj = new JSONObject(jsonData);
        final JSONArray definition = obj.getJSONArray("definition");
        JSONObject entry = definition.getJSONObject(0);

        // Parse as a Map
        Map<String, Object> myMap = entry.toMap();

        // Go through each of the element and print the key and value
        myMap.forEach(
                (key, value) -> System.out.println(((HashMap) ((ArrayList) value).get(0)).get("defaultValue"))
        );
    }

    @Test
    public void exercise12(){
        String myName = "Jason";
        String str = "   My    name           is    "  +  myName;
        String [] expectOutput = {"My", "name", "is", "Jason"};
        Assert.assertEquals(expectOutput, convertStringToArrayofString(str));

        myName = "          JohnPatino          ";
        str = "          My    name           is    "  +  myName;
        expectOutput = new String[]{"My", "name", "is", "JohnPatino"};
        Assert.assertEquals(expectOutput, convertStringToArrayofString(str));
    }

    @Test
    public void exercise13(){
        String textResponse = "Strict.Respongh//ghghhghjgse.Object = {service: https://e1qiuyo7uo5.execute-api.eu-central-1.amazonaws.com/test/discover};";
        String expectOutput = "https://e1qiuyo7uo5.execute-api.eu-central-1.amazonaws.com/prod/discover";
        Assert.assertEquals(expectOutput, cleanURL(textResponse));
    }

    @Test
    public void exercise14(){
        Assert.assertEquals(true, dateRegex("Date.01"));
        Assert.assertEquals(true, dateRegex("Date.05"));
        Assert.assertEquals(true, dateRegex("Date.31"));
        Assert.assertEquals(false, dateRegex("Date.32"));
        Assert.assertEquals(false, dateRegex("Date.-1456452"));
    }

    @Test
    public void exercise15(){
        jsonLikeData(JSON_DATA);
    }
}
