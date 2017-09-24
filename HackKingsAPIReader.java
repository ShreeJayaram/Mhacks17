
package com.example.prats.findmestats;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.*;

import java.io.*;

public class HackKingsAPIReader {
    public String readData(String identifiers) throws Exception {
        String urlString = "https://www.blackrock.com/tools/hackathon/performance";
        urlString += identifiers;
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();

        while ((inputLine = bufferedReader.readLine()) != null) {
            sb.append(inputLine + "\n");
        }

        String jsonString = sb.toString();
        bufferedReader.close();

        return jsonString;
    }
}
