package co.ak.githubrepos.model;

import java.util.List;

/**
 * Created on 2019-01-11, 3:58 PM.
 *
 * @author Akram Shokri
 */

public class CommitModel {
    private String sha;
    private String nodeId;
    private Commit commit;
    private String url;
    private String htmlUrl;
    private String commentsUrl;
    private OwnerModel author;
    private OwnerModel committer;
    private List<Commit.Node> parents = null;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public OwnerModel getAuthor() {
        return author;
    }

    public void setAuthor(OwnerModel author) {
        this.author = author;
    }

    public OwnerModel getCommitter() {
        return committer;
    }

    public void setCommitter(OwnerModel committer) {
        this.committer = committer;
    }

    public List<Commit.Node> getParents() {
        return parents;
    }

    public void setParents(List<Commit.Node> parents) {
        this.parents = parents;
    }
}
