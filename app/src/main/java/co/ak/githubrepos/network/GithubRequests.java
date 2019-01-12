package co.ak.githubrepos.network;

import java.util.ArrayList;

import co.ak.githubrepos.model.CommitModel;
import co.ak.githubrepos.model.RepoModel;
import co.ak.githubrepos.network.converter.ConvertJsonToCommitModel;
import co.ak.githubrepos.network.converter.ConvertJsonToRepoModel;
import co.ak.githubrepos.network.io.SCHttpRequest;

/**
 * Created on 2019-01-11, 3:45 PM.
 *
 * @author Akram Shokri
 */


public class GithubRequests {

    private static final String USERS_REPO = "https://api.github.com/users/%s/repos";
    private static final String REPO_COMMITS = "https://api.github.com/repos/%s/%s/commits";

    public ArrayList<RepoModel> getUserRepos(String username){
        SCHttpRequest scHttpRequest = new SCHttpRequest();
        return ConvertJsonToRepoModel
                .convertToRepoList(scHttpRequest.getData(String.format(USERS_REPO, username)));
    }

    public ArrayList<CommitModel> getRepoCommits(String username, String repoName){
        SCHttpRequest scHttpRequest = new SCHttpRequest();
        return ConvertJsonToCommitModel
                .convertToCommitList(scHttpRequest.getData(String.format(REPO_COMMITS, username, repoName)));
    }

}
