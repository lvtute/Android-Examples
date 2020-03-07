package com.example.learnlanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father","әpә", R.raw.family_father, R.drawable.family_father));
        words.add(new Word("mother","әṭa", R.raw.family_mother,R.drawable.family_mother));
        words.add(new Word("son","angsi", R.raw.family_son,R.drawable.family_son));
        words.add(new Word("daughter","tune", R.raw.family_daughter,R.drawable.family_daughter));
        words.add(new Word("older brother","taachi", R.raw.family_older_brother,R.drawable.family_older_brother));
        words.add(new Word("younger brother","chalitti",R.raw.family_younger_brother, R.drawable.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.raw.family_older_sister,R.drawable.family_older_sister));
        words.add(new Word("younger sister","kolliti",R.raw.family_younger_sister, R.drawable.family_younger_sister));
        words.add(new Word("grandmother","ama", R.raw.family_grandmother,R.drawable.family_grandmother));
        words.add(new Word("grandfather","paapa", R.raw.family_grandfather,R.drawable.family_grandfather));



        //
        WordAdapter itemsAdapter = new WordAdapter(this,words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);


                // Release the media player if it currently exists because we are about to
                // play a different sound file.
                releaseMediaPlayer();


                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release
                // the media player once the sounds has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompleteListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sound.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        // If the media player is not null, then it maybe currently playing a sound.
        if (mMediaPlayer != null){
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
