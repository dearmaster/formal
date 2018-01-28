package com.master.captain.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public List<T> load(final Class<T> clas) {
        String hql = "from " + clas.getSimpleName();
        return this.execute(
                session -> session.createQuery(hql).list()
        );
    }

    @Override
    public Serializable save(final T t) {
        return this.execute(session -> session.save(t));
    }

    @Override
    public void delete(final T t) {
        this.execute((DaoCallBack<Void>) session -> {
            session.delete(t);
            return null;
        });
    }

    @Override
    public void update(final T t) {
        this.execute((DaoCallBack<Void>) session -> {
            session.update(t);
            return null;
        });
    }

    protected <T> T execute(DaoCallBack<T> callBack) {
        Session session = sessionFactory.getCurrentSession();
        return callBack.doInAction(session);
    }

    private interface DaoCallBack<T> {
        T doInAction(Session session);
    }

}