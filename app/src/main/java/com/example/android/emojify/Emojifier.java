package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    final private static String LOG_TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap image){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(image).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d(LOG_TAG, "Number of faces is: "+String.valueOf(faces.size()));

        if (faces.size() == 0){
            Toast.makeText(context,"No face detected", Toast.LENGTH_SHORT).show();
        }

        detector.release();
    }
}
