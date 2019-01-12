package co.ak.githubrepos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.ak.githubrepos.model.RepoAndLastCommits;

/**
 * Created on 2019-01-11, 11:23 PM.
 *
 * @author Akram Shokri
 */

public class RepoAdapter extends RecyclerView.Adapter <RepoAdapter.RepoViewHolder>{
    private ArrayList<RepoAndLastCommits> repoCommitList;

    public RepoAdapter(ArrayList<RepoAndLastCommits> repoList) {
        this.repoCommitList = repoList;
    }


    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_list_item, parent, false);
        RepoViewHolder vh = new RepoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        String description = repoCommitList.get(i).getRepoModel().getDescription();
        repoViewHolder.descriptionText.setText(description != null && !"null".equalsIgnoreCase(description) ? description : "-");
        String language = repoCommitList.get(i).getRepoModel().getLanguage();
        repoViewHolder.languageText.setText(language != null && !"null".equalsIgnoreCase(language) ? language : "NA");
        repoViewHolder.repoNameText.setText(repoCommitList.get(i).getRepoModel().getName());
        repoViewHolder.forkCountText.setText(String.valueOf(repoCommitList.get(i).getRepoModel().getForksCount()));
        repoViewHolder.countText.setText("#" + (i+1));
        if(repoCommitList.get(i).getCommitModel() != null){
            repoViewHolder.commitText.setVisibility(View.VISIBLE);
            String sha = repoCommitList.get(i).getCommitModel().getSha();
            repoViewHolder.commitText.setText(sha != null ? sha : "No commit");
        }
    }


    @Override
    public int getItemCount() {
        return repoCommitList.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        public TextView forkCountText;
        public TextView descriptionText;
        public TextView languageText;
        public TextView repoNameText;
        public TextView countText;
        public TextView commitText;

        public RepoViewHolder(View v) {
            super(v);
            forkCountText = v.findViewById(R.id.forkValue);
            descriptionText = v.findViewById(R.id.descriptionValue);
            languageText = v.findViewById(R.id.languageValue);
            repoNameText = v.findViewById(R.id.repoNameValue);
            countText = v.findViewById(R.id.countValue);
            commitText = v.findViewById(R.id.lastCommit);
        }
    }

    public void setRepoCommitList(ArrayList<RepoAndLastCommits> repoCommitList) {
        this.repoCommitList = repoCommitList;
    }

    public ArrayList<RepoAndLastCommits> getRepoCommitList() {
        return repoCommitList;
    }
}
