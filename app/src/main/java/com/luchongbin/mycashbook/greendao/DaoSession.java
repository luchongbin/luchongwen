package com.luchongbin.mycashbook.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.luchongbin.mycashbook.bean.CashBook;
import com.luchongbin.mycashbook.bean.CheQueLog;
import com.luchongbin.mycashbook.bean.User;

import com.luchongbin.mycashbook.greendao.CashBookDao;
import com.luchongbin.mycashbook.greendao.CheQueLogDao;
import com.luchongbin.mycashbook.greendao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cashBookDaoConfig;
    private final DaoConfig cheQueLogDaoConfig;
    private final DaoConfig userDaoConfig;

    private final CashBookDao cashBookDao;
    private final CheQueLogDao cheQueLogDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cashBookDaoConfig = daoConfigMap.get(CashBookDao.class).clone();
        cashBookDaoConfig.initIdentityScope(type);

        cheQueLogDaoConfig = daoConfigMap.get(CheQueLogDao.class).clone();
        cheQueLogDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        cashBookDao = new CashBookDao(cashBookDaoConfig, this);
        cheQueLogDao = new CheQueLogDao(cheQueLogDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(CashBook.class, cashBookDao);
        registerDao(CheQueLog.class, cheQueLogDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        cashBookDaoConfig.clearIdentityScope();
        cheQueLogDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public CashBookDao getCashBookDao() {
        return cashBookDao;
    }

    public CheQueLogDao getCheQueLogDao() {
        return cheQueLogDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
