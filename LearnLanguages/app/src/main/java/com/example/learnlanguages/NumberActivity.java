package com.example.learnlanguages;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

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
        words.add(new Word("one","lutti", R.raw.number_one, R.drawable.number_one));
        words.add(new Word("two","otiiko", R.raw.number_two,R.drawable.number_two));
        words.add(new Word("three","tolookosu", R.raw.number_three,R.drawable.number_three));
        words.add(new Word("four","oyyisa", R.raw.number_four,R.drawable.number_four));
        words.add(new Word("five","massokka", R.raw.number_five,R.drawable.number_five));
        words.add(new Word("six","temmoka", R.raw.number_six,R.drawable.number_six));
        words.add(new Word("seven","kenekaku", R.raw.number_seven,R.drawable.number_seven));
        words.add(new Word("eight","kawinta", R.raw.number_eight,R.drawable.number_eight));
        words.add(new Word("nine","wo'e", R.raw.number_nine,R.drawable.number_nine));
        words.add(new Word("ten","na'aacha", R.raw.number_ten,R.drawable.number_ten));


        //
        WordAdapter itemsAdapter = new WordAdapter(this,words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file.
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumberActivity.this, word.getmAudioResourceId());
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
