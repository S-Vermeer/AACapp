package com.example.aacvoca;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;
import com.google.firebase.storage.FirebaseStorage;

import java.io.IOException;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    public static final String BUTTONTEXT_KEY = "Text";
    public static final String SOUNDURL_KEY = "soundURL";
    public MediaPlayer mediaPlayer;

    Button button;
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("users/test/Groups/main/Buttons/7QOOsPk3zL9m5VtORHro");

    String[] buttonIDs = {"buttonh1v1", "buttonh1v2", "buttonh1v3", "buttonh1v4", "buttonh2v1", "buttonh2v2", "buttonh2v3", "buttonh2v4", "buttonh3v1", "buttonh3v2", "buttonh3v3", "buttonh3v4"};


    @Override
    protected void onStart() {
        super.onStart();
        button = findViewById(R.id.buttonh1v1);
        mDocRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    String buttonText = documentSnapshot.getString(BUTTONTEXT_KEY);

                    //Map<String, Object> myData = documentSnapshot.getData();
                    button.setText(buttonText);
                } else {
                    button.setText("noSnapshot");
                }
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );*/
    }

    public void SoundButtonOnClick(View view) {

        button = findViewById(R.id.buttonh1v1);
        button.setBackgroundColor(R.color.colorPrimary);
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String buttonText = documentSnapshot.getString(BUTTONTEXT_KEY);
                    String soundURL = documentSnapshot.getString(SOUNDURL_KEY);

                    /*try {
                        mediaPlayer.setDataSource(soundURL);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mediaPlayer.prepare(); // might take long! (for buffering, etc)
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();*/
                    //Map<String, Object> myData = documentSnapshot.getData();
                    button.setText(buttonText);
                } else {
                    button.setText("noSnapshot");
                }
            }
        });


    }
}

/*
String url = "http://........"; // your URL here
MediaPlayer mediaPlayer = new MediaPlayer();
mediaPlayer.setAudioAttributes(
    AudioAttributes.Builder()
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .setUsage(AudioAttributes.USAGE_MEDIA)
        .build()
);
mediaPlayer.setDataSource(url);
mediaPlayer.prepare(); // might take long! (for buffering, etc)
mediaPlayer.start();
 */