package sg.edu.np.mad.madpractical;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private User user;

    private TextView textViewName;
    private TextView textViewDescription;
    private Button buttonFollow;
    private Button buttonMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewDescription = findViewById(R.id.textViewDescription);
        this.buttonFollow = findViewById(R.id.buttonFollow);
        this.buttonMessage = findViewById(R.id.buttonMessage);

        User dummyUser = new User("Ben", "Code. Create. Coordinate.",  1, false);
        this.setUser(dummyUser);
        this.buttonFollow.setOnClickListener(v -> {
            this.user.setFollowed(!this.user.isFollowed());
            this.updateUserFollowState();
        });
    }

    private void setUser(User user) {
        this.user = user;
        this.updateUserInfo();
        this.updateUserFollowState();
    }

    private void updateUserInfo() {
        this.textViewName.setText(user.getName());
        this.textViewDescription.setText(user.getDescription());
    }

    private void updateUserFollowState() {
        this.buttonFollow.setText(this.user.isFollowed() ? R.string.unfollow : R.string.follow);
    }
}