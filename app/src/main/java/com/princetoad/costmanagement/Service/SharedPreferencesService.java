package com.princetoad.costmanagement.Service;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public interface SharedPreferencesService {
    public boolean isFirstTime();

    public void saveObject(String key, Object value);

    public <T>Object getObject(String key, Class<T> a);

    public void remove(String key);
}
