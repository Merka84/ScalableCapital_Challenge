package co.ak.githubrepos.repository;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import co.ak.githubrepos.callback.FetchRepoCallback;
import co.ak.githubrepos.model.RepoAndLastCommits;
import co.ak.githubrepos.model.RepoModel;
import co.ak.githubrepos.network.GithubRequests;

/**
 * Created on 2019-01-11, 10:35 PM.
 *
 * @author Akram Shokri
 */

public class GithubRepoRepository {
    private AsyncTask<String, Void, Void> asyncTask;
    private GithubRequests request;
    private ArrayList<RepoAndLastCommits> repoWithCommitList;
    private FetchRepoCallback callback;

    public GithubRepoRepository(FetchRepoCallback callback) {
        this.callback = callback;
        this.request = new GithubRequests();
    }


    //for task #3, below method will become two methods: queryDb() and fetchRepos(),
    //first queryDb() will be called to query db and get data from it and fetchRepos()
    // will be called as well to update persisted data and it will notify queryDb()
    // to post updated data to UI via callback

    public void getRepos(String repoUserName){
        asyncTask = new AsyncTask<String, Void, Void>() {
            private ArrayList<RepoModel> repos;

            @Override
            protected Void doInBackground(String... args) {
                repos = request.getUserRepos(args[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                repoWithCommitList = new ArrayList<>();
                for(RepoModel repo: repos){
                    RepoAndLastCommits r = new RepoAndLastCommits(repo);
                    repoWithCommitList.add(r);
                }
                callback.onRepoListReady(repoWithCommitList);
            }
        }.execute(repoUserName);
    }
}
