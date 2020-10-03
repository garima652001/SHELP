package com.example.retrofit;


import android.content.Context;
import android.content.SharedPreferences;

/*public class Sharedprefs {
    private static Sharedprefs minstance;
    private Context ctx;
    private static final String SHARED_PREFS="sharedpref";

    private Sharedprefs(Context ctx)
    {
        this.ctx=ctx;
    }
    public static synchronized Sharedprefs getInstance(Context ctx){
        if(minstance==null)
        {
            minstance=new Sharedprefs(ctx);
        }
        return minstance;
    }

    public void saveUser(LoginResponse res)
    {

        SharedPreferences sharedPreferences= ctx.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();

        editor.putString("username",res.getUsername());
        editor.putString("userId",res.getUserId());
        editor.putString("token",res.getToken());

        editor.apply();
    }
    public boolean isloggedin(){
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        return(sharedPreferences.getString("userId",null)!=null);
    }

    public LoginResponse getuser()
    {
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        return new LoginResponse(
                sharedPreferences.getString("userId",null),
                sharedPreferences.getString("username",null),
                sharedPreferences.getString("token",null),
                sharedPreferences.getString("message",null)

        );
    }
}*/
public class Sharedprefs {
    private static final String SHARED_PREFS="sharedpref";


    public static String readShared(Context ctx, String setname,String defvalue)
    {
        SharedPreferences sharedPreferences =ctx.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        return sharedPreferences.getString(setname,defvalue);
    }

    public static void saveSharedsetting(Context ctx,String setname, String setvalue){
        SharedPreferences sharedPreferences =ctx.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(setname,setvalue);
        editor.apply();
    }
    public static void sharedprefsave(Context ctx, String name,String token){
        SharedPreferences prefs= ctx.getSharedPreferences("Name",0);
        SharedPreferences.Editor prefedit= prefs.edit();
        prefedit.putString("Name", name);
        prefedit.commit();
        SharedPreferences prefs_token= ctx.getSharedPreferences("Token",0);
        SharedPreferences.Editor prefedit_token= prefs_token.edit();
        prefedit_token.putString("Token", token);
        prefedit_token.commit();
    }
}