package co.ak.githubrepos.model;

/**
 * Created on 2019-01-12, 8:09 PM.
 *
 * @author Akram Shokri
 */
public class RepoAndLastCommits {
    private RepoModel repoModel;
    private CommitModel commitModel;

    public RepoAndLastCommits(RepoModel repoModel) {
        this.repoModel = repoModel;
    }

    public RepoModel getRepoModel() {
        return repoModel;
    }

    public void setRepoModel(RepoModel repoModel) {
        this.repoModel = repoModel;
    }

    public CommitModel getCommitModel() {
        return commitModel;
    }

    public void setCommitModel(CommitModel commitModel) {
        this.commitModel = commitModel;
    }
}
