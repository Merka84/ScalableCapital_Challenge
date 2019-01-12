package co.ak.githubrepos;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import co.ak.githubrepos.callback.FetchCommitCallback;
import co.ak.githubrepos.callback.FetchRepoCallback;
import co.ak.githubrepos.model.CommitModel;
import co.ak.githubrepos.model.RepoAndLastCommits;
import co.ak.githubrepos.model.RepoModel;
import co.ak.githubrepos.repository.GithubCommitRepository;
import co.ak.githubrepos.repository.GithubRepoRepository;

public class MainActivity extends AppCompatActivity implements FetchRepoCallback, FetchCommitCallback {
    private RepoAdapter repoAdapter;
    private TextView repoUserText;
    private Button goButton;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ConstraintLayout rootLayout;
    private GithubRepoRepository repoRepository;
    private GithubCommitRepository commitRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        setupRecycleView();
        setClickListener();

        repoRepository = new GithubRepoRepository(this);
        commitRepository = new GithubCommitRepository(this);
    }

    private void bindView(){
        recyclerView = findViewById(R.id.repoRecycleView);
        repoUserText = findViewById(R.id.repoUser);
        goButton = findViewById(R.id.goButton);
        progressBar = findViewById(R.id.progressCircular);
        rootLayout = findViewById(R.id.rootLayout);
    }

    private void setupRecycleView(){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        repoAdapter = new RepoAdapter(new ArrayList<RepoAndLastCommits>());
        recyclerView.setAdapter(repoAdapter);
    }

    private void setClickListener(){
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String repoUser = repoUserText.getText().toString();

                if(!repoUser.isEmpty()){
                    repoRepository.getRepos(repoUser);
                    searchInProgressUI();
                    
                }
            }
        });
    }
    
    private void searchInProgressUI(){
        progressBar.setVisibility(View.VISIBLE);
        repoUserText.setEnabled(false);
        goButton.setEnabled(false);
    }

    private void searchDoneUI(){
        progressBar.setVisibility(View.GONE);
        repoUserText.setEnabled(true);
        goButton.setEnabled(true);
    }

    private void showNoResultUI(){
        Snackbar snackbar = Snackbar
                .make(rootLayout, R.string.no_result_msg, Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    private void fetchCommits() {
        for(int i = 0; i < repoAdapter.getRepoCommitList().size(); i++){
            RepoModel repoModel = repoAdapter.getRepoCommitList().get(i).getRepoModel();
            commitRepository.getCommits(repoModel.getOwner().getLogin(), repoModel.getName(), i);
        }
    }

    @Override
    public void onRepoListReady(ArrayList<RepoAndLastCommits> repoCommitList) {
        searchDoneUI();

        if(repoCommitList.size() > 0){ //repolist won't be null
            repoAdapter.setRepoCommitList(repoCommitList);
            repoAdapter.notifyDataSetChanged();
            fetchCommits();
        }else{
            showNoResultUI();
        }
    }

    @Override
    public void onCommitListReady(int position, CommitModel commitModel) {
        repoAdapter.getRepoCommitList().get(position).setCommitModel(commitModel);
        repoAdapter.notifyItemChanged(position);
    }
}
