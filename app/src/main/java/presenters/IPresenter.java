package presenters;

import android.content.Intent;

/**
 * Created by jontt on 10/10/2017.
 */

public interface IPresenter {

    void update();

    void reload();

    void changeActivity(Intent intent);

}
