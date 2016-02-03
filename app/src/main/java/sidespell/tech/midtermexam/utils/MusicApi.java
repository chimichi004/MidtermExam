package sidespell.tech.midtermexam.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pak on 2/2/2016.
 */
public class MusicApi {
    public static final String BASE_URL     = "";
    public static final String IMG_BASE_URL = "";

    public static final int SUCCESS_CODE = 200;

    public static final String PARAM_QUERY   = "q";
    public static final String PARAM_MODE    = "mode";
    public static final String PARAM_API_KEY = "appId";
    private static final String LST_AlBUM   = "album";
    private static final String LST_CODE        = "cod";
    private static final String LST_MUSIC_NAME   = "name";
    private static final String LST_SINGER = "singer";
    private static final int LST_YEAR = 0;
    private static final String LST_BAND_NAME ="band_name";
    private static final String LST_SYS         = "sys";


    public static Music getMusic(Uri uri, @NonNull String requestMethod){
        String json = HttpUtils.getResponse(uri, requestMethod);
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        // Here we will now parse the json response and convert it into a Music object.
        final String name;
        final String album;
        final String singer;
        final int year;
        final String bandName;

        try {
            // 1) Convert the json string response into an actual JSON Object
            JSONObject jsonObject = new JSONObject(json);

            // 2) Get the status code
            int statusCode = jsonObject.getInt(LST_CODE);

            // 3) Check if the HTTP Status Code if it's valid or not
            if (statusCode == SUCCESS_CODE){

                name= jsonObject.getString(LST_MUSIC_NAME);
                JSONObject sys = jsonObject.getJSONObject(LST_SYS);
                album = sys.getString(LST_AlBUM);



            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }




}
