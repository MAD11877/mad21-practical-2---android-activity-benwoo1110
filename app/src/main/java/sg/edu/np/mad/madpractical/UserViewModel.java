package sg.edu.np.mad.madpractical;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    MutableLiveData<User> user;

    public UserViewModel() {
        this.user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public void modifyUser(UserModifier modifier) {
        User user = this.user.getValue();
        modifier.apply(user);
        this.user.setValue(user);
    }
}
