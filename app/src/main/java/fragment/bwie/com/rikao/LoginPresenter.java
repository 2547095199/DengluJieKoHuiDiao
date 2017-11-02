package fragment.bwie.com.rikao;

import android.text.TextUtils;

/**
 * Created by CZ on 2017/11/2.
 */
public class LoginPresenter {

    private LoginView loginView;
    private final LoginModel loginModel;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        loginModel = new LoginModel();
    }
    public void detach(){
        this.loginView = null;
    }
    public void login(String name,String pwd){
        if (TextUtils.isEmpty(name)){
            loginView.nameEmpty();
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            loginView.pwdExpty();
            return;
        }

        loginModel.login(name,pwd,new LoginModel.modelCallBack(){

            @Override
            public void success(String data) {
                loginView.loginSurress(data);
            }

            @Override
            public void failed(int code) {
                loginView.loginFailed(code);
            }
        });
    }
}
