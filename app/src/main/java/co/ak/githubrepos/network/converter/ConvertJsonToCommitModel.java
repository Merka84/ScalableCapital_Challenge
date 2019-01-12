package co.ak.githubrepos.network.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.ak.githubrepos.model.Commit;
import co.ak.githubrepos.model.CommitModel;

/**
 * Created on 2019-01-11, 9:22 PM.
 *
 * @author Akram Shokri
 */
public class ConvertJsonToCommitModel {

    public static ArrayList<CommitModel> convertToCommitList(JSONArray dataArray) {
        ArrayList commitList = new ArrayList();
        CommitModel commitModel;

        try {

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject data = dataArray.getJSONObject(0);
                commitModel = new CommitModel();

                commitModel.setAuthor(ConvertJsonToRepoModel.convertToOwnerModel(data.getJSONObject("author")));
                commitModel.setCommitter(ConvertJsonToRepoModel.convertToOwnerModel(data.getJSONObject("committer")));
                commitModel.setCommit(convertToCommit(data.getJSONObject("commit")));

                commitModel.setCommentsUrl(data.getString("comments_url"));
                commitModel.setHtmlUrl(data.getString("html_url"));
                commitModel.setUrl(data.getString("url"));
                commitModel.setNodeId(data.getString("node_id"));
                commitModel.setSha(data.getString("sha"));


                commitList.add(commitModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return commitList;
    }

    public static Commit convertToCommit(JSONObject data) {
        Commit commit = new Commit();

        try {
            if (data != null) {
                commit.setMessage(data.getString("message"));
                commit.setUrl(data.getString("url"));
                commit.setCommentCount(data.getInt("comment_count"));
                commit.setAuthor(convertToContributor(data.getJSONObject("author")));
                commit.setCommitter(convertToContributor(data.getJSONObject("committer")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return commit;
    }

    public static Commit.Contributor convertToContributor(JSONObject data) {
        Commit.Contributor contributor = new Commit.Contributor();

        try {
            if(data != null) {
                contributor.setName(data.getString("name"));
                contributor.setEmail(data.getString("email"));
                contributor.setDate(data.getString("date"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return contributor;
    }
}
