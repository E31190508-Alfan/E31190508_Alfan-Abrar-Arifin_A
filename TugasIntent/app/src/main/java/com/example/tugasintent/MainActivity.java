// Kelompok 2
// Alfan Abrar Arifin (E31190508)
// Alvina Lola E.P (E31190529)
// Deo Akbar Purwanto (E3110408)
// Elyas Agus Suhadak (E3110672)
// Muhammad Bagus Gunawan (E31190237)
// Ridho Riyadi Hartomo (E31190731)

package com.example.tugasintent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private final int RESULT_LOAD_IMG = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadImagefromGallery(View view) {
        // buat intentnya
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // mulai aktiviti
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // saat gambar diambil
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
            try {
                // dapatkan gambar dari data intent
                Uri selectedImage = data.getData();
                ImageView imgView = (ImageView) findViewById(R.id.imgView);

                // mengatur gambar pada ImageView
                imgView.setImageURI(selectedImage);
            } catch (Exception e) {
                Toast.makeText(this, "Kesalahan terjadi", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Anda belum mengambil gambar", Toast.LENGTH_LONG).show();
        }
    }
}
