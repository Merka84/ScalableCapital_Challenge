package co.ak.githubrepos.model;

/**
 * Created on 2019-01-11, 4:05 PM.
 *
 * @author Akram Shokri
 */
public class Commit {
    private Contributor author;
    private Contributor committer;
    private String message;
    private Node tree;
    private String url;
    private int commentCount;
    private Verification verification;

    public Contributor getAuthor() {
        return author;
    }

    public void setAuthor(Contributor author) {
        this.author = author;
    }

    public Contributor getCommitter() {
        return committer;
    }

    public void setCommitter(Contributor committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Node getTree() {
        return tree;
    }

    public void setTree(Node tree) {
        this.tree = tree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public static class Contributor {

        private String name;
        private String email;
        private String date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class Verification {

        private boolean verified;
        private String reason;

        public boolean isVerified() {
            return verified;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class Node {
        private String sha;
        private String url;
        private String htmlUrl;

        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
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
    }

}
