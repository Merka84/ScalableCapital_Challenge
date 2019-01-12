package co.ak.githubrepos.network;

import android.support.test.runner.AndroidJUnit4;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.ak.githubrepos.network.io.SCHttpRequest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created on 2019-01-11, 2:21 PM.
 *
 * @author Akram Shokri
 */

@RunWith(AndroidJUnit4.class)
public class CreateRequestTest {

    @Test
    public void getDataTest(){
        SCHttpRequest createRequest = new SCHttpRequest();
        JSONArray json = createRequest.getData("https://api.github.com/users/mralexgray/repos");
        assertNotNull(json);
        assertTrue(json.length() > 0);

    }
}
