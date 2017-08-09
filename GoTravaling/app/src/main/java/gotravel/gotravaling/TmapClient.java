package gotravel.gotravaling;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by sexytreetrunks on 2017-07-26.
 */

public class TmapClient extends AsyncTask<String, Void, Void> {
    private String stringURL = "https://apis.skplanetx.com/tmap/routes/pedestrian?version=1&format=xml&appKey="+APP_KEY;
    private static final String APP_KEY = "df216313-6d2c-32a6-aa05-ad4d7ac44879";
    private URL url;
    private Document responseDocument;
    @Override
    protected Void doInBackground(String... params) {
        String outputParam = "startX=" + params[0] + "&startY=" + params[1] + "&endX=" + params[2] + "&endY=" + params[3]
                + "&startName=start&endName=end&reqCoordType=WGS84GEO&resCoordType=WGS84GEO";
        try {
            url = new URL(stringURL);

            //커넥션관련 세팅
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);

            //tmap서버에 데이터 요청
            OutputStream outputStream = httpUrlConn.getOutputStream();
            outputStream.write(outputParam.getBytes());
            outputStream.flush();
            outputStream.close();

            //요청한 데이터 얻어오기
            String buffer = null;
            int httpResult = httpUrlConn.getResponseCode();
            if(httpResult == HttpURLConnection.HTTP_OK) {
                Log.i("---TmapClient","데이터 얻어오기 성공");
                responseDocument = parseXML(httpUrlConn.getInputStream());

            } else {
                Log.e("---TmapClient error","HttpResult: "+Integer.toString(httpResult));
                BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getErrorStream()));
                String errorString = null;
                while((errorString = br.readLine())!=null) {
                    Log.e("---httpErrorStream",errorString);
                }
            }
            httpUrlConn.disconnect();
        } catch (MalformedURLException e) {
            Log.e("---TmapClient","URL형식 예러");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document parseXML(InputStream inputStream) {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try{
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
            doc = objDocumentBuilder.parse(inputStream);
        }catch(Exception ex){
            Log.e("---TmapClient error","parseXML error");
        }
        return doc;
    }

    public ArrayList<Location> getPathPoints() {
        Element root = responseDocument.getDocumentElement();
        ArrayList<Location> pathPoints = new ArrayList<Location>();

        try {
            NodeList nodeList = root.getElementsByTagName("Placemark");
            for (int i = 1; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String nodeType = element.getElementsByTagName("tmap:nodeType").item(0).getTextContent();
                String coordinates = null;
                if (nodeType.contains("LINE")) {
                    coordinates = element.getElementsByTagName("LineString").item(0).getTextContent();
                    Log.i("****TmapClient","coordinate: " + coordinates);
                } else {
                    coordinates = element.getElementsByTagName("Point").item(0).getTextContent();
                    Log.i("****TmapClient","coordinate: " + coordinates);

                }

                StringTokenizer splitedLocationTokens = new StringTokenizer(coordinates, " ");
                splitedLocationTokens.nextToken();
                for (int j = 0; splitedLocationTokens.hasMoreElements(); j++) {
                    StringTokenizer locationTokens = new StringTokenizer(splitedLocationTokens.nextToken(), ",");
                    Location location;
                    if(nodeType.contains("LINE"))
                        location = new Location("Line");
                    else
                        location = new Location("Point");
                    for (int k = 0; locationTokens.hasMoreElements(); k++) {
                        location.setLongitude(Double.valueOf(locationTokens.nextToken()));
                        location.setLatitude(Double.valueOf(locationTokens.nextToken()));
                        pathPoints.add(location);
                    }
                }

            }
        } catch (Exception ex) {
            Log.e("****TmapClient error","getPathPoints error");
        }
        return pathPoints;
    }

    public String getTotalTime() {
        Element root = responseDocument.getDocumentElement();
        String totalTime = root.getElementsByTagName("tmap:totalTime").item(0).getTextContent();

        return totalTime;
    }

    public String getTotalDistance() {
        Element root = responseDocument.getDocumentElement();
        String totalDistance = root.getElementsByTagName("tmap:totalDistance").item(0).getTextContent();

        return totalDistance;
    }
}
