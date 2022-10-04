package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import id.ac.polinema.intentexercise.model.User;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView img;
    private TextView tvabout, tvfullname, tvnim, tvpassword, tvconpass, tvhomepage;
    private Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        img = findViewById(R.id.image_profile);
        tvabout = findViewById(R.id.label_about);
        tvfullname = findViewById(R.id.label_fullname);
        tvnim = findViewById(R.id.label_nim);
        //tvpassword = findViewById(R.id.text_password);
        //tvconpass = findViewById(R.id.text_confirm_password);
        tvhomepage = findViewById(R.id.label_homepage);
        btnView = findViewById(R.id.button_homepage);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.getString("profil") != null){
                Uri imgUri = Uri.parse(extras.getString("profil"));
                img.setImageURI(imgUri);
            }

            User user = extras.getParcelable("user");

            tvabout.setText(user.getAbout());
            tvfullname.setText(user.getFullname());
            tvnim.setText(user.getNim());
            tvhomepage.setText(user.getHomepage());
        }
        else {
            Toast.makeText(this, "Intent is missing!", Toast.LENGTH_SHORT).show();
        }
    }
    public void handleHomepage (View view) {
        Uri url = Uri.parse(tvhomepage.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        startActivity(intent);
    }
}
