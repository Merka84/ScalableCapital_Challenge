package co.ak.githubrepos.repository;

import android.os.AsyncTask;

import java.util.ArrayList;

import co.ak.githubrepos.callback.FetchCommitCallback;
import co.ak.githubrepos.model.CommitModel;
import co.ak.githubrepos.network.GithubRequests;

/**
 * Created on 2019-01-11, 10:35 PM.
 *
 * @author Akram Shokri
 */

public class GithubCommitRepository {

    private AsyncTask<String, Void, Void> asyncTask;
    private GithubRequests request;
    private ArrayList<CommitModel> commitList;
    private FetchCommitCallback callback;

    public GithubCommitRepository(FetchCommitCallback callback) {
        this.callback = callback;
        this.request = new GithubRequests();
    }

    public void getCommits(String repoUserName, String repoName, int position){
        asyncTask = new AsyncTask<String, Void, Void>() {
            private int index;

            @Override
            protected Void doInBackground(String... args) {
                if(args.length == 3) {
                    index = Integer.parseInt(args[2]);
                    commitList = request.getRepoCommits(args[0], args[1]);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                CommitModel commitModel = new CommitModel();
                if(commitList.size() > 0) {
                    commitModel = commitList.get(0);
                }
                callback.onCommitListReady(index, commitModel);
            }
        }.execute(repoUserName, repoName, String.valueOf(position));
    }
}
