package fragment.bwie.com.rikao;

/**
 * Created by CZ on 2017/11/2.
 */
public interface   LoginView {

    public void nameEmpty();
    public void pwdExpty();

    public void loginSurress(Object object);
    public void loginFailed(int code);
}
