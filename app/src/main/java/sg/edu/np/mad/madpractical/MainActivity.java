package sg.edu.np.mad.madpractical;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        Button buttonFollow = findViewById(R.id.buttonFollow);
        Button buttonMessage = findViewById(R.id.buttonMessage);

        UserViewModel userViewModel =  new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UserViewModel.class);
        userViewModel.getUser().observe(this, user -> {
            textViewName.setText(user.getName());
            textViewDescription.setText(user.getDescription());
            buttonFollow.setText(user.isFollowed() ? R.string.unfollow : R.string.follow);
        });

        buttonFollow.setOnClickListener(v -> userViewModel.modifyUser(user -> {
            user.setFollowed(!user.isFollowed());
        }));

        ((ViewGroup) findViewById(R.id.buttonsLayout)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        User dummyUser = new User("Ben", "Code. Create. Coordinate.",  1, false);
        userViewModel.setUser(dummyUser);
    }
}