package com.passwordmemo.sky.passwordmemo.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.passwordmemo.sky.passwordmemo.dao.Admin;
import com.passwordmemo.sky.passwordmemo.dao.UserPassword;
import com.passwordmemo.sky.passwordmemo.dao.SynData;

import com.passwordmemo.sky.passwordmemo.dao.AdminDao;
import com.passwordmemo.sky.passwordmemo.dao.UserPasswordDao;
import com.passwordmemo.sky.passwordmemo.dao.SynDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig adminDaoConfig;
    private final DaoConfig userPasswordDaoConfig;
    private final DaoConfig synDataDaoConfig;

    private final AdminDao adminDao;
    private final UserPasswordDao userPasswordDao;
    private final SynDataDao synDataDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        adminDaoConfig = daoConfigMap.get(AdminDao.class).clone();
        adminDaoConfig.initIdentityScope(type);

        userPasswordDaoConfig = daoConfigMap.get(UserPasswordDao.class).clone();
        userPasswordDaoConfig.initIdentityScope(type);

        synDataDaoConfig = daoConfigMap.get(SynDataDao.class).clone();
        synDataDaoConfig.initIdentityScope(type);

        adminDao = new AdminDao(adminDaoConfig, this);
        userPasswordDao = new UserPasswordDao(userPasswordDaoConfig, this);
        synDataDao = new SynDataDao(synDataDaoConfig, this);

        registerDao(Admin.class, adminDao);
        registerDao(UserPassword.class, userPasswordDao);
        registerDao(SynData.class, synDataDao);
    }
    
    public void clear() {
        adminDaoConfig.getIdentityScope().clear();
        userPasswordDaoConfig.getIdentityScope().clear();
        synDataDaoConfig.getIdentityScope().clear();
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public UserPasswordDao getUserPasswordDao() {
        return userPasswordDao;
    }

    public SynDataDao getSynDataDao() {
        return synDataDao;
    }

}
