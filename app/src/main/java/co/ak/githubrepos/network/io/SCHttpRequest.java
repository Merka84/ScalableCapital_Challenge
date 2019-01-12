package co.ak.githubrepos.network.io;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import co.ak.githubrepos.network.RequestType;

/**
 * Created on 2019-01-11, 2:07 PM.
 *
 * @author Akram Shokri
 */

public class SCHttpRequest {

    private static final int READ_TIMEOUT = 10000;    // milliseconds
    private static final int CONNECT_TIMEOUT = 15000; // milliseconds

    HttpURLConnection urlConnection = null;
    URL url;

    public JSONArray getData(String urlStr) {
        try {
            url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(RequestType.GET.name());
            urlConnection.setReadTimeout(READ_TIMEOUT);
            urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            String jsonString = sb.toString();


            return new JSONArray(jsonString);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }


}
