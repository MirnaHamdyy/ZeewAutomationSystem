//package eu.zeewscript.SeleniumUtility;
//
//import jdk.dynalink.beans.StaticClass;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.testng.internal.TestResult;
//
//import java.net.http.HttpClient;
//import java.net.http.HttpResponse;
//
//import static com.applitools.eyes.TestResultsStatus.Failed;
//import static com.applitools.eyes.TestResultsStatus.Unresolved;
//
////
//public class EyeSlack {
//
//    @SuppressWarnings("unused")
//    public static void post(TestResult res, String slackWebhookURL) {
//
//        String color = "";
//        String fallback = "Applitools Test Results";
//
//        if (res.isAborted()) {
//            color = "A9A9A9";
//
//            switch (res.getStatus()) {
//                case Failed:
//                    color = "FF0000";
//                    fallback = "Test Failed " + res.getName();
//                    break;
//
//                case Passed:
//                    color = "36a64f";
//                    fallback = "Test successfully completed " + res.getName();
//                    break;
//
//                case Unresolved:
//                    color = "FFA500";
//                    fallback = "Test mismatch found" + res.getName();
//                    break;
//            }
//            HttpClient httpClient = HttpClientBuilder.create().build();
//            try {
//                HttpPost request = new HttpPost(slackWebhookURL);
//
//                StringEntity params = new StringEntity("{\n" +
//                        "   \"attachments\" : [\n +" +
//                        "   {\n" +
//                        "   \"fallback\": \"" + fallback + ".\",\n" +
//                        "   \"color\": \"#" + color + "\",\n" +
//                        "   \"pretext\"" + res.getStatus().toString() + "\",\n" +
//                        "   \"author_name\": \"Applitools.com\",\n" +
//                        "   \"author_link\": \"https://eyes.applitools.com\",\n" +
//                        "   \"author_icon\": \"https://applitools.com/images/favicon.ico\",\n" +
//                        "   \"title\": \"See Results\",\n" +
//                        "   \"title_link\": \"" + res.getAppUrls().getBatch() + "\",\n" +
//                        "   \"fields\":[\n" +
//                        "    {\n" +
//                        "   \"title\": \"App\",\n" +
//                        "   \"value\":\"" + res.getAppName() + "\",\n" +
//                        "   \"short\": true\n" +
//                        "   }\n," +
//                        "   {\n" +
//                        "   \"title\":\"Test\",\n" +
//                        "   \"value\":\"" + res.getName() + "\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "    {\n" +
//                        "   \"title\":\"Batch\",\n" +
//                        "   \"value\":\"" + res.getBatchName() + "\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "    {\n" +
//                        "   \"title\":\"OS\",\n" +
//                        "   \"value\":\"" + res.getHostOS() + "\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "    {\n" +
//                        "   \"title\":\"Browser\",\n" +
//                        "   \"value\":\"" + res.getHostApp() + "\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "    {\n" +
//                        "   \"title\":\"Viewport\",\n" +
//                        "   \"value\":\"" + res.getHostDisplaySize() + "\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "    {\n" +
//                        "   \"title\":\"Duration\",\n" +
//                        "   \"value\":\"" + res.getDuration() + "Seconds\",\n" +
//                        "    \"short\": true\n" +
//                        "    }\n," +
//                        "   ],\n" +
//                        "   \"footer\": \"Test Start Time\",\n" +
//                        "   \"footer_icon\": \"https://applitools.com/images/favicon.ico\",\n" +
//                        "   \"ts\": " + res.getStartedAt().geTimeInMillis() / 1000 + "\n" +
//                        "   }\n" +
//                        " ]\n" +
//                        "}");
//                request.addHeader("content-type", "application/x-www-form-urlencoded");
//                request.setEntity(params);
//                HttpResponse response = httpClient.execute(request);
//            } catch (Exception ex) {
//
//            }
//        }
//    }
//}
