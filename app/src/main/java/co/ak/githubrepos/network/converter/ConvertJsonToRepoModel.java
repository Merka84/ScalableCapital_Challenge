package co.ak.githubrepos.network.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.ak.githubrepos.model.OwnerModel;
import co.ak.githubrepos.model.RepoModel;

/**
 * Created on 2019-01-11, 3:02 PM.
 *
 * @author Akram Shokri
 */
public class ConvertJsonToRepoModel {

    public static OwnerModel convertToOwnerModel(JSONObject data) {
        OwnerModel ownerModel = new OwnerModel();

        try {
            if (data != null) {
                ownerModel.setAvatarUrl(data.getString("avatar_url"));
                ownerModel.setNodeId(data.getString("node_id"));
                ownerModel.setId(data.getInt("id"));
                ownerModel.setLogin(data.getString("login"));
                ownerModel.setGravatarId(data.getString("gravatar_id"));
                ownerModel.setUrl(data.getString("url"));
                ownerModel.setHtmlUrl(data.getString("html_url"));
                ownerModel.setType(data.getString("type"));
                ownerModel.setSiteAdmin(data.getBoolean("site_admin"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ownerModel;

    }

    public static RepoModel.License convertToLicense(Object obj) {
        RepoModel.License license = new RepoModel.License();
        JSONObject data;
        if(obj == null || "null".equalsIgnoreCase(obj.toString())){
            return license;
        }else {
            data = (JSONObject) obj;
        }

        try {
            if (data != null) {
                license.setKey(data.getString("key"));
                license.setName(data.getString("name"));
                license.setNodeId(data.getString("node_id"));
                license.setSpdxId(data.getString("spdx_id"));
                license.setUrl(data.getString("url"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return license;

    }

    public static ArrayList<RepoModel> convertToRepoList(JSONArray dataArray) {
        ArrayList repoList = new ArrayList();
        RepoModel repo;


        for (int i = 0; i < dataArray.length(); i++) {
            try {
                JSONObject data = dataArray.getJSONObject(i);
                repo = new RepoModel();

                repo.setId(data.getInt("id"));
                repo.setNodeId(data.getString("node_id"));
                repo.setName(data.getString("name"));
                repo.setFullName(data.getString("full_name"));

                repo.setOwner(convertToOwnerModel(data.getJSONObject("owner")));
                repo.setLicense(convertToLicense(data.get("license")));

                repo.setArchived(data.getBoolean("archived"));
                repo.setSize(data.getInt("size"));
                repo.setWatchersCount(data.getInt("watchers_count"));
                repo.setLanguage(data.getString("language"));
                repo.setHasIssues(data.getBoolean("has_issues"));
                repo.setHasWiki(data.getBoolean("has_wiki"));
                repo.setHasDownloads(data.getBoolean("has_downloads"));
                repo.setHasProjects(data.getBoolean("has_projects"));
                repo.setOpenIssuesCount(data.getInt("open_issues_count"));
                repo.setOpenIssues(data.getInt("open_issues"));
                repo.setFork(data.getBoolean("fork"));
                repo.setDescription(data.getString("description"));

                repo.setCloneUrl(data.getString("clone_url"));
                repo.setSshUrl(data.getString("ssh_url"));
                repo.setGitUrl(data.getString("git_url"));
                repo.setCommitsUrl(data.getString("commits_url"));
                repo.setGitCommitsUrl(data.getString("git_commits_url"));

                repo.setArchiveUrl(data.getString("archive_url"));

                repo.setAssigneesUrl(data.getString("assignees_url"));
                repo.setBlobsUrl(data.getString("blobs_url"));
                repo.setGitTagsUrl(data.getString("git_tags_url"));
                repo.setGitRefsUrl(data.getString("git_refs_url"));
                repo.setTreesUrl(data.getString("trees_url"));
                repo.setStatusesUrl(data.getString("statuses_url"));
                repo.setLanguagesUrl(data.getString("languages_url"));

                repoList.add(repo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return repoList;
    }


}
