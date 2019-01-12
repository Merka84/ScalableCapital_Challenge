package co.ak.githubrepos.callback;

import co.ak.githubrepos.model.CommitModel;

/**
 * Created on 2019-01-12, 7:44 PM.
 *
 * @author Akram Shokri
 */
public interface FetchCommitCallback {

    void onCommitListReady(int position, CommitModel commitModel);
}
