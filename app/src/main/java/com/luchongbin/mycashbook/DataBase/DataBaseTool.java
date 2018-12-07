package com.luchongbin.mycashbook.DataBase;

import com.luchongbin.mycashbook.application.MyCashBookApplication;
import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.bean.User;
import com.luchongbin.mycashbook.greendao.CashBookDao;
import com.luchongbin.mycashbook.greendao.UserDao;

import java.util.List;

public class DataBaseTool {
    private static UserDao mUserDao;
    private static CashBookDao mCashBookDao;
    private static volatile DataBaseTool instance = null;
    public static DataBaseTool getInstance() {
        if (instance == null) {
            synchronized (DataBaseTool.class) {
                if (instance == null) {
                    instance = new DataBaseTool();
                    mUserDao = MyCashBookApplication.getInstance().getDaoSession().getUserDao();
                    mCashBookDao = MyCashBookApplication.getInstance().getDaoSession().getCashBookDao();
                }
            }
        }
        return instance;
    }


    /**
     * 增加用户信息
     */
    public  long insertUser(User mUser)
    {
        return mUserDao.insert(mUser);
    }
    /**
     *修改某条用户信息
     */
    public  void modifyUser(User mUser)
    {
        mUserDao.update(mUser);
    }
    /**
     *删除此用户
     */
    public  void deleteUserById(long id)
    {
        mUserDao.deleteByKey(id);
    }
    /**
     *获取某条用户信息
     */
    public  User getUserByUserId(Long userId)
    {
        User mUser = mUserDao.queryBuilder().where(UserDao.Properties.UserId.eq(userId)).unique();
        return mUser;
    }
    /**
     *获取某条用户信息
     */
    public  User getUserById(Long Id)
    {
        User mUser = mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(Id)).unique();
        return mUser;
    }
    /**
     * 获取除去管路员的所有用户
     */
    public  List<User> findUsers()
    {
        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.IsManager.eq(false)).build().list();
        return list;

    }
    /**
     * 增加账本信息
     */
    public  long insertCashBook(CashBook mCashBook)
    {
        return mCashBookDao.insert(mCashBook);
    }
    /**
     *修改某条账本信息
     */
    public  void modifyCashBook(CashBook mCashBook)
    {
        mCashBookDao.update(mCashBook);
    }
    /**
     *修改某条账本信息
     */
    public  void deleteCashBookById(long id)
    {
        mCashBookDao.deleteByKey(id);
    }
    /**
     *修改某条账本信息
     */
    public  void deleteCashBookByuserId(Long userId)
    {
        List<CashBook> list =getCashBooksByUserId(userId);
        mCashBookDao.deleteInTx(list);
    }

    /**
     *获取某用户的所有账户信息
     */
    public List<CashBook> getCashBooksByUserId(Long userId)
    {
        List<CashBook> list = mCashBookDao.queryBuilder().where(CashBookDao.Properties.UserId.eq(userId)).orderAsc(CashBookDao.Properties.Date).build().list();
        return list;
    }
    /**
     *获取某用户某月的所有账户信息
     */
    public List<CashBook> getCashBooksByUserIdAndData(Long userId,String data)
    {
        List<CashBook> list = mCashBookDao.queryBuilder().where(CashBookDao.Properties.UserId.eq(userId),CashBookDao.Properties.Date.like(data+"%")).orderAsc(CashBookDao.Properties.Date).build().list();
        return list;
    }
    /**
     * 查所有账本信息
     */
    public  List<CashBook> findCashBooks()
    {
        //惰性加载
        List<CashBook> list = mCashBookDao.queryBuilder().listLazy();
        return list;
    }
    /**
     *获取某条账本信息
     */
    public CashBook getCashBookById(Long id)
    {
        CashBook mCashBook = mCashBookDao.queryBuilder().where(CashBookDao.Properties.Id.eq(id)).unique();
        return mCashBook;
    }
    /**
     *获取某条账本信息
     */
    public CashBook getCashBookByCashBookId(long cashBookId)
    {
        CashBook mCashBook = mCashBookDao.queryBuilder().where(CashBookDao.Properties.CashBookId.eq(cashBookId)).unique();
        return mCashBook;
    }

}
