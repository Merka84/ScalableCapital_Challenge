package co.ak.githubrepos.callback;

import java.util.ArrayList;

import co.ak.githubrepos.model.RepoAndLastCommits;

/**
 * Created on 2019-01-12, 12:22 AM.
 *
 * @author Akram Shokri
 */
public interface FetchRepoCallback {

    void onRepoListReady(ArrayList<RepoAndLastCommits> repoCommitList);

}
