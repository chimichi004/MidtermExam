package sidespell.tech.midtermexam.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import sidespell.tech.midtermexam.BuildConfig;
import sidespell.tech.midtermexam.R;
import sidespell.tech.midtermexam.utils.Music;
import sidespell.tech.midtermexam.utils.MusicApi;

import static sidespell.tech.midtermexam.R.menu.menu_main;

public class MainFragment extends Fragment {


    private EditText etAlbum;
    private RecyclerView rv;


      private ImageView mImgIcon;
      private TextView    mName;
      private TextView    mDetails;
      private ProgressBar mProgressBar;
      private TextView    mTvError;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // TODO: Find all views here.
            etAlbum = (EditText) container.findViewById(R.id.etAlbum);
      //  listView = (ListView)container.findViewById(R.id.listView);
        mName = (TextView) view.findViewById(R.id.music_name);
        mImgIcon = (ImageView) view.findViewById(R.id.music_img);
        mDetails = (TextView) view.findViewById(R.id.music_detail);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mTvError = (TextView) view.findViewById(android.R.id.empty);




        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic operations here..
    }

    public class FetchMuscTask extends AsyncTask<String, Void, Music> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
            mTvError.setVisibility(View.GONE);
            mName.setVisibility(View.GONE);
            mDetails.setVisibility(View.GONE);
        }

        @Override
        protected Music doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            String city = params[0];

            Uri builtUri = Uri.parse(MusicApi.BASE_URL).buildUpon()
                    .appendQueryParameter(MusicApi.PARAM_QUERY,"album")
                    .appendQueryParameter(MusicApi.PARAM_MODE, "json")
                    .appendQueryParameter(MusicApi.PARAM_API_KEY,
                            BuildConfig.MIDTERM_EXAM_API_KEY)
                    .build();

            return MusicApi.getMusic(builtUri, "GET");
        }

        @Override
        protected void onPostExecute(Music w) {
            if (w == null) {
                // TODO: Set empty view
                mTvError.setVisibility(View.VISIBLE);
                mName.setVisibility(View.GONE);
                mDetails.setVisibility(View.GONE);
                return;
            }

            mProgressBar.setVisibility(View.GONE);
            mTvError.setVisibility(View.GONE);
            mName.setVisibility(View.VISIBLE);
            mTvError.setVisibility(View.VISIBLE);



        }
    }

}
