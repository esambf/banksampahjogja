package com.example.pmobakhir;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "spbu.db";
    private static int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table tblspbu(no integer primary key, nama text null, alamat text null, jam text null, fasilitas text null, urimap text null, lat text null, long text null, im text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO tblspbu (no, nama, alamat, jam, fasilitas, urimap, lat, long, im ) VALUES ('1000','Bank Sampah Mondoroko','Jl. Mondorakan No.27, Kec. Kotagede','08.00','Jemput Sampah','https://www.google.co.id/maps/place/Bank+Sampah+Mondoroko+RW+7/@-7.8154626,110.3713288,14.04z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x0:0xd145f0d8de4403de!8m2!3d-7.8272718!4d110.3963488','-7.827286','110.3963119','https://lh5.googleusercontent.com/p/AF1QipMpPwyHkM3XHmphSDwrzxjORRg195OW9PKXrSw=w426-h240-k-no'), ('1001','Bank Sampah Barokah','Gg. Gemah Ripah, Kec. Kotagede','09.00','Jemput Sampah','https://www.google.co.id/maps/place/Bank+Sampah+Barokah+Daleman+Prenggan/@-7.8315073,110.3830607,14z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x0:0xb1f2b79aae151140!8m2!3d-7.8315073!4d110.4000717','-7.8315045','110.4000757','https://lh5.googleusercontent.com/p/AF1QipOEwZeJHVLwsYR_hrS212pbkJujHdXz0KgZb0c=w408-h725-k-no'), ('1002','Bank Sampah Tuhutentrem','Jl. Sorosutan, Kec. Umbulharjo','09.00','Jemput Sampah','https://www.google.co.id/maps/place/Bank+Sampah+%22Tresno+Tuhutentrem%22/@-7.8315073,110.3830607,14z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x0:0xf9a17ee68159c6e8!8m2!3d-7.8206074!4d110.3787696','-7.8206033','110.3787564','https://lh6.googleusercontent.com/proxy/qzOdqnW80hoItF33TpsWGdcDzeY0B-VUA586p0Cn336edv5a9gdymDxm1x9tWsK-qxVEIRv4bZ2oo6qIrpoDEE9y4LkKIjL--jNARNXOTL1GzFUMYbpPyhKBoYnusxQS_u15aiFvOA3xwHOMbPpzld61GVs=w408-h306-k-no'), ('1004','Bank Sampah Reresik','Jl. Prawirotaman Kec. Mergangsan','09.00','Jemput Sampah','https://www.google.co.id/maps/place/Banks+Sampah+Reresik/@-7.8246762,110.3713354,15.3z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x0:0x65837d315a870892!8m2!3d-7.8190874!4d110.3707016','-7.8190983','110.370718','https://geo1.ggpht.com/cbk?panoid=uFuzTt3MeRbatv_yiz7Rdg&output=thumbnail&cb_client=search.gws-prod.gps&thumb=2&w=408&h=240&yaw=328.6254&pitch=0&thumbfov=100'), ('1005','Bank Sampah Blazent','Jl. Taman Siswa, Kec Gondomanan','09.00','Jemput Sampah','https://www.google.co.id/maps/place/Bank+Sampah+Blazent/@-7.8032427,110.3746386,14.13z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x2e7a578264d570af:0x59c1d08366e87c4d!8m2!3d-7.802693!4d110.377789','-7.8026662','110.3778866','https://lh6.googleusercontent.com/proxy/a-J6_y6M-4l_Sx9_mHgVhWIF4aVHjkYGsgqoUx83ngaX-bc7fiw_XfxCC2pnbmW0kiSn8Nk2cVtQHkUE-M1dRrr_QBC3Lcibvgikuaok6o58az6vw3mz003c4KQNu1IDnUzheEPJOOK_TenPzlFPMd4c_hA=w408-h306-k-no'), ('1006','Bank Sampah Damai Bersatu','Jl. Brigjen Katamso, Kec. Gondomanan','09.00','Jemput Sampah','https://www.google.co.id/maps/place/Bank+Sampah+Damai+Bersatu/@-7.8032427,110.3746386,14.13z/data=!4m8!1m2!2m1!1sbank+sampah!3m4!1s0x0:0x160e0fb815eccd9c!8m2!3d-7.8061198!4d110.3702509','-7.8061079','110.3702792','https://maps.gstatic.com/tactile/pane/default_geocode-2x.png');";

        db.execSQL(sql);

        String sql1 = "create table tbluser(no integer primary key, nama text null, alamat text null, username text null, password text null);";
        Log.d("Data1", "onCreate: " + sql1);
        db.execSQL(sql1);
        sql1 = "INSERT INTO tbluser (no, nama, alamat, username, password) VALUES ('3301171153000003','Esa Muhammad','esambf1','esambf','Kotagede');";
        db.execSQL(sql1);

        String sql2 = "create table tbladmin(no integer primary key autoincrement, username text null, password text null);";
        Log.d("Data2", "onCreate: " + sql2);
        db.execSQL(sql2);
        sql2 = "INSERT INTO tbladmin (username, password) VALUES ('admin','admin');";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2){
    }
}